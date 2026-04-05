import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Example3_2 {
    public static void main(String[] args) {

        try {
            String email = "ram.shrestha@example.com";
            String encoded;
            encoded = URLEncoder.encode(email, "xyz");
            System.out.println(encoded);

            String decode = URLDecoder.decode(encoded, "UTF-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Wrong encoding dude!!!");
        }

    }
}
