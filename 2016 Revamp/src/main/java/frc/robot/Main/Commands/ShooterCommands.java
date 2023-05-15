package frc.robot.Main.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Main.Subsystems.Shooter;

public class ShooterCommands {
    Shooter shooter;

    public IntakeCubeIn(Intake intake) {
        this.shooter = shooter;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        shooter.setShooterSpeedVelo(-0.4);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.setShooterSpeedakeVelo(0);
    }
}
