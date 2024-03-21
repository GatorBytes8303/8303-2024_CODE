// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages commands
package frc.robot.commands;

// Imports packages
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.Command;

// Slows down robot driving
public class BrakeCommand extends Command {
  /** Creates a new BrakeCommand. */

  public BrakeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //  Slows speed to this percent of the input value 
    DriveConstants.kDriveSpeedMultiplier = 0.35;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Releases brake and allows driving at normal speed
    DriveConstants.kDriveSpeedMultiplier = 1;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
