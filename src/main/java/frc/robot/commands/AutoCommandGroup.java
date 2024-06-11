// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutoCommandGroup. */
  public AutoCommandGroup(DriveSubsystem drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        new DriveCommand(DriveConstants.kAutoDriveSpeed * -1, DriveConstants.kAutoDriveSpeed * -1, drive),
        new DriveCommand(0.0, 0.0, drive)
    );
  }
}
