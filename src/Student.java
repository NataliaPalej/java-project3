import java.io.Serializable;

// A00279259 Natalia Palej

public class Student implements Serializable {
	
	private String id, name, surname, address, course;
	private float grade1, grade2, grade3, grade4;
	private static final long serialVersionUID = 1L;
	
	Student(String id, String name, String surname, String address, String course, float grade1, float grade2, float grade3, float grade4){
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
	
	public float getGrade1() {
		return grade1;
	}
	
	public void setGrade1(float grade1) {
		this.grade1 = grade1;
	}
	
	public float getGrade2() {
		return grade2;
	}
	
	public void setGrade2(float grade2) {
		this.grade2 = grade2;
	}
	
	public float getGrade3() {
		return grade3;
	}
	
	public void setGrade3(float grade3) {
		this.grade3 = grade3;
	}
	
	public float getGrade4() {
		return grade4;
	}
	
	public void setGrade4(float grade4) {
		this.grade4 = grade4;
	}
	
	public float getAverage(float grade, float grade2, float grade3, float grade4) {
		float average = (grade+grade2+grade3+grade4)/4;
		average = Math.round(average*100)/100;
		return average;
	}
	
	public String printDetails() {
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
}
