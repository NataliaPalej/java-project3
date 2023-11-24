import java.util.List;

public interface StudentView {
	void showAllStudents();
	void showStudentDetails(Student student);
    void showMessage(String message);
    void showSuccessMessage(String message);
    void showErrorMessage(String message);
}
