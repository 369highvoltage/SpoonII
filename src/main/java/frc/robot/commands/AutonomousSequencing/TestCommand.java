package frc.robot.commands.AutonomousSequencing;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoAim.AutoAimCommand;
import frc.robot.commands.AutoAim.AutoshootCommand;
import frc.robot.commands.Movement.PIDDriveCommand;
import frc.robot.commands.Movement.PIDTurn;
import frc.robot.commands.OLD.TurnRight;
import frc.robot.commands.PIDTesting.PIDRotateTurret;
import frc.robot.commands.PIDTesting.PIDTurnLeft;
import frc.robot.commands.TurretAuto.ConveyorCommand;
import frc.robot.commands.TurretAuto.IntakeCommand;

public class TestCommand {
    public Command Autonomous1() { //Left side autonomous
        return new SequentialCommandGroup(
            new ParallelCommandGroup(
                new IntakeCommand(1, 2),
                new ConveyorCommand(0.6, 1),
                new PIDDriveCommand(0.7, 35)
            ),
            new TurnRight(180, 0.7),
            new AutoshootCommand(0.63, 5)
        );
    }

    public Command Autonomous2() { //Center position autonomous
        return new SequentialCommandGroup(new PIDDriveCommand(0.8, 25)
            //new IntakeCommand(1, 2),
            //new AutoshootCommand(0.6, 16700, 2)
        );
            
    }

    public Command Autonomous3() { //Right side autonomous
        return new SequentialCommandGroup(
            new PIDDriveCommand(15, .5),
            new ParallelCommandGroup(
                new ConveyorCommand(0.5, 1),
                new PIDDriveCommand(20, 0.6),
                new IntakeCommand(1, 1.7)
            ),
            new ParallelCommandGroup(
                new ConveyorCommand(0.5, 0.5),
                new PIDTurn(150, 0.7)
            ),
            new AutoshootCommand(0.68, 5),
            new PIDTurn(65, 0.7)
        );
    }

    public Command Autonomous4() { //Right side autonomous
        return new SequentialCommandGroup(
            // pickup second ball
            new ParallelCommandGroup(
                new ConveyorCommand(0.5, 1),
                new PIDDriveCommand(35, 0),
                new IntakeCommand(1, 1.7)
            ),
            // point towards goal
            new ParallelCommandGroup(
                new ConveyorCommand(0.5, 0.5),
                new PIDTurn(150, 0.7)
            ),
            // shoot
            new AutoAimCommand(0.7),
            // new AutoshootCommand(0.68, 5),
            // travel to third ball
            new PIDTurnLeft(125, 0.7),
            new ParallelCommandGroup(
                new ConveyorCommand(0.5, 1),
                new PIDDriveCommand(65, 0),
                new IntakeCommand(1, 1.7)
            )
            // point towards goal
            // new ParallelCommandGroup(
            //     new ConveyorCommand(0.5, 0.5),
            //     new PIDTurnRight(150, 0.7)
            // ),
            // // shoot
            // new AutoshootCommand(0.68, 5),
        );
    }

    public Command Autonomous5() { //Center Autonomous
        return new SequentialCommandGroup(
            new PIDDriveCommand(15, 0.5),
            new PIDTurn(90, 0.5),
            new PIDRotateTurret(-45),
            new AutoAimCommand(0.6)
        );
        
    }

    }
