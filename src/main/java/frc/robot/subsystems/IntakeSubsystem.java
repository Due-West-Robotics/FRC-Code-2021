package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{

    private final CANSparkMax intakeMotor = new CANSparkMax(DriveConstants.kIntakeMotorPort,
                                                            CANSparkMax.MotorType.kBrushed);

    public IntakeSubsystem() {
    }

    public void stopIntake() {
      intakeMotor.set(0);
    }
    @Override
    public void periodic() {
      intakeMotor.set(1);
      // This method will be called once per scheduler run
    }
  
    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }

  }   
