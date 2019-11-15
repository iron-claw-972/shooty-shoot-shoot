
package frc.robot;

import edu.wpi.first.wpilibj.*;


public class Robot extends TimedRobot {

  FlywheelControl fc = new FlywheelControl();

  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    fc.update();

  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testPeriodic() {
  }
}
