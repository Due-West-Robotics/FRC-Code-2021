package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.ControlType;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

public class DriveSubsystem extends SubsystemBase {

  private final AHRS ahrs = new AHRS(SerialPort.Port.kUSB);
  private final CANSparkMax motor1L = new CANSparkMax(DriveConstants.kLeftMotor1Port,CANSparkMax.MotorType.kBrushless);
  private final CANSparkMax motor2L = new CANSparkMax(DriveConstants.kLeftMotor2Port,CANSparkMax.MotorType.kBrushless);
  private final CANSparkMax motor1R = new CANSparkMax(DriveConstants.kRightMotor1Port,CANSparkMax.MotorType.kBrushless);
  private final CANSparkMax motor2R = new CANSparkMax(DriveConstants.kRightMotor2Port,CANSparkMax.MotorType.kBrushless);

  // The motors on the left side of the drive.
  private final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(motor1L);

  // The motors on the right side of the drive.
  private final SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(motor1R);

  // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  private final CANEncoder encoderL = motor1L.getEncoder();
  private final CANEncoder encoderR = motor1R.getEncoder();

  private double currentHeading;
  private int completeRotations = 0;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    currentHeading = getGyro();
    motor1L.setInverted(false);
    motor2L.setInverted(false);
    motor1R.setInverted(true);
    motor2R.setInverted(true);

    //set the back drive motors to follow the front ones
    motor2L.follow(getFrontLeftSparkMax());
    motor2R.follow(getFrontRightSparkMax());

    //setup PID controllers
    motor1L.getPIDController().setP(.00025);
    motor1R.getPIDController().setP(.00025);
    motor1L.getPIDController().setI(.0000003);
    motor1R.getPIDController().setI(.0000003);
    motor1L.getPIDController().setD(.0001);
    motor1R.getPIDController().setD(.0001);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {

    double m_fwd = -fwd;
    double m_rot = -rot;
    double leftMotorOutput = 0;
    double rightMotorOutput = 0;
    double fwdSign = Math.signum(fwd);
    double rotSign = Math.signum(rot);

    if(Math.abs(m_fwd) < 0.05) {
      m_fwd = 0;
    }
    if(Math.abs(m_rot) < 0.05) {
      m_rot = 0;
    }


    m_fwd = Math.pow(m_fwd,2);
    m_rot = Math.pow(m_rot,2);

    m_fwd *= fwdSign;
    m_rot *= rotSign;

    leftMotorOutput -= m_fwd;
    rightMotorOutput -= m_fwd;

    leftMotorOutput += m_rot;
    rightMotorOutput -= m_rot;

    leftMotorOutput = MathUtil.clamp(leftMotorOutput, -1.0, 1.0);
    rightMotorOutput = MathUtil.clamp(rightMotorOutput, -1.0, 1.0);

    System.out.println("leftMotorOutput: " + leftMotorOutput);
    System.out.println("rightMotorOutput: " + rightMotorOutput);

    motor1L.getPIDController().setReference(leftMotorOutput * 5676 , ControlType.kVelocity);
    motor1R.getPIDController().setReference(rightMotorOutput * 5676 , ControlType.kVelocity);
  }

  /** Resets the drive encoders to currently read a position of 0. */
  public void resetEncoders() {
    encoderL.setPosition(0);
    encoderR.setPosition(0);
  }
  public void setDistancePerPulse() {
    encoderL.setPositionConversionFactor((DriveConstants.kGearRatio)*Math.PI*DriveConstants.kWheelDiameterInches);
    encoderR.setPositionConversionFactor((DriveConstants.kGearRatio)*Math.PI*DriveConstants.kWheelDiameterInches);
  }


  public void resetGyro() {
    ahrs.reset();
  }

  public void calibrateGyro() {
    ahrs.calibrate();
    while(ahrs.isCalibrating()) {
    }
  }

  /**
   * Gets the average distance of the TWO encoders.
   *
   * @return the average of the TWO encoder readings
   */
  public double getAverageEncoderDistance() {
    return (encoderL.getPosition() + encoderR.getPosition()) / 2.0;
  }

  public double getEncoderLPosition() {
    return(encoderL.getPosition());
  }

  /**
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   */
  public CANEncoder getLeftEncoder() {
    return encoderL;
  }

  /**
   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   */
  public CANEncoder getFrontRightEncoder() {
    return encoderR;
  }

  public CANSparkMax getFrontLeftSparkMax() {
    return motor1L;
  }

  public CANSparkMax getFrontRightSparkMax() {
    return motor1R;
  }

  public CANSparkMax getBackLeftSparkMax() {
    return motor2L;
  }

  public CANSparkMax getBackRightSparkMax() {
    return motor2R;
  }
  
  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }

  public double getGyro() {
    return (ahrs.getAngle());
  }


  //resets the number of accumulations
  public void resetCompleteRotations() {
    completeRotations = 0;
  }

  //returns the total gyro turn
  public double getAcumulatedHeading() {
    return getGyro() + 360 * completeRotations;
  }

  public int getCompleteRotations() {
    return completeRotations;
  }

  public void setBrake(){
    motor1L.setIdleMode(CANSparkMax.IdleMode.kBrake);
    motor1R.setIdleMode(CANSparkMax.IdleMode.kBrake);
    motor2L.setIdleMode(CANSparkMax.IdleMode.kBrake);
    motor2R.setIdleMode(CANSparkMax.IdleMode.kBrake);
  }

  public void setCoast(){
    motor1L.setIdleMode(CANSparkMax.IdleMode.kCoast);
    motor1R.setIdleMode(CANSparkMax.IdleMode.kCoast);
    motor2L.setIdleMode(CANSparkMax.IdleMode.kCoast);
    motor2R.setIdleMode(CANSparkMax.IdleMode.kCoast);
  }

  @Override
    public void periodic() {

      SmartDashboard.putNumber("encoder", getAverageEncoderDistance());

      //compare old heading to current heading to check for complete rotations
      double oldHeading = currentHeading;

      //update the current heading
      currentHeading = getGyro();

      //if the difference is greater than 180 degrees, add or subtract one from complete rotations *NOT USED WITH ONLY GYRO
      /*if(Math.abs(oldHeading - currentHeading) > 180) {
        if(oldHeading > currentHeading) {
          completeRotations++;
        }else{
          completeRotations--;
        }
      }*/
    }
}