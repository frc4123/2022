package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIdConstants;

public class IndexerSubsystem extends SubsystemBase{
    private final TalonSRX index = new TalonSRX(CanIdConstants.INTAKE_MASTER_ID);

    public IndexerSubsystem(){
        index.configOpenloopRamp(1);
        index.setNeutralMode(NeutralMode.Brake);
    }

    public void setIndexerVelo(double velo){
        index.set(ControlMode.PercentOutput, velo);
    }
}
