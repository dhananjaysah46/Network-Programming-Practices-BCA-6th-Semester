import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class LocalTimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Local Time Server Started");

            while (true) {
                Socket client = server.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(new Date().toString());
                client.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
