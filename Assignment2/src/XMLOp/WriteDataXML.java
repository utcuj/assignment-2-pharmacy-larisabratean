package XMLOp; 

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import javax.security.auth.login.Configuration;

import com.thoughtworks.xstream.XStream;

import model.Administrator;
import model.Employee;
import model.Medication;
import model.Selling;

public class WriteDataXML {

	public WriteDataXML()
	{
		
	}
	
	 
	public WriteDataXML(String e,Object d,int op) throws FileNotFoundException
	{
		FileOutputStream fileReader = null;
		XStream xstream1 = new XStream();
		XStream.setupDefaultSecurity(xstream1);

		xstream1.allowTypesByWildcard(new String[] {
			    "model.Employee","model.Selling","model.Administrator","model.Medication"});
		try
		{
			String xml="";
			switch(op)
			{
			case 1: 
			{
			
				xml=xstream1.toXML((ArrayList<Employee>)d);
				break;
			}
			case 2: 
			{
				xml=xstream1.toXML((ArrayList<Administrator>)d);	break;
			}
			case 3: 
			{
				xml=xstream1.toXML((ArrayList<Selling>)d);	break;
			}
			case 4: 
			{
				xml=xstream1.toXML((ArrayList<Medication>)d);	break;
			}
			
			}

            fileReader = new FileOutputStream("C:\\Users\\larisa\\workspace\\Assignment2\\"+ e + ".xml");
            fileReader.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
            byte[] bytes = xml.getBytes("UTF-8");
            fileReader.write(bytes);
		}catch (Exception ex){
            System.err.println("Error in XML Write: " + ex);
        }
		
		
	}
}
