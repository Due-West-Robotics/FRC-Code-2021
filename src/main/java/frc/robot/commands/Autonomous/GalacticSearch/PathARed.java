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
            new StartIntake(m_intake),
            new DriveDistance(85, 0.5, m_drive),
            new TurnDegrees(m_drive, 90, 0.5, DriveConstants.kRight, 0),
            new DriveDistance(30, 0.5, m_drive),
            new TurnDegrees(m_drive, 180, 0.5, DriveConstants.kLeft, 15),
            new DriveDistance(90, 0.5, m_drive),
            new TurnDegrees(m_drive, 90, 0.5, DriveConstants.kRight, 0),
            new DriveDistance(150, 0.75, m_drive)
        );
    }
}