package frc.robot.commands.Autonomous.AutoNav;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class BouncePath extends SequentialCommandGroup {

    DriveSubsystem m_drive;

    public BouncePath(DriveSubsystem driveSubsystem) {
        m_drive = driveSubsystem;
        addCommands(
            //to first point
            new DriveDistance(m_drive,19, 0.5),
            new TurnDegrees(m_drive, -85, .2, DriveConstants.kLeft, 30),
            new DriveDistance(m_drive, 30, 0.5),
            //to second point
            new DriveDistance(m_drive,-30, 0.5),
            new TurnDegrees(m_drive, -112, -.2, DriveConstants.kRight, 27),
            new DriveDistance(m_drive,-67, 0.5),
            new TurnDegrees(m_drive, -265, -.2, DriveConstants.kRight, 27),
            new DriveDistance(m_drive, -90, 0.2),
            //to third point
            new DriveDistance(m_drive, 90, 0.5),
            new TurnDegrees(m_drive, -356, .2, DriveConstants.kLeft, 27),
            new DriveDistance(m_drive,30, 0.5),
            new TurnDegrees(m_drive, -445, .2, DriveConstants.kLeft, 27),
            new DriveDistance(m_drive,95, 0.2),
            //to end
            new TurnDegrees(m_drive, -520, -.2, DriveConstants.kRight, 27));
    }
}