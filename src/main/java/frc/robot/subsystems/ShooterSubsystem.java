package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIdConstants;

public class ShooterSubsystem extends SubsystemBase{
    private final TalonSRX shooter = new TalonSRX(CanIdConstants.SHOOTER_MASTER_ID);

    /** Creates a new ShooterSubsystem */
    public ShooterSubsystem(){
        shooter.configOpenloopRamp(1);
        shooter.setNeutralMode(NeutralMode.Brake);
    }

    public void setShooterVelo(double velo){
        shooter.set(ControlMode.PercentOutput, velo);
    }
}
