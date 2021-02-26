package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.*;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class TurnDegrees extends CommandBase {
  private final DriveSubsystem m_drive;
  private double m_targetHeading;
  private double m_speed;
  private double m_rspeed, m_lspeed;
  private double m_initHeading;
  private double m_accumulatedHeading;
  private double m_turnRadius;
  private boolean m_finished = false;
  private int m_direction;
  private CANPIDController m_flSpeedPID;
  private CANPIDController m_frSpeedPID;
  private CANPIDController m_blSpeedPID;
  private CANPIDController m_brSpeedPID;

  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param degrees   The control input for driving forwards/backwards
   * @param speed     The control input for turning
   */
  public TurnDegrees(DriveSubsystem subsystem, double degrees, double speed, int direction, double radius) {
      m_drive = subsystem;
      m_targetHeading = degrees;
      m_speed = speed;
      m_direction = direction;
      m_turnRadius = radius;
      m_flSpeedPID = m_drive.getFrontLeftSparkMax().getPIDController();
      m_frSpeedPID = m_drive.getFrontRightSparkMax().getPIDController();
      m_blSpeedPID = m_drive.getBackLeftSparkMax().getPIDController();
      m_brSpeedPID = m_drive.getBackRightSparkMax().getPIDController();
      addRequirements(m_drive);
  }

  @Override
  public void initialize() {

    System.out.println("Starting");
    m_drive.setBrake();


    //calculate the motor speeds required to turn a specific radius
    double robotRadius = .5*DriveConstants.kDriveWidth;
    double speedRatio = (m_turnRadius-robotRadius)/(m_turnRadius+robotRadius);
    double outerSpeed = m_speed;
    double innerSpeed = m_speed*speedRatio;

    System.out.println("outerSpeed: " + outerSpeed);
    System.out.println("innerSpeed: " + innerSpeed);

    //set the motors to go the required speed
    if(m_direction == DriveConstants.kLeft) {
      m_frSpeedPID.setReference(outerSpeed, ControlType.kVelocity);
      m_brSpeedPID.setReference(outerSpeed, ControlType.kVelocity);
      m_flSpeedPID.setReference(innerSpeed, ControlType.kVelocity);
      m_blSpeedPID.setReference(innerSpeed, ControlType.kVelocity);
    } else if(m_direction == DriveConstants.kRight) {
      m_frSpeedPID.setReference(innerSpeed, ControlType.kVelocity);
      m_brSpeedPID.setReference(innerSpeed, ControlType.kVelocity);
      m_flSpeedPID.setReference(outerSpeed, ControlType.kVelocity);
      m_blSpeedPID.setReference(outerSpeed, ControlType.kVelocity);
    }
      



       //get the initial heading
       m_initHeading = m_drive.getGyro();

       //reset the accumulated gyro
       m_drive.resetCompleteRotations();
    }

    @Override
    public void execute() {

      //start turning
      m_drive.tankDrive(m_lspeed, m_rspeed);

      //get the current heading
      m_accumulatedHeading = m_drive.getAcumulatedHeading();
      //if the goal is reached, stop and set the command to finished
      if(m_direction == DriveConstants.kRight && m_accumulatedHeading > m_targetHeading) {
        m_drive.tankDrive(0,0);
        m_finished = true;
      }else if(m_direction == DriveConstants.kLeft && m_accumulatedHeading < m_targetHeading) {
        m_drive.tankDrive(0,0);
        m_finished = true;
      }
    }

    @Override
    public boolean isFinished() {
      return m_finished;
    }

    @Override
    public void end(boolean interrupted) {
      m_drive.arcadeDrive(0, 0);
    }
}