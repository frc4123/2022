package frc.robot.Main.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Main.Constants.CanIdConstants;

public class Intake extends SubsystemBase{

    private final WPI_TalonSRX intake = new WPI_TalonSRX(CanIdConstants.INTAKE_CAN_ID); {

       // if it is pushing it out with a positive value change this
       intake.configOpenloopRamp(.3);
       intake.setInverted(false);
     }
   
     public void setIntakeSpeed(double speed) {
       intake.set(speed);
     }
    
}
