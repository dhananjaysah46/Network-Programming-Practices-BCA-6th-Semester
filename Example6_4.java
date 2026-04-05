import java.io.*;
import java.net.*;

public class Example6_4 {
    public static final String SERVER = "dict.org";
    public static final int PORT = 2628;
    public static final int TIMEOUT = 15000;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Example6_3 <word1> <word2> ...");
            return;
        }

        try (Socket socket = new Socket(SERVER, PORT)) {
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            for (String word : args) {
                define(word, writer, reader);
            }

            writer.write("quit\r\n");
            writer.flush();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    static void define(String word, Writer writer, BufferedReader reader) throws IOException {
        writer.write("DEFINE wn " + word + "\r\n"); // Use WordNet instead
        writer.flush();

        boolean found = false;
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.startsWith("250 ")) { // OK (end of response)
                return;
            } else if (line.startsWith("500 ")) { // No match
                System.out.println("No definition found for " + word);
                return;
            } else if (line.matches("\\d{3} .*")) { // Ignore status codes
                continue;
            } else if (line.trim().equals(".")) { // Ignore end marker
                continue;
            } else {
                System.out.println(line);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No definition found for " + word);
        }
    }
}
