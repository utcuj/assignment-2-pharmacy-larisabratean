package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;

public class SigninEmployee {
	public JButton btnSell ;
	public DefaultTableModel table_3  ;
	public DefaultTableModel table_1;
	public JButton btnSearch;
	public JButton btnSearchIng ;
	public JFrame frame;
	public JButton btnShowAll;
	public JTextField textName;
	public JTextField textIngredients;
	public JTextField textManufacter;
	public JTextField textNameM;
	public JTextField textQuantity;
	public JTextField textField;
	public JButton buttonSearchManu;
	public JButton btnSeeSells;
	public JScrollPane scrollPane_1;
	public JTextField textBani;
public JTable table,table1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SigninEmployee window = new SigninEmployee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public void setFrame()
	{
		this.frame.setVisible(true);
	}
	public SigninEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public JFrame getFrame()
	{
		return this.frame;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 780, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSearchMedicationBy = new JLabel("Search medication by :");
		lblSearchMedicationBy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSearchMedicationBy.setBounds(10, 33, 194, 29);
		panel.add(lblSearchMedicationBy);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(35, 73, 59, 14);
		panel.add(lblName);
		
		JLabel lblIngredients = new JLabel("Ingredients:");
		lblIngredients.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIngredients.setBounds(35, 98, 83, 23);
		panel.add(lblIngredients);
		
		JLabel lblManufacter = new JLabel("Manufacter:");
		lblManufacter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblManufacter.setBounds(35, 132, 83, 14);
		panel.add(lblManufacter);
		
		textName = new JTextField();
		textName.setBounds(146, 71, 86, 20);
		panel.add(textName);
		textName.setColumns(10);
		
		textIngredients = new JTextField();
		textIngredients.setText("");
		textIngredients.setBounds(146, 100, 86, 20);
		panel.add(textIngredients);
		textIngredients.setColumns(10);
		
		textManufacter = new JTextField();
		textManufacter.setBounds(146, 130, 86, 20);
		panel.add(textManufacter);
		textManufacter.setColumns(10);
		
		JLabel lblSellMedication = new JLabel("Sell medication:");
		lblSellMedication.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSellMedication.setBounds(505, 37, 99, 21);
		panel.add(lblSellMedication);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(453, 73, 59, 14);
		panel.add(label);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQuantity.setBounds(450, 102, 83, 14);
		panel.add(lblQuantity);
		
		textNameM = new JTextField();
		textNameM.setBounds(564, 71, 86, 20);
		panel.add(textNameM);
		textNameM.setColumns(10);
		table=new JTable();
		table_3= new DefaultTableModel();
		
		table_3.addColumn("Nume");
		table_3.addColumn("Ingredients");
		table_3.addColumn("Manufacter");
		table_3.addColumn("Price");
		table_3.addColumn("Quantity");
		table.setModel(table_3);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 339, 175);
		scrollPane.setViewportView(table);
		panel.add(scrollPane);
		textQuantity = new JTextField();
		textQuantity.setText("");
		textQuantity.setBounds(564, 100, 86, 20);
		panel.add(textQuantity);
		textQuantity.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(564, 130, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNameClient = new JLabel("Name Client:");
		lblNameClient.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNameClient.setBounds(453, 132, 83, 14);
		panel.add(lblNameClient);
		
		btnSell = new JButton("Sell");
		btnSell.setBounds(665, 109, 89, 23);
		panel.add(btnSell);
		
		 btnSearch = new JButton("Search");
		btnSearch.setBounds(242, 70, 89, 23);
		panel.add(btnSearch);
		btnSearchIng = new JButton("Search");
		btnSearchIng.setBounds(242, 99, 89, 23);
		panel.add(btnSearchIng);
		
		 buttonSearchManu = new JButton("Search");
		buttonSearchManu.setBounds(242, 129, 89, 23);
		panel.add(buttonSearchManu);
		
		
		btnSeeSells = new JButton("See sells");
		btnSeeSells.setBounds(564, 193, 89, 23);
		panel.add(btnSeeSells);
		table1=new JTable();
		table_1= new DefaultTableModel();
		
		table_1.addColumn("Client");
		table_1.addColumn("Medicine");
		table_1.addColumn("Cantity"); 
		table_1.addColumn("Left Money"); 
		table1.setModel(table_1);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(394, 227, 360, 143);
		scrollPane_1.setViewportView(table1);
		panel.add(scrollPane_1);
		
		JLabel lblBaniClient = new JLabel("Bani Client:");
		lblBaniClient.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBaniClient.setBounds(453, 162, 83, 14);
		panel.add(lblBaniClient);
		
		textBani = new JTextField();
	
		textBani.setBounds(564, 160, 86, 20);
		panel.add(textBani);
		textBani.setColumns(10);
		
		 btnShowAll = new JButton("Show all");
		btnShowAll.setBounds(143, 347, 89, 23);
		panel.add(btnShowAll);
	}
	 public void cleanModel(){
	        // remove all rows
	        while (table1.getRowCount() > 0) {
	            ((DefaultTableModel) table1.getModel()).removeRow(0);
	        }
	    }
}
