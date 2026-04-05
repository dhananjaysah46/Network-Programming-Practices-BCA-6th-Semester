import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Example10_1 {
    public static void main(String[] args) {
        final String SERVER = "time.nist.gov";
        final int PORT = 37;

        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(5000);
            InetAddress serverAddress = InetAddress.getByName(SERVER);

            // Send empty packet
            byte[] sendData = new byte[1];
            DatagramPacket request =
                    new DatagramPacket(sendData, sendData.length, serverAddress, PORT);
            socket.send(request);

            // Receive 4-byte binary time
            byte[] buffer = new byte[4];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);

            // The time protocol sets the epoch at 1900, the Java Date class at 1970. This number
            // converts between them
            // Convert the 4 bytes to unsigned 32-bit integer
            long secondsSince1900 = ((buffer[0] & 0xFFL) << 24) | ((buffer[1] & 0xFFL) << 16)
                    | ((buffer[2] & 0xFFL) << 8) | (buffer[3] & 0xFFL);

            // Convert to Unix time (subtract 70 years in seconds)
            long unixTime = secondsSince1900 - 2208988800L;
            Date date = new Date(unixTime * 1000);

            System.out.println("Current time from NIST (RFC 868): " + date);
            socket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
