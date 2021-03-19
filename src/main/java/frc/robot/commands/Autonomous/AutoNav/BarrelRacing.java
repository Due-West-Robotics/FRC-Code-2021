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
    new DriveDistance(m_drive, 95, 0.5),
    new TurnDegrees(m_drive, 360, 0.5,DriveConstants.kRight,28.5),
    new DriveDistance(m_drive, 100, 0.5),
    new TurnDegrees(m_drive, 337.5, 0.5,DriveConstants.kRight,33),
    new DriveDistance(m_drive, 52, 0.5),
    new TurnDegrees(m_drive, 270, 0.5,DriveConstants.kRight,46),
    new DriveDistance(m_drive, 245, 0.8));
    }
}
