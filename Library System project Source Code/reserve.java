import javax.swing.JInternalFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.EventListener.*;
import java.text.*;

public class reserve extends JInternalFrame
{
 	
 	public int paintx, painty;
 	public Connection con;
 	public String dd;
 	public String p;
 	public Container c = getContentPane();
 	public int j;
 	public String chk;
 	public JButton save;
 	public JTabbedPane tab = new JTabbedPane();
 	public JTextField book_id[] = new JTextField[5];
 	public JTextField patron_id[] = new JTextField[5];
 	public JTextField reserve_date[] = new JTextField[5];
 	public JTextField status[] = new JTextField[5];
 	public JPanel upper = new JPanel();
 	public JLabel book = new JLabel("Book ID");
 	public JLabel patron = new JLabel("Patron ID");
 	public JLabel date = new JLabel("Reservation Date");
 	public JLabel status_text = new JLabel("Status");
 	public JLabel id = new JLabel("Book ID");
	public JTextField idText = new JTextField(5);
	public java.util.Date currentDate = new java.util.Date();
	public SimpleDateFormat formatter = new SimpleDateFormat ("MMMM dd yyyy", Locale.getDefault());
 	
 	
    public reserve(String pp) {
        super("Item Reservation", 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
              
        String url = "jdbc:odbc:lib";
		//Load the driver to allow connection to the database
		try {
 			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 			con = DriverManager.getConnection(url);
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
 		
        
        p = pp;
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
		setBounds( (paintx - 500)/2 , ((painty-100) - 300)/2,
						 500,300);
        		
		c.add(toolBar, BorderLayout.NORTH);
	
			idText.addFocusListener(new MyActionListener()
  		{
			public void focusLost(FocusEvent e)
			{
				
				try
				{
				Statement s = con.createStatement();
				String query = "SELECT * FROM reservation WHERE bookID = '" + idText.getText() + "'";
				ResultSet rs = s.executeQuery(query);
				int i = 0;
				while(rs.next())
				{
					book_id[i].setText(rs.getString("bookID"));
					patron_id[i].setText(rs.getString("patronID"));
					chk = patron_id[i].getText();
					reserve_date[i].setText(rs.getString("reservationDate"));
					status[i].setText(rs.getString("Status"));
					book_id[i].setBackground(Color.lightGray);
					patron_id[i].setBackground(Color.lightGray);
					reserve_date[i].setBackground(Color.lightGray);
					status[i].setBackground(Color.lightGray);
					i++;	
					if (p.equals(chk))
					{
						JOptionPane.showMessageDialog(null, "You have reserved this book before");
						save.setEnabled(false);
					}									
				}
				j = i;
				}
				catch(SQLException sqlex)
				{
					sqlex.printStackTrace();
				}
				
			}
		});
		
		JPanel panel = new JPanel();
		
		panel.add(id);
		panel.add(idText);
		
		
		for (int i = 0; i<5; i++)
    	{
   		 book_id[i] = new JTextField(10);
    	 book_id[i].setEditable(false);
   		}
   	
    for (int i = 0; i<5; i++)
    {
    patron_id[i] = new JTextField(10);
    patron_id[i].setEditable(false);
   	}
    
 
   	
    for (int i = 0; i<5; i++)
    {
    reserve_date[i] = new JTextField(10);
    reserve_date[i].setEditable(false);
   	}
    
    for (int i = 0; i<5; i++)
    {
    status[i] = new JTextField(10);
    status[i].setEditable(false);
   	}
    
    upper.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	
	gbc.gridy = 0;
    gbc.gridx = 0;
    //upper.add(loan_items, gbc);
    
    
    
    gbc.gridy = 1;
    upper.add(book, gbc);
    
    for (int i = 0; i<5; i++)
    {
    gbc.gridy = 2+i;
    upper.add(book_id[i], gbc);
	}
    
    
    gbc.gridx = 1;
    gbc.gridy = 1;
    upper.add(patron, gbc);
    
	for (int i = 0; i<5; i++)
    {
    gbc.gridy = 2+i;
    upper.add(patron_id[i], gbc);
	}
    
    gbc.gridx = 2;
    gbc.gridy = 1;
    upper.add(date, gbc);
    
    for (int i = 0; i<5; i++)
    {
    gbc.gridy = 2+i;
    upper.add(reserve_date[i], gbc);
	}
        
    gbc.gridx = 3;
    gbc.gridy = 1;
    upper.add(status_text, gbc);
    for (int i = 0; i<5; i++)
    {
    gbc.gridy = 2+i;
    upper.add(status[i], gbc);
	}
	
		c.add(panel, BorderLayout.CENTER);
		c.add(upper, BorderLayout.SOUTH);
		
		        
    }
      protected void addButtons(JToolBar toolBar) {
        JButton button = null;

        //first button
        button = new JButton(new ImageIcon("new.gif"));
        button.setToolTipText("New");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        toolBar.add(button);
        
		dd = formatter.format(currentDate);
        
        //second button
        save = new JButton(new ImageIcon("save.gif"));
        save.setToolTipText("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {	
            	if(j > 5)
            	{
            		JOptionPane.showMessageDialog(null, "Reservation quota exceeded");
            	}
            	else
            	{
            	try
            	{
            	Statement s = con.createStatement();
            	
            	String query = "INSERT INTO reservation (bookID, patronID, reservationDate, Status" + 
 						") VALUES ('" +
 					idText.getText() +"','" +
 					p +"','" +
 					dd +"','" +
 					"Reserved" +"')";
 				
 				String query2 = "UPDATE Item SET reservation = 'YES' WHERE item_id = '" + idText.getText() + "'";	
 					
 				int result = s.executeUpdate(query);
 				int result2 = s.executeUpdate(query2);
 				 
 				if (result == 1 || result2 == 1)
 				{
 					System.out.print("yeah");
 				}
 			}
 			catch(SQLException sqlex)
 			{
 				sqlex.printStackTrace();
 			}
 					
            }
            
            try
				{
				Statement s = con.createStatement();
				String query = "SELECT * FROM reservation WHERE bookID = '" + idText.getText() + "'";
				ResultSet rs = s.executeQuery(query);
				int i = 0;
				while(rs.next())
				{
					book_id[i].setText(rs.getString("bookID"));
					patron_id[i].setText(rs.getString("patronID"));
					chk = patron_id[i].getText();
					reserve_date[i].setText(rs.getString("reservationDate"));
					status[i].setText(rs.getString("Status"));
					book_id[i].setBackground(Color.lightGray);
					patron_id[i].setBackground(Color.lightGray);
					reserve_date[i].setBackground(Color.lightGray);
					status[i].setBackground(Color.lightGray);
					i++;									
				}
				j = i;
				}
				catch(SQLException sqlex)
				{
					sqlex.printStackTrace();
				}
				
        }
        });
        toolBar.add(save);
    }
}  