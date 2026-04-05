import java.net.*;
import java.util.*;

public class Example4_2 {
    public static void main(String[] args) {
        try {
            // Set up the CookieManager and get the CookieStore
            CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);
            CookieStore cookieStore = cookieManager.getCookieStore();

            // Create a custom cookie
            HttpCookie cookie = new HttpCookie("userToken", "abc123xyz");
            cookie.setDomain("httpbin.org");
            cookie.setPath("/");
            cookie.setMaxAge(3600); // 1 hour

            // Add the cookie to the store
            URI uri = new URI("http://httpbin.org");
            cookieStore.add(uri, cookie);

            // Now make a request to httpbin.org/cookies to see the sent cookies
            URL url = new URL("http://httpbin.org/cookies");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read and print the response
            Scanner scanner = new Scanner(connection.getInputStream());
            System.out.println("Response from server:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();

            // Show all cookies in the store
            System.out.println("\nCookies currently in store:");
            List<HttpCookie> cookies = cookieStore.getCookies();
            for (HttpCookie c : cookies) {
                System.out.println("Name: " + c.getName());
                System.out.println("Value: " + c.getValue());
                System.out.println("Domain: " + c.getDomain());
                System.out.println("Path: " + c.getPath());
                System.out.println("Max Age: " + c.getMaxAge());
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
