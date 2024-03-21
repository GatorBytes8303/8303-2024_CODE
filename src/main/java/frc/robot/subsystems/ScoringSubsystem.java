// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages subsytems
package frc.robot.subsystems;

// Imports packages
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ScoringConstants;

// Runs scoring motor
public class ScoringSubsystem extends SubsystemBase {

  // Declares motor controller
  private CANSparkMax m_scoringMotor;

  // Scoring Motor settings
  public ScoringSubsystem() {
  m_scoringMotor = new CANSparkMax(ScoringConstants.kScoringMotorID, MotorType.kBrushless);
  m_scoringMotor.setInverted(ScoringConstants.kScoringMotorInverted); 
  }

  /* What runs when the subsystem is not being used. aka the default setting. */
  public void setScorer(double speed){
  // Motor runs at this speed
    m_scoringMotor.set(speed);

  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
