package Micro; 
import view.Login; 

import java.io.FileNotFoundException;  
import controller.ControllerLog;
public class MVC {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	
	/*	List<Medication> m= new ArrayList<Medication>();
		List<Selling> s= new ArrayList<Selling>();
		//List<Administrator> a= new ArrayList<Administrator>();
		List<Employee> e= new ArrayList<Employee>();
		
		Medication m1= new Medication("Algocalmin","bica, beta","Mana",200,2,6);
		Employee e1= new Employee(4,"Plesa Gabriel","eu","Cluj");
		Selling s1= new Selling("Ibuprofen",20,"Alex",2000);
		m.add(m1);
		e.add(e1);
		s.add(s1); 
		new WriteDataXML("Selling",s,3);
		new WriteDataXML("Medication",m,4);

		new WriteDataXML("Users",e,1);*/
		Login l= new Login();
		l.setFrame();
		ControllerLog cl= new ControllerLog(l);
		
	}

}
