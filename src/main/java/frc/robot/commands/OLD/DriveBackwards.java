package frc.robot.commands.OLD;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveBackwards extends CommandBase {
    double initialPosition = 0;
    double currentPosition = 0;
    double distance = 0;
    double mod = 0;

    //This command will drive the robot forward when called. Speed refers to the 
    public DriveBackwards(double speed, double distanceToTravel){
        distance = distanceToTravel;
        mod = -speed;
    }

    @Override
    public void initialize() {
        //gets the initial position of the encoder, and starts driving the robot.
        RobotContainer.m_driveSubsystem.encoderReset();
        initialPosition = RobotContainer.m_driveSubsystem.getLinearDistanceEncoder();
        RobotContainer.m_driveSubsystem.tankDrive(-1.0, -1.0);
    }

    @Override
    public void execute() {
        //Measures the current position of the robot, and continues powering the drivetrain.
        currentPosition = RobotContainer.m_driveSubsystem.getLinearDistanceEncoder();
        RobotContainer.m_driveSubsystem.tankDrive(-1, -1);
    }

    @Override
    public void end(boolean interrupted) {
        //Stop the robot from moving after the command ends.
        RobotContainer.m_driveSubsystem.tankDrive(0.0, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
      //Check if the robot has reached the target distance.
      return (currentPosition >= distance);
    }

    

}
