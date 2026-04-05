import java.io.*;
import java.net.*;

public class Example6_1 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("time.nist.gov", 13);
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
