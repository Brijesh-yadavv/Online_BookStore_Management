import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

	static Connection con;
	public static Connection createConnection() throws SQLException {
		//load the jdbc driver...........
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//create the connection
			String user="root";
			String password="Perfect@123";
			String url="jdbc:mysql://localhost:3306/bookstore";
			con=DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
