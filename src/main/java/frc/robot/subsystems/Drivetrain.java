// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.List;

import com.ctre.phoenix.led.ColorFlowAnimation.Direction;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.estimator.DifferentialDrivePoseEstimator;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(CanIdConstants.LEFT_MASTER_ID);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(CanIdConstants.RIGHT_MASTER_ID);
  private final WPI_VictorSPX leftSlave = new WPI_VictorSPX(CanIdConstants.LEFT_SLAVE_ID);
  private final WPI_VictorSPX rightSlave = new WPI_VictorSPX(CanIdConstants.RIGHT_SLAVE_ID);

  private final ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMaster, rightMaster);

  // https://docs.wpilib.org/en/stable/docs/software/wpilib-tools/robot-characterization/introduction.html
  private final DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(gyro.getRotation2d());

  private final DifferentialDriveVoltageConstraint autoVoltageConstraint = new DifferentialDriveVoltageConstraint(TrajectoryConstants.SIMPLE_MOTOR_FEED_FOrWARD, 
    TrajectoryConstants.DRIVE_KINEMATICS, 10);
  
  private final PIDController ramseteController = new PIDController(TrajectoryConstants.KP, 0, 0);
  
  private final TrajectoryConfig config = new TrajectoryConfig(TrajectoryConstants.MAX_VELOCITY,
    TrajectoryConstants.MAX_ACCELERATION).setKinematics(TrajectoryConstants.DRIVE_KINEMATICS).addConstraint(autoVoltageConstraint);

  public final List<Trajectory> pathList;
  
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

    pathList = List.of(
      TrajectoryGenerator.generateTrajectory(new Pose2d(0, 0, new Rotation2d(0)),
        List.of(new Translation2d(1, 0)), new Pose2d(3, 0, new Rotation2d(0)), config),
      TrajectoryGenerator.generateTrajectory(new Pose2d(0, 0, new Rotation2d(0)),
        List.of(new Translation2d(2, 0)), new Pose2d(4, 0, new Rotation2d(0)), config));
    resetEncoders();
  }
  
  public void arcadeDrive(double speed, double direction){
    differentialDrive.arcadeDrive(speed, direction);
  }

  /**
    * Tank drive. Typically used for trajectory following.
    *
    * @param leftVolts  the voltage to supply to the left side of the drive train
    * @param rightVolts the voltage to supply to the right side of the drive train
    */
    public void voltDrive(double leftVolts, double rightVolts) {
      // TODO make sure this is voltage compensated
      leftMaster.setVoltage(leftVolts);
      rightMaster.setVoltage(-rightVolts);
      differentialDrive.feed();
  }

  /** Calibrates the gyro. */
  public void calibrateGyro() {
    gyro.calibrate();
  }

  /** Sets the gyro to a heading of 0 degrees. */
  public void resetGyro() {
    gyro.reset();
  }

  /** Sets drive train encoders to 0 meters. */
  public void resetEncoders() {
    leftMaster.setSelectedSensorPosition(0, 0, DriveConstants.TIMEOUT);
    rightMaster.setSelectedSensorPosition(0, 0, DriveConstants.TIMEOUT);
  }

  /**
    * Resets the specified pose. Resets the drive train encoders and the
    * {@link Pose2d} instance.
    *
    * @param pose the Pose2d instance to reset
    */
  public void resetPose(Pose2d pose) {
    resetEncoders();
    odometry.resetPosition(pose, gyro.getRotation2d());
  }

  /**
    * Returns a {@code DifferentialDriveWheelSpeeds} object.
    *
    * @return a {@link DifferentialDriveWheelSpeeds} object
    */
    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
      return new DifferentialDriveWheelSpeeds(getLeftWheelSpeed(), getRightWheelSpeed());
  }

  /**
    * Returns the position, in meters, of the left side of the wheelbase. Position
    * accumulates stating from when the robot is turned on.
    *
    * @return the current position, in meters, of the left side of the wheelbase
    */
    private double getLeftWheelPosition() {
      // TODO remove gear ratio when using talonsrxs
      return ((leftMaster.getSelectedSensorPosition() * DriveConstants.WHEEL_CIRCUMFERENCE_METERS
              / DriveConstants.TALONFX_ENCODER_CPR) / DriveConstants.GEAR_RATIO);
  }

  /**
    * Returns the position, in meters, of the right side of the wheelbase. Position
    * accumulates stating from when the robot is turned on.
    *
    * @return the current position, in meters, of the right side of the wheelbase
    */
    private double getRightWheelPosition() {
      return ((leftMaster.getSelectedSensorPosition() * DriveConstants.WHEEL_CIRCUMFERENCE_METERS
              / DriveConstants.TALONFX_ENCODER_CPR) / DriveConstants.GEAR_RATIO);
  }

  /**
    * Returns the current velocity, in meters per second, of the left side of the
    * wheelbase.
    *
    * @return the current velocity, in meters per second, of the left side of the
    *         wheelbase
    */
    private double getLeftWheelSpeed() {
      return (leftMaster.getSelectedSensorVelocity(0) * 10 / DriveConstants.TALONFX_ENCODER_CPR
              / DriveConstants.GEAR_RATIO * DriveConstants.WHEEL_CIRCUMFERENCE_METERS);
  }

  /**
    * Returns the current velocity, in meters per second, of the right side of the
    * wheelbase.
    *
    * @return the current velocity, in meters per second, of the right side of the
    *         wheelbase
    */
    private double getRightWheelSpeed() {
      return (leftMaster.getSelectedSensorVelocity(0) * 10 / DriveConstants.TALONFX_ENCODER_CPR
              / DriveConstants.GEAR_RATIO * DriveConstants.WHEEL_CIRCUMFERENCE_METERS);
  }

  /**
    * Returns the {@code Pose2d} instance.
    *
    * @return the {@link Pose2d} instance
    */
    public Pose2d getPose() {
      return odometry.getPoseMeters();
  }

  /**
    * Returns a {@code RamseteCommand} object. Used to follow the specified
    * {@link Trajectory}.
    *
    * @param path the {@code Trajectory} to follow
    * @return a {@link RamseteCommand} object
    */
  public RamseteCommand ramseteCommand(Trajectory path) {
    return new RamseteCommand(path, odometry::getPoseMeters, new RamseteController(),
      TrajectoryConstants.SIMPLE_MOTOR_FEED_FOrWARD, TrajectoryConstants.DRIVE_KINEMATICS,
      this::getWheelSpeeds, ramseteController, ramseteController, this::voltDrive, this);
  }

  @Override
    public void periodic() {
      odometry.update(gyro.getRotation2d(), getLeftWheelPosition(), getRightWheelPosition());
    }
}