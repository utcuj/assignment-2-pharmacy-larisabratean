package controller; 
import model.Employee;
import model.Medication;
import model.Selling; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File; 
import java.util.ArrayList; 
import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;

import XMLOp.ReadDataXML;
import model.Administrator;
import view.Login;
import view.SigninAdmin;
import view.SigninEmployee;
public class ControllerLog implements ActionListener {
private Login logn;
private ArrayList<Employee> emp;
private ArrayList<Administrator> admins; 
public ControllerLog ( Login l)

{  
	this.emp = new ReadDataXML().ReadData("Users", 1);
	this.admins= new ReadDataXML().ReadData("Admin", 2); 
this.logn=l;
this.logn.btnEmployee.addActionListener(this);

this.logn.btnAdmin.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
	if (e.getSource()==logn.btnAdmin)
	{	boolean ok=false;
		String pass=new String(logn.passwordField.getPassword());
		String nume= new String(logn.textUsername.getText());
		
		
		for (Administrator a: admins)
		{
			if( (a.getPassword().equals(pass))  && (a.getNume().equals(nume)))
			{ 
				SigninAdmin sa=new SigninAdmin();
			sa.getFrame().setVisible(true);
			ok=true;
			  new ControllerAdministrator(sa,a);
			  break;
			}
			else  if (!ok){
				JOptionPane.showMessageDialog(null, "Admin-ul nu exista!");

			}
		}
	}
	if (e.getSource()==logn.btnEmployee)
	{
		boolean ad=false;
		String pass=new String(logn.passwordField.getPassword());
		String nume= new String(logn.textUsername.getText());
		 
		
		
		for (Employee a: emp)
		{
			if( (a.getPassword().equals(pass))  && (a.getNume().equals(nume)))
			{  SigninEmployee se=new SigninEmployee();
			se.getFrame().setVisible(true);
			ad=true;
			  new ControllerEmployee(se,a);
			  break;
			}
			else  if (!ad){
				JOptionPane.showMessageDialog(null, "Angajatul-ul nu exista!");

			}
		}
			
	
	}
}
public Object ReadData(String e,int op) 
{
    final String path = "C:\\Users\\larisa\\workspace\\Assignment2\\";

	XStream xstream1 = new XStream();
	XStream.setupDefaultSecurity(xstream1);
	xstream1.allowTypesByWildcard(new String[] {
		    "model.Employee","model.Selling","model.Administrator","model.Medication"});
		 
	 
		switch(op)
		{
		case 1: 
		{
			xstream1.processAnnotations(Employee.class);

			ArrayList<Employee> data = (ArrayList<Employee>) xstream1.fromXML(new File(path+e+".xml")); // 
			return data;
		}
		case 2: 
		{

			xstream1.processAnnotations(Administrator.class);
			ArrayList<Administrator> data = (ArrayList<Administrator>) xstream1.fromXML(new File(path+e+".xml")); // 
			return  data;
		}
		case 3: 
		{
			xstream1.processAnnotations(Selling.class);
			ArrayList<Selling> data = (ArrayList<Selling>) xstream1.fromXML(new File(path+e+".xml")); // 
			return  data;			}
		case 4: 
		{
			xstream1.processAnnotations(Medication.class);
			ArrayList<Medication> data = (ArrayList<Medication>) xstream1.fromXML(new File(path+e+".xml")); // 
			return data;			}
		
		default: 
			{
				xstream1.processAnnotations(Medication.class);
		ArrayList<Medication> data = (ArrayList<Medication>) xstream1.fromXML(new File(path+e+".xml")); // 
		return   data;			}
        

		}
}
}
