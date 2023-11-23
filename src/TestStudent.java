import java.util.ArrayList;
import java.util.List;

public class TestStudent {
	
	static Student studentClass = new Student();
	
	public static void main(String[] args) {
		// Create array to store students in (using initial data created in StudentController)
        List<Student> studentList = StudentController.studentList();
		
        StudentController studentController = new StudentController();
        StudentGUI studentGUI = new StudentGUI(studentController);

		try {
			studentController.serialiseStudents(studentList);
			System.out.println("TestStudent(): Students successfully serialised.");
		} catch (Exception e) {
			System.out.println("TestStudent(): Couldn't serialize.\nError: ");
			e.printStackTrace();
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------\n");
		
		// Deserializing
		System.out.println("TestStudent(): Deserializing Students");
		// Create list for deserialization 
		List<Student> deserialize = studentController.deserialiseStudents();
		System.out.println("printDetails():");
		for (Student student : deserialize) {
			System.out.println(student.printDetails());
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------\n");
		
		// Set the controller for the GUI
        studentGUI.setStudentController(studentController);
        System.out.println("setStudentController(): Student Controller Set");

        // Start your application
        
        System.out.println("run(): StudentGUI runs");
	}
}
