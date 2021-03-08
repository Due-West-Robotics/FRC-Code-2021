// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.AutoNav;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.*;
import frc.robot.commands.*;

public class BarrelRacing extends SequentialCommandGroup {

  DriveSubsystem m_drive;

  public BarrelRacing(DriveSubsystem driveSubsystem) {
    m_drive = driveSubsystem;
    addCommands(
    new DriveDistance(13, 0.25, m_drive),
    new TurnDegrees(m_drive, 90, 0.2,DriveConstants.kRight,24),
    new DriveDistance(5, 0.25, m_drive),
    new TurnDegrees(m_drive, 90, 0.2,DriveConstants.kRight,24),
    new DriveDistance(5, 0.25, m_drive),
    new TurnDegrees(m_drive, 90, 0.2,DriveConstants.kRight,24),
    new DriveDistance(5, 0.25, m_drive),
    new TurnDegrees(m_drive, 90, 0.2,DriveConstants.kRight,24),
    new DriveDistance(7, 0.25, m_drive),
    new WaitCommand(5));
    }
}
