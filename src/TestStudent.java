import java.util.ArrayList;
import java.util.List;

public class TestStudent {
	
	static Student studentClass = new Student();
	
	public static void main(String[] args) {
		// Create array to store students in
		List<Student> students = new ArrayList<>();
		
		// Create initial data with StudentController class
		StudentController studentController = new StudentController();
		students = studentController.studentList();
		
		try {
			studentClass.serialiseStudents(students);
			System.out.println("TestStudent(): Students successfully serialised.");
		} catch (Exception e) {
			System.out.println("TestStudent(): Couldn't serialize.\nError: ");
			e.printStackTrace();
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------\n");
		
		// Deserializing
		System.out.println("TestStudent(): Deserializing Students");
		// Create list for deserialization 
		List<Student> deserialize = studentClass.deserialiseStudents();
		System.out.println("printDetails():");
		for (Student student : deserialize) {
			System.out.println(student.printDetails());
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------\n");
		
	}

	
	
	
	
	
	

}
