package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException; 
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf implements Report {


	public void generate(List<Medication> a) {
		
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Reports.pdf"));
		
			document.open();
			for (int i=0;i<a.size();i++)
			{
				if (a.get(i).getQuantity()==0)
				{
					document.add(new Paragraph("The medicine named: "+a.get(i).getName()+" it's out of stock!\n"));
				}
			} 
			   JOptionPane.showMessageDialog(null, "PDF made!");
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
