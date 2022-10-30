import javax.swing.*;
import java.awt.*;

public interface book_loan_tab_Interface 
{
	public JPanel upper = new JPanel(); 
	public JPanel down = new JPanel();
	public JPanel lower = new JPanel();
	public JTextField book_title_text1[] = new JTextField[5];
	public JTextField acc_no_text[] = new JTextField[5];
	public JTextField rent_date_text[] = new JTextField[5];
	public JTextField due_date_text[] = new JTextField[5];
	public JLabel loan_items = new JLabel("Loan Items");
    public JLabel book_title = new JLabel("Book Title");
    public JLabel acc_no = new JLabel("Acc No");
    public JLabel rent_date = new JLabel("Rent Date");
    public JLabel due_date = new JLabel("Due Date");
    public JLabel dump = new JLabel();
    public JTextField txtBookSearch = new JTextField(10);
        public JTextField testing = new JTextField(3);
}