package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {
    private final CANSparkMax leftDrive = new CANSparkMax(LEFT_DRIVE_ID, MotorType.kBrushless);
    private final CANSparkMax rightDrive = new CANSparkMax(RIGHT_DRIVE_ID, MotorType.kBrushless);
    private final DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);

    private Drivetrain() {
        configMotor(leftDrive, true);
        configMotor(rightDrive, false);
    }

    public void setSpeeds(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    private void configMotor(CANSparkMax motor, boolean inverted) {
        motor.setIdleMode(IdleMode.kBrake);
        motor.setInverted(inverted);
    }


    private static Drivetrain instance;

    public static Drivetrain getInstance() {
        if (instance == null) {
            instance = new Drivetrain();
        }
        return instance;
    }
}