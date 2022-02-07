package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ClimberSubsystem;

public class ClimberUpCommand extends CommandBase{
    ClimberSubsystem climberSubsystem;

    public ClimberUpCommand(ClimberSubsystem climberSubsystem){
        this.climberSubsystem = climberSubsystem;
        addRequirements(climberSubsystem);
    }

    @Override
    public void execute() {
        climberSubsystem.setClimberVelo(0.4);
    }

    @Override
    public void end(boolean interrupted) {
        climberSubsystem.setClimberVelo(0);
    }
}
