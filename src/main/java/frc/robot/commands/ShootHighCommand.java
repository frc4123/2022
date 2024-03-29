package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ShooterSubsystem;

public class ShootHighCommand extends CommandBase{
    ShooterSubsystem shooterSubsystem;

    public ShootHighCommand(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }
    
    @Override
    public void execute() {
        //shooterSubsystem.setShooterVelo(0.325);  for competition
        shooterSubsystem.setShooterVelo(1); //for club carnival
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.setShooterVelo(0);
    }
}
