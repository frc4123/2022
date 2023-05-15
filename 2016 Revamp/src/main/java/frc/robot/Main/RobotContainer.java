package frc.robot.Main;

import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.UsbCameraInfo;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController; 


import frc.robot.Main.Commands.*;

import frc.robot.Main.Commands.IntakeCommands;
// import frc.robot.Main.Commands.ShooterCommands; This gives error ???

import frc.robot.Main.Subsystems.Drivetrain;
import frc.robot.Main.Subsystems.Shooter;
import frc.robot.Main.Subsystems.Intake;

 //to fix with vendordeps



public class RobotContainer {
    //subsystems
    private final Drivetrain m_drivetrain = new Drivetrain();
    private final Intake m_intake = new Intake();
    private final Shooter m_shooter = new Shooter();
    //Commands
    private final ShooterCommands m_shooteron = new ShooterCommands(m_shooter);
    private final IntakeIn m_intakein = new IntakeIn(m_intake);
    private final IntakeOut m_intakeout = new IntakeOut(m_intake);

    private final CommandXboxController driverController = new CommandXboxController(UsbConstants.DRIVER_CONTROLLER_PORT);
    private final CommandXboxController driverController2 = new CommandXboxController(UsbCameraInfoConstants.AUXDRIVER_CONTROLLER_PORT);

    public void initializeSubsystems() {
      // add negative (-) to getLeftY to invert drive
      m_drivetrain.setDefaultCommand(
        new SetDrivetrain(
          m_drivetrain, 
          () -> -driverController.getLeftY(), 
          () -> -driverController.getRightX()));
    }

    public RobotContainer() {
        configureButtonBindings();
        initializeSubsystems();
      }

      private void configureButtonBindings() {
        // driverController2.leftBumper().onTrue(new WaitCommand(0.1).andThen(m_toggleControl).withTimeout(0.5));    
        // driverController2.rightBumper().onTrue(new WaitCommand(0.1).andThen(m_toggleSet).withTimeout(0.5));
        driverController.b().whileTrue(m_shooter);
        driverController.a().whileTrue(m_intakein);
        driverController.y().whileTrue(m_intakeout);
        
      }
}
