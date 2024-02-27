// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ScoringConstants;

import com.revrobotics.CANSparkLowLevel.MotorType;

public class ScoringSubsystem extends SubsystemBase {

  private CANSparkMax m_scoringMotor;

  private RelativeEncoder m_encoder;

  /** Scoring Motor */
  public ScoringSubsystem() {
  m_scoringMotor = new CANSparkMax(ScoringConstants.kScoringMotorID, MotorType.kBrushless);
  m_scoringMotor.setInverted(ScoringConstants.kScoringMotorInverted); 
  }

  /* What runs when the subsystem is not being used. aka the default setting. */
  public void setScorer(double speed){

    m_scoringMotor.set(speed);

  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      m_encoder = m_scoringMotor.getEncoder();
      SmartDashboard.putNumber("Scoring Encoder Position", m_encoder.getPosition());
      SmartDashboard.putNumber("Scoring Encoder Velocity", m_encoder.getVelocity());
  }
}
