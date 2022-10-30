import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class book_loan_main extends JPanel implements book_loan_main_Interface {
        
    public book_loan_main() {
    	  
        //tabbedPane.addTab("Rental Details", null, loan, "Rental Details");
        //tabbedPane.setFont (new Font ("Impact", Font.PLAIN, 12));
        //tabbedPane.setSelectedIndex(0);
        //book_loan_master mast = new book_loan_master();       		
        //master.add(mast);
        tab.add(loan);
        //add(master, BorderLayout.NORTH);
        add(tab, BorderLayout.CENTER);
        
    }

}
