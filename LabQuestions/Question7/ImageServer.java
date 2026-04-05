package Question7;

import java.io.*;
import java.net.*;

public class ImageServer {
    public static void main(String[] args) {
        try {
            // Use safe port 5001
            ServerSocket server = new ServerSocket(5001);
            System.out.println("Image Server Started on port 5001");

            while (true) {
                // Wait for client connection
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getInetAddress());

                // Read the correct image file
                File file = new File("dog.jpg"); // Your actual file
                if (!file.exists()) {
                    System.out.println("File not found: dog.jpg");
                    client.close();
                    continue;
                }

                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());

                // Send file length first
                dos.writeInt((int) file.length());
                dos.flush();

                // Send file bytes
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    dos.write(buffer, 0, bytesRead);
                }

                dos.flush();  // Ensure all bytes sent
                bis.close();
                client.close();
                System.out.println("Image sent successfully");
            }
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
            e.printStackTrace();
        }
    }
}
