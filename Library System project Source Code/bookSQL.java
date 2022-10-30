import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class bookSQL implements book_master_info_Interface, book_master_tab_Interface, book_loan_tab_Interface, book_loan_master_Interface, mainInterface
{
	public java.util.Date today ;
	public Calendar cal = Calendar.getInstance();
	public Connection con;
	public String a, b, c, h, i, j, k, l,d,g;
	public JTextField temp = new JTextField(10);
	public String chkd;
	
	public bookSQL()
	{
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

	}
	
	public bookSQL(String aa, String bb, String cc, String dd, String hh, String gg, String ii, String jj, String kk, String ll)
	{
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
 		a = aa;
 		b = bb;
 		c = cc;
 		d = dd;
 		g = gg;
 		h = hh;
 		i = ii;
 		j = jj;
 		k = kk;
 		l = ll;
 		
 		
 	}
		
		
		
		
 		public void add()
 		{
 		try
 				{
 					
 					Statement statement = con.createStatement();
 					
 					
 				String query = "INSERT INTO Item (item_id, title, type, year, author, subject_area, location, avail, permission" + 
 						") VALUES ('" +
 					a +"','" +
 					b +"','" +
 					"Book" +"','" +
 					l +"','" +
 					j +"','" +
 					g +"','" +
 					k +"','" +
 					"IN" +"','" +
 					type_combo.getSelectedItem() +"')";
 				
 				int result = statement.executeUpdate(query);
 				
 				String query2 = "INSERT INTO book_detail (item_id, isbn, type, category, classification_no, publisher, pages" + 
 						") VALUES ('" +
 					a +"','" +
 					c +"','" +
 					type_combo.getSelectedItem() +"','" +
 					category_combo.getSelectedItem() +"','" +
 					d +"','" +
 					h +"','" +
 					i +"')";
 				
 				int result2 = statement.executeUpdate(query2);
 				
 				if (result == 1 && result2 == 1)
 				
 				{
 					JOptionPane.showMessageDialog(null, "Insertion succesfull");
 				book_no_text.setText("BK-");
            	book_title_text.setText("");
            	isbn_text.setText("");
            	class_text.setText("");
            	publisher_text.setText("");
            	place_text.setText("");
            	year_text.setText("");
            	pages_text.setText("");
            	location_text.setText("");
            	authorsArea.setText("");
            	subjectArea.setText("");	
 		}
 				else {
 					JOptionPane.showMessageDialog(null, "Insertion Failed");
				book_no_text.setText("BK-");
            	book_title_text.setText("");
            	isbn_text.setText("");
            	class_text.setText("");
            	publisher_text.setText("");
            	place_text.setText("");
            	year_text.setText("");
            	pages_text.setText("");
            	location_text.setText("");
            	authorsArea.setText("");
            	subjectArea.setText("");
 				}
 			statement.close();
 			}
 			catch(SQLException sqlex) {
 			}
 			}
 			
 	public void update()
 	{
 				
 				
 				try
 				{
 				Statement statement = con.createStatement();
				String query1 = "UPDATE Item SET " +
				"title ='" + b +
				"', type ='" + "Book" +
				"', location ='" + l +
				"', author ='" + j +
				"', year ='" + g +
				"', subject_area ='" + k +
				"', permission ='" + type_combo.getSelectedItem() +
				"' WHERE item_id LIKE '%" + a + "%'";
														
				int result = statement.executeUpdate(query1);
				
				String query2 = "UPDATE book_detail SET " +
				"isbn ='" + c +
				"', type ='" + type_combo.getSelectedItem() +
				"', category ='" + category_combo.getSelectedItem() +
				"', classification_no ='" + d +
				"', publisher ='" + h +
				"', pages ='" + i +
				"' WHERE item_id LIKE '%" + a + "%'";
														
				int result2 = statement.executeUpdate(query2);
				
				if (result == 1 && result2 == 1)
				{
				JOptionPane.showMessageDialog(null, "Update Succesfull");
				book_no_text.setText("BK-");
            	book_title_text.setText("");
            	isbn_text.setText("");
            	class_text.setText("");
            	publisher_text.setText("");
            	place_text.setText("");
            	year_text.setText("");
            	pages_text.setText("");
            	location_text.setText("");
            	authorsArea.setText("");
            	subjectArea.setText("");	
            	
            	book_no_text.setEditable(true);
            	book_title_text.setEditable(true);
 				isbn_text.setEditable(true);
 				class_text.setEditable(true);
 				publisher_text.setEditable(true);
 				year_text.setEditable(true);
 				pages_text.setEditable(true);
 				authorsArea.setEditable(true);
 				subjectArea.setEditable(true);
 				location_text.setEditable(true);
				}
				statement.close();
				}
				catch (SQLException sqlex) 
				{
				JOptionPane.showMessageDialog(null, sqlex);							 			
				}
 				
	}
	
	




public boolean check_fine()
		{
			
		
			boolean check = false;
		try
		{
			Statement satemt = con.createStatement();
		
					
			String query1 = "SELECT * FROM loan WHERE member_id = '" + patron_no_text.getText() + "'";
					
			ResultSet rs = satemt.executeQuery(query1);
			int chker = 0;		
			while(rs.next())
			{
					
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
			
			Calendar cal = Calendar.getInstance();
			java.sql.Date d = rs.getDate("due_date");
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
				chker = 1;
				
				//return check;
			}
			else
			{
				System.out.println("no overdue");
				
			}
		}
		
		if (chker ==1)
			return true;
		else
			return false;
			
			
		}
		
		catch(SQLException sqlex)
		{
			//sqlex.printStackTrace();
		}
		return check;
	}
	
	
	
	public void loan()
	{
		if (testing.getText().equals(""))
		{
			
		try
		{
			
			Statement stmt = con.createStatement();
			
			boolean chk = false;
			
			 chk = check_fine();	
			 			 
 						
			String querycnt = "SELECT * FROM loan WHERE member_id = '" + patron_no_text.getText() + "'";
			ResultSet rscnt = stmt.executeQuery(querycnt);
			int loancnt = 0;
			while(rscnt.next())
			{
				loancnt++;
			}
						
			if(loancnt<5)
			{

			
				String queryselbook = "SELECT * FROM Item WHERE item_id = '" + txtBookSearch.getText() + "'";
				ResultSet rs = stmt.executeQuery(queryselbook);
						
				rs.next();
				String abc = rs.getString("title");
				String avail = rs.getString("avail");
				String type = rs.getString("permission");
				String re = rs.getString("reservation");
				System.out.println(re);
			
			
				if (avail.equals("OUT"))
				{
					JOptionPane.showMessageDialog(null, "The Book is already borrowed by another member.");
					int confirm = JOptionPane.showConfirmDialog(null, "Would you like to reserve the book?", "Confirm Reservation", JOptionPane.YES_NO_OPTION);
					if( confirm == JOptionPane.YES_OPTION )
 					{
 						reserveBook();
 					}
				}
				else if (re.equals("YES"))
				{
					try
					{
						Statement s = con.createStatement();
						String querycheck = "SELECT * FROM reservation WHERE bookID = '" + txtBookSearch.getText() + "'";
						ResultSet rst = s.executeQuery(querycheck);
						
						while(rst.next())
						{
						temp.setText(rst.getString("patronID"));
						chkd = temp.getText();
						}
						String t = patron_no_text.getText();
						
						if(t.equals(chkd))
						{
							int conf = JOptionPane.showConfirmDialog(null, "You have reserved this book, would you like to borrow it?", "Confirm", JOptionPane.YES_NO_OPTION);
							if(conf == JOptionPane.YES_OPTION)
							{
								try
								{
									Statement st = con.createStatement();
									String qur = "UPDATE Item SET avail = 'IN' WHERE item_id = '" + txtBookSearch.getText() + "'";
									st.executeUpdate(qur);
									String qurr = "UPDATE Item SET reservation = 'NO' WHERE item_id = '" + txtBookSearch.getText() + "'";
									st.executeUpdate(qurr);
									String que = "DELETE * FROM reservation WHERE patronID = '" + chkd + "'";
									st.executeUpdate(que);
									loan();
								}
								catch(SQLException sqlex)
								{
									sqlex.printStackTrace();
								}
							}
						}
						else
						{
							int confirm = JOptionPane.showConfirmDialog(null, "Would you like to reserve the book?", "Confirm Reservation", JOptionPane.YES_NO_OPTION);
						if( confirm == JOptionPane.YES_OPTION )
 						{
 						reserveBook();
 						}
 					
 					
						}
					}
					catch(SQLException sqlex)
					{
						sqlex.printStackTrace();
					}
				}
				else if(type.equals("Reference"))
				{
					JOptionPane.showMessageDialog(null, "This Book is for Refernece use only.");
				}
				else
				{
					java.util.Date ddd = new java.util.Date();
			
					DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT);
						
					System.out.println("----------------------");
					System.out.println(df2.format(ddd));
					System.out.println("----------------------");
					
					
					cal.add(Calendar.DATE , 21);
					
					today = cal.getTime();
					System.out.println("******************");
					System.out.println(df2.format(today));
					System.out.println("****************");
	
					String queryins = "INSERT INTO loan(item_id, member_id, rent_date, due_date) VALUES" +
					 "('" + txtBookSearch.getText() + 
					 "', '" + patron_no_text.getText()+
					 "', '" + df2.format(ddd) + 
					 "', '" + df2.format(today) + "')";

					 try
					 {
						int res = stmt.executeUpdate(queryins);
						
						String queryupd = "UPDATE Item SET avail = 'OUT' WHERE item_id = '" + txtBookSearch.getText() + "'";
						
						int res1 = stmt.executeUpdate(queryupd);
						
								
								String bname[] = new String[5]; 
								java.sql.Date rdate[] = new java.sql.Date[5];
								java.sql.Date ddate[] = new java.sql.Date[5];
	
								String query22 = "SELECT * From loan WHERE member_id = '" + patron_no_text.getText() + "'";
								ResultSet rs22 = stmt.executeQuery(query22);
								
								int i = 0;
								while (rs22.next() ) 
								{
									bname[i] = rs22.getString("item_id");
									rdate[i] = rs22.getDate("rent_date");
									ddate[i] = rs22.getDate("due_date");
									
									i = i+1;
								}
								
								
								int j = 0;
								while (i>0){
								String query3 = "SELECT * FROM Item WHERE item_id = '" + bname[j] + "'";
								ResultSet rs3 = stmt.executeQuery(query3);
								
								rs3.next();
								i = i -1;
								
								book_title_text1[j].setText(rs3.getString("title"));
								acc_no_text[j].setText(bname[j]);
								rent_date_text[j].setText(df2.format(rdate[j]));
								due_date_text[j].setText(df2.format(ddate[j]));
								j = j+1;
								patron_no_text.setEditable(false);
								
								
							}
							
							
							dump.setText("");
							stmt.close();
					
					
					
				 }
				 catch(SQLException sqlex)
				 {
				 	sqlex.printStackTrace();
				 }
					
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Quota exceeded");
			
		}
		//JOptionPane.showMessageDialog(null, "Please Clear the Due to borrow items.00");		

		catch(SQLException sqlex)
		{
			sqlex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Item Dosent Exist. Please check the id and submit.");
		}
		
		
			
		testing.setText("a");
		
	}
		
	}
	
	public void delete()
	{
		try
 		{
 		Statement statement = con.createStatement();
 		int rs = JOptionPane.showConfirmDialog(null, "WARNING!! Record once deleted cannot be retrieved!! Continue with delete?", "CONFIRM", JOptionPane.YES_NO_OPTION);
 		if (rs == JOptionPane.YES_OPTION)
 		{
	 		String query3 = "delete * from Item "+
	 		" WHERE item_id LIKE '%" + a + "%'";
	 		int result = statement.executeUpdate(query3);
	 		String query2 = "delete * from book_detail "+
	 		" WHERE item_id LIKE '%" + a + "%'";
	 		int result2 = statement.executeUpdate(query2);	 		
			if (result == 1 && result2 == 1)
			{
				JOptionPane.showMessageDialog(null, "del Succesful");
				book_no_text.setText("");
            	book_title_text.setText("");
            	isbn_text.setText("");
            	class_text.setText("");
            	publisher_text.setText("");
            	place_text.setText("");
            	year_text.setText("");
            	pages_text.setText("");
            	location_text.setText("");
            	authorsArea.setText("");
            	subjectArea.setText("");	
            	
            	book_no_text.setEditable(true);
            	book_title_text.setEditable(true);
 				isbn_text.setEditable(true);
 				class_text.setEditable(true);
 				publisher_text.setEditable(true);
 				year_text.setEditable(true);
 				pages_text.setEditable(true);
 				authorsArea.setEditable(true);
 				subjectArea.setEditable(true);
 				location_text.setEditable(true);
			}
			statement.close();
			
	 	}
 		}
 		catch (SQLException sqlex) 
 		{
 		}
	}
	
	protected void reserveBook() 
	{
		String p = patron_no_text.getText();
		reserve jor = new reserve(p);
        jor.setVisible(true);
        desktop.add(jor);
        try {
            jor.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
}