// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.ColorFlowAnimation.Direction;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.math.estimator.DifferentialDrivePoseEstimator;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(CanIdConstants.LEFT_MASTER_ID);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(CanIdConstants.RIGHT_MASTER_ID);
  private final WPI_VictorSPX leftSlave = new WPI_VictorSPX(CanIdConstants.LEFT_SLAVE_ID);
  private final WPI_VictorSPX rightSlave = new WPI_VictorSPX(CanIdConstants.RIGHT_SLAVE_ID);

  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMaster, rightMaster); 
  
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftMaster.configContinuousCurrentLimit(10, 0);
    leftMaster.configPeakCurrentLimit(15, 0);
    leftMaster.configPeakCurrentDuration(100, 0);
    leftMaster.enableCurrentLimit(true);

    rightMaster.configContinuousCurrentLimit(40, 0);
    rightMaster.configPeakCurrentLimit(60, 0);
    rightMaster.configPeakCurrentDuration(500, 0);
    rightMaster.enableCurrentLimit(true);

    leftMaster.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0,
        DriveConstants.TIMEOUT);
    rightMaster.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0,
        DriveConstants.TIMEOUT);

      leftMaster.setNeutralMode(NeutralMode.Brake);
      rightMaster.setNeutralMode(NeutralMode.Brake);
      rightSlave.setNeutralMode(NeutralMode.Brake);
      leftSlave.setNeutralMode(NeutralMode.Brake);
        
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

  }
  
  public void arcadeDrive(double speed, double direction){
    differentialDrive.arcadeDrive(speed, direction);
  }

  
  



  
  
}
