package frc.robot.Main.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Main.Subsystems.Intake;

public class IntakeCommands {
    Intake intake;

    public IntakeCubeIn(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.setIntakeRollerSpeedVelo(-0.4);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setIntakeRollerSpeedakeVelo(0);
    }
}
