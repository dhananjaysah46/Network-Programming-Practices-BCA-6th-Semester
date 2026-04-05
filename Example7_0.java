import java.io.*;
import java.net.*;

public class Example7_0 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Step 1: Create ServerSocket
        System.out.println("Server is running...");
        
        Socket client = server.accept(); // Step 2: Accept client
        System.out.println("Client connected!");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println("Hello, Client!"); // Step 3: Send response

        client.close(); // Step 4: Close socket
        server.close();
    }
}
