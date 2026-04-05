import java.net.*;

public class URLParts {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://www.example.com:8080/find/user/query?name=Dhananjay&age=22#age");
        URL url = uri.toURL();

        System.out.println("Scheme: " + uri.getScheme());
        System.out.println("Host: " + uri.getHost());
        System.out.println("Port: " + uri.getPort());
        System.out.println("Path: " + uri.getPath());
        System.out.println("Query: " + uri.getQuery());
        System.out.println("Fragment: " + uri.getFragment());
    }
}
