package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorDownCommand extends CommandBase{
    ElevatorSubsystem elevatorSubsystem;

    public ElevatorDownCommand(ElevatorSubsystem elevatorSubsystem) {
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        elevatorSubsystem.setElevatorVelo(-0.55);
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.setElevatorVelo(0);
    }
}