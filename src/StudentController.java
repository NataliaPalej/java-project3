import java.util.ArrayList;
import java.util.List;

public class StudentController {
	private List<Student> studentList;

    public StudentController() {
        this.studentList = new ArrayList<>();
    }
    
    public StudentController(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void add(Student student) {
        studentList.add(student);
    }

    public void delete(Student student) {
        studentList.remove(student);
    }

    public void update(Student oldStudent, Student newStudent) {
        int index = studentList.indexOf(oldStudent);
        if (index != -1) {
            studentList.set(index, newStudent);
        }
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

    public List<Student> getStudentList() {
        return studentList;
    }

}
