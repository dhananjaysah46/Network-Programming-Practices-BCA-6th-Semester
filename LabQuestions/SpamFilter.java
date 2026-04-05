import java.net.*;
import java.util.*;

public class SpamFilter {
    public static void main(String[] args) {

        Set<String> blacklist = new HashSet<>();
        blacklist.add("192.168.1.100");
        blacklist.add("spam.example.com");

        String input = "spam.example.com";

        // Step 1: Check blacklist directly
        if (blacklist.contains(input)) {
            System.out.println("SPAM detected!");
            return;
        }

        try {
            // Step 2: Resolve only if needed
            InetAddress addr = InetAddress.getByName(input);
            if (blacklist.contains(addr.getHostAddress())) {
                System.out.println("SPAM detected!");
            } else {
                System.out.println("Safe address.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host. Treated as SPAM.");
        }
    }
}

