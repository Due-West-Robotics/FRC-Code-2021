package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
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
  private double m_rspeed, m_lspeed;
  private double m_initHeading;
  private boolean m_finished = false;
  private int m_direction;


  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param degrees   The control input for driving forwards/backwards
   * @param speed     The control input for turning
   */
  public TurnDegrees(DriveSubsystem subsystem, double degrees, double speed, int direction) {
      m_drive = subsystem;
      m_targetHeading = degrees;
      m_rspeed = speed;
      m_lspeed = speed;
      m_direction = direction;
      addRequirements(m_drive);
  }

  @Override
  public void initialize() {

      //get the current heading
      m_initHeading = m_drive.getGyro();

      //set motor power for the drive direction
      if(m_direction == DriveConstants.kLeft) {
        m_lspeed = -1;
      } else if(m_direction == DriveConstants.kRight) {
        m_rspeed = -1;
      }
    }

    @Override
    public void execute() {

      //start turning
      m_drive.tankDrive(m_lspeed, m_rspeed);

      if(m_direction == DriveConstants.kRight) {

      }else if(m_direction == DriveConstants.kLeft) {

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