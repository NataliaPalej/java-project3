import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentController {
	private List<Student> studentList;

    public StudentController() {
    	this.studentList = studentList();
    }
    
    public StudentController(List<Student> studentList) {
        this.studentList = studentList;
    }
    
    public StudentController(List<Student> studentList, StudentGUI studentGUI) {
        this.studentList = studentList;
    }

    public void add(Student student) {
        studentList.add(student);
    }

    public void delete(String name) {
    	Iterator<Student> iterator = studentList.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name) || student.getId().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("StudentController delete(): Student " + student.getName() + " was deleted.");
            }
        }
        if (studentList.isEmpty()) {
            System.out.println("StudentController delete(): List is empty");
        }
    }

    public void update(Student studentToUpdate, Student updatedStudent) {
    	for (int i=0; i<studentList.size(); i++) {
    		if (studentToUpdate.getId().equals(studentList.get(i).getId()) || studentToUpdate.getName().equals(studentList.get(i).getName())) {
    			studentList.set(i, updatedStudent);
                return;
    		}
    	}
    	System.out.println("update(): Student not found in the list.");
    }
    
    public String getAll() {
    	StringBuilder result = new StringBuilder();
        for (Student student : studentList) {
            System.out.println(student.printDetails());
            result.append(student.printDetails());
        }
        return result.toString();
    }

    public Student getByName(String name) {
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public Student getByID(String id) {
        for (Student student : studentList) {
        	if (student.getId().equals(id)) {
        		return student;
        	}
        }
        return null;
    }
    
    // Initial data for the studentList
    public static List<Student> studentList() {    	
    	List<Student> students = new ArrayList<>();
    	students.add(new Student("1", "Kasia", "Pretty", "Tullamore", "Bachelor of Beauty", 89, 93, 99, 91));
		students.add(new Student("2", "Dominik", "Dominos", "Tullamore", "Bachelor of Computing", 72, 68, 88, 84));
		students.add(new Student("3", "Adrian", "Diablo", "Athlone", "Bachelor of Computing", 51, 92, 90, 87));
		students.add(new Student("4", "Natalia", "Normanes", "Athlone", "Bachelor of Computing", 91, 93, 94, 89));
		students.add(new Student("5", "Slowak", "Golias", "Trim", "Bachelor of Social", 41, 38, 68, 51));
		students.add(new Student("6", "Monika", "Monikowska", "Monksland", "Bachelor of Hairdressing", 31, 48, 67, 36));
		students.add(new Student("7", "Kuba", "Kubowski", "Monksland", "Bachelor of Mechanics", 71, 68, 78, 83));
		return students;
    }

    public List<Student> getStudentList() {
        return studentList;
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
