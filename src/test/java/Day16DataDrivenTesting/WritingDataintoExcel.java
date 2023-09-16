package Day16DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataintoExcel {

	public static void main(String[] args) throws IOException 
	{
	      FileOutputStream file =new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
           
	      
	      XSSFWorkbook workbook =new XSSFWorkbook();
	      
	      XSSFSheet sheet= workbook.createSheet();
	      
	      XSSFRow rowdata= sheet.createRow(0);
	      XSSFRow rowdata2= sheet.createRow(1);
	      
	   /*creating rows, cells and updating data without loop    
	      rowdata.createCell(0).setCellValue("welcome");
	      rowdata.createCell(1).setCellValue("xyz");
	      rowdata.createCell(2).setCellValue("1234");
	      rowdata2.createCell(0).setCellValue("testing");
	      rowdata2.createCell(1).setCellValue("test");
	      rowdata2.createCell(2).setCellValue("testings");*/
	      
	      
	    //  creating rows, cells and updating data with loop
	      Scanner sc = new Scanner(System.in);
	      
	      
	      for(int r=0; r<=3;r++)
	      {
	    	  XSSFRow currentrow = sheet.createRow(r);
	    	  
	    	  for(int c=0;c<2;c++)
	      
	    	  {    System.out.println("Enter a value");
	    		  //currentrow.createCell(c).setCellValue("welcome");//print welcome in all cells
	    		  String value =sc.next();//taking input from the user 
	    		  currentrow.createCell(c).setCellValue(value);
	    		  
	    	  }
	      }
	      
	      workbook.write(file);
	      
	      workbook.close();
	      
	      file.close();
	      
	      System.out.println("Writing is done");
	
	       
	       
	
	
	}

}
