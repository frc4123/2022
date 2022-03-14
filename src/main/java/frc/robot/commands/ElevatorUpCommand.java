package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorUpCommand extends CommandBase{
    ElevatorSubsystem elevatorSubsystem;

    public ElevatorUpCommand(ElevatorSubsystem elevatorSubsystem) {
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        elevatorSubsystem.setElevatorVelo(0.4);
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.setElevatorVelo(0);
    }
}