package frc.robot.commands.Autonomous.GalacticSearch;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class PathARed extends SequentialCommandGroup {

    DriveSubsystem m_drive;
    IntakeSubsystem m_intake;

    /**
     * Creates a new autonomous PathARed command.
     *
     * @param driveSubsystem The drive subsystem with which this sequential command will run
     * @param intakeSubsystem The intake subsystem with which this sequential command will run
     */

    public PathARed(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
        m_drive = driveSubsystem;
        m_intake = intakeSubsystem;
        addCommands(
            new DriveDistance(m_drive,-24, 0.65),
            new StartIntake(m_intake),
            new DriveDistance(m_drive,94, 0.35),
            new TurnDegrees(m_drive, 65.374, 0.5, DriveConstants.kRight, 21.176),
            new TurnDegrees(m_drive, 252.538, 0.5, DriveConstants.kRight, 11),
            new DriveDistance(m_drive, 93.675, 0.5),
            new TurnDegrees(m_drive, 360, 0.5, DriveConstants.kRight, 0),
            new DriveDistance(m_drive, 155, 0.75)
        );
    }
}