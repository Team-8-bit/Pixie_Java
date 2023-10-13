// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IncrementHood;
import frc.robot.commands.Shoot;

public class RobotContainer {
  public static final CommandXboxController xbox = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    xbox.leftBumper().whileTrue(new DriveCommand());

    Trigger hoodStepUp = new Trigger(() -> xbox.getRightY() < -0.1);
    Trigger hoodStepDown = new Trigger(() -> xbox.getRightY() > 0.1);

    xbox.leftBumper().negate().and(hoodStepUp).whileTrue(
        new RepeatCommand(
            new SequentialCommandGroup(
                new IncrementHood(0.5),
                new WaitCommand(0.1))));
    xbox.leftBumper().negate().and(hoodStepDown).whileTrue(
        new RepeatCommand(
            new SequentialCommandGroup(
                new IncrementHood(-0.5),
                new WaitCommand(0.1))));

    xbox.a().onTrue(new Shoot(0.4));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}