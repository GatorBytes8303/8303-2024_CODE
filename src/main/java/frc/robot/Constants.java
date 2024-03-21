// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Packages constants for rest of code to use
package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

 // Allows constants to be called by other java files
public final class Constants {

  // Controller port number
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  // Drivetrain constants
  public static class DriveConstants {
    // Left side motor controller settings/id
    public static final int kLeftLeadMotorID = 10;
    public static final int kLeftFollowMotorID = 11;
    public static final boolean kLeftLeadMotorInverted = true;
    public static final boolean kLeftFollowMotorInverted = false;

    // Right side motor controller settings/id
    public static final int kRightLeadMotorID = 12;
    public static final int kRightFollowMotorID = 13;
    public static final boolean kRightLeadMotorInverted = false;
    public static final boolean kRightFollowMotorInverted = false;

    // Speed sensativity
    public static double kDriveSpeedMultiplier = 1;
  }
  
  // Arm motor constants
  public static class ArmConstants {
    // Motor controller settings/id
    public static final int kArmMotorID = 14;
    public static final boolean kArmMotorInverted = false;
    public static final double kArmSpeed = 0.08;

    // PID to allow percise semi-automatic controll
    public static final double kP = 0.025;
    public static final double kI = 0;
    public static final double kD = 0;

    // Positions
    public static double kASetpoint = 89.5;
    public static double kBSetpoint = 190;
    public static double kCSetpoint = 20;

  }
  
  // Scoring motor constants
  public static class ScoringConstants {
    // Motor controller settings/id
    public static final int kScoringMotorID = 15;
    public static final boolean kScoringMotorInverted = true;
  }
  
  // Constants not related to other major components
  public static class MiscConstants {
    public static boolean kRobotIsTeleoperated = true;
  }
}
