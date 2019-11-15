package frc.robot;

public class PositionController {

    private float currentTime;
    private float pastTime;
    private float timeDifference;
    private float referenceTime;

    private final double MAX_VEL = 0;
    private final double MAX_ACCEL = 0;
    private final double MAX_JERK = 0;

    private final double P = 0;
    private final double I = 0;
    private final double D = 0;
    private double currentError;
    private double pastError;
    private double errorDifference;
    private double integralMemory;
    private double derivative;

    private double truePos;
    private double desiredPos;


    public PositionController() {
        referenceTime = getTimeSeconds();
        integralMemory = 0;
    }

    public void update() {
        pastTime = currentTime;
        currentTime = getTimeSeconds();
        timeDifference = currentTime - pastTime;
        
        pastError = currentError;
        currentError = truePos - desiredPos;
        errorDifference = currentError - pastError;

    }

    private double PID() {
        derivative = errorDifference/timeDifference;
        integralMemory += currentError * timeDifference;
        return P * currentError + I * integralMemory + D * derivative;
    }

    private double motionProfile() {
        
    }

    private float getTimeSeconds() {
        return System.currentTimeMillis()/1000;
    }

}