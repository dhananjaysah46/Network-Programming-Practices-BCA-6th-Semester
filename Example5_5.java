import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class Example5_5 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.example.com");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);

        try (OutputStream outputStream = conn.getOutputStream();
                OutputStream bos = new BufferedOutputStream(outputStream);
                OutputStreamWriter osw = new OutputStreamWriter(bos)) {
            osw.write("Hello World!!");
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}
