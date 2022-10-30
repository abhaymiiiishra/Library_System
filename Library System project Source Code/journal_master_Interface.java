import javax.swing.*;
import java.awt.*;

public interface journal_master_Interface
{
	public journal_master_info mast = new journal_master_info();
    public JPanel master = new JPanel();
    public JPanel tab = new JPanel(); 
    public journal_tab tabbed1 = new journal_tab();
    public ImageIcon icon = new ImageIcon("");
    public JTabbedPane tabbedPane = new JTabbedPane();
}