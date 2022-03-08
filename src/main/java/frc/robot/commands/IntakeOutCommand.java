package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
/**
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.networktables.NetworkTableEntry;
*/

import frc.robot.subsystems.IntakeSubsystem;

public class IntakeOutCommand extends CommandBase{
    IntakeSubsystem intakeSubsystem;
    /**
    private ShuffleboardTab tab = Shuffleboard.getTab("Main");
    public NetworkTableEntry maxSpeed = 
    tab.add("Intake Out Speed", 1)
        .withWidget(BuiltInWidgets.kTextView)
        .getEntry();
    */

    public IntakeOutCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        /**
        double max = maxSpeed.getDouble(-0.3);
        intakeSubsystem.setIntakeVelo(1 * max);
        */
        intakeSubsystem.setIntakeVelo(-0.3);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.setIntakeVelo(0);
    }
}
