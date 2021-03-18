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
            new DriveDistance(m_drive, 12, 0.5)
        );
    }
}