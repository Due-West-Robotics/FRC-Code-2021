package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class CommandTest extends SequentialCommandGroup {

    DriveSubsystem m_drive;

    public CommandTest(DriveSubsystem driveSubsystem) {
        m_drive = driveSubsystem;
        addCommands(
            new TurnDegrees(m_drive, 90, .4,DriveConstants.kRight,12));
    }
}