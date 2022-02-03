package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.IntakeSubsystem;

public class IntakeInCommand extends CommandBase{
    IntakeSubsystem intakeSubsystem;

    public IntakeInCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        intakeSubsystem.setIntakeVelo(0.55);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.setIntakeVelo(0);
    }
}
