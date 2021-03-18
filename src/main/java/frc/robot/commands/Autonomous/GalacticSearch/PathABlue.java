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
            new StartIntake(m_intake),
            new DriveDistance(m_drive, 12, 0.5)
        );
    }
}