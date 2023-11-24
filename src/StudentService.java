/**
 * author @NataliaPalej A00279259
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentService extends Remote {
	
	String getAll() throws RemoteException;
	Student getByID(String id) throws RemoteException;
    Student getByName(String name) throws RemoteException;
    void add(Student student) throws RemoteException;
    void update(Student studentToUpdate, Student updatedStudent) throws RemoteException;
    void delete(String id) throws RemoteException;
}
