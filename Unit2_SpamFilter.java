import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

public class Unit2_SpamFilter {
    private static final Set<String> SPAM_BLACKLIST = new HashSet<>();

    static {
        SPAM_BLACKLIST.add("192.0.2.10");
        SPAM_BLACKLIST.add("203.0.113.20");
    }

    public static boolean isSpammer(String ipAddress) {
        try {
            InetAddress senderAddress = InetAddress.getByName(ipAddress);

            return SPAM_BLACKLIST.contains(senderAddress.getHostAddress());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        String[] testIP = {"192.0.2.10", "127.0.0.1"};

        for (String ip : testIP) {
            if (isSpammer(ip)) {
                System.err.println(ip + " is invalide.");
            } else {
                System.out.println(ip + " is valid.");
            }
        }
    }
}
