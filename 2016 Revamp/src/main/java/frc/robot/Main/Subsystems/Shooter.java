package frc.robot.Main.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Main.Constants;

public class Shooter {
    
  private final WPI_TalonSRX shooter = new WPI_TalonSRX(Constants.SHOOTER_CAN_ID);

       // if it is pushing it out with a positive value change this
       shooter.configOpenloopRamp(.3);
       shooter.setInverted(false);
     }
   
     public void setIntakeRollerSpeed(double speed) {
       intakeRoller.set(speed);
     }
    
  
}
