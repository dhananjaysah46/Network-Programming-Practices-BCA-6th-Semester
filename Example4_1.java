import java.io.*;
import java.net.*;
import java.util.*;

public class Example4_1 {
    public static void main(String[] args) {
        try {
            // Set up the CookieManager
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);

            // URL to connect to
            URL url = new URL("http://httpbin.org/cookies/set?name=Rabindra+Rai");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Send a GET request
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            // StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

            // Print the response
            // System.out.println("Response: " + response.toString());

            // Retrieve cookies
            CookieStore cookieStore = cookieManager.getCookieStore();
            List<HttpCookie> cookies = cookieStore.getCookies();

            // Print cookies
            System.out.println("Cookies:");
            for (HttpCookie cookie : cookies) {
                System.out.println("Name: " + cookie.getName());
                System.out.println("Value: " + cookie.getValue());
                System.out.println("Domain: " + cookie.getDomain());
                System.out.println("Path: " + cookie.getPath());
                System.out.println("Max Age: " + cookie.getMaxAge());
                System.out.println("Secure: " + cookie.getSecure());
                System.out.println("HttpOnly: " + cookie.isHttpOnly());
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
