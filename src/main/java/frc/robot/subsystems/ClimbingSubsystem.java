// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages subsytems
package frc.robot.subsystems;

// Imports packages
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Code for climbers to activate
public class ClimbingSubsystem extends SubsystemBase {
  
// Declares the varibles as motor controllers
private CANSparkMax leftClimb;
private CANSparkMax rightClimb;


  /** Creates a new ClimbingSubsystem. */
  public ClimbingSubsystem(CANSparkMax leftClimb, CANSparkMax rightClimb) {
    // Sets climb as parameters 
    this.leftClimb = leftClimb;
    this.rightClimb = rightClimb;

  }

  // Motors run as this speed parameters
  public void runMotor(double rightSpeed, double leftSpeed) {
    rightClimb.set(rightSpeed);
    leftClimb.set(leftSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
