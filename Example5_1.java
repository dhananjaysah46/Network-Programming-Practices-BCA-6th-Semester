import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Example5_1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.exmple.com");
            URLConnection con = url.openConnection();

            try (BufferedReader buff =
                    new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String readLine;
                while ((readLine = buff.readLine()) != null) {
                    System.out.println(readLine);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
