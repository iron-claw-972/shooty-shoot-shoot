package frc.robot;
import static frc.robot.Constants.*;

public class Solver {
  double a, b, c, discriminant;
  public double getAngle(double distance) {
    a = (GRAVITY*Math.pow(distance, 2))/(2*Math.pow(VELOCITY, 2));
    b = distance;
    c = a + START_HEIGHT - TARGET_HEIGHT;
    discriminant = Math.pow(b, 2) - (4*a*c);

    if (discriminant < 0) {
      return -1;
    }

    double root = (-b-Math.sqrt(discriminant))/(2*a);
    return Math.atan(root)*180/Math.PI;
  }
}
