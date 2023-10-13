// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends CommandBase {
  private final Drivetrain drivetrain = Drivetrain.getInstance();

  /** Creates a new DriveCommand. */
  public DriveCommand() {
    addRequirements(drivetrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = deadzone(RobotContainer.xbox.getLeftY() * 0.5);
    double rightSpeed = deadzone(RobotContainer.xbox.getRightY() * 0.5);
    drivetrain.setSpeeds(leftSpeed, rightSpeed);
  }

  public double deadzone(double input) {
    if (Math.abs(input) < 0.1) {
      return 0;
    } else {
      return input;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setSpeeds(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
