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
		
		final JTextArea textArea = new JTextArea();// top text box
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 0 2,grow");
		
		JTextArea textArea_1 = new JTextArea(); //bottom text box
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		

		
		final JFileChooser filepicker= new JFileChooser();
		
		btnNewButton.addActionListener(new ActionListener() //open button interrupt
		{
			
			File textfile;
			String filename;
			FileReader fread;
			BufferedReader buffreader;
			String text;
			
			StringBuilder builder = new StringBuilder();
			
			public void actionPerformed(ActionEvent e) // file selection block
			{

				
				filepicker.showOpenDialog(null);
				
				if(!(filepicker.getSelectedFile()==null)) //stops null poiner exeption on cancel
				{
					textfile = filepicker.getSelectedFile();
					filename = textfile.getAbsolutePath();
					text = ""; //sets text to empty for new read
					builder.setLength(0);
					try 
					{
						fread = new FileReader(filename);
						buffreader = new BufferedReader(fread); //need a method here to read the formatted text into textarea.read
					
						while((text = buffreader.readLine()) != null) builder.append(text).append("\n");
						text = builder.toString();
						textArea.setText(text);
						
						buffreader.close();
						fread.close();
						textArea.requestFocus();
					}
					catch(Exception exeption1)
					{
						JOptionPane.showMessageDialog(null, "Error in reading file, exeption:" + exeption1);
					}
				}
				
			}
		});
		
		
		
		btnNewButton_1.addActionListener(new ActionListener()  //save file interupt
		{
			int id; //to check if cancled/accepted
			
			public void actionPerformed(ActionEvent arg0) 
			{
				
				id = filepicker.showSaveDialog(null);
				
				PrintWriter output;
				
				if(id == 0) //accepted 
				{
					
					try 
					{
						output = new PrintWriter(filepicker.getSelectedFile());
						output.write(textArea.getText()); //reads text from textarea, set in the other interupt
						//System.out.print(textArea.getText()); // outputs correctly in console, but dosnt save correctly in .txt file
						output.close();
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
