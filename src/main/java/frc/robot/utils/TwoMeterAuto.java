package frc.robot.utils;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.Drivetrain;

public class TwoMeterAuto {

    private final Trajectory path;
    private final Command command;

    /**
     * Auto profile that drives 2 meters backwards.
     * 
     * @param drivetrain the driveSubsystem
     */
    public TwoMeterAuto(Drivetrain drivetrain){
        path = drivetrain.pathList.get(0);

        command = new SequentialCommandGroup(
                new InstantCommand(() -> drivetrain.resetPose(path.getInitialPose()), drivetrain),
                drivetrain.ramseteCommand(path),
                new InstantCommand(() -> drivetrain.arcadeDrive(0, 0), drivetrain));
    }

    /**
     * Returns this Command
     * 
     * @return this Command
     */
    public Command getCommand() {
        System.out.println("Two meters");
        return command;
    }
}
