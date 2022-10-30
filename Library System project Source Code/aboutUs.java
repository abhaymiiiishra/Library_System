import java.awt.*;
import javax.swing.*;

public class aboutUs extends JInternalFrame {
 	
 	 private int paintx, painty;

    public aboutUs() {
        super("About CyberVisions", 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
            
        int inset = 100;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Container c = getContentPane();
        setSize(550,400);
 		//setLocation(0, 0);
 		paintx = (screenSize.width);
		painty = (screenSize.height);
		
 		setResizable(false);
 		show();
 		
 		JLabel logo = new JLabel();
		Icon accLogo = new ImageIcon("aboutus.jpg");
		logo.setIcon( accLogo );
		setBounds( (paintx - 550)/2 , ((painty-50) - 400)/2,
						 550,400);
		
		c.add(logo);
 		
        
    }
 	
}