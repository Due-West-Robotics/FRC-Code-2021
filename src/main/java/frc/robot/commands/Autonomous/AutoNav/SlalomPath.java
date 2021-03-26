package frc.robot.commands.Autonomous.AutoNav;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class SlalomPath extends SequentialCommandGroup {

    DriveSubsystem m_drive;

    public SlalomPath(DriveSubsystem driveSubsystem) {
        m_drive = driveSubsystem;
        addCommands(
            new DriveDistance(m_drive, 24, 1),
            new TurnDegrees(m_drive, -85, .25, DriveConstants.kLeft, 30),
            new TurnDegrees(m_drive, -7, .25, DriveConstants.kRight, 30),
            new DriveDistance(m_drive, 120, 1),
            new TurnDegrees(m_drive, 85, .25, DriveConstants.kRight, 30),
            new TurnDegrees(m_drive, -265, .25, DriveConstants.kLeft, 28),
            new TurnDegrees(m_drive, -190, .25, DriveConstants.kRight, 30),
            new DriveDistance(m_drive, 120, 1),
            new TurnDegrees(m_drive, -100, .4, DriveConstants.kRight, 30),
            new TurnDegrees(m_drive, -175, .4, DriveConstants.kLeft, 27));
            //new DriveDistance(10, .25, m_drive));
    }
}