package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import database.Database;

// Main class for a calendar system , that manages all appointments, patients, and employees
// has 3 lists , storing appointment, patients, employees respectively
public class Calendar {

    // List to store all appointment records
    private List<Appointment> appointmentList = new ArrayList<>();

    // List to store all registered patients
    private List<Patient> patientList = new ArrayList<>();

    // List to store all registered employees (doctors)
    private List<Employee> employeeList = new ArrayList<>();

    // Getter for appointment list
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    // Getter for patient list
    public List<Patient> getPatientList() {
        return patientList;
    }

    // Getter for employee list
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Adds one or more appointments for a patient.
     * Each integer in the list represents an hour of the day (e.g., 9 = 9:00 AM).
     * The appointment time will be set to today with the given hour.
     */

    //You can add more than one time slot once, that's why we use a intList.
    // Add appointment for a specific date and hour
   /* public void addAppointment(Patient patient, Employee employee, int year, int month, int day, int hour) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, 0);
        Appointment appt = new Appointment(patient, employee, dateTime);
        appointmentList.add(appt);
    }*/
    public void addAppointment(Patient patient, Employee employee, int year, int month, int day, int hour) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, 0);
        Appointment appt = new Appointment(patient, employee, dateTime);
        appointmentList.add(appt);

        try (Connection con = Database.connect();
             PreparedStatement ps = con.prepareStatement(
                 "INSERT INTO appointments (patient_id, dentist_id, start_time, end_time, status) " +
                 "VALUES ((SELECT id FROM users WHERE username=?), (SELECT id FROM users WHERE username=?), ?, ?, 'BOOKED')")) {
            ps.setString(1, patient.getUsername());
            ps.setString(2, employee.getUsername());
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(dateTime));
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(dateTime.plusHours(1)));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Removes an appointment for a given patient at a specific time.
     * If multiple appointments exist for the same time and patient, only the first match is removed.
     */
    /*public void removeAppointment(Patient patient, LocalDateTime dateTime) {
        appointmentList.removeIf(appt ->
                appt.getPatient().equals(patient) && appt.getDateTime().equals(dateTime)
        );
    }*/
    public void removeAppointment(Patient patient, LocalDateTime dateTime) {
        appointmentList.removeIf(appt ->
                appt.getPatient().equals(patient) && appt.getDateTime().equals(dateTime)
        );

        try (Connection con = Database.connect();
             PreparedStatement ps = con.prepareStatement(
                 "DELETE FROM appointments WHERE patient_id = (SELECT id FROM users WHERE username=?) AND start_time = ?")) {
            ps.setString(1, patient.getUsername());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(dateTime));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the appointment time for a specific patient.
     * Replaces the old time with the new time.
     */
    public void updateDateTime(Patient patient, LocalDateTime oldTime, LocalDateTime newTime) {
        for (Appointment appt : appointmentList) {
            if (appt.getPatient().equals(patient) && appt.getDateTime().equals(oldTime)) {
                appt.setDateTime(newTime);
                break; // Exit after updating the first match
            }
        }
    }

    // Adds a new patient to the system
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    // Adds a new employee (doctor) to the system
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}

