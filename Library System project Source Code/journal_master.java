import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class journal_master extends JPanel implements journal_master_Interface{
        
    public journal_master() {

        tabbedPane.addTab("Journal Details", icon, tabbed1, "Journal Details");
        tabbedPane.setFont (new Font ("Impact", Font.PLAIN, 12));
        tabbedPane.setSelectedIndex(0);
        		
        master.add(mast);
        tab.add(tabbedPane);
        add(master, BorderLayout.NORTH);
        add(tab, BorderLayout.CENTER);
    }

}
