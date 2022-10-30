import javax.swing.*;
import java.awt.*;

public interface video_master_info_Interface
{
	public JPanel text = new JPanel(); 
    public String type_list[] = {"Reference", "Lendable"};
    public String category_list[] = {"VHS", "S-VHS", "U-Matic"};
	public JTextField Video_no_text = new JTextField(20);
	public JTextField Video_title_text = new JTextField(20);
	public JComboBox type_combo = new JComboBox(type_list);
	public JComboBox category_combo = new JComboBox(category_list);
	public JLabel Video_master = new JLabel("Video Master");
	public JLabel Video_no = new JLabel("Video No");
	public JLabel Video_title = new JLabel("Video Title");
	public JLabel Video_type = new JLabel("Video Type");
	public JLabel Video_cat = new JLabel("Video Category");
	//public video vid = new video();

}