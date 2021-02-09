package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class IntakeSubsystem extends SubsystemBase{
    private final SpeedControllerGroup intakeMotors =
    //The motors for the intake system
      new SpeedControllerGroup(
          new CANSparkMax(DriveConstants.kIntakeMotorPort,CANSparkMax.MotorType.kBrushed));

     // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(intakeMotors, null);
    /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }
}
