import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Message from Server: " + br.readLine());
            socket.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
