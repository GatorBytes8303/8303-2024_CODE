// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages subsytems
package frc.robot.subsystems;

// Imports packages
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

// Drivetrain to be called
public class DriveSubsystem extends SubsystemBase {

  // Allows drive to be diff driven
  private DifferentialDrive m_drive;

  // Motor controllers declared
  private CANSparkMax m_leftLeadMotor;
  private CANSparkMax m_leftFollowMotor;

  private CANSparkMax m_rightLeadMotor;
  private CANSparkMax m_rightFollowMotor;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

    // Left Motors
    m_leftLeadMotor = new CANSparkMax(DriveConstants.kLeftLeadMotorID, MotorType.kBrushless);
    m_leftFollowMotor = new CANSparkMax(DriveConstants.kLeftFollowMotorID, MotorType.kBrushless);
    m_leftLeadMotor.setInverted(DriveConstants.kLeftLeadMotorInverted);
    m_leftFollowMotor.follow(m_leftLeadMotor, DriveConstants.kLeftFollowMotorInverted);

    // Right Motors 
    m_rightLeadMotor = new CANSparkMax(DriveConstants.kRightLeadMotorID, MotorType.kBrushless);
    m_rightFollowMotor = new CANSparkMax(DriveConstants.kRightFollowMotorID, MotorType.kBrushless);
    m_rightLeadMotor.setInverted(DriveConstants.kRightLeadMotorInverted);
    m_rightFollowMotor.follow(m_rightLeadMotor, DriveConstants.kRightFollowMotorInverted);

    // Constructs the drivetrain 
    m_drive = new DifferentialDrive(m_leftLeadMotor, m_rightLeadMotor);
  }

  // What runs when the subsystem is not being used. aka the default setting. 
  // This method is used in TankDriveCommand to go a certain speed 
  public void drive(double left, double right) {
    // Changes sensativity with constants
    left = left * DriveConstants.kDriveSpeedMultiplier;
    right = right * DriveConstants.kDriveSpeedMultiplier;

    // Slows even more
    m_drive.tankDrive(left, right);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
