import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Example3_1 {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        String location =
                "https://www.example.com:8080/find/user/query?name=Ram+Shrestha&age=30#age";

        URI uri = new URI(location);
        System.err.println("Authority: " + uri.getAuthority());
        System.err.println("Scheme: " + uri.getScheme());
        System.err.println("Host: " + uri.getHost());
        System.err.println("Path: " + uri.getPath());
        System.err.println("Query: " + uri.getQuery());
        System.err.println("Fragment: " + uri.getFragment());

        // URL url = uri.toURL();
        URL url = new URL(location);
        System.err.println("URL Authority: " + url.getAuthority());
        System.err.println("URL Protocol: " + url.getProtocol());
        System.err.println("URL Host: " + url.getHost());
        System.err.println("URL Path: " + url.getPath());
        System.err.println("URL Query: " + url.getQuery());
    }
}
