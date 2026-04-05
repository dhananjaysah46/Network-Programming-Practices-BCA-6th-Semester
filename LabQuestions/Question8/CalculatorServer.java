import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer implements Calculator {
    public CalculatorServer() {}

    @Override
    public int add(int a, int b) throws java.rmi.RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws java.rmi.RemoteException {
        return a - b;
    }

    @Override
    public int divide(int a, int b) throws java.rmi.RemoteException {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    @Override
    public int remainder(int a, int b) throws java.rmi.RemoteException {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a % b;
    }

    public static void main(String[] args) {
        try {
            // Create server object
            CalculatorServer obj = new CalculatorServer();

            // Export object to RMI runtime
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            // Start RMI registry programmatically
            Registry registry = LocateRegistry.createRegistry(1099); // default port
            registry.bind("CalculatorService", stub);

            System.out.println("Calculator RMI Server is ready.");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
            e.printStackTrace();
        }
    }
}
