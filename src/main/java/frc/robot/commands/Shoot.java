package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class Shoot extends SequentialCommandGroup {
    public Shoot(double speed, int shots) {
        addCommands(
            new SetShooter(speed),
            new WaitCommand(1.2),
            new SetLoader(0.3),
            new WaitCommand(0.25 * shots),
            new ConditionalCommand(new WaitCommand(0.25 * (shots - 2)), new InstantCommand(), () -> shots > 2),
            new SetLoader(0),
            new WaitCommand(0.25),
            new SetShooter(0)
        );
    }
}
