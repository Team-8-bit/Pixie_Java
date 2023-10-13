package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class SetShooter extends CommandBase {
    private final Shooter shooter = Shooter.getInstance();

    private final double speed;

    public SetShooter(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        shooter.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
