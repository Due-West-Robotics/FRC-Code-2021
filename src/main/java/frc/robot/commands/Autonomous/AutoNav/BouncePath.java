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
            new DriveDistance(18, 0.5, m_drive),
            new TurnDegrees(m_drive, -90, .25, DriveConstants.kLeft, 18),
            new DriveDistance(2, 0.5, m_drive),
            //to second point
            new DriveDistance(-36, 0.5, m_drive),
            new TurnDegrees(m_drive, -35, .25, DriveConstants.kLeft, 18),
            new DriveDistance(-84, 0.5, m_drive),
            new TurnDegrees(m_drive, -135, .25, DriveConstants.kLeft, 18),
            new DriveDistance(-120, 0.5, m_drive),
            //to third point
            new DriveDistance(120, 0.5, m_drive),
            new TurnDegrees(m_drive, 90, .25, DriveConstants.kLeft, 18),
            new DriveDistance(30, 0.5, m_drive),
            new TurnDegrees(m_drive, 95, .25, DriveConstants.kLeft, 18),
            new DriveDistance(120, 0.5, m_drive),
            //to end
            new DriveDistance(-12, 0.5, m_drive),
            new TurnDegrees(m_drive, -45, .25, DriveConstants.kLeft, 28),
            new DriveDistance(-27, 0.5, m_drive)
        );
    }
}