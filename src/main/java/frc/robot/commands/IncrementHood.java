package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hood;

public class IncrementHood extends CommandBase {
    private final Hood hood = Hood.getInstance();

    private final double increment;

    public IncrementHood(double increment) {
        this.increment = increment;
    }

    @Override
    public void initialize() {
        System.out.println(hood.getTargetPosition() + increment);
        hood.setTargetPosition(hood.getTargetPosition() + increment);
    }

    @Override
    public boolean isFinished() {
        return hood.atPosition();
    }
}
