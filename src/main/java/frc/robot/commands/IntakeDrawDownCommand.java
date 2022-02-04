// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.IntakeDrawSubsystem;

public class IntakeDrawDownCommand extends CommandBase {
    IntakeDrawSubsystem intakeDrawSubsystem;

    /** Creates a new IntakeDrawDownCommand. */
    public IntakeDrawDownCommand(IntakeDrawSubsystem intakeDrawSubsystem) {
        this.intakeDrawSubsystem = intakeDrawSubsystem;
        addRequirements(intakeDrawSubsystem);
    }

    @Override
    public void execute() {
        intakeDrawSubsystem.setIntakeDrawVelo(-0.1);
    }

    @Override
    public void end(boolean interrupted) {
        intakeDrawSubsystem.setIntakeDrawVelo(0);
    }
}
