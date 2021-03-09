package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistance extends CommandBase {
  private final DriveSubsystem m_drive;
  private final double m_distance;
  private double m_speed;
  private boolean finished = false;
  private boolean forward;


  /**
   * Creates a new DriveDistance.
   *
   * @param inches The number of inches the robot will drive
   * @param speed  The speed at which the robot will drive
   * @param drive  The drive subsystem on which this command will run
   */
  public DriveDistance(double inches, double speed, DriveSubsystem drive) {
    m_distance = inches;
    m_speed = speed;
    m_drive = drive;
    addRequirements(m_drive);
  }

  @Override
  public void initialize() {
    m_drive.resetEncoders();
    m_drive.setBrake();
    if (m_speed < 0) {
      m_speed = m_speed * -1;
    }
    if (m_distance > 0) {
      forward = true;
    }
    else if (m_distance < 0) {
      forward = false;
    }
    else {
      finished = true;
    }

  }

  @Override
  public void execute() {
    if (forward == true){
      m_drive.arcadeDrive(-m_speed, 0);
    }
    else if (forward == false){
      m_drive.arcadeDrive(m_speed, 0);
    }
    if (forward == true && Math.abs(m_drive.getAverageEncoderDistance()) >= m_distance){
      finished = true;
      m_drive.resetIAccum();
    }
    else if (forward == false && Math.abs(m_drive.getAverageEncoderDistance()) <= m_distance){
      finished = true;
      m_drive.resetIAccum();
    }
    else {
      finished = false;
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
    //m_drive.setCoast();
  }

  @Override
  public boolean isFinished() {
    return finished;
  }
}