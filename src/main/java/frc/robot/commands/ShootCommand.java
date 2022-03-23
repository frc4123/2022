package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
/**
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.networktables.NetworkTableEntry;
*/

import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends CommandBase{
    ShooterSubsystem shooterSubsystem;

    public ShootCommand(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }
    
    @Override
    public void execute() {
        shooterSubsystem.setShooterVelo(0.25);
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.setShooterVelo(0);
    }
}
