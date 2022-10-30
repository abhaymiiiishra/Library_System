import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public interface passwordInterface
{
	public JLabel user = new JLabel("User Name");
	public JLabel passwod = new JLabel("Password");
	public JTextField usersName = new JTextField(20);
	public JPasswordField userPassword = new JPasswordField(20);
	public JButton okButton = new JButton("Ok");
	public JButton closeButton = new JButton("Close");
	public JCheckBox chk = new JCheckBox("Remember Password");
}