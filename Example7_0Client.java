import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Example7_0Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change if server is on another machine
        int port = 8080; // Must match the server's port

        try (Socket socket = new Socket(serverAddress, port);
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to the server.");

            // Read the message from the server
            String serverMessage = in.readLine();
            System.out.println("Server says: " + serverMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
