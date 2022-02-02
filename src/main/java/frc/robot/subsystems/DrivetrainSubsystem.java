// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    public WPI_TalonFX m_FL,m_FR,m_RL,m_RR;
    public MotorControllerGroup m_leftSide, m_rightSide;
    public DifferentialDrive m_drive;
  /** Creates a new Drivetrain subsystem and assigns sides. */
  public DrivetrainSubsystem() {
    m_FL = new WPI_TalonFX(1);
    m_RL = new WPI_TalonFX(2);

    m_leftSide = new MotorControllerGroup(m_FL, m_RL);

    m_FR = new WPI_TalonFX(3);
    m_RR = new WPI_TalonFX(4);

    m_rightSide = new MotorControllerGroup(m_FR, m_RR);

    m_drive = new DifferentialDrive(m_leftSide,m_rightSide);
  }
  
  public void tankDrive(double speedLeft, double speedRight, double mod){
      m_drive.tankDrive(speedLeft*mod, speedRight*mod);
  }

  public double getEncoderDistance(int motor) {
    switch(motor)
    {
      case 1:
      //get FL motor encoder rotation
      return m_FL.getSelectedSensorPosition(); //in theory this should work (per 4096 sensor units, do math to figure out the accurate distance in inches)

      case 2:
      //get RL motor encoder rotation
      return m_RL.getSelectedSensorPosition();

      case 3:
      //get FR motor encoder rotation
      return m_FR.getSelectedSensorPosition();

      case 4:
      //get RR motor encoder rotation
      return m_RR.getSelectedSensorPosition();

    }
    return 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}