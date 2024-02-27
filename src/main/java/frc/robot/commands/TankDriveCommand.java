// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class TankDriveCommand extends Command {
  private final DriveSubsystem m_drivetrain;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  
  /** Creates a new TankDriveCommand. */
  public TankDriveCommand(DoubleSupplier left, DoubleSupplier right, DriveSubsystem drivetrain) {
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
    /*Calls the drive function defined in DriveSubsystem. */
    m_drivetrain.drive(m_left.getAsDouble(), m_right.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
