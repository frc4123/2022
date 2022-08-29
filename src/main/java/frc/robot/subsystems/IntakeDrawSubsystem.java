package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIdConstants;

public class IntakeDrawSubsystem extends SubsystemBase {
    private final TalonSRX draw = new TalonSRX(CanIdConstants.INTAKE_DRAW_ID);

    /** Creates a new IntakeDrawSubsystem */
    public IntakeDrawSubsystem() {
        draw.configOpenloopRamp(1);
        draw.setNeutralMode(NeutralMode.Brake);
    }

    public void setIntakeDrawVelo(double velo) {
        draw.set(ControlMode.PercentOutput, velo);
    }
}
