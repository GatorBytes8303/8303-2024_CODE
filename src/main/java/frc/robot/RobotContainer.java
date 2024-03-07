// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//Constants
import frc.robot.Constants.OperatorConstants;

//Misc
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

//Subsystems
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ScoringSubsystem;

//Commands
import frc.robot.commands.TankDriveCommand;
import frc.robot.commands.BrakeCommand;
import frc.robot.commands.ArmLiftCommand;
import frc.robot.commands.ScoringCommand;
import frc.robot.commands.GrabbingCommand;
import frc.robot.commands.ASetPointTrimCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems are defined here...
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final ArmSubsystem m_arm = new ArmSubsystem();
  private final ScoringSubsystem m_scorer = new ScoringSubsystem();

  // The robot's commands are defined here...
  private final ScoringCommand m_score = new ScoringCommand(m_scorer);
  private final GrabbingCommand m_grab = new GrabbingCommand(m_scorer);
  private final ArmLiftCommand m_armLift = new ArmLiftCommand(1, m_arm);
  private final ArmLiftCommand m_armUnlift = new ArmLiftCommand(-1, m_arm);
  private final BrakeCommand m_brake = new BrakeCommand();
  private final ASetPointTrimCommand m_ATrimUp = new ASetPointTrimCommand(0.5);
  private final ASetPointTrimCommand m_ATrimDown = new ASetPointTrimCommand(-0.5);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //-------- D R I V E T R A I N   C O M M A N D S -------

    //Drive
    m_drive.setDefaultCommand(
      new TankDriveCommand(
        () -> m_driverController.getLeftY(),
        () -> m_driverController.getRightY(),
        m_drive)
      );

    //Brake
    m_driverController
      .leftBumper()
        .whileTrue(
          m_brake
        );
    
    // ------------- A R M   C O M M A N D S ---------

    //Arm Control
    m_driverController
      .leftTrigger()
        .whileTrue(
          m_armLift
        );
  
    //Arm Control
    m_driverController
      .rightTrigger()
        .whileTrue(
          m_armUnlift
      );

    //Arm PID A-Setpoint
    m_driverController
      .a()
        .onTrue(
          m_arm.setAngleCommandA()
        );

    //Arm PID B-Setpoint
    m_driverController
      .b()
        .onTrue(
          m_arm.setAngleCommandB()
        );

    //A-Setpoint trim UP
    m_driverController
      .start()
        .whileTrue(
          m_ATrimUp
        )
          .onFalse(
            m_arm.setAngleCommandA()
          );

    //B-Setpoint trim UP
    m_driverController
      .back()
        .whileTrue(
          m_ATrimDown
        )
          .onFalse(
            m_arm.setAngleCommandA()
          );

    // ---------- S C O R I N G   C O M M A N D S ------

    //Intake
    m_driverController
      .rightBumper()
        .whileTrue(
          m_grab
        );
  
    //Throw    
    m_driverController
      .y()
        .whileTrue(
          m_score
      );

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
    return null;
  }
}
