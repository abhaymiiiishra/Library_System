import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.awt.PrintJob.*;


public class patronReport extends JFrame implements patrepInterface {
	
	private int paintx, painty;
	public Connection connection;
	public JButton clear, print;
	
	public patronReport() {
              
        	 super("Patron Report");
              
               JToolBar toolBar = new JToolBar();
        		addButtons(toolBar);
        	
        	String url = "jdbc:odbc:lib";
 		
 		
 		try {
 			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 			connection = DriverManager.getConnection(url);
 		}
 		catch(ClassNotFoundException cnfex)  {
 			System.err.println("Failed to load driver");
 			cnfex.printStackTrace();
 			System.exit(1);
 		}
 		catch(SQLException sqlex){
 			System.err.println("unable to connect");
 			sqlex.printStackTrace();
 		}
        
        
        int inset = 250;
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        Container c = getContentPane();
        c.setLayout(null);
 		setLocation(0, 0);
 		setResizable(false);
 		show();
 		paintx = (screenSize.width);
		painty = (screenSize.height);
		setBounds( (paintx - 800)/2 , ((painty-100) - 500)/2,
						 800,550);
        String color[] = {"Black"};
        
        print_label.setForeground(Color.black);
        //first line
        item_id_label.setBounds(330, 20, 60, 20);
        item_id_text.setBounds(380, 20, 80, 20);
        
        
        item_id_text.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
			try
			{
				Statement statement = connection.createStatement();
					String query1 = "SELECT * FROM patronmaster " + 
 								"WHERE id = '" + item_id_text.getText() +"'";
					
					ResultSet rs1 = statement.executeQuery(query1);
					try
					{
						rs1.next();		            	
						
			            	item_title_text.setText(rs1.getString(2));
			 				item_type_text.setText(rs1.getString(3));
			 				author_text.setText(rs1.getString(6));
			 				location_text.setText(rs1.getString(8));
			 				year_text.setText(rs1.getString(4));
			 				subject_text.setText(rs1.getString(9));
			 				avail_text.setText(rs1.getString(10));
			 				permission_text.setText(rs1.getString(5));
			 				makeRecord();			 					
			 		}
					catch (SQLException sqlex)
					{
						
					}
						
					
				}
				catch (SQLException sqlex)
					{
					
					}
								
					}
					});
        
        
        
        //second line
        item_title_label.setBounds(150, 70, 150, 20);
        item_title_text.setEditable(false);
        item_title_text.setBounds(230, 70, 150, 20);
        item_type_label.setBounds(410, 70, 150, 20);
        item_type_text.setEditable(false);
        item_type_text.setBounds(490, 70, 150, 20);
        
        //third line
        location_label.setBounds(150, 90, 150, 20);
        location_text.setEditable(false);
        location_text.setBounds(230, 90, 150, 20);
        author_label.setBounds(410, 90, 150, 20);
        author_text.setEditable(false);
        author_text.setBounds(490, 90, 150, 20);
        
        //forth line
        year_label.setBounds(150, 110, 150, 20);
        year_text.setEditable(false);
        year_text.setBounds(230, 110, 150, 20);
        subject_label.setBounds(410, 110, 150, 20);
        subject_text.setEditable(false);
        subject_text.setBounds(490, 110, 150, 20);
        
        //fifth line
        avail_label.setBounds(150, 130, 150, 20);
        avail_text.setEditable(false);
        avail_text.setBounds(230, 130, 150, 20);
        permission_label.setBounds(410, 130, 150, 20);
        permission_text.setEditable(false);
        permission_text.setBounds(490, 130, 150, 20);
        
        //sixth line
        print_label.setBounds(250, 170, 150, 20);
        textArea.setEditable(false);
        textArea.setBounds(230, 190, 420, 300);
       
        
        item_id_label.setForeground(Color.black);
        item_title_label.setForeground(Color.black);
        item_type_label.setForeground(Color.black);
        location_label.setForeground(Color.black);
        author_label.setForeground(Color.black);
        year_label.setForeground(Color.black);
        subject_label.setForeground(Color.black);
        avail_label.setForeground(Color.black);
        permission_label.setForeground(Color.black);
        
        toolBar.setBounds(10,10,80,30);
        
        c.add(toolBar);
        c.add(item_id_label);
        c.add(item_id_text);
        c.add(item_title_label);
        c.add(item_title_text);
        c.add(item_type_label);
        c.add(item_type_text);
        c.add(location_label);
        c.add(location_text);
        c.add(author_label);
        c.add(author_text);
        c.add(year_label);
        c.add(year_text);
        c.add(subject_label);
        c.add(subject_text);
        c.add(avail_label);
        c.add(avail_text);
        c.add(permission_label);
        c.add(permission_text);
        c.add(print_label);
        c.add(textArea);
	}
	
	public String makeRecord()
	{
		String buffer;

		//        12345678901234567890123456789012345678901234567890123456789012345678901234567890
		String buffer1  = "\t\tPatron Records\n";
//		buffer += "12345678901234567890123456789012345678901234567890123456789012345678901234567890";
		String buffer2 = "----------------------------------------------------------------------\n";
		String buffer4 = "Patron ID          |  " + item_id_text.getText() +    "  |\n";
		String sep1 = "----------------------------------------------------------------------\n";
		String buffer5 = "Patron Name:       |  " + item_title_text.getText() +  "  |\n";
		String sep2 = "----------------------------------------------------------------------\n";
		String buffer6 = "IC/Passport:       |  " + item_type_text.getText() + 	 "  |\n";
		String sep3 = "----------------------------------------------------------------------\n";
		String buffer7 = "Registered:        |  " + location_text.getText() +    "  |\n";
		String sep4 = "----------------------------------------------------------------------\n";
		String buffer8 = "Expiry Date:       |  " + author_text.getText() + 	 "  |\n";
		String sep5 = "----------------------------------------------------------------------\n";
		String buffer9 = "Status:            |  " + year_text.getText() + 		 "  |\n";
		String sep6 = "----------------------------------------------------------------------\n";
		String buffer10 = "Address:           |  " + subject_text.getText() +    "  |\n";
		String sep7 = "----------------------------------------------------------------------\n";
		String buffer11 = "Tel:               |  " + avail_text.getText() +      "  |\n";
		String sep8 = "----------------------------------------------------------------------\n";
		String buffer12 = "Salute:            |  " + permission_text.getText() + "  |\n";
		String sep9 = "----------------------------------------------------------------------\n";
		
		buffer = buffer1 + buffer2 + buffer4 + sep1 + buffer5 + sep2 + buffer6 + sep3 + buffer7 + sep4 + buffer8 + sep5 + buffer9 + sep6 + buffer10 + sep7 + buffer11 + sep8 + buffer12 + sep9;
		
		textArea.setText(buffer);
		return buffer;
	}

		
        protected void addButtons(JToolBar toolBar) {
       
		//forth button
        clear = new JButton(new ImageIcon("clear.gif"));
        clear.setToolTipText("Update");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            item_id_text.setText("");
            item_title_text.setText("");
			item_type_text.setText("");
			author_text.setText("");
			location_text.setText("");
			year_text.setText("");
			subject_text.setText("");
			avail_text.setText("");
			permission_text.setText("");
			textArea.setText("");	
            }
        });
        toolBar.add(clear);
		
         //forth button
        print = new JButton(new ImageIcon("print.gif"));
        print.setToolTipText("Print");
        //print.addActionListener(handler);
        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         	     printRecord(makeRecord());       	
            }
        });
        toolBar.add(print);
    }	
    
    private void printRecord(String s)
	{
		StringReader sr = new StringReader(s);
		LineNumberReader lnr = new LineNumberReader(sr);
		Font typeface = new Font("Monospaced", Font.PLAIN, 12);						
		Properties p = new Properties();
		PrintJob pjob = getToolkit().getPrintJob(this, "Print report", p);
				
		if (pjob != null) {
			Graphics pg = pjob.getGraphics();
			if (pg != null) {		
				FontMetrics fm = pg.getFontMetrics(typeface);		
				int margin = 20;
				int pageHeight = pjob.getPageDimension().height - margin;
    			int fontHeight = fm.getHeight();
    			int fontDescent = fm.getDescent();
    			int curHeight = margin;	
				
				String nextLine;
				pg.setFont (typeface);    			

				try
				{
					do
					{
						nextLine = lnr.readLine();
						if (nextLine != null) {         
							if ((curHeight + fontHeight) > pageHeight)
							{ // New Page
								pg.dispose();
								pg = pjob.getGraphics();
								curHeight = margin;
							}
							
							curHeight += fontHeight;

							if (pg != null)
							{
								pg.setFont (typeface);
								pg.drawString (nextLine, margin, curHeight - fontDescent);
							}
						}
					}
					while (nextLine != null);
					
				}
				catch (EOFException eof)
				{
				}
				catch (Throwable t)
				{
					t.printStackTrace();
				}
			}
			pg.dispose();
		}
		if (pjob != null)
			pjob.end();
	}
	
	private void printFrame(JFrame f)
	{
	}
	
}