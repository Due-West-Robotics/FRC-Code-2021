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
            new TurnDegrees(m_drive, 268.481, .4,DriveConstants.kRight,24),
            new DriveDistance(46.744, .5, m_drive),
            new TurnDegrees(m_drive, 0, .4,DriveConstants.kLeft,24),
            new DriveDistance(48, .5, m_drive));
    }
}