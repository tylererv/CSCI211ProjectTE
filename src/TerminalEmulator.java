import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

public class TerminalEmulator extends JFrame {

    private JTextArea textArea;
    private JTextField inputField;
    private PipedOutputStream outputStream;

    public TerminalEmulator() {
        super("Terminal Emulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);

        inputField = new JTextField();
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(Color.WHITE);
        inputField.setCaretColor(Color.WHITE);
        inputField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = inputField.getText();
                textArea.append(command + "\n");
                processCommand(command);
                inputField.setText("");
            }
        });

        outputStream = new PipedOutputStream() {
            @Override
            public void write(int b) throws IOException {
                super.write(b);
                SwingUtilities.invokeLater(() -> {
                    textArea.append(String.valueOf((char) b));
                    textArea.setCaretPosition(textArea.getDocument().getLength());
                });
            }
        };

        System.setOut(new PrintStream(outputStream, true));
        System.setErr(new PrintStream(outputStream, true));

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(inputField, BorderLayout.SOUTH);
        setContentPane(contentPane);
    }

    private void processCommand(String command) {
        if (command.equalsIgnoreCase("date")) {
            System.out.println(new java.util.Date());
        } else if (command.equalsIgnoreCase("clear")) {
            textArea.setText("");
        } else if (command.equalsIgnoreCase("exit")) {
            System.exit(0);
        } else if (command.startsWith("echo ")) {
            System.out.println(command.substring(5));
        } else {
            System.out.println("Command not recognized: " + command);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TerminalEmulator terminal = new TerminalEmulator();
            terminal.setVisible(true);
        });
    }
}