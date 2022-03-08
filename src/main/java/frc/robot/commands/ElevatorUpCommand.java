package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ElevatorSubsystem;
/**
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.networktables.NetworkTableEntry;
*/

public class ElevatorUpCommand extends CommandBase{
    ElevatorSubsystem elevatorSubsystem;
    /**
    private ShuffleboardTab tab = Shuffleboard.getTab("Main");
    public NetworkTableEntry maxSpeed = 
    tab.add("Elevate Up Speed", 1)
        .withWidget(BuiltInWidgets.kTextView)
        .getEntry();
    */

    public ElevatorUpCommand(ElevatorSubsystem elevatorSubsystem) {
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        /**
        double max = maxSpeed.getDouble(0.5);
        elevatorSubsystem.setElevatorVelo(1 * max);
        */
        elevatorSubsystem.setElevatorVelo(0.5);
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.setElevatorVelo(0);
    }
}