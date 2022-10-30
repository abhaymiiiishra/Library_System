import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class book_master_main extends JPanel implements book_master_main_Interface{
    
    public book_master_main() {
   
        tabbedPane.addTab("Details", icon, tabbed1, "Details");
        tabbedPane.setFont (new Font ("Impact", Font.PLAIN, 12));
        tabbedPane.setSelectedIndex(0);
		
        master.add(mast);
        tab.add(tabbedPane);
        add(master, BorderLayout.NORTH);
        add(tab, BorderLayout.CENTER);
        
        
    }

}
