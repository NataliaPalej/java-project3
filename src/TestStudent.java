import java.util.ArrayList;
import java.util.List;

public class TestStudent {
	
	static Student studentClass = new Student();
	
	public static void main(String[] args) {
		// Create array to store students in
		List<Student> students = new ArrayList<>();
		
		// Create and add students to the array
		students.add(new Student("A123456", "Kasia", "Pretty", "Tullamore", "Bachelor of Beauty", 89, 93, 99, 91));
		students.add(new Student("A654321", "Dominik", "Dominos", "Tullamore", "Bachelor of Computing", 72, 68, 88, 84));
		students.add(new Student("A789456", "Adrian", "Diablo", "Athlone", "Bachelor of Computing", 51, 92, 90, 87));
		students.add(new Student("A987654", "Natalia", "Norman", "Athlone", "Bachelor of Computing", 91, 93, 94, 89));
		students.add(new Student("A456123", "Slowak", "Golias", "Trim", "Bachelor of Social", 41, 38, 68, 51));
		students.add(new Student("A654321", "Monika", "Monikowska", "Monksland", "Bachelor of Hairdressing", 31, 48, 67, 36));
		students.add(new Student("A741852", "Kuba", "Kubowski", "Monksland", "Bachelor of Mechanics", 71, 68, 78, 83));
			
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
