package frc.robot.commands.Autonomous.GalacticSearch;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class PathBBlue extends SequentialCommandGroup {

    DriveSubsystem m_drive;
    IntakeSubsystem m_intake;

    public PathBBlue(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
        m_drive = driveSubsystem;
        m_intake = intakeSubsystem;
        addCommands(
            new DriveDistance(m_drive,-24, 0.65),
            new StartIntake(m_intake),
            new DriveDistance(m_drive, 129, 0.5),
            new TurnDegrees(m_drive, -90, 0.5, DriveConstants.kLeft, 14.25),
            new DriveDistance(m_drive, 90.75, 0.5),
            new TurnDegrees(m_drive, 0, 0.5, DriveConstants.kRight, 17.5),
            new DriveDistance(m_drive, 25, 0.5),
            new TurnDegrees(m_drive, 90, 0.5, DriveConstants.kRight, 17.5),
            new DriveDistance(m_drive, 60, 0.5),
            new TurnDegrees(m_drive, 0, 0.5, DriveConstants.kLeft, 15),
            new DriveDistance(m_drive, 45, 0.5),
            new TurnDegrees(m_drive, -90, 0.5, DriveConstants.kLeft, 10.607),
            new DriveDistance(m_drive, 15, 0.5),
            new TurnDegrees(m_drive, 0, 0.5, DriveConstants.kRight, 19.393),
            new DriveDistance(m_drive, 5, 0.5)
        );
    }
}