package frc.robot.commands.Autonomous.GalacticSearch;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class PathBRed extends SequentialCommandGroup {

    DriveSubsystem m_drive;
    IntakeSubsystem m_intake;

    /**
     * Creates a new autonomous PathBRed command.
     *
     * @param driveSubsystem The drive subsystem with which this sequential command will run
     * @param intakeSubsystem The intake subsystem with which this sequential command will run
     */

    public PathBRed(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
        m_drive = driveSubsystem;
        m_intake = intakeSubsystem;
        addCommands(
            new DriveDistance(m_drive,-24, 0.65),
            new StartIntake(m_intake),
            new DriveDistance(m_drive,34, 0.5),
            new TurnDegrees(m_drive, -90, 0.5, DriveConstants.kLeft, 19.25),
            new DriveDistance(m_drive,32.372, 0.5),
            new TurnDegrees(m_drive, 0, 0.5, DriveConstants.kRight, 17.391),
            new DriveDistance(m_drive,25.218, 0.5),
            new TurnDegrees(m_drive, 90, 0.5, DriveConstants.kRight, 17.391),
            new DriveDistance(m_drive,81.622, 0.5),
            new TurnDegrees(m_drive, -90, 0.5, DriveConstants.kLeft, 30),
            new DriveDistance(m_drive,60, 0.5),
            new TurnDegrees(m_drive, 0, 0.5, DriveConstants.kRight, 21.622),
            new DriveDistance(m_drive,105, 0.75),
            new StopIntake(m_intake)
        );
    }
}
