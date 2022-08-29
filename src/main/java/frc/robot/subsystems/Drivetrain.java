package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

/**
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.networktables.NetworkTableEntry;
import java.util.Map;
*/

public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX leftLeader = new WPI_TalonSRX(CanIdConstants.LEFT_MASTER_ID);
  private final WPI_TalonSRX rightLeader = new WPI_TalonSRX(CanIdConstants.RIGHT_MASTER_ID);
  private final WPI_VictorSPX leftFollower = new WPI_VictorSPX(CanIdConstants.LEFT_SLAVE_ID);
  private final WPI_VictorSPX rightFollower = new WPI_VictorSPX(CanIdConstants.RIGHT_SLAVE_ID);

  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftFollower, rightLeader);
  /**
    double max = maxSpeed.getDouble(1.0);
    differentialDrive.arcadeDrive(speed * max, direction * max);
  */
  
  public Drivetrain() {
    leftLeader.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, DriveConstants.TIMEOUT);
    rightLeader.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, DriveConstants.TIMEOUT);

    leftLeader.setNeutralMode(NeutralMode.Brake);
    rightLeader.setNeutralMode(NeutralMode.Brake);
    rightFollower.setNeutralMode(NeutralMode.Brake);
    leftFollower.setNeutralMode(NeutralMode.Brake);
        
    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);
  }
  
/**
  private ShuffleboardTab tab = Shuffleboard.getTab("Main");
  public NetworkTableEntry maxSpeed = 
    tab.addPersistent("Max Speed", 1)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0, "max", 1))
      .getEntry();
  */

  public void arcadeDrive(double speed, double direction){
    differentialDrive.arcadeDrive(speed, direction);
  }
}