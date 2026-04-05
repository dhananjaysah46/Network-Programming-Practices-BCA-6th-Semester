import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class NISTTimeClient {
    public static void main(String[] args) {
        try {
            // Connect to NIST Daytime server on port 13
            Socket socket = new Socket("time.nist.gov", 13);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String time;
            System.out.println("Time from NIST server:");
            while ((time = br.readLine()) != null) {
                System.out.println(time);
            }

            br.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("Unable to connect to time.nist.gov on port 13");
            System.out.println("Reason: " + e.getMessage());
        }
    }
}


// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.Socket;

// public class LocalTimeClient {
//     public static void main(String[] args) {
//         try {
//             Socket socket = new Socket("localhost", 5000);
//             BufferedReader br = new BufferedReader(
//                     new InputStreamReader(socket.getInputStream()));

//             System.out.println("Time from server:");
//             System.out.println(br.readLine());

//             br.close();
//             socket.close();
//         } catch (Exception e) {
//             System.out.println("Client Error: " + e);
//         }
//     }
// }

