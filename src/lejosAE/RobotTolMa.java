package lejosAE;

import lejos.hardware.*;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.*;
import lejos.robotics.navigation.*;

public class RobotTolMa {

	public MovePilot robot;
	public EV3GyroSensor gyro = new EV3GyroSensor((SensorPort.S4));
	public SampleProvider gyroSample;

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

		robot = new MovePilot(CreateChassis());
		gyroSample = gyro.getAngleMode();
//		robot.addMoveListener(listener);
//		System.out.println("Configured!");

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

		float[] sample = new float[1];

		Sound.beep();

		robot.setAngularAcceleration(10);
		robot.rotateRight();
		System.out.println("Rotating Right.");
//			gyroSample.fetchSample(sample, 0);
//			System.out.println("gyroSample = " + sample[0]);

		while (true) {

			gyroSample.fetchSample(sample, 0);
			System.out.println("Angle = " + sample[0]);
			while (sample[0] <= 360) {
				robot.stop();

			}
			break;
		}
		System.out.println("DONE.");
		Button.waitForAnyPress();
	}

}
