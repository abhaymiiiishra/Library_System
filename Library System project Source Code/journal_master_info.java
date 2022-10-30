import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class journal_master_info extends JPanel implements journal_Interface, journal_master_info_Interface, journal_tab_Interface{
        public Connection connection;
     public int confirm;
        
    public journal_master_info() {    
    
    
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
  	

	class_text.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();      
      if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
        JOptionPane.showMessageDialog(null, "Please enter a numerical value");
        getToolkit().beep();
        e.consume();
    	  }
    	}
  	});
	
	
	issue_number_text.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();      
      if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
        JOptionPane.showMessageDialog(null, "Please enter a numerical value");
        getToolkit().beep();
        e.consume();
    	  }
    	}
  	});
	
	year_text.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();      
      if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
        JOptionPane.showMessageDialog(null, "Please enter a numerical value");
        getToolkit().beep();
        e.consume();
    	  }
    	}
  	});
	
	pages_text.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();      
      if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
        JOptionPane.showMessageDialog(null, "Please enter a numerical value");
        getToolkit().beep();
        e.consume();
    	  }
    	}
  	});
  	
  	journal_no_text.setText("JL-");
  	journal_no_text.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
			try
			{
				Statement statement = connection.createStatement();
					String query1 = "SELECT * FROM Item " + 
 								"WHERE item_id = '" + 
 								journal_no_text.getText() +"'";
					
					ResultSet rs1 = statement.executeQuery(query1);
					try
					{
						rs1.next();
							            	
			            	journal_title_text.setText(rs1.getString(2));
			 				year_text.setText(rs1.getString(6));
			 				authorsArea.setText(rs1.getString(5));
			 				subjectArea.setText(rs1.getString(7));
			 				location_text.setText(rs1.getString(4));
			 				type_combo.setSelectedItem(rs1.getString(3));			 					
			 		}
					catch (SQLException sqlex)
					{
						
					}
						
					String query = "SELECT * FROM journal_detail " + 
 								"WHERE item_id = '" + 
 								journal_no_text.getText() +"'";
					
					ResultSet rs = statement.executeQuery(query);
					try
					{
						rs.next();
						
			            	type_combo.setSelectedItem(rs.getString(3));
			            	category_combo.setSelectedItem(rs.getString(4));
			            	issue_number_text.setText(rs.getString(5));
			            	publisher_text.setText(rs.getString(6));
			            	pages_text.setText(rs.getString(7));
			             	class_text.setText(rs.getString(2));
			            	
			            	int confirm = JOptionPane.showConfirmDialog(null, "This record Exists, would you like to update it?", "CONFIRM", JOptionPane.YES_NO_OPTION);
			 				
			 				if(confirm == JOptionPane.NO_OPTION)
			 				{
			            	journal_no_text.setEditable(false);
			            	journal_title_text.setEditable(false);
 							issue_number_text.setEditable(false);
			 				class_text.setEditable(false);
			 				publisher_text.setEditable(false);
			 				year_text.setEditable(false);
			 				pages_text.setEditable(false);
			 				authorsArea.setEditable(false);
			 				subjectArea.setEditable(false);
			 				location_text.setEditable(false);	
							}
					
							else
			 				{
			 				save.addActionListener(new ActionListener() 
			 				{
            					public void actionPerformed(ActionEvent e) 
            					{
					 				String a = journal_no_text.getText();
					            	String b =  journal_title_text.getText();
					            	String c =  issue_number_text.getText();
					            	String d =  class_text.getText();
					            	String h =  publisher_text.getText();
					            	String g =  year_text.getText();
					            	String i = pages_text.getText();
					            	String j = authorsArea.getText();
					            	String k = subjectArea.getText();
					            	String l = location_text.getText();
					            	//Object m = campus_combo.getSelectedItem();
					            	journalSQL jorsql = new journalSQL(a, b, c, d, h, g, i, j, k, l);
					            	jorsql.update();
            					}
            				});
            				}
											 										
								statement.close(); 
			 			
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
  	
  	
  	
	
	journal_master.setFont (new Font ("Impact", Font.PLAIN, 16));
	text.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
		
    gbc.gridy = 0;
    gbc.gridx = 0;
    text.add(journal_master, gbc);
    
    gbc.gridy = 1;
    text.add(journal_no, gbc);
    gbc.gridy = 2;
    text.add(journal_title, gbc);
    gbc.gridy = 3;
    text.add(journal_type, gbc);
    gbc.gridy = 4;
    text.add(journal_cat, gbc);
    gbc.gridy = 1;
    gbc.gridx = 1;
    text.add(journal_no_text, gbc);
    gbc.gridy = 2;
    text.add(journal_title_text, gbc);
    gbc.gridy = 3;
    text.add(type_combo, gbc);
    gbc.gridy = 4;
    text.add(category_combo, gbc);
    
    gbc.gridy = 1;
    gbc.gridx = 2;
    text.add(issue_number, gbc);
    gbc.gridy = 2;
    text.add(class_no, gbc);
    gbc.gridy = 3;
    text.add(publisher, gbc);
    gbc.gridy = 4;
    text.add(yer, gbc);
    gbc.gridy = 5;
    text.add(pages, gbc);
    
    gbc.gridy = 1;
    gbc.gridx = 3;
    text.add(issue_number_text, gbc);
    gbc.gridy = 2;
    text.add(class_text, gbc);
    gbc.gridy = 3;
    text.add(publisher_text, gbc);
    gbc.gridy = 4;
    text.add(year_text, gbc);
    gbc.gridy = 5;
    text.add(pages_text, gbc);
    
    add(text);
    setBackground(Color.blue);
    }
    
    }
