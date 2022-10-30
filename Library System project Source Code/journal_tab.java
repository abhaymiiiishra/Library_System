import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class journal_tab extends JPanel implements journal_tab_Interface{
    
    public journal_tab() {   

   		tab.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
        gbc.gridy = 0;
        gbc.gridx = 0;
        tab.add(authors, gbc);
        gbc.gridy = 1;
        tab.add(subject, gbc);
        gbc.gridy = 2;
        tab.add(location, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        tab.add(scrollPaneAuthors, gbc);
        gbc.gridy = 1;
        tab.add(scrollPaneSubject, gbc);
        gbc.gridy = 2;
        tab.add(location_text, gbc);
        
        tab.setSize(400, 400);
        add(tab);
    }
    
    }
