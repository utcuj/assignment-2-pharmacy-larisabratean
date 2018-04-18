package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import java.util.List;

import javax.swing.JOptionPane;
 
import model.Employee;
import model.Medication;
import model.Selling;
import view.SigninEmployee;
import XMLOp.ReadDataXML; 
import XMLOp.WriteDataXML;
 
public class ControllerEmployee  implements ActionListener{
	private SigninEmployee emp;
	private Employee model;
	private List<Medication> meds ;
	private List<Selling> sells;
	public ControllerEmployee(SigninEmployee m, Employee e)
	{
		this.model= e;
		this.emp=m;
		this.meds= new ReadDataXML().ReadData("Medication",4);
		this.sells= new ReadDataXML().ReadData("Selling", 3);
		this.emp.btnSearch.addActionListener(this);
		this.emp.btnSearchIng.addActionListener(this);
		this.emp.btnSell.addActionListener(this);
		this.emp.buttonSearchManu.addActionListener(this);
		this.emp.btnSeeSells.addActionListener(this);

	}
public void actionPerformed(ActionEvent e)
{
	if (e.getSource()==emp.btnSell)
	{	
	 
		String nume_produs = new String(emp.textNameM.getText());
		String nume_client= new String(emp.textField.getText());
		int cantity = Integer.parseInt(emp.textQuantity.getText());
		int bani_client = Integer.parseInt(emp.textBani.getText());

		 for (Medication m: meds )
		 {
			 if( m.getName().equals(nume_produs))
			 {
			if (cantity<=m.getQuantity())	 
			{
				 int amount= cantity* m.getPrice();
				 if (bani_client>= amount)
				 { 
					 sells.add(new Selling(nume_produs,cantity,nume_client,bani_client-amount));
					 try {
						new WriteDataXML("Selling",sells,3);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						JOptionPane.showMessageDialog(null, "The order was placed! You have "+(bani_client-amount)+" left!");
					 
				 }
				 else JOptionPane.showMessageDialog(null, "The client doesn't have enough money!");
				 m.setQuantity(m.getQuantity()-cantity);
				 try {
					new WriteDataXML("Selling",sells,3);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
			else JOptionPane.showMessageDialog(null, "The product is out of stock!");
			 } 
			 	
		 }
		 
	}
		
	if (e.getSource()==emp.btnSearch)
	{	
		String nume_medic= emp.textName.getText();
	   
						afisareMedicamente(nume_medic );
	  
	}
	if (e.getSource()==emp.btnShowAll)
	{	
		 
	afisareMedicamenteTotal();
	  
	}
	if (e.getSource()==emp.btnSearchIng)
	{	
		String ing= emp.textIngredients.getText();
	 
						afisareMedicamenteIng(ing ); 	 
		 
	
	}
	if (e.getSource()==emp.buttonSearchManu)
	{	
		
		String ing= emp.textManufacter.getText();
		 
			 afisareMedicamenteMan(ing ); 	 
		 
	}
	if (e.getSource()==emp.btnSeeSells)
	{	

		afisareComenzi() ;
	}
	
		
		
		
}
public   void afisareMedicamente(String a)  {
	   this.emp.table_3.setRowCount(0);
		this.emp.cleanModel();
	    for (Object med : meds) {
	     if (((Medication)med).getName().equals(a)){
	      String[] ob = { String.valueOf(((Medication) med).getName()),String.valueOf(((Medication) med).getIngredients()),
	    		  String.valueOf(((Medication) med).getManufacter()),
	    		  String.valueOf(((Medication)med).getPrice()),
	    		  String.valueOf(((Medication)med).getQuantity())
	      };
	  
	      emp.table_3.addRow(ob);
	      			}
	    			}  
}

public   void afisareMedicamenteTotal( )  {
	   this.emp.table_3.setRowCount(0);
		this.emp.cleanModel();
	    for (Object med : meds) {
	     
	      String[] ob = { String.valueOf(((Medication) med).getName()),String.valueOf(((Medication) med).getIngredients()),
	    		  String.valueOf(((Medication) med).getManufacter()),
	    		  String.valueOf(((Medication)med).getPrice()),
	    		  String.valueOf(((Medication)med).getQuantity())
	      };
	  
	      emp.table_3.addRow(ob);
	      			}
	    			
}
    void afisareMedicamenteIng(String ing)  {
    	this.emp.cleanModel();
	   this.emp.table_3.setRowCount(0);
	   String[] parts=ing.split(", ");
	    for (Object med : meds) {
	    	String[] parts1=((Medication)med).getIngredients().split(", ");
			for (int i=0;i<parts.length;i++)
			{
				for (int j=0;j<parts1.length;j++) {
				 if (parts[i].equals(parts1[j])) {
	      String[] ob = { String.valueOf(((Medication) med).getName()),String.valueOf(((Medication) med).getIngredients()),
	    		  String.valueOf(((Medication) med).getManufacter()),
	    		  String.valueOf(((Medication)med).getPrice()),
	    		  String.valueOf(((Medication)med).getQuantity())
	      };
	  
	      emp.table_3.addRow(ob);
	      			}
				}
	    			}  
	    }
}

    public   void afisareMedicamenteMan(String a)  {
    	this.emp.cleanModel();
    	this.emp.table_3.setRowCount(0);
 		
 	    for (Object med : meds) {
 	     if (((Medication)med).getManufacter().equals(a)){
 	      String[] ob = { String.valueOf(((Medication) med).getName()),String.valueOf(((Medication) med).getIngredients()),
 	    		  String.valueOf(((Medication) med).getManufacter()),
 	    		  String.valueOf(((Medication)med).getPrice()),
 	    		  String.valueOf(((Medication)med).getQuantity())
 	      };
 	  
 	      emp.table_3.addRow(ob);
 	      			}
 	    			}  
 }

public   void afisareComenzi()   {
	   this.emp.table_1.setRowCount(0);
	  
	    for (Object sel : sells) {
	      String[] ob = { String.valueOf(((Selling) sel).getClient()),String.valueOf(((Selling) sel).getMedic()),
	    		  String.valueOf(((Selling) sel).getTotalQuantity()),
	    		  
	    		  String.valueOf(((Selling)sel).getBani())  
	          };
	     emp.table_1.addRow(ob);
	    }
	  }	
public int getId()
{
	return this.model.getId();
}
public void setId(int id)
{
this.model.setId(id);}
public String getNume()
{
	return this.model.getNume();
}
public String getAdresa()
{
	return this.model.getAdresa();
}
public String getPassword()
{
	return this.model.getPassword() ;
}
public void setNume(String nume)
{
	this.model.setNume(nume);
}
public void setPassword(String password)
{
	this.model.setPassword(password);
}
public void setAdresa(String adresa)
{
	this.model.setAdresa(adresa);
}
}
