import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public interface General_frame_Interface
{
	public General gen = new General();
	public java.util.Date currentDate = new java.util.Date();;
	public SimpleDateFormat formatter = new SimpleDateFormat ("MMMM dd yyyy", Locale.getDefault());
}