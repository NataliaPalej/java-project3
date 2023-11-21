import java.util.ArrayList;
import java.util.List;

public class StudentController {
	private List<Student> studentList;

    public StudentController() {
        this.studentList = new ArrayList<>();
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

    public void getAll() {
        for (Student student : studentList) {
            System.out.println(student.printDetails());
        }
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
