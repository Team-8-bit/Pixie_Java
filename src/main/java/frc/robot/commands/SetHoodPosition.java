package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hood;

public class SetHoodPosition extends CommandBase {
    private final Hood hood = Hood.getInstance();

    private final double position;

    public SetHoodPosition(double position) {
        this.position = position;
    }

    @Override
    public void initialize() {
        hood.setTargetPosition(position);
    }

    @Override
    public boolean isFinished() {
        return hood.atPosition();
    }
}
