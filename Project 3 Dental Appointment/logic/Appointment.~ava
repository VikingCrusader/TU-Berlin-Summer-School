package logic;

import java.time.LocalDateTime;
// The responsibility of this class is:
// the appointment information of a patient in a certain time period
public class Appointment {
    private Patient patient;
    private Employee employee;
    private LocalDateTime dateTime;

    public Appointment(Patient patient, Employee employee, LocalDateTime dateTime) {
        this.patient = patient;
        this.employee = employee;
        this.dateTime = dateTime;
    }

    public Patient getPatient() { return patient; }
    public Employee getEmployee() { return employee; }
    public LocalDateTime getDateTime() { return dateTime; }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient.getName() +
                ", doctor=" + employee.getName() +
                ", dateTime=" + dateTime +
                '}';
    }
}
