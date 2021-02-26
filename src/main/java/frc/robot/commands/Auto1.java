// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.*;

public class Auto1 extends SequentialCommandGroup {

  DriveSubsystem m_drive;

  public Auto1(DriveSubsystem driveSubsystem) {
    m_drive = driveSubsystem;
    addCommands(new DriveDistance(12, 0.25, m_drive),
     new WaitCommand(5));
     //new TurnDegrees(m_drive, 90, 0.2,DriveConstants.kRight,24));
  }
}
