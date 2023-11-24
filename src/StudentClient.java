import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class StudentClient {
	
	static Student studentClass = new Student();
	
	public static void main(String[] args) throws RemoteException {
		
		System.out.println("StudentClient: starting\n");
		Registry registry = null;
		
		try {
			System.out.println("\n------------------------------------------------------------------------------------\n");
			
			// Get registry]
			registry = LocateRegistry.getRegistry("localhost", 1099);		
			
	        // getInstance() to get singleton instance of StudentController
	        StudentController studentController = StudentController.getInstance();
	        StudentGUI studentGUI = new StudentGUI(studentController);
			
	        System.out.println("\n-----------------------------------------------------------------------------------\n");
	        System.out.println("\nStudentClient(): ready");
		} catch (Exception e) {
			System.out.println("\nStudentClient: Couldn't start client");
			e.printStackTrace();
		}
	}
}
