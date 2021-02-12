package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{

    private final CANSparkMax intakeMotor = new CANSparkMax(DriveConstants.kIntakeMotorPort,
                                                            CANSparkMax.MotorType.kBrushed);

    public IntakeSubsystem() {
      intakeMotor.set(1);
    }
    public void stopIntake() {
      
    }

  }   
