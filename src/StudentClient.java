import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StudentClient {

	public static void main(String[] args) {
		System.out.println("StudentClient: starting");
		Registry registry = null;
		try {
			// Get registry]
			registry = LocateRegistry.getRegistry("localhost", 1234);
			// Find objects 
			StudentService studentService = (StudentService) registry.lookup("StudentService");
			System.out.println("StudentClient: Finding obects\n");
			
			// Calling methods
			System.out.println("getAll(): method called");
			String allStudents = studentService.getAll();
            System.out.println("All Students: \n" + allStudents);	
		} catch (Exception e) {
			System.out.println("\nStudentClient: Couldn't start client");
			e.printStackTrace();
		} finally {
			// Close registry
			try {
                if (registry != null) {
                    LocateRegistry.getRegistry().unbind("StudentService");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	}
}
