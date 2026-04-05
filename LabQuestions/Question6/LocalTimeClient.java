import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class LocalTimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000); // Use 5000 if port 13 blocked
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            System.out.println("Time from server:");
            System.out.println(br.readLine());

            br.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
