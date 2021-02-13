package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
  
public class startIntake extends CommandBase {
  
  private final IntakeSubsystem m_intake;

  /**
   * Creates a new DriveDistance.
   *
   * @param intake The drive subsystem on which this command will run
   */
  public startIntake(IntakeSubsystem intake) {
    m_intake = intake;
    addRequirements(m_intake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_intake.startIntake();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
