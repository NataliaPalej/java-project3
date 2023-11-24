/**
 * author @NataliaPalej A00279259
 */

import java.rmi.RemoteException;

public interface StudentView {
	void showAllStudents() throws RemoteException;
	void showStudentDetails(Student student) throws RemoteException;
    void showMessage(String message);
    void showSuccessMessage(String message);
    void showErrorMessage(String message);
}
