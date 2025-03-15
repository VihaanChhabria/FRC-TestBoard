// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CoralSensorSubsystem extends SubsystemBase {
  /** Creates a new NoteDetector. */

  private static CoralSensorSubsystem instance;

  private final int SensorPort = 1;

  private DigitalInput sensor;

  public CoralSensorSubsystem() {
    sensor = new DigitalInput(SensorPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    SmartDashboard.putBoolean("Coral Status", getCoralStatus());
  }

  /*
   * Returns true if ring is seen
   * false if ring is not seen
   */

  public boolean getCoralStatus() {
    return sensor.get();
  }


  public static CoralSensorSubsystem getInstance() {
    if (instance == null) {
      instance = new CoralSensorSubsystem();
      return instance;
    }
    return instance;
  }
}
