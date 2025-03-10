import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ScrollablePopup {

    public static void main(String[] args) {
        String longText = "This is a long text that will require scrolling.\n"
                + "It can contain multiple lines and paragraphs.\n"
                + "The user will be able to scroll through this text\n"
                + "using the scroll bar in the popup.\n"
                + "This is the end of the text.";

        JTextArea textArea = new JTextArea(longText, 10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Scrollable Text", JOptionPane.PLAIN_MESSAGE);
    }
}