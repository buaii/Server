

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerIF extends Remote {
	int add (int a, int b) throws RemoteException;
	String save (String name) throws RemoteException;
	String read (String name) throws RemoteException;
}
