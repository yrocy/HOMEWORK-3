package nextPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
		String dbUsername = "root";
		String dbPassword = "12345";
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);		
		    
			
		    String sql = "INSERT INTO users (username, email, fullname, password)"
		    		+ " VALUES ('QwertyName', 'email@domain.com', 'FirstName LastName', 'asterisk')";
			
			Statement statement = connection.createStatement();
			
			int rows = statement.executeUpdate(sql);
						
		    if (rows > 0) {
		    	System.out.println("A new user has been inserted successfully.");
		    }
		    
		    	connection.close();
		    	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}

