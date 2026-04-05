import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

public class Example2_1 {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName("www.google.com.np");
            System.out.println(ia.isReachable(1));
            InetAddress ias[] = InetAddress.getAllByName("www.google.com.np");

            for(InetAddress ip : ias) {
            System.out.println(ip.getHostAddress());
            }

            InetAddress in =
               tAddress.getByAddress(new byte[] {(byte) 142, (byte) 250, (byte) 194, 36
            // );
            System.out.println(in.getCanonicalHostName());

            InetAddress local = InetAddress.getLocalHost();
            // System.out.println(local);

            NetworkInterface nic = NetworkInterface.getByInetAddress(local);
            System.out.println(nic.isLoopback());
        } catch (UnknownHostException e) {
            System.out.println("Unkown Host");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
