// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages commands
package frc.robot.commands;

// Imports packages
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ScoringSubsystem;

//Runs scoring motor in reverse
public class GrabbingCommand extends Command {

  // Grabs scoring motor code
  private final ScoringSubsystem m_scorer;

  /** Creates a new GrabbingCommand. */
  public GrabbingCommand(ScoringSubsystem scorer) {
    // The variable is set to the param motor
    m_scorer = scorer;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_scorer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Runs motor in reverse
    m_scorer.setScorer(-0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stops motor
    m_scorer.setScorer(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
