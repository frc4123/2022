package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIdConstants;

public class IntakeSubsystem extends SubsystemBase{
    private final TalonSRX index = new TalonSRX(CanIdConstants.INTAKE_MASTER_ID);

    /** Creates a new IntakeSubsystem */
    public IntakeSubsystem(){
        index.configOpenloopRamp(1);
        index.setNeutralMode(NeutralMode.Brake);
    }

    public void setIntakeVelo(double velo){
        index.set(ControlMode.PercentOutput, velo);
    }
}
