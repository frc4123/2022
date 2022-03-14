package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.IntakeDrawSubsystem;

public class IntakeDrawDownCommand extends CommandBase {
    IntakeDrawSubsystem intakeDrawSubsystem;

    public IntakeDrawDownCommand(IntakeDrawSubsystem intakeDrawSubsystem) {
        this.intakeDrawSubsystem = intakeDrawSubsystem;
        addRequirements(intakeDrawSubsystem);
    }

    @Override
    public void execute() {
        intakeDrawSubsystem.setIntakeDrawVelo(0.5);
    }

    @Override
    public void end(boolean interrupted) {
        intakeDrawSubsystem.setIntakeDrawVelo(0);
    }
}
