import java.net.*;
import java.io.*;
import java.util.*;

public class ProxyAuthentication {
    public static void main(String[] args) {
        try {
            // Set authentication details
            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            "username", "password".toCharArray());
                }
            });

            // Set proxy details
            ProxySelector.setDefault(new ProxySelector() {
                public List<Proxy> select(URI uri) {
                    return Arrays.asList(
                            new Proxy(Proxy.Type.HTTP,
                                    new InetSocketAddress("proxy.server.com", 8080))
                    );
                }

                public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                    System.out.println("Proxy connection failed");
                }
            });

            // Connect to secure website
            URL url = new URL("https://www.example.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();

            System.out.println("Successfully authenticated and connected via proxy.");

        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
