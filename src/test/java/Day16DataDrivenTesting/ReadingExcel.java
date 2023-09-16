package Day16DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* For data driven testing we need to install two dependencies-
 1. Apache POI Common  
 2. Apache POI API Based On OPC and OOXML Schemas 
 
These both dependencies works only for Microsoft excel
  
  
Hierarchy
 Excel(File)--> Workbook-->Sheets-->Rows-->cell
 
FileInputStream- it is used to open a file and read the data into file.     
FileOutputStream- it is used to write the file

Both these classes are for Excel file and  are generic comes from java and can be used for all types of files.
Here the file are opened into buffer and hence wasting memory so should be closed after completing
the operation.  

XSSFWorkbook- it is a special class for handling Workbook comes from ApachePOI

XSSFSheet - it a class for handling sheets comes from ApachePOI

XSSFRow - it a class for handling rows comes from ApachePOI

XSSFCell - it a class for handling cells comes from ApachePOI
  
 */

public class ReadingExcel {

	public static void main(String[] args) throws IOException 
	{
	  // For reading the file
		
	FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\test.xlsx");
	
	/* System.getProperty ("user.dir")- gives the current project location in which our test data folder
is present inside which our test data is present in excel file, so we will concatinate this current project
location (somewhat kind of relative path) */
	
	XSSFWorkbook workbook =new XSSFWorkbook(file);
	
	// Approach1 (by sheet name) 
	XSSFSheet sheet= workbook.getSheet("Sheet1");// sheet present inside the workbook
	
	//Approach2 (by index of sheet, not applicable when number of sheets are more)
	//Note - index of sheets starts from 0
	//workbook.getSheetAt(0);
      
// fetching total number of rows in sheet
	int rows =sheet.getLastRowNum();
	
// fetching total number of columns/cells in sheet
	
	int cells= sheet.getRow(1).getLastCellNum();
	
	System.out.println("total number of rows are:"+rows);
	System.out.println("total number of cells are :"+cells );
	
	
	for (int r =0;r<=rows;r++)//here less than and equal to is used because excel starts reading rows from 0 and java also starts from 0
	{
    	XSSFRow currentrow	=sheet.getRow(r); //capturimg particular row 
		
    	for(int c=0;c<cells;c++)//here only less than is used because excel starts reading cells from 1 but java starts from 0
	  
    	{
    		/*XSSFCell cell= currentrow.getCell(c);// capturing cell data of captured row
    	     cell.toString(); //converting data into string*/
    	     
    	    //or we can write 
    	  
    	     String value =currentrow.getCell(c).toString();
             System.out.println(value);    	
    	}
	
	
	
	}
	        workbook.close();//closing the workboox so to avoid wasting the memory
	        file.close();//closing the workboox so to avoid wasting the memory
	
	
	
	}

}
