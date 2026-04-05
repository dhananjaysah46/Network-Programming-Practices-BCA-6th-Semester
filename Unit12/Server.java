import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            CalculatorImpl calculator = new CalculatorImpl();

            // Create and start the RMI registry on the default port (1099)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry with a name
            registry.bind("CalculatorService", calculator);

            System.out.println("Server started and waiting for client requests...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
