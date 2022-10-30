import javax.swing.JInternalFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.EventListener.*;
import javax.swing.*;
import java.awt.print.*;
import java.util.GregorianCalendar.*;

public class ReturnMain extends JInternalFrame implements ReturnMain_Interface{
 	
 	public int paintx, painty;
 	public Connection connection;
 	public Container c = getContentPane();
 	public JTabbedPane tab = new JTabbedPane();
 	public JTextField temp = new JTextField(10);
 	public JTextField temp2 = new JTextField(10);
 	public String chk = "";
 	public String chk2 = "";
 	
    public ReturnMain() {
        super("Item Return Entry", 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
              
              
        
        			String url = "jdbc:odbc:lib";
		
		//Load the driver to allow connection to the database
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
        
        temp.setVisible(false);
      	JToolBar toolBar = new JToolBar();
        addButtons(toolBar);
        int inset = 100;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        setSize(800,500);
 		setLocation(0, 0);
 		setResizable(false);
 		show();
 		paintx = (screenSize.width);
		painty = (screenSize.height);
		setBounds( (paintx - 800)/2 , ((painty-100) - 500)/2,
						 800,500);
        		
		c.add(toolBar, BorderLayout.NORTH);
		        
        JPanel up = new JPanel();
        JPanel down = new JPanel();
        JPanel down2 = new JPanel();
        JPanel pat_info = new JPanel();
        JPanel bk_info = new JPanel();
        
        patron_info.setFont (new Font ("Arial", Font.BOLD, 20));
    	book_info.setFont (new Font ("Arial", Font.BOLD, 20));
	
   	
        pat_info.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		
        gbc1.gridy = 0;
        gbc1.gridx = 0;
        pat_info.add(patron_info, gbc1);
        
        gbc1.gridy = 1;
        gbc1.gridx = 0;
        pat_info.add(patron_no, gbc1);
        gbc1.gridy = 2;
        pat_info.add(name, gbc1);
        gbc1.gridy = 3;
        pat_info.add(passport, gbc1);
        gbc1.gridy = 4;
        pat_info.add(group_type, gbc1);
        gbc1.gridy = 5;
        pat_info.add(expiry_date, gbc1);
        gbc1.gridy = 6;
        pat_info.add(status, gbc1);
        gbc1.gridy = 7;
        pat_info.add(loan_duration, gbc1);
        
        gbc1.gridy = 1;
        gbc1.gridx = 1;
        pat_info.add(patron_no_text, gbc1);
        gbc1.gridy = 2;
        pat_info.add(name_text, gbc1);
        gbc1.gridy = 3;
        pat_info.add(passport_text, gbc1);
        gbc1.gridy = 4;
        pat_info.add(group_type_text, gbc1);
        gbc1.gridy = 5;
        pat_info.add(expiry_date_text, gbc1);
        gbc1.gridy = 6;
        pat_info.add(status_text, gbc1);
        gbc1.gridy = 7;
        pat_info.add(loan_duration_text, gbc1);
        
        
        
        bk_info.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		
        gbc2.gridy = 0;
        gbc2.gridx = 0;
        bk_info.add(book_info, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        bk_info.add(book_no, gbc2);
        gbc2.gridy = 2;
        bk_info.add(book_title, gbc2);
        gbc2.gridy = 3;
        bk_info.add(book_type, gbc2);
        gbc2.gridy = 4;
        bk_info.add(author, gbc2);
        gbc2.gridy = 5;
        bk_info.add(publisher, gbc2);
        gbc2.gridy = 6;
        bk_info.add(subject, gbc2);
        gbc2.gridy = 7;
        bk_info.add(location, gbc2);
        
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        bk_info.add(book_no_text, gbc2);
        gbc2.gridy = 2;
        bk_info.add(book_title_text, gbc2);
        gbc2.gridy = 3;
        bk_info.add(book_type_text, gbc2);
        gbc2.gridy = 4;
        bk_info.add(author_text, gbc2);
        gbc2.gridy = 5;
        bk_info.add(publisher_text, gbc2);
        gbc2.gridy = 6;
        bk_info.add(subject_text, gbc2);
        gbc2.gridy = 7;
        bk_info.add(location_text, gbc2);
                
  		down.add(pat_info, BorderLayout.WEST); 
  		down2.add(bk_info, BorderLayout.EAST);
  		
  		
  		JPanel rtn_ent = new JPanel();
  		
  		book_rtn_entry.setFont (new Font ("Arial", Font.BOLD, 20));
    	fine_collection.setFont (new Font ("Arial", Font.BOLD, 20));
    	
        rtn_ent.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
        gbc.gridy = 0;
        gbc.gridx = 0;
        rtn_ent.add(book_rtn_entry, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        rtn_ent.add(book_ac_no, gbc);
	    gbc.gridx = 1;
        rtn_ent.add(rent_date, gbc);
        gbc.gridx = 2;
        rtn_ent.add(rent_due_date, gbc);
        gbc.gridx = 3;
        rtn_ent.add(tag, gbc);
        gbc.gridx = 4;
        rtn_ent.add(day_overdue, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        rtn_ent.add(book_ac_no_text, gbc);
        
        book_ac_no_text.addFocusListener(new MyActionListener()
  		{
			public void focusLost(FocusEvent e)
			{
									
		try
		{
			Statement satemt = connection.createStatement();
					
			String query1 = "SELECT * FROM loan WHERE item_id = '" + book_ac_no_text.getText() + "'";
					
			ResultSet rs = satemt.executeQuery(query1);
					
			rs.next();
					
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
			
			Calendar cal = Calendar.getInstance();
			java.sql.Date d = rs.getDate("due_date");
			String mid = rs.getString("member_id");
			String iid = rs.getString("item_id");
			java.util.Date as = new java.util.Date();
					
			GregorianCalendar dat = new GregorianCalendar(as.getYear(), as.getMonth(), as.getDate());
					
			int a = 0;
			
			if(!d.after(as))
			{
				while (as.after(d))
				{	
					cal.add(dat.DATE, -1);
					as = cal.getTime();
					a++;
					System.out.println(a);
				} 
			}

			if (a>0)
			{
				System.out.println("overdue");
			}
			else
			{
				System.out.println("no overdue");
			}
			
		java.sql.Date rdate = rs.getDate("rent_date");
					
			rent_date_text.setText(df.format(rdate));
			rent_due_date_text.setText(df.format(d));
					
			day_overdue_text.setText(String.valueOf(a-1));
					
			String query2 = "SELECT * FROM Item WHERE item_id = '" + book_ac_no_text.getText() + "'";
			
			ResultSet rs11 = satemt.executeQuery(query2);
			double fine = 0.00;
			double amtfine = 0.00;
			
			try
			{
				rs11.next();
				String btype = rs11.getString("type");
				
				if (btype.equals("Book"))
				{
					fine = 0.50;
				}
				if (btype.equals("Video"))
				{
					fine = 1.00;
				}
						
				if (btype.equals("Journal"))
				{
					fine = 0.25;
				}
						
				if (a>0)
				{
					amtfine = (a-1) * fine;
					amount_fine_text.setText(String.valueOf(amtfine));
					day_overdue_text.setText(String.valueOf(a-1));

				}
				else
				{
					amount_fine_text.setText("0.00");
					day_overdue_text.setText(String.valueOf(a));
				}
				
				String query3 = "SELECT * FROM patronmaster WHERE id = '" + mid + "'";
				
				ResultSet rs3 = satemt.executeQuery(query3);
				
				try
				{
					rs3.next();
					patron_no_text.setText(rs3.getString("id"));
					name_text.setText(rs3.getString("name"));
					passport_text.setText(rs3.getString("ic"));
					group_type_text.setText(rs3.getString("group_type"));
					expiry_date_text.setText(rs3.getString("expiry_date"));
					status_text.setText(rs3.getString("status"));
					loan_duration_text.setText("21");
					
				}
				catch(SQLException sqlex)
				{
					sqlex.printStackTrace();
				}
				
				String query4 = "SELECT * FROM Item WHERE item_id = '" + iid + "'";
				
				ResultSet rs4 = satemt.executeQuery(query4);
				
				try
				{
					rs4.next();
					book_no_text.setText(rs4.getString("item_id"));
					book_title_text.setText(rs4.getString("title"));
					book_type_text.setText(rs4.getString("type"));
					location_text.setText(rs4.getString("location"));
					author_text.setText(rs4.getString("author"));
					subject_text.setText(rs4.getString("year"));
					publisher_text.setText(rs4.getString("permission"));
					
				}
				catch(SQLException sqlex)
				{
					sqlex.printStackTrace();
				}
			}
			catch(SQLException sqlex)
			{
				//sqlex.printStackTrace();
			}
		}
		
		catch(SQLException sqlex)
		{
			//sqlex.printStackTrace();
		}
	}
		} );
		
		
        gbc.gridx = 1;
        rent_date_text.setEditable(false);
        rtn_ent.add(rent_date_text, gbc);
        gbc.gridx = 2;
        rent_due_date_text.setEditable(false);
        rtn_ent.add(rent_due_date_text, gbc);
        gbc.gridx = 3;
        tag_text.setEditable(false);
        rtn_ent.add(tag_text, gbc);
        gbc.gridx = 4;
        day_overdue_text.setEditable(false);
        rtn_ent.add(day_overdue_text, gbc);
        
        gbc.gridy = 6;
        gbc.gridx = 2;
        rtn_ent.add(fine_collection, gbc);
        gbc.gridy = 7;
        rtn_ent.add(amount_fine, gbc);
        gbc.gridy = 8;
        rtn_ent.add(amount_collected, gbc);
        
        gbc.gridy = 7;
        gbc.gridx = 3;
        amount_fine_text.setEditable(false);
        rtn_ent.add(amount_fine_text, gbc);
        gbc.gridy = 8;
        rtn_ent.add(amount_collected_text, gbc);
        gbc.gridx = 4;
        
        //dump1.setText("");
        yeah.setVisible(false);
        rtn_ent.add(yeah, gbc);
        up.add(rtn_ent);
        
        JPanel upPanel = new JPanel();
        upPanel.add(up);
                
        c.add(upPanel, BorderLayout.CENTER);
        tab.addTab("Patron Info", icon, down, "Patron Info");
        tab.addTab("Book Info", icon, down2, "Book Info");
		tab.setSelectedIndex(0);
        c.add(tab, BorderLayout.SOUTH);
    
    }
    
    public void returnitem()
    {
    	try
    	{
    		Statement stmt = connection.createStatement();
    		
    		String q1 = "UPDATE Item SET avail = 'IN' WHERE item_id = '" + book_ac_no_text.getText() + "'";
    		String q3 = "SELECT * FROM reservation WHERE bookID = '" + book_ac_no_text.getText() + "'";
    		
    		int res = stmt.executeUpdate(q1);
    		ResultSet rs = stmt.executeQuery(q3);
    		
    		while (rs.next())
    		{
    			temp2.setText(rs.getString("patronID"));
    			temp.setText(rs.getString("status"));
				chk = temp.getText();
				chk2 = temp2.getText();    		
    		}
    		
    		if (chk.equals("Reserved"))
    		{
    			JOptionPane.showMessageDialog(null, "This item has been reserved by " +chk2);
    		}
    		else
    		{
    			int conf = JOptionPane.showConfirmDialog(null, "would you like to renew the book?", "confirm renewal", JOptionPane.YES_NO_OPTION);
    			
    			if(conf == JOptionPane.YES_OPTION)
    			{
    				JOptionPane.showMessageDialog(null, "wait lah wei");
    				bookSQL bsql = new bookSQL();
    				bsql.loan();
    				JOptionPane.showMessageDialog(null, "Book has been renewed");
    				
    			}
    			else
    			{
    				String q2 = "DELETE * FROM loan WHERE item_id = '" + book_ac_no_text.getText() + "'";
    		
    		int res2 = stmt.executeUpdate(q2);
    		
    			}
    		}
    				book_no_text.setText("");
					book_title_text.setText("");
					book_type_text.setText("");
					location_text.setText("");
					author_text.setText("");
					subject_text.setText("");
					publisher_text.setText("");
					
					patron_no_text.setText("");
					name_text.setText("");
					passport_text.setText("");
					group_type_text.setText("");
					expiry_date_text.setText("");
					status_text.setText("");
					loan_duration_text.setText("");
					
					rent_date_text.setText("");
					rent_due_date_text.setText("");
					amount_fine_text.setText("");
					day_overdue_text.setText("");
					book_ac_no_text.setText("");
					day_overdue_text.setText("");
					amount_collected_text.setText("");
					day_overdue_text.setText("");
    	}
    	catch(SQLException sqlex)
    	{
    		sqlex.printStackTrace();
    	}
    	
    	
    }
    
    
      protected void addButtons(JToolBar toolBar) {
        JButton button = null;

        //first button
        button = new JButton(new ImageIcon("new.gif"));
        button.setToolTipText("New");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	book_no_text.setText("");
					book_title_text.setText("");
					book_type_text.setText("");
					location_text.setText("");
					author_text.setText("");
					subject_text.setText("");
					publisher_text.setText("");
					
					patron_no_text.setText("");
					name_text.setText("");
					passport_text.setText("");
					group_type_text.setText("");
					expiry_date_text.setText("");
					status_text.setText("");
					loan_duration_text.setText("");
					
					rent_date_text.setText("");
					rent_due_date_text.setText("");
					amount_fine_text.setText("");
					day_overdue_text.setText("");
					book_ac_no_text.setText("");
					day_overdue_text.setText("");
					amount_collected_text.setText("");
					day_overdue_text.setText("");
            }
        });

        toolBar.add(button);
        
        //second button
        button = new JButton(new ImageIcon("save.gif"));
        button.setToolTipText("Save");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	if (amount_fine_text.getText().equals("0.00") || (amount_collected_text.getText().equals(amount_fine_text.getText())))
            		returnitem();
            	else
            		JOptionPane.showMessageDialog(null, "Please Pay outstanding amount");
            }
        });
        toolBar.add(button);

        
         //forth button
        button = new JButton(new ImageIcon("clear.gif"));
        button.setToolTipText("Clear");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	book_no_text.setText("");
					book_title_text.setText("");
					book_type_text.setText("");
					location_text.setText("");
					author_text.setText("");
					subject_text.setText("");
					publisher_text.setText("");
					
					patron_no_text.setText("");
					name_text.setText("");
					passport_text.setText("");
					group_type_text.setText("");
					expiry_date_text.setText("");
					status_text.setText("");
					loan_duration_text.setText("");
					
					rent_date_text.setText("");
					rent_due_date_text.setText("");
					amount_fine_text.setText("");
					day_overdue_text.setText("");
					book_ac_no_text.setText("");
					day_overdue_text.setText("");
					amount_collected_text.setText("");
					day_overdue_text.setText("");
            }
        });
        toolBar.add(button);
        }  
}