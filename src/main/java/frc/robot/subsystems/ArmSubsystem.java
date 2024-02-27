// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ArmConstants;

import com.revrobotics.CANSparkLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {

  private CANSparkMax m_armMotor;
  private RelativeEncoder m_encoder;

  /** Arm Motor */
  public ArmSubsystem() {
  m_armMotor = new CANSparkMax(ArmConstants.kArmMotorID, MotorType.kBrushless);
  m_armMotor.setInverted(ArmConstants.kArmMotorInverted); 
  }

  private double speed;
  /* What runs when the subsystem is not being used. aka the default setting. */
  public void armLift(double left, double right){

    left = left * ArmConstants.kArmSpeedMultiplier;
    right = right * ArmConstants.kArmSpeedMultiplier;
    speed = right - left;

    m_armMotor.set(speed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run, reports Encoder data
      m_encoder = m_armMotor.getEncoder();
      SmartDashboard.putNumber("Arm Encoder Position", m_encoder.getPosition());
      SmartDashboard.putNumber("Arm Encoder Velocity", m_encoder.getVelocity());
  }
}
