

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final String query=" select ID , BOOKNAME ,BOOKEDITION,BOOKPRICE from bookdata";
    
	   
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	
	//get the book infromation from the html page or from the user................
	
	
	
	
	//creating the jdbc connection and storing the information into databasee.................
	
	try {
		Connection con=CreateConnection.createConnection();
		
		PreparedStatement ps=con.prepareStatement(query);
		
		out.println("<Center>");
		
		out.println("<table border=\"1\" width=\"400px\" height=\"auto\" ");
		out.println("<tr>");
		out.println("<th>Book Id </th>");
		out.println("<th>Book Name </th>");
		out.println("<th>Book Edition </th>");
		
		out.println("<th>Book Price </th>");
		out.println("<th> Edit </th>");
		out.println("<th>Delete Book </th>");
		out.println("</tr>");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			out.println("<tr>");
			out.println("<td>"+rs.getInt(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getFloat(4)+"</td>");
			out.println("<td><a href='editScreen?id="+rs.getInt(1)+" '>Edit</a></td>");
			out.println("<td><a href='deleteScreen?id="+rs.getInt(1)+" '>Delete</a></td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
	

		
		
		
		int count=ps.executeUpdate();
		if(count==1) {
			out.println("<h2>Record is Registered successfully</h2>");
		}
		else {
			out.println("<h2>Record is not Registered </h2>");
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	out.println("<a href='index.html'>Home</a>");
	out.println("</Center>");
		
		
	}
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request,response);
		
		
		
	}


}
