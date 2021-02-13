// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();

  // The autonomous routines

  // A simple auto routine that drives forward a specified distance, and then stops.
  /*private final Command m_simpleAuto =
      new DriveDistance(
          AutoConstants.kAutoDriveDistanceInches, AutoConstants.kAutoDriveSpeed, m_robotDrive);

 /* // A complex auto routine that drives forward, drops a hatch, and then drives backward.
  private final Command m_complexAuto = new ComplexAuto(m_robotDrive, m_hatchSubsystem);
*/
  //A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();


  // The driver's controller
  GenericHID m_driverController = new Joystick(0);

  private final Command m_arcadeDrive = new ArcadeDrive(m_robotDrive,
  () -> m_driverController.getY(GenericHID.Hand.kLeft),
  () -> m_driverController.getX(GenericHID.Hand.kRight));

  private final Command m_defaultDrive = new DefaultDrive(m_robotDrive);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new ArcadeDrive(
            m_robotDrive,
            () -> m_driverController.getY(GenericHID.Hand.kLeft),
            () -> m_driverController.getX(GenericHID.Hand.kRight)));

    /*m_intakeSubsystem.setDefaultCommand(
      // A split-stick arcade command, with forward/backward controlled by the left
      // hand, and turning controlled by the right.
      new startIntake(
          m_intakeSubsystem));*/

   // Add commands to the autonomous command chooser
    m_chooser.setDefaultOption("Default", m_arcadeDrive);
    //m_chooser.addOption("Complex Auto", m_arcadeDrive);

    //Put the chooser on the dashboard
    Shuffleboard.getTab("Teleop").add(m_chooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Grab the hatch when the 'A' button is pressed.
    new JoystickButton(m_driverController, 5).whenPressed(new startIntake(m_intakeSubsystem));
    new JoystickButton(m_driverController, 6).whenPressed(new stopIntake(m_intakeSubsystem));
    }
    



  /*public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
   /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getTeleopCommand() {
    return m_chooser.getSelected();
  }

  public void arcadeDrive() {
    m_arcadeDrive.schedule();
  }
}