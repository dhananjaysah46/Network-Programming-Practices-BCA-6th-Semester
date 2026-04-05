package Question7;

import java.io.*;
import java.net.*;

public class ImageClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5001);
            System.out.println("Connected to server");

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // Read file length first
            int fileLength = dis.readInt();
            byte[] fileBytes = new byte[fileLength];

            // Read exactly fileLength bytes
            dis.readFully(fileBytes);

            FileOutputStream fos = new FileOutputStream("receivedDog.jpg"); // Save received file
            fos.write(fileBytes);
            fos.close();

            socket.close();
            System.out.println("Image received successfully");

        } catch (Exception e) {
            System.out.println("Client Error: " + e);
            e.printStackTrace();
        }
    }
}
