// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class ArmLiftCommand extends Command {

  private final ArmSubsystem m_arm;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;

  /** Creates a new ArmLiftCommand. */
  public ArmLiftCommand(DoubleSupplier left, DoubleSupplier right, ArmSubsystem arm) {

    m_arm = arm;
    m_left = left;
    m_right = right;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arm.armLift(m_left.getAsDouble(), m_right.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.armLift(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
