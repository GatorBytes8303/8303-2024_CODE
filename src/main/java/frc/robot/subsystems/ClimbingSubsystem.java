// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ClimbingSubsystem extends SubsystemBase {
private CANSparkMax leftClimb;
private CANSparkMax rightClimb;


  /** Creates a new ClimbingSubsystem. */
  public ClimbingSubsystem(CANSparkMax leftClimb, CANSparkMax rightClimb) {
    this.leftClimb = leftClimb;
    this.rightClimb = rightClimb;

  }

  public void runMotor(double rightSpeed, double leftSpeed) {
    rightClimb.set(rightSpeed*1);
    leftClimb.set(leftSpeed*1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
