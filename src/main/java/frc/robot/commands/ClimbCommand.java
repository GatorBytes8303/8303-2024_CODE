// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages commands
package frc.robot.commands;

// Imports packages
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbingSubsystem;

// Allows climb motors to run
public class ClimbCommand extends Command {

  // Initalizes the variable that hold the speed of the climbers and the system to be called
  private final double m_speed;
  ClimbingSubsystem m_Climb;

  /** Creates a new ClimbCommand. */
  public ClimbCommand(double speed, ClimbingSubsystem climb) {

    // Sets varibles to input parameters
    m_speed = speed;
    m_Climb = climb;
    m_Climb.runMotor(m_speed, m_speed * -1);
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Climb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Runs the climb motors at the set speed
    
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stops climb motors
    m_Climb.runMotor(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
