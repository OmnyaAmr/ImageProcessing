import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		ImageFrame frame = new ImageFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}
}

class ImageFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImageFrame() {
		setTitle("DMET501 Image Processor!");
		setSize(500, 500);
		setLayout(new GridLayout(2, 2));
		setBackground(Color.white);

		JLabel Label1 = new JLabel(new ImageIcon("src\\test1.jpg"));
		JLabel Label2 = new JLabel(new ImageIcon("src\\test2.jpg"));
		JLabel Label3 = new JLabel(new ImageIcon("src\\test1Output.jpg"));
		JLabel Label4 = new JLabel(new ImageIcon("src\\test2Output.jpg"));

		add(Label1);
		add(Label2);
		add(Label3);
		add(Label4);
	}

}
