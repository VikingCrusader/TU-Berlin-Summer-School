package logic;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
	private String address;
	private String telephone;
	private List<Appointment> appointments = new ArrayList<>();

	public Patient(String name, String username, String password, String address, String telephone) {
		super(name, username, password);
		this.address = address;
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void bookAppointment(Appointment appt) {
		appointments.add(appt);
	}

	public void cancelAppointment(Appointment appt) {
		appointments.remove(appt);
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", username=" + username + ", address=" + address
				+ ", telephone=" + telephone + ", appointments=" + appointments.size() + "]";
	}
}

