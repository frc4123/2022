package frc.robot.Main.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Main.Constants.CanIdConstants;

public class Shooter extends SubsystemBase{
    
  private final WPI_TalonSRX shooter = new WPI_TalonSRX(CanIdConstants.SHOOTER_CAN_ID);

  public Shooter() {
    shooter.configOpenloopRamp(.3);
    shooter.setInverted(false);
  }
   
  public void setShooterSpeed(double speed) {
    shooter.set(speed);
  }
}
