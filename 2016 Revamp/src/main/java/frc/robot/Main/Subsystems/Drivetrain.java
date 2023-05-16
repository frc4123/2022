package frc.robot.Main.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Main.Constants;
import frc.robot.Main.Constants.CanIdConstants;

// import io.github.oblarg.oblog.Loggable;
// import io.github.oblarg.oblog.annotations.Log;

public class Drivetrain extends SubsystemBase{
    private final WPI_TalonFX leftMaster = new WPI_TalonFX(CanIdConstants.LEFT_MASTER_ID);
    private final WPI_TalonFX  leftSlave = new WPI_TalonFX(CanIdConstants.LEFT_SLAVE_ID);
    private final WPI_TalonFX rightMaster = new WPI_TalonFX(CanIdConstants.RIGHT_MASTER_ID);
    private final WPI_TalonFX  rightSlave = new WPI_TalonFX(CanIdConstants.RIGHT_SLAVE_ID);

    private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMaster, rightMaster);
    
    public Drivetrain() {
        //!Set brake to nuetralmode in firmware
    
        rightSlave.follow(rightMaster);
        leftSlave.follow(leftMaster);
    
        leftMaster.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 10);
        rightMaster.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 10);

        public Void stopMotors(){
            differentialDrive.stopMotor();
          }
        


    }


        
    

    
        //leftMaster.setSensorPhase(true);
        // leftMaster.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        // rightMaster.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

      }

