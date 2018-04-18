package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font; 
import javax.swing.JButton; 
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SigninAdmin {

	public JFrame frame;
	public JTextField textNumeMed;
	public JTextField textNumeMan;
	public JTextField textIngre;
	public JTextField textQu;
	public JTextField textPriceM;
	public JTextField textNumeE;
	public JTextField textadr;
	public JButton btnAddMedicine ;
	public DefaultTableModel table_3,table_1;
	public JTable table,table1;
	public JButton btnDeleteMed ;
	
	public JButton btnUpdate ;
	
	public JButton btnVire ;
	 
	
	public JButton btnView;
	
	public JButton btnAddEmployee ;
	
	public JButton btnDeleteEmployee ;
	
	public JButton btnUpdateEmployee ;
	 
	public JButton btnGenerate ;
	
	public JRadioButton rdbtnCsv ;
	
	public JRadioButton rdbtnPdf ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SigninAdmin window = new SigninAdmin();
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
	public void cleanModel(){
        // remove all rows
        while (table1.getRowCount() > 0) {
            ((DefaultTableModel) table1.getModel()).removeRow(0);
        }
    }
	public SigninAdmin() {
		initialize();
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textNumeMed = new JTextField();
		textNumeMed.setBounds(151, 47, 86, 20);
		frame.getContentPane().add(textNumeMed);
		textNumeMed.setColumns(10);
		
		JLabel lblOperationsForMedicine = new JLabel("Operations for Medicine:");
		lblOperationsForMedicine.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOperationsForMedicine.setBounds(33, 24, 184, 14);
		frame.getContentPane().add(lblOperationsForMedicine);
		
		JLabel lblOperationsForEmployees = new JLabel("Operations for Employees:");
		lblOperationsForEmployees.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOperationsForEmployees.setBounds(410, 24, 184, 14);
		frame.getContentPane().add(lblOperationsForEmployees);
		
		JLabel lblNume = new JLabel("Nume:");
		lblNume.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNume.setBounds(33, 49, 46, 14);
		frame.getContentPane().add(lblNume);
		
		JLabel lblManufacter = new JLabel("Manufacter:");
		lblManufacter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblManufacter.setBounds(33, 74, 79, 14);
		frame.getContentPane().add(lblManufacter);
		
		JLabel lblIngredients = new JLabel("Ingredients:");
		lblIngredients.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIngredients.setBounds(33, 99, 79, 20);
		frame.getContentPane().add(lblIngredients);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(33, 130, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQuantity.setBounds(33, 155, 65, 14);
		frame.getContentPane().add(lblQuantity);
		
		textNumeMan = new JTextField();
		textNumeMan.setText("");
		textNumeMan.setBounds(151, 72, 86, 20);
		frame.getContentPane().add(textNumeMan);
		textNumeMan.setColumns(10);
		
		textIngre = new JTextField();
		textIngre.setBounds(151, 100, 86, 20);
		frame.getContentPane().add(textIngre);
		textIngre.setColumns(10);
		
		textQu = new JTextField();
		textQu.setText("");
		textQu.setBounds(151, 153, 86, 20);
		frame.getContentPane().add(textQu);
		textQu.setColumns(10);
		
		textPriceM = new JTextField();
		textPriceM.setBounds(151, 128, 86, 20);
		frame.getContentPane().add(textPriceM);
		textPriceM.setColumns(10);
		table1=new JTable();
		table_1= new DefaultTableModel();
		
		table_1.addColumn("Medicine");
		table_1.addColumn("Ingredients");
		table_1.addColumn("Manufacter");  
		table_1.addColumn("Price");
		table_1.addColumn("Quantity");
		table1.setModel(table_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 231, 389, 100);
		scrollPane.setViewportView(table1);
		frame.getContentPane().add(scrollPane);
		table=new JTable();
		table_3= new DefaultTableModel();
		
		table_3.addColumn("Name Employee");
		table_3.addColumn("Adress"); 
		table.setModel(table_3);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(459, 211, 251, 100);
		scrollPane_1.setViewportView(table);
		frame.getContentPane().add(scrollPane_1);
		
		textNumeE = new JTextField();
		textNumeE.setBounds(508, 47, 86, 20);
		frame.getContentPane().add(textNumeE);
		textNumeE.setColumns(10);
		
		JLabel label = new JLabel("Nume:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(405, 49, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdresa.setBounds(405, 74, 58, 14);
		frame.getContentPane().add(lblAdresa);
		
		textadr = new JTextField();
		textadr.setBounds(508, 72, 86, 20);
		frame.getContentPane().add(textadr);
		textadr.setColumns(10);
		btnAddMedicine = new JButton("Add");
		btnAddMedicine.setBounds(17, 186, 95, 23);
		frame.getContentPane().add(btnAddMedicine);
		
	 btnDeleteMed = new JButton("Delete");
		btnDeleteMed.setBounds(122, 186, 89, 23);
		frame.getContentPane().add(btnDeleteMed);
		
	 btnUpdate = new JButton("Update");
		btnUpdate.setBounds(227, 186, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
	 btnVire = new JButton("View");
		btnVire.setBounds(115, 354, 89, 23);
		frame.getContentPane().add(btnVire);
		
		
	 btnView = new JButton("View Employees");
	 btnView.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 	}
	 });
		btnView.setBounds(574, 161, 121, 23);
		frame.getContentPane().add(btnView);
		
		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBounds(428, 127, 121, 23);
		frame.getContentPane().add(btnAddEmployee);
		
		 btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setBounds(428, 161, 121, 23);
		frame.getContentPane().add(btnDeleteEmployee);
		
		 btnUpdateEmployee = new JButton("Update Employee");
		btnUpdateEmployee.setBounds(574, 127, 121, 23);
		frame.getContentPane().add(btnUpdateEmployee);
		
		JLabel lblChooseTheType = new JLabel("Choose the type of report you want to generate:");
		lblChooseTheType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblChooseTheType.setBounds(428, 322, 321, 20);
		frame.getContentPane().add(lblChooseTheType);
		 btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(640, 354, 89, 23);
		frame.getContentPane().add(btnGenerate);
		
		 rdbtnCsv = new JRadioButton("CSV");
		rdbtnCsv.setBounds(410, 354, 109, 23);
		frame.getContentPane().add(rdbtnCsv);
		
	 rdbtnPdf = new JRadioButton("PDF");
		rdbtnPdf.setBounds(525, 354, 109, 23);
		frame.getContentPane().add(rdbtnPdf);
	}
}
