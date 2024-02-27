// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class DriveConstants {
    public static final int kLeftLeadMotorID = 10;
    public static final int kLeftFollowMotorID = 11;
    public static final boolean kLeftLeadMotorInverted = true;
    public static final boolean kLeftFollowMotorInverted = false;

    public static final int kRightLeadMotorID = 12;
    public static final int kRightFollowMotorID = 13;
    public static final boolean kRightLeadMotorInverted = false;
    public static final boolean kRightFollowMotorInverted = false;

    public static final double kDriveSpeedMultiplier = 0.7;
  }
  
  public static class ArmConstants {
    public static final int kArmMotorID = 14;
    public static final boolean kArmMotorInverted = false;
    public static final double kArmSpeedMultiplier = 0.2;
  }
  
  public static class ScoringConstants {
    public static final int kScoringMotorID = 15;
    public static final boolean kScoringMotorInverted = true;
  }

}
