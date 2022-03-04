package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.networktables.NetworkTableEntry;

public class ElevatorDownCommand extends CommandBase{
    ElevatorSubsystem elevatorSubsystem;
    private ShuffleboardTab tab = Shuffleboard.getTab("Main");
    public NetworkTableEntry maxSpeed = 
    tab.add("Elevate Down Speed", 1)
        .withWidget(BuiltInWidgets.kTextView)
        .getEntry();

    public ElevatorDownCommand(ElevatorSubsystem elevatorSubsystem) {
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        double max = maxSpeed.getDouble(-0.5);
        elevatorSubsystem.setElevatorVelo(1 * max);
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.setElevatorVelo(0);
    }
}