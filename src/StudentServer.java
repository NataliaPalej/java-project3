/**
 * author @NataliaPalej A00279259
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StudentServer {

	public static void main(String[] args) {
		System.out.println("StudentServer: starting\n");
		try {
			// Creating instance of remote StudentController object 
			StudentController studentController = new StudentController();
			// Creating registry on localhost and default RMI port of 1099
			Registry registry = LocateRegistry.createRegistry(1099);
			// Bind remote into the registry
			registry.bind("StudentService", studentController);
			System.out.println("\nStudentServer: ready\n");
		} catch (Exception e) {
			System.out.println("StudentServer: Couldn't start server");
			e.printStackTrace();
		}
	}
}
