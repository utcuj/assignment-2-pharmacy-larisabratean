package XMLOp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

import model.Administrator;
import model.Employee;
import model.Medication;
import model.Selling;
public class ReadDataXML {
	public ReadDataXML()
	{
		
	}
  
	public <T> T ReadData(String e,int op) 
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
				return(T) data;
			}
			case 2: 
			{

				xstream1.processAnnotations(Administrator.class);
				ArrayList<Administrator> data = (ArrayList<Administrator>) xstream1.fromXML(new File(path+e+".xml")); // 
				return(T) data;
			}
			case 3: 
			{
				xstream1.processAnnotations(Selling.class);
				ArrayList<Selling> data = (ArrayList<Selling>) xstream1.fromXML(new File(path+e+".xml")); // 
				return(T) data;
			}
			case 4: 
			{
				xstream1.processAnnotations(Medication.class);
				ArrayList<Medication> data = (ArrayList<Medication>) xstream1.fromXML(new File(path+e+".xml")); // 
		 				return(T) data;
			}
			
			default: 
				{
					xstream1.processAnnotations(Medication.class);
			ArrayList<Medication> data = (ArrayList<Medication>) xstream1.fromXML(new File(path+e+".xml")); // 
			return(T) data;
		}
	        

			}
	}
}
