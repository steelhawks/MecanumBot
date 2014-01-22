/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc2014.team2601.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import frc2014.team2601.Constants;
import frc2014.team2601.commands.Drive;

/**
 *
 * @author Neil
 */
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    class ReversedTalon extends Talon{
        public ReversedTalon(int channel){
            super(channel);
        }
        
        public void set(double speed){
            super.set(speed*-1);
        }
    }
    
    //Talon motor controller initialization
    Talon frontLeft = new ReversedTalon(Constants.FRONT_LEFT);
    Talon rearLeft = new ReversedTalon(Constants.REAR_LEFT);
    Talon frontRight = new Talon(Constants.FRONT_RIGHT);
    Talon rearRight = new Talon(Constants.REAR_RIGHT);
    
    //Miscellaneous drive objects and variables
    RobotDrive robotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    private double speed = 1.0; //TODO: Replace with SFX/LiveWindow implementation for quick speed changing
    
    //Sensor initialization
    Gyro gyro = new Gyro(Constants.GYRO);
    private final double sensitivity = 0.07;
    
    public Drivetrain(){
        gyro.setSensitivity(sensitivity);
        robotDrive.stopMotor();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Drive());
    }
    
    public void resetGyro(){
        gyro.reset();
    }
    
    public void mecanumDrive(Joystick joystick){
        double x = joystick.getX();
        double y = joystick.getY();
        double rotation = joystick.getTwist();
        double angle = gyro.getAngle();
        robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
    }
    
    public void setSpeed(double speed){
        this.speed = speed;
    }
}
