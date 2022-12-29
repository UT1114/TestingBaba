package jdbcUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import propertyUtility.PropertyUtility;

public class JDBCUtility {
//static final String url="jdbc:oracle:thin:@//172.24.35.168:1527/KYCNG";
	static List<String> li=null;
	
public static List<String>  getDBData(String query) {
	try{  
		final String dbURL=PropertyUtility.getPropertyData("ng.db.url");
		 final String userName=PropertyUtility.getPropertyData("ng.db.username");
		 final String password=PropertyUtility.getPropertyData("ng.db.password");

		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		Connection con=DriverManager.getConnection(dbURL,userName,password);  

		Statement stmt=con.createStatement();  
		  
		ResultSet rs=stmt.executeQuery(query);  
		int b;
		while(rs.next()) 
		
			
			//li.add(rs.getString(0));
			
			
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(4));  
		
		con.close();  
		  
		}catch(Exception e){
			System.out.println(e);
			}
	return li;  
		  
		}  
}
