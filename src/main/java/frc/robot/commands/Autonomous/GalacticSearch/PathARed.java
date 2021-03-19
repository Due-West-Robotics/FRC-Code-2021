package frc.robot.commands.Autonomous.GalacticSearch;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class PathARed extends SequentialCommandGroup {

    DriveSubsystem m_drive;
    IntakeSubsystem m_intake;

    public PathARed(DriveSubsystem driveSubsystem) {
        m_drive = driveSubsystem;
        addCommands(
            new DriveDistance(m_drive,-24, 0.65),
            new StartIntake(m_intake),
            new DriveDistance(m_drive,94, 0.35),
            new TurnDegrees(m_drive, 57.313, 0.5, DriveConstants.kRight, 21.176),
            new TurnDegrees(m_drive, 196, 0.5, DriveConstants.kRight, 11),
            new DriveDistance(m_drive, 94.802, 0.5),
            new TurnDegrees(m_drive, 90, 0.5, DriveConstants.kRight, 0),
            new DriveDistance(m_drive, 155, 0.75)
        );
    }
}