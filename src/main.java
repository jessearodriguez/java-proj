import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class main extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup justification = new ButtonGroup();
	private final ButtonGroup spacing = new ButtonGroup();
	private JTextField textField;

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
		setBounds(100, 100, 870, 567);
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
		rdbtnNewRadioButton.setActionCommand("lj");
		justification.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Right Justification");

		toolBar.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setActionCommand("rj");
		justification.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnFullJustification = new JRadioButton("Full Justification    ");
		justification.add(rdbtnFullJustification);
		rdbtnFullJustification.setActionCommand("fj");
		toolBar.add(rdbtnFullJustification);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Single spaced");
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setActionCommand("ss");
		spacing.add(rdbtnNewRadioButton_2);

		toolBar.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Double Spaced     ");
		spacing.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setActionCommand("ds");
		toolBar.add(rdbtnNewRadioButton_3);
		
		JLabel lblLineLength = new JLabel("Line length:");
		toolBar.add(lblLineLength);
		
		JPanel panel = new JPanel();
		toolBar.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		
		textField.setText("80");
		textField.setBounds(0, 0, 35, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		final JTextArea textArea = new JTextArea();// top text box
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setFont(textArea.getFont().deriveFont(16f));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 0 2,grow");
		
		JTextArea textArea_1 = new JTextArea(); //bottom text box
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		

		
		final JFileChooser filepicker= new JFileChooser();
		
		final Helper helper = new Helper(); //helper object that calls all methods
		
		
		// start of listeners 
		
		
		textField.addKeyListener(new KeyAdapter() // text field listener for variable line length box, only activates on enter press
		{
			@Override

			public void keyPressed(KeyEvent e) 
			{
				int linelength=0;
				int emptylines=helper.emptylines;
				int casecode=0b0000;
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try
					{
						linelength = Integer.parseInt(textField.getText());
						//System.out.print(justification.getSelection().getActionCommand()+"\n");
						casecode=helper.generatecode(justification, spacing);
						switch (casecode)
						{
						//ds
						case 0b0001: break;
						case 0b0010: break;
						case 0b0100: break;
					//ss
						case 0b1001: break;
						case 0b1010: break;
						case 0b1100: break;
						default: break;
						
						}
						
						
						//textArea.setText(helper.formatText(helper.text, linelength));
					}
					catch(Exception exep)
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid input.");
					}
					
				}
			}
		});
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() //right justify radio button
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				textArea.setText(helper.rjustify(textArea.getText()));
				//helper.text=textArea.getText();
			}
		});
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() //left justify radio button
		{
			public void actionPerformed(ActionEvent e) 
			{
				textArea.setText(helper.ljustify(textArea.getText()));
				//helper.text=textArea.getText();
			}
		});
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
						buffreader = new BufferedReader(fread); 
						while((text = buffreader.readLine()) != null) builder.append(text).append("\n");
						
						text = builder.toString();//pass this string to the formatting method, multiple method calls here for analysis too.
						
						
						
						textArea.setText(helper.formatText(helper.ljustify(text),80));
						helper.preemptycalc(text);
						helper.text=textArea.getText();
						helper.statcalc(textArea_1,textArea.getText());
						//textArea.setText(text);
						
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
						

						char letter;
						String text = textArea.getText();
						
						for(int i =0; i <text.length();i++) //formats new lines correctly, iterates through the entire text
						{
							letter = text.charAt(i);
							if(letter == '\n')
							{
								output.println();
							}
							else
							{
								output.append(letter);
							}
						}
						output.close();
					}
					catch(Exception exeption1)
					{
						JOptionPane.showMessageDialog(null, "Error in saving file, exeption:" + exeption1);
					}
					
					
				}
			}
			
		});
	}
}
