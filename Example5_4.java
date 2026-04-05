import java.io.*;
import java.net.*;
import java.util.*;

public class Example5_4 {
    public static void main(String args[]) {
        try {
            // Define the URL to connect to
            URL url = new URL("https://www.example.com");

            // Open a connection to the URL
            URLConnection conn = url.openConnection();

            // Print a blank line for formatting
            System.out.println();

            // Retrieve and display the content type of the resource
            System.out.println("Content-type: " + conn.getContentType());

            // Check and display content encoding if available
            if (conn.getContentEncoding() != null) {
                System.out.println("Content-encoding: " + conn.getContentEncoding());
            }

            // Check and display the date header if available
            if (conn.getDate() != 0) {
                System.out.println("Date: " + new Date(conn.getDate()));
            }

            // Check and display the last modified date if available
            if (conn.getLastModified() != 0) {
                System.out.println("Last modified: " + new Date(conn.getLastModified()));
            }

            // Check and display the expiration date if available
            if (conn.getExpiration() != 0) {
                System.out.println("Expiration date: " + new Date(conn.getExpiration()));
            }

            // Check and display the content length if available
            if (conn.getContentLength() != -1) {
                System.out.println("Content-length: " + conn.getContentLength() + " bytes");
            }

            System.out.println();
            // Display all header fields from the response
            if (conn.getHeaderFields() != null) {
                System.out.println("Content Headers: \n" + conn.getHeaderFields());
            }

            System.out.println(); // Print a blank line for formatting
        } catch (MalformedURLException mue) {
            // Handle invalid URL format exception
            System.err.println("This URL is malformed.");
        } catch (IOException ioe) {
            // Handle input-output exceptions, e.g., connectivity issues
            System.err.println("Unable to connect to the resource.");
        }
    }
}
