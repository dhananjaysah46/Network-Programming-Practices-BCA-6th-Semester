import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket(5001);
            System.out.println("UDP Server Started...");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Receive message from Client: " + msg);
            socket.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
