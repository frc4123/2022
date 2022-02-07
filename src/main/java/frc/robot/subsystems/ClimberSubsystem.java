package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIdConstants;

public class ClimberSubsystem extends SubsystemBase{
    private final TalonSRX climb = new TalonSRX(CanIdConstants.CLIMBER_MASTER_ID);

    public ClimberSubsystem(){
        climb.configOpenloopRamp(1);
        climb.setNeutralMode(NeutralMode.Brake);
    }

    public void setClimberVelo(double velo){
        climb.set(ControlMode.PercentOutput, velo);
    }
}