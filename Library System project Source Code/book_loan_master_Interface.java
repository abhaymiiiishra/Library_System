import javax.swing.*;
import java.awt.*;

public interface book_loan_master_Interface 
{
	public JPanel tab = new JPanel();
	public JLabel patron_no = new JLabel("Patron No");
    public JLabel patron_name = new JLabel("Name");
    public JLabel patron_group_type = new JLabel("Group Type");
    public JLabel patron_status = new JLabel("Status");
    public JLabel patron_loan_limit = new JLabel("Total Loan Limit");
    public JLabel patron_expiry_date = new JLabel("Expiry Date");   
    public JTextField patron_no_text = new JTextField(20);
    public JTextField patron_name_text = new JTextField(20);
    public JTextField patron_group_type_text = new JTextField(20);
    public JTextField patron_status_text = new JTextField(5);
    public JTextField patron_loan_limit_text = new JTextField(5);
    public JTextField patron_expiry_date_text = new JTextField(5);

    
}