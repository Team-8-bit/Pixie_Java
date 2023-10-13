package frc.robot.subsystems;

import static frc.robot.Constants.LOADER_ID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Loader extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(LOADER_ID, MotorType.kBrushless);

    private Loader() {
        motor.setIdleMode(IdleMode.kBrake);
        motor.setInverted(false);
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    private static Loader instance;

    public static Loader getInstance() {
        if (instance == null) {
            instance = new Loader();
        }
        return instance;
    }
}
