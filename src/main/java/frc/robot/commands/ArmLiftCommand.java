// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages commands
package frc.robot.commands;

// Imports packages
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

// Lifting code is created here for execution via controls
public class ArmLiftCommand extends Command {

  // Initialises variables 
  private final ArmSubsystem m_arm;
  private final double m_direction;

  // Creates a new ArmLiftCommand
  public ArmLiftCommand(int direction, ArmSubsystem arm) {

    // Variables take input parameters to be used in command
    m_arm = arm;
    m_direction = direction;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Runs the lifting command on the arm
    m_arm.armLift(m_direction * ArmConstants.kArmSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stops arm
    m_arm.armLift(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
