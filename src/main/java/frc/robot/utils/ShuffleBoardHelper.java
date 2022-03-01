package frc.robot.utils;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ComplexWidget;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import edu.wpi.first.wpilibj.shuffleboard.ComplexWidget;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Drivetrain;

import java.util.Map;

public class ShuffleBoardHelper {

    public static BuiltInWidgets kPowerDistribution;
    private final TwoMeterAuto twoMeterAuto;
    private final ShuffleboardTab driverTab;
    private ComplexWidget pdhWidget;
    private SendableChooser<Command> chooser;
    private PowerDistribution pdh; 

    /**
     * Used to create all {@link Shuffleboard} widgets for the robot.
     *
     * @param driveSubsystem the drive subsystem
     */
    public ShuffleBoardHelper(Drivetrain drivetrain) {
        driverTab = Shuffleboard.getTab("Driver Board");

        twoMeterAuto = new TwoMeterAuto(drivetrain);
        pdh = new PowerDistribution();
        chooser = new SendableChooser<>();

        setupLayout();
    }

    private void setupLayout() {
        driverTab.add("Select program for auto", chooser).withPosition(0, 0).withSize(2, 1);
        chooser.setDefaultOption("2 meter", twoMeterAuto.getCommand());

        pdhWidget = driverTab.add("PDH", pdh).withWidget(kPowerDistribution).withPosition(0, 7).withSize(3, 2);
    }

    /**
     * Returns the selected {@code Command} in the {@link SendableChooser} box on
     * Shuffleboard.
     *
     * @return the selected autonomous command
     */
    public Command getSelectedCommand() {
        return chooser.getSelected();
    }

    /**
     * Returns this {@link #pdpWidget}. This displays the power draw per PDP channel
     * and total voltage and amperage.
     *
     * @return this {@link #pdpWidget}
     */
    public ComplexWidget getPdpWidget() {
        return pdhWidget;
    }
}
