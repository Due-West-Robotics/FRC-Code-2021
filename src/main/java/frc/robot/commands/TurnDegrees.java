package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class TurnDegrees extends CommandBase {
  private final DriveSubsystem m_drive;
  private double m_degrees;
  private double m_rspeed, m_lspeed;

  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param degrees   The control input for driving forwards/backwards
   * @param speed     The control input for turning
   */
  public TurnDegrees(DriveSubsystem subsystem, double degrees, double speed) {
      m_drive = subsystem;
      m_degrees = degrees;
      m_rspeed = speed;
      m_lspeed = speed;
      addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (m_degrees < 0) {
          m_degrees = m_degrees * -1;
          }
    if 
      }

    @Override
    public void execute() {
        m_drive.tankDrive(m_speed, m_speed);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}