import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost"); // Server host
            Calculator stub = (Calculator) registry.lookup("CalculatorService");

            int a = 20, b = 6;

            System.out.println("Add: " + stub.add(a, b));
            System.out.println("Subtract: " + stub.subtract(a, b));
            System.out.println("Divide: " + stub.divide(a, b));
            System.out.println("Remainder: " + stub.remainder(a, b));

        } catch (Exception e) {
            System.out.println("Client Error: " + e);
            e.printStackTrace();
        }
    }
}
