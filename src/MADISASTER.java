import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class MADISASTER {

	private JFrame frame;
	private JTextField Nametextfield;
	private JTextField Mobiletextfield;
	private JTextField Addressextfield;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MADISASTER window = new MADISASTER();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn;
	PreparedStatement preparedst;
	ResultSet result;
	private JTextField IDtextfield;
	
	
	public void Connect()
	{
		try
		{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madisaster", "root", "@Collo_2543");
		}catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
	}
	
	
	/**
	 * Create the application.
	 */
	public MADISASTER() {
		initialize();
		Connect();
		Retrievedata();
	}
	
	private void Retrievedata() {
	    int ck;
	    
	    try {
	    	 preparedst = conn.prepareStatement("select * from Ukumbi");
	    	 result = preparedst.executeQuery();

	        // Get metadata of the result set (column information)
	        ResultSetMetaData meta = result.getMetaData();
	        ck = meta.getColumnCount();

	        // Get the table model
	        DefaultTableModel tmodel = (DefaultTableModel) table.getModel();

	        // Clear the previous rows before fetching new data
	        tmodel.setRowCount(0);

	        // Loop through the result set and add each row to the table model
	        while (result.next()) {
	            Vector<String> vector = new Vector<String>();
	            for (int i = 1; i <= ck; i++) {
	                vector.add(result.getString(i));  // Adding data of each column
	            }
	            tmodel.addRow(vector);  // Add the row to the model
	        }
	    } catch (SQLException sql) {
	        sql.printStackTrace();
	    }
	}

 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 1271, 648);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(21, 63, 505, 535);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel Labelname = new JLabel("Name");
		Labelname.setFont(new Font("Calibri", Font.BOLD, 18));
		Labelname.setBounds(23, 120, 101, 29);
		panel.add(Labelname);
		
		JLabel Labelmobile = new JLabel("Mobile");
		Labelmobile.setFont(new Font("Calibri", Font.BOLD, 18));
		Labelmobile.setBounds(23, 180, 101, 29);
		panel.add(Labelmobile);
		
		JLabel Labeldate = new JLabel("DOB");
		Labeldate.setFont(new Font("Calibri", Font.BOLD, 18));
		Labeldate.setBounds(21, 304, 90, 29);
		panel.add(Labeldate);
		
		JLabel Labelgender = new JLabel("Gender");
		Labelgender.setFont(new Font("Calibri", Font.BOLD, 18));
		Labelgender.setBounds(23, 235, 79, 29);
		panel.add(Labelgender);
		
		JLabel Labeladdress = new JLabel("Address");
		Labeladdress.setFont(new Font("Calibri", Font.BOLD, 18));
		Labeladdress.setBounds(28, 344, 93, 46);
		panel.add(Labeladdress);
		
		Nametextfield = new JTextField();
		Nametextfield.setBounds(146, 114, 196, 39);
		panel.add(Nametextfield);
		Nametextfield.setColumns(10);
		
		Mobiletextfield = new JTextField();
		Mobiletextfield.setBounds(143, 174, 199, 39);
		panel.add(Mobiletextfield);
		Mobiletextfield.setColumns(10);
		
		Addressextfield = new JTextField();
		Addressextfield.setBounds(143, 351, 199, 39);
		panel.add(Addressextfield);
		Addressextfield.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setMaximumRowCount(31);
		comboBox.setBounds(140, 294, 51, 39);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"}));
		comboBox_1.setMaximumRowCount(12);
		comboBox_1.setBounds(218, 294, 70, 39);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015"}));
		comboBox_2.setMaximumRowCount(10);
		comboBox_2.setBounds(306, 294, 71, 39);
		panel.add(comboBox_2);
		
		JRadioButton rdbtnmale = new JRadioButton("Male");
		rdbtnmale.setFont(new Font("Calibri", Font.ITALIC, 18));
		rdbtnmale.setBounds(142, 237, 109, 23);
		panel.add(rdbtnmale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Calibri", Font.ITALIC, 18));
		rdbtnFemale.setBounds(257, 237, 109, 23);
		panel.add(rdbtnFemale);
		
		ButtonGroup buttongroup = new ButtonGroup();//Enable selection of one gender only at a time
		buttongroup.add(rdbtnmale );
		buttongroup.add(rdbtnFemale);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Accept terms and conditions");
		chckbxNewCheckBox.setFont(new Font("Calibri", Font.ITALIC, 18));
		chckbxNewCheckBox.setBounds(109, 413, 282, 23);
		panel.add(chckbxNewCheckBox);
		
		JButton exitbuttton = new JButton("Exit");
		exitbuttton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		exitbuttton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		exitbuttton.setBounds(61, 443, 131, 46);
		panel.add(exitbuttton);
		
		JButton registerbutton = new JButton("Register");
		registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// add a try and catch for exception purposes
				  try
				  { 
					 
					  preparedst = conn.prepareStatement("insert into  Ukumbi(ID,Name,Gender,Address,Contact) values(?,?,?,?,?)");
					 // replace each question mark with their respective value
					  preparedst.setString(1,IDtextfield.getText());
					  preparedst.setString(2,Nametextfield.getText());
					 
					 String gender = "";
					 if(rdbtnmale.isSelected()) { gender = "Male";}
					 else  if(rdbtnFemale.isSelected()) {gender = "Female";}
					 
					 preparedst.setString(3,gender);
					 preparedst.setString(4,Addressextfield.getText());
					 preparedst.setString(5,Mobiletextfield.getText());
					 
					 //this will return number row affect in our db
					 int RowAffect_Db = preparedst.executeUpdate();
					 //create a condition
					 if(RowAffect_Db > 0)
					 {
						 JOptionPane.showMessageDialog(null, "Registration done sucessfully...");
						 
					 }
					 Retrievedata();
					 
					 IDtextfield.setText("");
					 Nametextfield.setText("");
					 buttongroup.clearSelection();
					 Addressextfield.setText("");
					 Mobiletextfield.setText("");
					 chckbxNewCheckBox.setSelected(false);
					 IDtextfield.requestFocus();
					  
				  }catch(SQLException pk)
				  {
					 pk.printStackTrace();
				  }	
				
		
			}
		});
		registerbutton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		registerbutton.setBounds(218, 443, 131, 46);
		panel.add(registerbutton);
		
		JLabel LabelID = new JLabel("ID");
		LabelID.setFont(new Font("Calibri", Font.BOLD, 18));
		LabelID.setBounds(23, 58, 79, 23);
		panel.add(LabelID);
		
		IDtextfield = new JTextField();
		IDtextfield.setBounds(146, 45, 196, 39);
		panel.add(IDtextfield);
		IDtextfield.setColumns(10);
		
		
		JLabel Labelregistration = new JLabel("REGISTRATION FORM");
		Labelregistration.setFont(new Font("Calibri", Font.BOLD, 20));
		Labelregistration.setBounds(116, 11, 227, 36);
		frame.getContentPane().add(Labelregistration);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(536, 58, 709, 535);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(133, -26, 409, 36);
		panel_1.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 689, 513);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			    new Object[][] {},
			    new String[] { "ID", "Name", "Gender", "Address", "Contact" }
			));

		
		JLabel Labeldtabase = new JLabel("Database information");
		Labeldtabase.setFont(new Font("Calibri", Font.BOLD, 20));
		Labeldtabase.setBounds(706, 11, 227, 36);
		frame.getContentPane().add(Labeldtabase);
	}
}
