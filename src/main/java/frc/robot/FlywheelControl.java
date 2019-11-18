package frc.robot;

import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class FlywheelControl {
    public final double desiredSpeed = 0.25;
    public final double p = 0.5;
    public final double i = 0;
    public final double d = 0;
    public final double f = 0;

    private TalonSRX talon1 = new TalonSRX(1);
    private TalonSRX talon2 = new TalonSRX(2);
    private TalonSRX talon3 = new TalonSRX(3);
    private TalonSRX talon4 = new TalonSRX(4);

    private double error = 0;
    private double lastError = 0;
    private double integral = 0;

    private long lastTime;
    private long currentTime;

    public void update() {
        System.out.println(talon1.getSensorCollection().getQuadratureVelocity());
        error = desiredSpeed - talon1.getSensorCollection().getQuadratureVelocity();
        currentTime = System.currentTimeMillis();

        integral += (currentTime - lastTime) * error;
        double derivative = (error - lastError) * (currentTime - lastTime);
 
        double power = p*error + i*integral + d*derivative + f*desiredSpeed;
        talon1.set(ControlMode.PercentOutput, power);
        talon2.set(ControlMode.PercentOutput, power);
        talon3.set(ControlMode.PercentOutput, -power);
        talon4.set(ControlMode.PercentOutput, -power);

        lastError = error;
        lastTime = System.currentTimeMillis();
    }+ 
}