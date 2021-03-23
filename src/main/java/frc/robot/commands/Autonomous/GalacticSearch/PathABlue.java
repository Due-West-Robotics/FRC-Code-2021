package frc.robot.commands.Autonomous.GalacticSearch;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class PathABlue extends SequentialCommandGroup {

    DriveSubsystem m_drive;
    IntakeSubsystem m_intake;

    public PathABlue(DriveSubsystem driveSubsystem) {
        m_drive = driveSubsystem;
        addCommands(
            new DriveDistance(m_drive,120, 0.5),
            new DriveDistance(m_drive,-24, 0.65),
            new StartIntake(m_intake),
            new DriveDistance(m_drive,54, 0.35),
            new TurnDegrees(m_drive, -90, .25, DriveConstants.kLeft, 0),
            new DriveDistance(m_drive, 96, 0.5),
            new TurnDegrees(m_drive, 90, .25, DriveConstants.kLeft, 0),
            new DriveDistance(m_drive, 60, 0.5),
            new TurnDegrees(m_drive, 90, .25, DriveConstants.kLeft, 0),
            new DriveDistance(m_drive, 40, 0.5),
            new TurnDegrees(m_drive, -90, .25, DriveConstants.kLeft, 0),
            new DriveDistance(m_drive, 64, 0.5)
        );
    }
}