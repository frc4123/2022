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
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.UsbConstants;

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
import frc.robot.commands.AutoDriveBackCommand;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeDrawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ClimberSubsystem;

import frc.robot.utils.TwoMeterAuto;

public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final IntakeDrawSubsystem intakeDrawSubsystem = new IntakeDrawSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();

  private final XboxController driverController = new XboxController(UsbConstants.DRIVER_CONTROLLER_PORT);
  private final XboxController driverController2 = new XboxController(UsbConstants.AUXDRIVER_CONTROLLER_PORT);

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
  private final AutoDriveBackCommand autoDriveBackCommand = new AutoDriveBackCommand(drivetrain);

  private final TwoMeterAuto twoMeterAuto = new TwoMeterAuto(drivetrain);

  private void calibrate() {
    System.out.println("Gyro is calibrating...");
    drivetrain.calibrateGyro();
  }

  public RobotContainer() {
    // add negative (-) to getLeftY to invert drive (shooter will be the back, intake will be the front)
    calibrate();
    configureButtonBindings();

    drivetrain.setDefaultCommand(new RunCommand(() -> drivetrain.arcadeDrive(
      driverController.getRightX(),
      driverController.getLeftY()),
      drivetrain));
  }

  private void configureButtonBindings() {
    Button lb = new JoystickButton(driverController, XboxConstants.LB_BUTTON);
    Button rb = new JoystickButton(driverController, XboxConstants.RB_BUTTON);
    Button a = new JoystickButton(driverController2, XboxConstants.A_BUTTON);
    Button b = new JoystickButton(driverController2, XboxConstants.B_BUTTON);
    Button x = new JoystickButton(driverController2, XboxConstants.X_BUTTON);
    Button y = new JoystickButton(driverController2, XboxConstants.Y_BUTTON);
    POVButton povUp = new POVButton(driverController2, 0);
    POVButton povUpRight = new POVButton(driverController2, 45);
    POVButton povRight = new POVButton(driverController2, 90);
    POVButton povDownRight = new POVButton(driverController2, 135);
    POVButton povDown = new POVButton(driverController2, 180);
    POVButton povDownLeft = new POVButton(driverController2, 225);
    POVButton povLeft = new POVButton(driverController2, 270);
    POVButton povUpLeft = new POVButton(driverController2, 315);

    lb.whenHeld(shootHighCommand);
    rb.whenHeld(shootCommand);
    a.whenHeld(intakeInCommand);
    b.whenHeld(intakeDrawUpCommand);
    x.whileHeld(intakeDrawDownCommand);
    y.whileHeld(intakeOutCommand);
    povUp.whileHeld(elevatorUpCommand);
    povUpRight.whileHeld(elevatorUpCommand);
    povUpLeft.whileHeld(elevatorUpCommand);
    povDown.whileHeld(elevatorDownCommand);
    povDownRight.whileHeld(elevatorDownCommand);
    povDownLeft.whileHeld(elevatorDownCommand);
    povRight.whileHeld(climberUpCommand);
    povLeft.whileHeld(climberDownCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //return new SequentialCommandGroup(shootCommand.alongWith(elevatorUpCommand.withTimeout(5)), twoMeterAuto.getCommand());
    return new WaitCommand(.2)
    .andThen(new ShootCommand(shooterSubsystem)).alongWith(new WaitCommand(4)
    .andThen(new ElevatorUpCommand(elevatorSubsystem))).withTimeout(7)
    .andThen(new AutoDriveBackCommand(drivetrain).withTimeout(7));
  }
  
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
