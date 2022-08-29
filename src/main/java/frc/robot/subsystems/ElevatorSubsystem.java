package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIdConstants;

public class ElevatorSubsystem extends SubsystemBase{
    private final TalonSRX elev = new TalonSRX(CanIdConstants.ELEVATOR_MASTER_ID);

    /** Creates a new ElevatorSubsystem */
    public ElevatorSubsystem(){
        elev.configOpenloopRamp(1);
        elev.setNeutralMode(NeutralMode.Brake);
    }

    public void setElevatorVelo(double velo){
        elev.set(ControlMode.PercentOutput, velo);
    }
}