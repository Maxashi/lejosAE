package lejosAE;
import lejos.hardware.*;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.*;
import lejos.robotics.navigation.*;

public class RobotTolMa {

	public MovePilot pilot;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Project();
		
	}
	
	
	public static void Project() {
		
		RobotTolMa robot = new RobotTolMa();
		robot.ConfigureRobot();
		
		robot.Testrun();	 
	}
	
	
	public void ConfigureRobot() {
		
		pilot = new MovePilot(CreateChassis());
		System.out.println("Configured!");

	    Sound.beep();
	}
	
	
	public Chassis CreateChassis() {
		
		// Create the chassis configuration
		// Spurweite innen 9cm, mitte: 12 cm
		// Radbeite 3 cm, roller ist ~10,5cm hinter der Achse
		 Wheel wheel1 = WheeledChassis.modelWheel(Motor.B, 54.95).offset(-60);
		 Wheel wheel2 = WheeledChassis.modelWheel(Motor.C, 54.95).offset(60);
		 Chassis chassis = new WheeledChassis(new Wheel[] { wheel1, wheel2 }, WheeledChassis.TYPE_DIFFERENTIAL);
		 	
		 return chassis;
	}
	
	public void Testrun() {
		
		System.out.println("Press Button to Start.");
		
        Button.waitForAnyPress();

        pilot.setLinearAcceleration(30);
		pilot.travel(900);
		
		Sound.beep();
		
		pilot.setAngularAcceleration(20);
		pilot.rotate(540);
		
		pilot.setLinearAcceleration(30);
		pilot.travel(900);
		
		Sound.beep();
	}
	

}
