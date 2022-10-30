import javax.swing.*;
import java.awt.*;

public interface General_Info_Interface
{
	public JPanel pane1 = new JPanel(); 
	public JPanel pane2 = new JPanel(); 
	public JPanel scroll = new JPanel();
	public JPanel text = new JPanel();
    public JTextArea textArea = new JTextArea(4, 30);
    public JLabel tel = new JLabel("Tel No"); 
    public JLabel address = new JLabel("Address"); 
    public JLabel fax = new JLabel("Fax No");
    public JLabel email = new JLabel("E-Mail");
    public JLabel contacts = new JLabel("Contacts");
    public JTextField tel_text = new JTextField(20);
    public JTextField fax_text = new JTextField(20);
    public JTextField email_text = new JTextField(20);
    public JScrollPane scrollPane = new JScrollPane(textArea);
}