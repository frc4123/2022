// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanIdConstants;

public class IntakeDrawSubsystem extends SubsystemBase {

    private final TalonSRX motor = new TalonSRX(CanIdConstants.INTAKE_DRAW_ID);

    /** Creates a new IntakeDrop. */
    public IntakeDrawSubsystem() {
        motor.configOpenloopRamp(1);
        motor.setNeutralMode(NeutralMode.Brake);
    }

    /**
     * Sets the velocity of the Intake motor.
     * 
     * @param velo the velocity of the intake motor in percent
     */
    public void setIntakeDrawVelo(double velo) {
        motor.set(ControlMode.PercentOutput, velo);
    }
}
