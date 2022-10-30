import javax.swing.*;
import java.awt.*;

public interface book_master_tab_Interface
{
	JPanel tab = new JPanel();
	JLabel authors = new JLabel("Authors");
    JLabel subject = new JLabel("Subject Areas");
    JLabel location = new JLabel("Location");
    JTextField location_text = new JTextField(20);
    JTextArea authorsArea = new JTextArea(3, 20);
    JScrollPane scrollPaneAuthors = new JScrollPane(authorsArea);
    JTextArea subjectArea = new JTextArea(3, 20);
    JScrollPane scrollPaneSubject = new JScrollPane(subjectArea);
}