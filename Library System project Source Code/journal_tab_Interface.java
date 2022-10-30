import javax.swing.*;
import java.awt.*;

public interface journal_tab_Interface
{
	public JPanel tab = new JPanel();
    public JLabel authors = new JLabel("Authors");
    public JLabel subject = new JLabel("Subject Areas");
    public JLabel location = new JLabel("Location");
    public JTextField location_text = new JTextField(20);
    public JTextArea authorsArea = new JTextArea(3, 20);
    public JScrollPane scrollPaneAuthors = new JScrollPane(authorsArea);
    public JTextArea subjectArea = new JTextArea(3, 20);
    public JScrollPane scrollPaneSubject = new JScrollPane(subjectArea);
	
}