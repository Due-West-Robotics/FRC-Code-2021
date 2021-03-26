package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class AutoTest extends SequentialCommandGroup {

    DriveSubsystem m_drive;

    public AutoTest(DriveSubsystem driveSubsystem) {
        m_drive = driveSubsystem;
        addCommands(
            new DriveDistance(m_drive, 48, .3),
            new DriveDistance(m_drive, -48, .3));
    }
}