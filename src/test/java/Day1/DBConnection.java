package Day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/arvind";					

		//Database Username		
		String username = "root";	
        
		//Database Password		
		String password = "admin";				

		//Query to Execute		
		String query = "select *  from city;";	
        
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.jdbc.Driver");			
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String cid = rs.getString(1);								        
                    String cname = rs.getString(2);					                               
                    System. out.println(cid+"  "+cname);		
            }		
			 // closing DB Connection		
			con.close();			
}

	}


