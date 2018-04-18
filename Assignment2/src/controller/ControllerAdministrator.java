package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JOptionPane;

import XMLOp.ReadDataXML;
import XMLOp.WriteDataXML;
import model.Administrator;
import view.SigninAdmin; 
import model.Employee;
import model.GenerateCsv;
import model.GeneratePdf;
import model.Medication;
import model.ReportFactory;
public class ControllerAdministrator implements ActionListener {
	private SigninAdmin adm;
	private Administrator admin;
	private List<Medication> meds;
	private List<Employee> emp;
	
	public ControllerAdministrator(SigninAdmin m, Administrator e)
	{
		this.admin=e;
		this.adm=m;
		this.meds= new ReadDataXML().ReadData("Medication",4);
		this.emp=  new ReadDataXML().ReadData("Users",1);
		this.adm.btnAddEmployee.addActionListener(this);
		this.adm.btnAddMedicine.addActionListener(this);
		this.adm.btnDeleteEmployee.addActionListener(this);
		this.adm.btnDeleteMed.addActionListener(this);
		this.adm.btnDeleteMed.addActionListener(this);
		this.adm.btnGenerate.addActionListener(this);
		this.adm.btnUpdate.addActionListener(this);
		this.adm.btnUpdateEmployee.addActionListener(this);
		this.adm.btnView.addActionListener(this);
		this.adm.btnVire.addActionListener(this);
		this.adm.rdbtnCsv.addActionListener(this);
		this.adm.rdbtnPdf.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==adm.btnAddEmployee)
		{
			emp.add(new Employee(adm.textNumeE.getText(),adm.textadr.getText()));
			   JOptionPane.showMessageDialog(null, "Succes!");
			afisareEmployees();
			 try {
					new WriteDataXML("Users",emp,1);
				} catch (FileNotFoundException e1) { 
					e1.printStackTrace();
				}
		}

		if (e.getSource()==adm.btnAddMedicine)
		{ 
			meds.add(new Medication(adm.textNumeMed.getText(),adm.textIngre.getText(),adm.textNumeMan.getText(),Integer.parseInt(adm.textQu.getText()),Integer.parseInt(adm.textPriceM.getText())));
			   JOptionPane.showMessageDialog(null, " The medicine was added!");
			afisareMedicamente();
			
			try {
					new WriteDataXML("Medication",meds,4);
				} catch (FileNotFoundException e1) { 
					e1.printStackTrace();
				}
		}
		if (e.getSource()==adm.btnDeleteEmployee)
		{
		boolean ok=false;
		int ind=-1;
			for (int i=0;i<emp.size();i++)
			{
				if (emp.get(i).getNume().equals(adm.textNumeE.getText()))
				{
					ok=true;
					ind=i;
					break;
				}
			}
			if ((ok==true)&& (ind!=-1))
			{
				emp.remove(ind);
				   JOptionPane.showMessageDialog(null, "Employee deleted!");
				   afisareEmployees();
				try {
					new WriteDataXML("Users",emp,1);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource()==adm.btnDeleteMed)
		{
			boolean ok=false;
			int ind=-1;
				for (int i=0;i<meds.size();i++)
				{
					if (meds.get(i).getName().equals(adm.textNumeMed.getText()))
					{
						ok=true;
						ind=i;
						break;
					}
				}
				if ((ok==true)&& (ind!=-1))
				{
					emp.remove(ind);
					afisareMedicamente();
					   JOptionPane.showMessageDialog(null, "Medicine deleted!");
					try {
						new WriteDataXML("Medication",meds,4);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
		}
		 
		if (e.getSource()==adm.btnGenerate)
		{
			
			ReportFactory rep = new ReportFactory();
			if (adm.rdbtnCsv.isSelected())
			{
				GenerateCsv gen= (GenerateCsv) rep.getReport("CSV");
				gen.generate(meds);
			}
			 if ( adm.rdbtnPdf.isSelected())
			{
				GeneratePdf gen= (GeneratePdf) rep.getReport("PDF");	
				gen.generate(meds);
			}
		}
		if (e.getSource()==adm.btnUpdate)
		{
			for (int i=0;i<meds.size();i++)
			{
				if (adm.textNumeMed.getText().equals(meds.get(i).getName())) 
						{
				 
					meds.get(i).setQuantity(Integer.parseInt(adm.textQu.getText()));
			 
						} 
			}
			try {
				new WriteDataXML("Medication",meds,4);
				afisareMedicamente();
				JOptionPane.showMessageDialog(null, "Quantity updated!");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==adm.btnUpdateEmployee)
		{
			for (int i=0;i<emp.size();i++)
			{
				if (adm.textNumeE.getText().equals(emp.get(i).getNume())) 
						{
				 
					emp.get(i).setAdresa(adm.textadr.getText());
			 
						} 
			}
			try {
				new WriteDataXML("Users",emp,1);
				afisareEmployees();
				JOptionPane.showMessageDialog(null, "Adress updated!");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==adm.btnView)
		{
			afisareEmployees();
		}
		if (e.getSource()==adm.btnVire)
		{
			afisareMedicamente();
		}
		
	}
	public   void afisareMedicamente()  {
		   this.adm.table_1.setRowCount(0);
			
		    for (Object med : meds) {
		     
		      String[] ob = { String.valueOf(((Medication) med).getName()),String.valueOf(((Medication) med).getIngredients()),
		    		  String.valueOf(((Medication) med).getManufacter()),
		    		  String.valueOf(((Medication)med).getPrice()),
		    		  String.valueOf(((Medication)med).getQuantity())
		      };
		  
		      adm.table_1.addRow(ob);
		      		 
		    			}  
	}
	
	public   void afisareEmployees()  {
		   this.adm.table_3.setRowCount(0);
			 
		    for (Object ang : emp) {
		     
		      String[] ob = { String.valueOf(((Employee) ang).getNume()),
		    		  String.valueOf(((Employee)ang).getAdresa())
		      };
		  
		      adm.table_3.addRow(ob);
		      		 
		    			}  
	}
}
