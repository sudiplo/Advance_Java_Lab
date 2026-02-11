import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            HelloImpl obj = new HelloImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HelloService", obj);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
