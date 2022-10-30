import javax.swing.*;
import java.awt.*;

public interface book_master_Interface
{
	public book_master_main gen = new book_master_main();
	public JButton newForm = new JButton(new ImageIcon("new.gif"));
	public JButton save = new JButton(new ImageIcon("save.gif"));
	public JButton delete = new JButton(new ImageIcon("delete.gif"));
	public JButton update = new JButton(new ImageIcon("update.gif"));
}