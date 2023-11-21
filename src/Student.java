import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// A00279259 Natalia Palej

@SuppressWarnings("serial")
public class Student implements Serializable {
	
	private String id, name, surname, address, course;
	private double grade1, grade2, grade3, grade4;
	
	Student(String id, String name, String surname, String address, String course, double grade1, double grade2, double grade3, double grade4){
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.course = course;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
		this.grade4 = grade4;
	}
	
	// Empty Constructor
	Student(){
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public double getGrade1() {
		return grade1;
	}
	
	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}
	
	public double getGrade2() {
		return grade2;
	}
	
	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}
	
	public double getGrade3() {
		return grade3;
	}
	
	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}
	
	public double getGrade4() {
		return grade4;
	}
	
	public void setGrade4(double grade4) {
		this.grade4 = grade4;
	}
	
	public double getAverage(double grade, double grade2, double grade3, double grade4) {
		double average = (grade+grade2+grade3+grade4)/4;
		average = Math.round(average*100)/100;
		return average;
	}
	
	public String printDetails() {
		if (this.name.length() < 6 || this.surname.length() < 6 || this.address.length() < 6) {
			return "\nID: " + this.id + 
					"\nName: " + this.name +
					"\tSurname: " + this.surname + "     "+
					"\tAddress: " + this.address +"     "+
					"\tCourse: " + this.course +
					"\nGrade1: " + this.grade1 +
					"\tGrade2: " + this.grade2 +
					"\tGrade3: " + this.grade3 +
					"\tGrade4: " + this.grade4 +
					"\tGPA: " + getAverage(this.grade1, this.grade2, this.grade3, this.grade4) + "%";
		}
		
		return 	"\nID: " + this.id +
				"\nName: " + this.name +
				"\tSurname: " + this.surname +
				"\tAddress: " + this.address +
				"\tCourse: " + this.course +
				"\nGrade1: " + this.grade1 +
				"\tGrade2: " + this.grade2 +
				"\tGrade3: " + this.grade3 +
				"\tGrade4: " + this.grade4 +
				"\t\tGPA: " + getAverage(this.grade1, this.grade2, this.grade3, this.grade4) + "%";
	}
	
	public String getStudentDetails() {
		return "\nID: " + this.id +
				"\nName: " + this.name +
				"\nSurname: " + this.surname +
				"\nAddress: " + this.address +
				"\nCourse: " + this.course +
				"\nGrade1: " + this.grade1 +
				"\nGrade2: " + this.grade2 +
				"\nGrade3: " + this.grade3 +
				"\nGrade4: " + this.grade4 +
				"\nGPA: " + getAverage(this.grade1, this.grade2, this.grade3, this.grade4) + "%";
	}
	
	// Serialise Method
	public void serialiseStudents(List<Student> students) {
		try {
			// Serialise to the file
			FileOutputStream fileOut = new FileOutputStream("students.ser");
			// Assign what object to serialise
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			// Loop through phones array
			for (Student s : students) {
				objOut.writeObject(s);
			}
			objOut.close();
			fileOut.close();
		} catch (Exception e) {
			System.out.println("Exception cought.\n");
			e.printStackTrace();
		}
	}
	
	// Deserialise method
	public List<Student> deserialiseStudents() {
		List<Student> students = new ArrayList<>();
		try {
			FileInputStream fileIn = new FileInputStream("students.ser");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			// Loop until end of file is reached
			while (true) {
                try {
                	Student s = (Student) objIn.readObject();
                	students.add(s);
                } catch (Exception e) {
                	//System.out.println("\n# End of File Reached#\n");
                    break; 
                }
            }
			objIn.close();
			fileIn.close();
		} catch (Exception e) {
			System.out.println("Couldn't deserialize the file!");
			e.printStackTrace();
		}
		return students;
	}
}
