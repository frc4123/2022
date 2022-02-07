// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
// import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
// import edu.wpi.first.wpilibj.util.Units;

public final class Constants {
    /** USB ports on the computer */
    public static final class UsbConstants {

        public static final int DRIVER_CONTROLLER_PORT = 0;
        public static final int AUXDRIVER_CONTROLLER_PORT = 1;
        public static final int USB_PORT_2 = 2;
        public static final int USB_PORT_3 = 3;
    }

    /** Xbox buttons to their corresponding integer value. */
    public static final class XboxConstants {

        // Button mappings
        public static int D_PAD = 0;
        public static int A_BUTTON = 1;
        public static int B_BUTTON = 2;
        public static int X_BUTTON = 3;
        public static int Y_BUTTON = 4;
        public static int LB_BUTTON = 5;
        public static int RB_BUTTON = 6;
        public static int BACK_BUTTON = 7;
        public static int START_BUTTON = 8;
        public static int LEFT_STICK = 9;
        public static int RIGHT_STICK = 10;

        // Axis control mappings
        // Notes:
        // - Left and right trigger use axis 3
        // - Left trigger range: 0 to 1
        // - Right trigger range: 0 to -1).
        public static int LEFT_AXIS_X = 6;
        public static int LEFT_AXIS_Y = 1;
        public static int LEFT_TRIGGER_AXIS = 2;
        public static int RIGHT_TRIGGER_AXIS = 3;
        public static int RIGHT_AXIS_X = 4;
        public static int RIGHT_AXIS_Y = 5;

        // Direction pad lookup angles
        public static int POV_UP = 0;
        public static int POV_RIGHT = 90;
        public static int POV_DOWN = 180;
        public static int POV_LEFT = 270;
    }

    /**
     * PS4 buttons and their corresponding integer value. Note: you must use
     * DS4Windows in order to use a PS4 controller on a computer
     */
    public static final class PS4Constants {

        public static int X_BUTTON = 1;
        public static int O_BUTTON = 2;
        public static int SQUARE_BUTTON = 3;
        public static int TRIANGLE_BUTTON = 4;
    }

    /** Logitech buttons and their corresponding integer value */
    public static final class LogitechConstants {

        public static final int ONE_BUTTON = 1;
        public static final int TWO_BUTTON = 2;
        public static final int THREE_BUTTON = 3;
        public static final int FOUR_BUTTON = 4;
        public static final int LB_BUTTON = 5;
        public static final int RB_BUTTON = 6;
    }

    /** Values relating to the robot's drive train */
    public static final class DriveConstants {

        // middle to middle of the wheel
        public static final double TRACK_WIDTH_METERS = 0.638;
        public static final int MAG_ENCODER_CPR = 4096;
        public static final int TALONFX_ENCODER_CPR = 2048;
        // !remove from calculations if not using an integrated encoder
        public static final double GEAR_RATIO = 11.25; // 12:50 => 20:54 on a falconfx gives 14.8 fps. Driven/Driver
        public static final double WHEEL_DIAMETER_METERS = 0.15875;
        public static final double WHEEL_CIRCUMFERENCE_METERS = Math.PI * WHEEL_DIAMETER_METERS;
        public static final int TIMEOUT = 50;
    }

    /**
     * Mapping between physical CAN devices and their corresponding ID in the CAN
     * chain
     */
    public static final class CanIdConstants {

        // Note: RIO is always 0
        // Note: PDH is always 1
        public static final int RIGHT_MASTER_ID = 2;
        public static final int RIGHT_SLAVE_ID = 3;
        public static final int LEFT_MASTER_ID = 4;
        public static final int LEFT_SLAVE_ID = 5;
        public static final int SHOOTER_MASTER_ID = 6;
        public static final int INTAKE_MASTER_ID = 7;
        public static final int ELEVATOR_MASTER_ID = 8;
        public static final int INTAKE_DRAW_ID = 9;
        public static final int CLIMBER_MASTER_ID = 10;
    }

    /**
     * Values relating to path finding and trajectory following. See
     * {@see FourMeterAuto}
     */
    public static final class TrajectoryConstants {

        public static final double KS = 1.2;
        public static final double KV = 0.329;
        public static final double KA = 0.0933;
        public static final double KP = 8.5;

        public static final double RAMSETE_B = 2.0;
        public static final double RAMSETE_ZETA = 0.7;

        public static final double MAX_VELOCITY = 3;
        public static final double MAX_ACCELERATION = 3;

        public static final double STARTING_POSE_X = 0;
        public static final double STARTING_POSE_Y = 0;
        public static final boolean IS_GYRO_REVERSED_FOR_PATHWEAVER = true;

        // public static final DifferentialDriveKinematics DRIVE_KINEMATICS = new DifferentialDriveKinematics(
        //         DriveConstants.TRACK_WIDTH_METERS);

        // public static final SimpleMotorFeedforward SIMPLE_MOTOR_FEED_FOrWARD = new SimpleMotorFeedforward(
        //         TrajectoryConstants.KS, TrajectoryConstants.KV, TrajectoryConstants.KA);
    }

    /**
     * Values relating to the auto-aim feature of the robot. See
     * {@see AutoAimCommand}.
     */
    public static final class AutoAimConstants {
        // !MAKE SURE THIS IS RIGHT
        // see if we can just pull this from Network tables
        public static final String CAMERA_NAME = "Microsoft_LifeCam_HD-3000";
        // !CHARACTERIZE THE ROBOT FOR THESE VALUES
        public static final double KP = 0.009;
        public static final double KI = 0.0;
        public static final double KD = 0.01;
        public static final double FFW = 0.29;
        // public static final double KA = 0;
        // public static final double KV = 0;
        // public static final double KS = 0;

        /** Tolerance for the Vision PID. Units are in degrees. */
        public static final double TOLERANCE = 0.1;

        // TODO get these values
        // public static final double CAMERA_HEIGHT_METERS = Units.inchesToMeters(21.375);
        // // 73.25
        // // 53
        // // taller gives longer distance
        // public static final double TARGET_HEIGHT_METERS = Units.inchesToMeters(83);
        // // measures 28 but gives bad result, so 23 is used
        // public static final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(23);
    }
}