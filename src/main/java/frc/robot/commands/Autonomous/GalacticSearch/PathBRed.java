package frc.robot.commands.Autonomous.GalacticSearch;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class PathBRed extends SequentialCommandGroup {

    DriveSubsystem m_drive;
    IntakeSubsystem m_intake;

    public PathBRed(DriveSubsystem driveSubsystem) {
        m_drive = driveSubsystem;
        addCommands(
            new StartIntake(m_intake),
            new DriveDistance(12, 0.5, m_drive)
        );
    }
}