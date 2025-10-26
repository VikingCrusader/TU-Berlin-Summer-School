package day5;

class Lamp {
	boolean isOn = false;
	
	void turnOn () {
		isOn = true;
	}
	void turnOff () {
		isOn = false;
	}
	void checkStatus () {
		if (isOn == true) {
			System.out.println("the lamp is on");
		} else {
			System.out.println("the lamp is off");
		}
	}
}