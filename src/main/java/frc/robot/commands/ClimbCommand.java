// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbingSubsystem;

public class ClimbCommand extends Command {

  private final double m_speed;
  private final ClimbingSubsystem m_climb;


  /** Creates a new ClimbCommand. */
  public ClimbCommand(double speed, ClimbingSubsystem climb) {

    m_speed = speed;
    m_climb = climb;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_climb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_climb.climb(m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_climb.climb(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
