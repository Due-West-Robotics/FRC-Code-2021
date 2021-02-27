package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.*;

public class CommandTest extends SequentialCommandGroup {

    DriveSubsystem m_drive;

    public CommandTest(DriveSubsystem driveSubsystem) {
        m_drive = driveSubsystem;
        addCommands(
            new TurnDegrees(m_drive, -90, .4,DriveConstants.kLeft,48));
    }
}