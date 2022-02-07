// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants.UsbConstants;

// import frc.robot.commands.ExampleCommand;
// import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.ShootHighCommand;
import frc.robot.commands.IntakeInCommand;
import frc.robot.commands.IntakeOutCommand;
import frc.robot.commands.IntakeDrawDownCommand;
import frc.robot.commands.IntakeDrawUpCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.ClimberUpCommand;
import frc.robot.commands.ClimberDownCommand;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeDrawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final IntakeDrawSubsystem intakeDrawSubsystem = new IntakeDrawSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();

  private final XboxController driverController = new XboxController(UsbConstants.DRIVER_CONTROLLER_PORT);

  private final ShootCommand shootCommand = new ShootCommand(shooterSubsystem);
  private final ShootHighCommand shootHighCommand = new ShootHighCommand(shooterSubsystem);
  private final IntakeInCommand intakeInCommand = new IntakeInCommand(intakeSubsystem);
  private final IntakeOutCommand intakeOutCommand = new IntakeOutCommand(intakeSubsystem);
  private final IntakeDrawDownCommand intakeDrawDownCommand = new IntakeDrawDownCommand(intakeDrawSubsystem);
  private final IntakeDrawUpCommand intakeDrawUpCommand = new IntakeDrawUpCommand(intakeDrawSubsystem);
  private final ElevatorUpCommand elevatorUpCommand = new ElevatorUpCommand(elevatorSubsystem);
  private final ElevatorDownCommand elevatorDownCommand = new ElevatorDownCommand(elevatorSubsystem);
  private final ClimberUpCommand climberUpCommand = new ClimberUpCommand(climberSubsystem);
  private final ClimberDownCommand climberDownCommand = new ClimberDownCommand(climberSubsystem);
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drivetrain.setDefaultCommand(new RunCommand(() -> drivetrain.arcadeDrive(driverController.getRightX(),
        driverController.getLeftY()), drivetrain));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Button lb = new JoystickButton(driverController, XboxConstants.LB_BUTTON);
    Button rb = new JoystickButton(driverController, XboxConstants.RB_BUTTON);
    Button a = new JoystickButton(driverController, XboxConstants.A_BUTTON);
    Button b = new JoystickButton(driverController, XboxConstants.B_BUTTON);
    Button x = new JoystickButton(driverController, XboxConstants.X_BUTTON);
    Button y = new JoystickButton(driverController, XboxConstants.Y_BUTTON);
    POVButton povUp = new POVButton(driverController, 0);
    POVButton povDown = new POVButton(driverController, 180);
    POVButton povLeft = new POVButton(driverController, 90);
    POVButton povRight = new POVButton(driverController, 270);

    lb.whileHeld(shootHighCommand);
    rb.whileHeld(shootCommand);
    a.whenHeld(intakeDrawDownCommand);
    b.whenHeld(intakeDrawUpCommand);
    x.whileHeld(intakeInCommand);
    y.whileHeld(intakeOutCommand);
    povUp.whileHeld(elevatorUpCommand);
    povDown.whileHeld(elevatorDownCommand);
    povLeft.whileHeld(climberUpCommand);
    povRight.whileHeld(climberDownCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_autoCommand;
  // }
  
  /**
     * This {@link #driverController}. This is an {@link XboxController} that is
     * used by the main driver of the robot.
     *
     * @return this {@link #driverController}
     */
  public XboxController getDriverController() {
    return driverController;
  }
}
