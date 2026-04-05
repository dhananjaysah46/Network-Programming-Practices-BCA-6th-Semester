import java.net.Socket;

public class Example6_2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1024; i++) {
            try {
                Socket socket = new Socket("localhost", i);
                socket.setSoTimeout(500);
                System.out.println("There is a server in port: " + i);
                socket.close();
            } catch (Exception e) {
                // If you want to scan for ports that are free
                // System.out.println("Port is free: " + i);
            }
        }
    }
}
