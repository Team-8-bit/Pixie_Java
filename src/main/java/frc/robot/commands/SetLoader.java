package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Loader;

public class SetLoader extends CommandBase {
    private final Loader loader = Loader.getInstance();

    private final double speed;

    public SetLoader(double speed) {
        this.speed = speed;
    }

    @Override
    public void initialize() {
        loader.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
