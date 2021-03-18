package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;

public class CameraTurn extends CommandBase {
    private final CameraSubsystem m_camera;
    private final DriveSubsystem m_drive;
    private boolean finished = false;
    /**
     * Creates a new DefaultDrive.
     *
     * @param m_cameraSubsystem The drive subsystem this command wil run on.
     */
    public CameraTurn(CameraSubsystem m_cameraSubsystem, DriveSubsystem m_driveSubsystem) {
      m_camera = m_cameraSubsystem;
      m_drive = m_driveSubsystem;
      addRequirements(m_camera);
      addRequirements(m_drive);
  }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (m_camera.HasValidTarget()) {
        if (m_camera.GetTargetHorizontalOffset() > 0) {
          m_drive.arcadeDrive(-0.5, 0.25);
        }
        else if (m_camera.GetTargetHorizontalOffset() < 0){
          m_drive.arcadeDrive(-0.5, -0.25);
        }
        else {m_drive.arcadeDrive(0, 0);}
      }
      else {m_drive.arcadeDrive(0, 0.5);}
      if (m_camera.GetTargetArea() == 0 && m_camera.HasValidTarget()) {
        finished = true;
      }
      else if (m_camera.GetTargetArea() >= 5 && m_camera.HasValidTarget()){
        finished = true;
      }
      else {
        finished = false;
      }
    }

  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      m_drive.arcadeDrive(0, 0);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return finished;}
      
 /*   do{ 
        double leftMotorOutput = 15;
        double rightMotorOutput = -15;
        }
    while (tx >= 0);
    do{ 
        double leftMotorOutput = -15;
        double rightMotorOutput = 15;
        }
    while (tx <= 0); */
}