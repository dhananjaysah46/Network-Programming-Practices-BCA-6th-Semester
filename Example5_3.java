import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Example5_3 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.exmple.com");
            URLConnection con;
            con = url.openConnection();

            Map<String, List<String>> headers = con.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();
                System.out.println(headerName + ": " + headerValues);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
