package frc.robot.Main.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Main.Subsystems.Intake;

public class IntakeIn extends CommandBase {
    Intake intake;

    public IntakeIn(Intake intake) {
        this.intake = intake;
        addRequirements((Subsystem)intake);
    }

    @Override
    public void execute() {
        intake.setIntakeSpeed(-0.4);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setIntakeSpeed(0);
    }
}
