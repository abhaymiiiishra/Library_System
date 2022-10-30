import javax.swing.*;
import java.awt.*;

public interface journal_Interface
{
	public journal_master gen = new journal_master();
	public JButton newBut = new JButton(new ImageIcon("new.gif"));
	public JButton save = new JButton(new ImageIcon("save.gif"));
	public JButton delete = new JButton(new ImageIcon("delete.gif"));
	JToolBar toolBar = new JToolBar();
}
