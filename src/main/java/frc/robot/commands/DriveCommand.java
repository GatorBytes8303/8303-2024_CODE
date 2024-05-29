// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages commands
package frc.robot.commands;

// Imports packages
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
  // Inits variables
  private final DriveSubsystem m_drivetrain;
  private final Double m_left;
  private final Double m_right;

  /** Creates a new TankDriveCommand. */
  public DriveCommand(Double left, Double right, DriveSubsystem drivetrain) {
    // Drives drivetrain
    m_drivetrain = drivetrain;
    m_left = left;
    m_right = right;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_drivetrain.drive(m_left, m_right);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stops drive motors
    m_drivetrain.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
