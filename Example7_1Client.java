import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Example7_1Client {
    public final static String SERVER_HOST = "localhost";
    public final static int SERVER_PORT = 13;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String dateTime = reader.readLine();
            System.out.println("Current date and time: " + dateTime);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
