import java.io.*;
import java.net.*;
import java.util.*;

public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            // Create a URL object representing the page to be read
            URL url = new URL("https://www.example.com");
            // Open a connection to the URL
            URLConnection conn = url.openConnection();
            // Connect to the server
            conn.connect();

            // Get the content length of the resource
            System.out.println("Content length: " + conn.getContentLength());

            // Get the content length using getHeaderField()
            System.out.println("Content length: " + 
                conn.getHeaderField("Content-Length"));

            // Get the content type of the resource
            System.out.println("Content type: " + conn.getContentType());

            // Get the content type using getHeaderField()
            System.out.println("Content type: " + 
                conn.getHeaderField("Content-Type"));

            // Get the last modified date of the resource
            System.out.println("Last modified date: " + 
                new Date(conn.getLastModified()));

            // Get the last modified using getHeaderField()
            System.out.println("Expires: " + 
                conn.getHeaderField("Expires"));

            // Get the last expires getHeaderField()
            System.out.println("Expires: " + conn.getHeaderField("Expires"));

            System.out.println("Header Fields: " + conn.getHeaderFields());

            // Read the data from the URL
            // BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // String line;
            // while ((line = br.readLine()) != null) {
            //     System.out.println(line);
            // }
            // br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
