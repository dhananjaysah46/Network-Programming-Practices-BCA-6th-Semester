import java.io.*;
import java.net.*;

public class Exaple7_2Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change if the server is remote
        int port = 8080;
        File outputFile = new File("received_dog.jpg");

        try (Socket socket = new Socket(serverAddress, port);
                InputStream is = socket.getInputStream();
                FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image received and saved as " + outputFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
