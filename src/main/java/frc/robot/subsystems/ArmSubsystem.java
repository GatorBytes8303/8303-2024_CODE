// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages subsytems
package frc.robot.subsystems;

// Imports packages
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ArmConstants;

import com.revrobotics.CANSparkLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {
  
  private CANSparkMax m_armMotor;
  private RelativeEncoder m_encoder;
  // pid cont
  private SparkPIDController m_controller;

  /** Arm Motor */
  public ArmSubsystem() {

  m_armMotor = new CANSparkMax(ArmConstants.kArmMotorID, MotorType.kBrushless);
  m_armMotor.restoreFactoryDefaults();
  m_armMotor.setInverted(ArmConstants.kArmMotorInverted); 

  m_encoder = m_armMotor.getEncoder();

  // assign pid cont
  m_controller = m_armMotor.getPIDController();
  m_encoder.setPositionConversionFactor(18);
  m_controller.setP(ArmConstants.kP);
  m_controller.setI(ArmConstants.kI);
  m_controller.setD(ArmConstants.kD);
  m_controller.setFeedbackDevice(m_encoder);

  m_armMotor.burnFlash();
  }

  public Command setAngleCommandA(){
    return Commands.runOnce(() -> setAngleA());
  }

  public Command setAngleCommandB(){
    return Commands.runOnce(() -> setAngleB());
  }

  public Command setAngleCommandC(){
    return Commands.runOnce(() -> setAngleC());
  }

  /* What runs when the subsystem is not being used. aka the default setting. */
  public void armLift(double speed){

    m_armMotor.set(speed);

  }

  //PID control
  private void setAngleA() {
    m_controller.setReference(ArmConstants.kASetpoint, ControlType.kPosition);
  }

  private void setAngleB() {
    m_controller.setReference(ArmConstants.kBSetpoint, ControlType.kPosition);
  }

  private void setAngleC() {
    m_controller.setReference(ArmConstants.kCSetpoint, ControlType.kPosition);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run, reports Encoder data
      m_encoder = m_armMotor.getEncoder();
      SmartDashboard.putNumber("Arm Encoder Position", m_encoder.getPosition());
      SmartDashboard.putNumber("Arm Encoder Velocity", m_encoder.getVelocity());
  }
}
