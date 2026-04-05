import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Example6_3 extends JFrame {
    private JTextField domainField;
    private JTextArea resultArea;

    public Example6_3() {
        setTitle("Whois Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        domainField = new JTextField();
        JButton queryButton = new JButton("Query");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        queryButton.addActionListener(e -> queryWhois());

        add(domainField, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(queryButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void queryWhois() {
        String domain = domainField.getText();
        String whoisServer = "whois.internic.net"; // WHOIS server

        try (Socket socket = new Socket(whoisServer, 43);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(domain); // Send query

            // Read response
            String line;
            resultArea.setText(""); // Clear previous result
            while ((line = in.readLine()) != null) {
                resultArea.append(line + "\n");
            }
        } catch (IOException e) {
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Example6_3();
    }
}
