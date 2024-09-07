import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class Server extends UnicastRemoteObject implements ServerIF {
	private static final long serialVersionUID = 1L;
	protected Server() throws RemoteException {
		super();
	}
	
	private Vector<String> saveName;
	
	public static void main (String[] args) {
		try {
			Server server = new Server();
			server.saveName = new Vector<String>();
			Naming.rebind("Server", server);
			System.out.println("Server is ready !!!");
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public int add (int a, int b) {
		System.out.println("Server's response !!!");
		return a + b;
	}
	
	public String save (String name) {
		this.saveName.add(name);
		return "Save" + name + "Success !!!";
	}

	public String read(String name) throws RemoteException {
		if (this.saveName.contains(name)) {
			return name + " is in Server !!!";
		} else {
			return name + " is not in Server !!!";					
		}
	}
}


