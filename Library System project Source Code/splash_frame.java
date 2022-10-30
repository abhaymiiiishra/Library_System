import javax.swing.*;
import java.awt.*;

public class splash_frame extends JInternalFrame {
 	
 	 private int paintx, painty;

    public splash_frame() {
        super("Splash Screen", 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
            
        int inset = 100;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         int rx = this.getX();
         System.out.print(rx);
 		paintx = (screenSize.width);
		painty = (screenSize.height);
		setBounds( (paintx - 636)/2 , ((painty-50) - 478)/2,
						 636,478);
		
        Container c = getContentPane();
        setSize(640,510);
 		show();
 		
 		JLabel logo = new JLabel();
		Icon accLogo = new ImageIcon("splash.jpg");
		logo.setIcon( accLogo );
		c.add(logo);
 		
        
    }
 	
}