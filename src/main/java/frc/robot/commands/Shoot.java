package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class Shoot extends SequentialCommandGroup {
    public Shoot(double speed) {
        addCommands(
            new SetShooter(speed),
            new WaitCommand(.75),
            new SetLoader(0.3),
            new WaitCommand(2),
            new SetShooter(0),
            new SetLoader(0)
        );
    }
}
