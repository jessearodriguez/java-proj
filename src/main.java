import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.TextArea;

public class main extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup justification = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(5, 5, 561, 27);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("Open");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		toolBar.add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Left justification");
		toolBar.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		justification.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Right Justification");
		toolBar.add(rdbtnNewRadioButton_1);
		justification.add(rdbtnNewRadioButton_1);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(5, 364, 561, 80);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(5, 32, 561, 326);
		textArea_1.setEditable(false);
		contentPane.add(textArea_1);
	}

}
