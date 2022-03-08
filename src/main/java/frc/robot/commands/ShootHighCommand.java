package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
/**
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.networktables.NetworkTableEntry;
*/

import frc.robot.subsystems.ShooterSubsystem;

public class ShootHighCommand extends CommandBase{
    ShooterSubsystem shooterSubsystem;
    /**
    private ShuffleboardTab tab = Shuffleboard.getTab("Main");
    public NetworkTableEntry maxSpeed = 
    tab.add("Shooter High Speed", 1)
        .withWidget(BuiltInWidgets.kTextView)
        .getEntry();
    */

    public ShootHighCommand(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }
    
    @Override
    public void execute() {
        /**
        double max = maxSpeed.getDouble(0.2125);
        shooterSubsystem.setShooterVelo(1 * max);
        */
        shooterSubsystem.setShooterVelo(0.5);
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.setShooterVelo(0);
    }
}
