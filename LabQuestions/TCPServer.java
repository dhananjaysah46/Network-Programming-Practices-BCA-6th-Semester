import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server Started...");

            Socket client = server.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello from Server!");
            client.close();
            server.close();
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
}
