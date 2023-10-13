package frc.robot.subsystems;

import static frc.robot.Constants.SHOOTER_ID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(SHOOTER_ID, MotorType.kBrushless);

    private Shooter() {
        motor.setIdleMode(IdleMode.kCoast);
        motor.setInverted(false);

        motor.setOpenLoopRampRate(2);
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    private static Shooter instance;

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }
}
