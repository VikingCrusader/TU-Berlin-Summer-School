package day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Student_Manage_Test {
	public static void main(String[] args) {
		Collection <Student> enrollment = new ArrayList();
		Student s1 = new Student("Anna", "Zhang", "S20230001");
		Student s2 = new Student("Anna", "Schmidt", "S20230002");
		Student s3 = new Student("Lukas", "Müller", "S20230003");
		Student s4 = new Student("Sophie", "Weber", "S20230004");
		Student s5 = new Student("Max", "Fischer", "S20230005");
		Student s6 = new Student("Laura", "Wolf", "S20230006");
		Student s7 = new Student("Tim", "Becker", "S20230007");
		Student s8 = new Student("Julia", "Neumann", "S20230008");
		Student s9 = new Student("Felix", "Hoffmann", "S20230009");
		Student s10 = new Student("Emma", "Krause", "S20230010");
		
		enrollment.add(s1);
		enrollment.add(s2);
		enrollment.add(s3);
		enrollment.add(s4);
		enrollment.add(s5);
		enrollment.add(s6);
		enrollment.add(s7);
		enrollment.add(s8);
		enrollment.add(s9);
		enrollment.add(s10);
		
		//iterate
		enrollment.forEach (s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getStudentID()));
		System.out.println();

		//search by ID
		String ID = "S20230001";
		enrollment.forEach(s -> {
			if (ID.equals(s.getStudentID())) {
				System.out.println(s.getFirstName() + " " + s.getLastName());
			}
		});
		System.out.println();

		//drop student
		String dropID0 = "S20230005";
		enrollment.removeIf(s -> s.getStudentID().equals(dropID0));
		
		String dropID = "S20230004";

		Iterator<Student> iterator = enrollment.iterator();
		while (iterator.hasNext()) {
		    Student current = iterator.next();
		    if (current.getStudentID().equals(dropID)) {
		        iterator.remove(); // 正确的删除方式
		    }
		}

		//iterate and print again
		enrollment.forEach (s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getStudentID()));
		System.out.println();

		// search by first name
		String firstname = "Anna";
		enrollment.forEach(s -> {
			if(s.getFirstName().equals(firstname)) {
				System.out.println(s.getFirstName() + " " + s.getLastName());
			}
		});
		System.out.println();

		//start with L
		enrollment.forEach(s -> {
			if (s.getFirstName().charAt(0) == 'L') {
				System.out.println(s.getFirstName() + " " + s.getLastName());
			}
		});
		System.out.println();

		// using filter
		enrollment.stream().filter(s -> s.getFirstName().startsWith("L")).forEach(s -> {
			System.out.println(s.getFirstName() + " " + s.getLastName());
		});
		
		//using findAny
//		enrollment.stream().filter(s -> s.getFirstName().startsWith("L")).findAny().forEach(s -> {
//			System.out.println(s.getFirstName() + " " + s.getLastName());
//		});
		
	}
}

class Student {
	private String firstName;
	private String lastName;
	private String studentID;
	
	public Student(String firstName, String lastName, String studentID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	
	
	
}