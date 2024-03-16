// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.ClimbingConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ClimbingSubsystem extends SubsystemBase {


  private final CANSparkMax m_leadMotor;
  private final CANSparkMax m_followMotor;
  //private final RelativeEncoder m_encoder;
  //private final SparkPIDController m_controller;


  /** Creates a new ClimbingSubsystem. */
  public ClimbingSubsystem() {

    m_leadMotor = new CANSparkMax(ClimbingConstants.kClimberLeadMotorID, MotorType.kBrushed);
    m_leadMotor.setInverted(ClimbingConstants.kClimberLeadMotorInverted);
    m_followMotor = new CANSparkMax(ClimbingConstants.kClimberFollowMotorID, MotorType.kBrushed);
    m_followMotor.follow(m_leadMotor, true);

    //m_encoder = m_leadMotor.getEncoder();
    //m_controller = m_leadMotor.getPIDController();

    //m_encoder.setPositionConversionFactor(1);
    //m_controller.setP(ClimbingConstants.kP);
    //m_controller.setI(ClimbingConstants.kI);
    //m_controller.setD(ClimbingConstants.kD);
    //m_controller.setFeedbackDevice(m_encoder);

    
    m_leadMotor.burnFlash();
    //m_followMotor.burnFlash();

  }

  public void climb(double speed) {
    m_leadMotor.set(speed);
     //m_controller.setReference(ClimbingConstants.kASetpoint, ControlType.kPosition);
  }

  public void runMotor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
