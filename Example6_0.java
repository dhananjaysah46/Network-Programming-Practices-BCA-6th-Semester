import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Example6_0 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("www.example.com", 80)) {
            System.out.println("Connected: " + socket.isConnected());
            System.out.println("Closed: " + socket.isClosed());
            System.out.println("Local address: " + socket.getLocalAddress());
            System.out.println("Remote address: " + socket.getRemoteSocketAddress());
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        }
    }
}