package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIdConstants;

public class IntakeDrawSubsystem extends SubsystemBase {
    private final TalonSRX motor = new TalonSRX(CanIdConstants.INTAKE_DRAW_ID);

    public IntakeDrawSubsystem() {
        motor.configOpenloopRamp(1);
        motor.setNeutralMode(NeutralMode.Brake);
    }

    public void setIntakeDrawVelo(double velo) {
        motor.set(ControlMode.PercentOutput, velo);
    }
}
