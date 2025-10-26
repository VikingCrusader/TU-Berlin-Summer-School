package day5;

public class Room {
	public static void main(String[] args) {
		Lamp lamp1 = new Lamp();
		Lamp lamp2 = new Lamp();
		Lamp lamp3 = new Lamp();
		lamp1.checkStatus();
		lamp1.turnOn();
		lamp1.checkStatus();
	}
}
