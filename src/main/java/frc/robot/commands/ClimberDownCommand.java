package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ClimberSubsystem;

public class ClimberDownCommand extends CommandBase{
    ClimberSubsystem climberSubsystem;

    public ClimberDownCommand(ClimberSubsystem climberSubsystem){
        this.climberSubsystem = climberSubsystem;
        addRequirements(climberSubsystem);
    }

    @Override
    public void execute() {
        climberSubsystem.setClimberVelo(-0.6);
    }

    @Override
    public void end(boolean interrupted) {
        climberSubsystem.setClimberVelo(0);
    }
}
