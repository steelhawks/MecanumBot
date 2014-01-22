package frc2014.team2601;

/**
 * The Constants is a mapping from the ports sensors and actuators are wired into
 to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //Drivetrain in Digital Sidecar
    public static final int FRONT_LEFT = 1;
    public static final int REAR_LEFT = 2;
    public static final int FRONT_RIGHT = 3;
    public static final int REAR_RIGHT = 4;
    
    //Sensors in Analogue Breakout
    public static final int GYRO = 2;
    
    //Operator interface
    public static final int JOYSTICK = 1;
    public static final int SPEED_AXIS = 4; //joystick dial
}
