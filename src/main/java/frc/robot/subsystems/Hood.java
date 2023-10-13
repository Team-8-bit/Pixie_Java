package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Hood extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(HOOD_ID, MotorType.kBrushless);
    private final RelativeEncoder encoder = motor.getEncoder();

    private Hood() {
        motor.setSmartCurrentLimit(20);
        motor.setIdleMode(IdleMode.kBrake);
        motor.setInverted(true);

        motor.setOpenLoopRampRate(0.5);

        encoder.setPosition(0);
    }

    public void setTargetPosition(double position) {
        targetPosition = position;
    }

    private double targetPosition = 0;

    @Override
    public void periodic() {
        double currentPosition = encoder.getPosition();
        double speed = (currentPosition - targetPosition) * 0.1;

        motor.set(-speed);
        SmartDashboard.putNumber("currentPosition", currentPosition);
        SmartDashboard.putNumber("targetPosition", targetPosition);
    }

    public boolean atPosition() {
        double currentPosition = encoder.getPosition();
        return Math.abs(currentPosition - targetPosition) < 0.25;
    }

    public double getTargetPosition() {
        return targetPosition;
    }


    private static Hood instance;

    public static Hood getInstance() {
        if (instance == null) {
            instance = new Hood();
        }
        return instance;
    }
}
