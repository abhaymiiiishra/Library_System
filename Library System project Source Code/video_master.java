import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class video_master extends JPanel implements video_master_Interface{
    
    public video_master() {
        tabbedPane.addTab("Video Details", icon, tabbed1, "Video Details");
        tabbedPane.setFont (new Font ("Impact", Font.PLAIN, 12));
        tabbedPane.setSelectedIndex(0);
        master.add(mast);
        tab.add(tabbedPane);
        add(master, BorderLayout.NORTH);
        add(tab, BorderLayout.CENTER);
    }

}
