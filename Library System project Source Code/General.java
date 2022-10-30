import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class General extends JPanel implements General_Interface{

    public General() {
        
        tabbedPane.addTab("Patron Details", icon, gen, "Patron Details");
        tabbedPane.setFont (new Font ("Impact", Font.PLAIN, 12));
        tabbedPane.setSelectedIndex(0);
        		
        master.add(rem);
        tab.add(tabbedPane);
        add(master, BorderLayout.NORTH);
        add(tab, BorderLayout.CENTER);
    }

}
