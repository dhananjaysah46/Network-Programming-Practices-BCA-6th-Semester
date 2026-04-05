import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Example5_2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.exmple.com");
            URLConnection con = url.openConnection();

            try (InputStream is = con.getInputStream()) {
                int readLine;
                while ((readLine = is.read()) != -1) {
                    System.out.print((char) readLine);
                }
            } catch (Exception e) {

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
