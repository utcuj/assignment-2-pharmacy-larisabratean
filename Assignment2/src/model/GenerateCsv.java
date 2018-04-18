package model;
 
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class GenerateCsv implements Report {

	
	public void generate(List<Medication> meds) { 
	    final String NEW_LINE_SEPARATOR = "\n"; 
	    final String FILE_HEADER = "NameMed";

		        FileWriter fileWriter = null;
	   try {
	       fileWriter = new FileWriter("Report.csv"); 
	       fileWriter.append(FILE_HEADER.toString());

	       fileWriter.append(NEW_LINE_SEPARATOR);
		 
		            for ( int i=0;i<meds.size();i++) {
		            	if (meds.get(i).getQuantity()==0) {  
		                fileWriter.append(meds.get(i).getName());  
		                fileWriter.append(NEW_LINE_SEPARATOR); 
		            }
		            }
		            JOptionPane.showMessageDialog(null, "CSV made!");
					 
		          
		 
		        } catch (Exception e) {
		 
		        	JOptionPane.showMessageDialog(null,"Error CSV!");
					 
		 
		            e.printStackTrace();
		 
		        } finally {
		 
		             
		 
		            try {
	 
		                fileWriter.flush();
		 
		                fileWriter.close();
		 
		            } catch (IOException e) {
		 
		            	JOptionPane.showMessageDialog(null, "Error Closing CSV!");
						 
		                e.printStackTrace();
		 
		            }
		 
		             
		 
		        }

		
	}

}
