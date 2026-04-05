import java.io.*;
import java.net.*;

public class Example7_2 {
    public static void main(String[] args) {
        int port = 8080;
        File imageFile = new File("dog.jpg");
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected...");

                try (FileInputStream fis = new FileInputStream(imageFile);
                        OutputStream os = clientSocket.getOutputStream()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Image sent...");
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        } catch (IOException e) {

        }
    }
}
