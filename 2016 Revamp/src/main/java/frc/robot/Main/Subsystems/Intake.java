package frc.robot.Main.Subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Main.Constants;

public class Intake {
    private final WPI_TalonSRX intakeRoller = new WPI_TalonSRX(Constants.INTAKE_CAN_ID);

       // if it is pushing it out with a positive value change this
       intakeRoller.configOpenloopRamp(.3);
       intakeRoller.setInverted(false);
     }
   
     public void setIntakeRollerSpeed(double speed) {
       intakeRoller.set(speed);
     }
    
}
