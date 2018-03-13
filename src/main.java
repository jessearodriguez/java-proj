import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;

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
		setBounds(100, 100, 709, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[561px,grow]", "[27px][326px,grow][80px,grow]"));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, "cell 0 0,grow");
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 0 2,grow");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);

		btnNewButton.addActionListener(new ActionListener() 
		{
			JFileChooser filepicker;
			File textfile;
			String filename;
			FileReader fread;
			BufferedReader buffreader;
			public void actionPerformed(ActionEvent e) // file selection block
			{

				filepicker = new JFileChooser();
				filepicker.showOpenDialog(null);
				
				if(!(filepicker.getSelectedFile()==null)) //stops null poiner exeption on cancle
				{
					textfile = filepicker.getSelectedFile();
					filename = textfile.getAbsolutePath();
					
					try 
					{
						fread = new FileReader(filename);
						buffreader = new BufferedReader(fread);
						textArea.read(buffreader, null);
						buffreader.close();
						textArea.requestFocus();
					}
					catch(Exception exeption1)
					{
						JOptionPane.showMessageDialog(null, "Error in reading file, exeption:" + exeption1);
					}
				}
			}
		});
	}
}
