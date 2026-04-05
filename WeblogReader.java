import java.io.*;
import java.net.*;

public class WeblogReader {
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 1) {
            System.out.println("Usage: java Weblog <logfile>");
            return;
        }

        // Try-with-resources block to automatically close resources
        try (FileInputStream fin = new FileInputStream(args[0]);
                Reader in = new InputStreamReader(fin);
                BufferedReader bin = new BufferedReader(in)) {

            // Read each line from the log file
            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                // Find the first space to separate the IP address from the rest of the entry
                int index = entry.indexOf(' ');
                if (index == -1) {
                    // If no space is found, the log entry is invalid
                    System.err.println("Invalid log entry: " + entry);
                    continue;
                }

                // Extract the IP address and the rest of the log entry
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                // Resolve the IP address to a hostname and print the log entry with the
                // hostname
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException ex) {
                    // If the IP address cannot be resolved, print the original log entry
                    System.err.println("Unknown host for IP: " + ip + ", log entry: " + entry);
                }
            }
        } catch (IOException ex) {
            // Handle any IO exceptions that occur
            System.err.println("Exception: " + ex);
        }
    }
}