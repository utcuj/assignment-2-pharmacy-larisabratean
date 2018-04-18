package model;

public class ReportFactory {
	  //use getShape method to get object of type shape 
	   public Report getReport(String repType){
	      if(repType == null){
	         return null;
	      }		
	      if(repType.equalsIgnoreCase("CSV")){
	         return new GenerateCsv();
	         
	      } else if(repType.equalsIgnoreCase("PDF")){
	         return new GeneratePdf();
	         
	      }
	      return null;
	   }
}
