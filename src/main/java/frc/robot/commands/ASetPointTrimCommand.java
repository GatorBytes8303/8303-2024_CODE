// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages commands
package frc.robot.commands;

// Imports packages
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ArmConstants;

// Changes PID setpoint for duration of the instance, resets after shutdown
public class ASetPointTrimCommand extends Command {

  // Initializes the var to contain setpoint
  private final double m_trim;

  // Creates a new ASetPointTrimCommand.
  public ASetPointTrimCommand(double trim) {
    // Allows trim to be set
    m_trim = trim;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Adds one degree on one press
    ArmConstants.kASetpoint += m_trim;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Allows for set point monitoring from dashboard
    SmartDashboard.putNumber("A Setpoint", ArmConstants.kASetpoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
