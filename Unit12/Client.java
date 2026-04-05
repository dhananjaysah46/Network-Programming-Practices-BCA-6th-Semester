import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the reference to the remote object from the registry
            Registry registry = LocateRegistry.getRegistry("localhost");
            CalculatorInterface calculator =
                    (CalculatorInterface) registry.lookup("CalculatorService");

            // Invoke the remote method
            int result = calculator.add(5, 3);

            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
