package frc.robot.Main.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Main.Subsystems.Shooter;

public class ShooterCommands extends CommandBase {
    Shooter shooter;

    public ShooterCommands(Shooter shooter) {
        this.shooter = shooter;
        addRequirements((Subsystem)shooter);
    }

    @Override
    public void execute() {
        shooter.setShooterSpeed(-0.4);
    }
    
    @Override
    public void end(boolean interrupted) {
        shooter.setShooterSpeed(0);
    }
    
}
