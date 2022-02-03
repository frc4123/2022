package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.IndexerSubsystem;

public class IndexOutCommand extends CommandBase{
    IndexerSubsystem indexerSubsystem;

    public IndexOutCommand(IndexerSubsystem indexerSubsystem) {
        this.indexerSubsystem = indexerSubsystem;
        addRequirements(indexerSubsystem);
    }

    @Override
    public void execute() {
        indexerSubsystem.setIndexerVelo(-0.55);
    }

    @Override
    public void end(boolean interrupted) {
        indexerSubsystem.setIndexerVelo(0);
    }
}
