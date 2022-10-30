import javax.swing.*;
import java.awt.*;

public class Splash implements Runnable, mainInterface{
private String initMsg;

public Splash(String initMsg) {
this.initMsg = initMsg; 
}

public void run() {
splashWindow.getContentPane().add(l, BorderLayout.CENTER);
splashWindow.pack();
splashWindow.setSize(splashWindow.getSize().width, splashWindow.getSize().height);
splashWindow.setLocation(dim.width/2 - splashWindow.getWidth() /2,dim.height/2 -
splashWindow.getHeight()/2);
splashWindow.toFront();
splashWindow.show(); } 

public JWindow getWindow()
{ 
return splashWindow;
}

}