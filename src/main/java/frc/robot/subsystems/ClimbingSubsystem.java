// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ClimbingSubsystem extends SubsystemBase {


  private final Victor m_motor;


  /** Creates a new ClimbingSubsystem. */
  public ClimbingSubsystem() {

    m_motor = new Victor(0);



  }

  public void runMotor() {

    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
