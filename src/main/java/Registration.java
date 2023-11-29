

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final String query="INSERT INTO bookdata(BOOKNAME, BOOKEDITION, BOOKPRICE) VALUES (?,?,?)";
       
   
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	
	//get the book infromation from the html page or from the user................
	
	String bookname=request.getParameter("bookName");
	float bookprice=Float.parseFloat(request.getParameter("bookPrice"));
	
	String bookedition =request.getParameter("bookEdition");
	
	
	
	
	//creating the jdbc connection and storing the information into database.................
	
	try {
		Connection con=CreateConnection.createConnection();
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1, bookname);
		ps.setString(2, bookedition);
		ps.setFloat(3, bookprice);
		
		int count=ps.executeUpdate();
		if(count==1) {
			out.println("<h2>Record is Registered successfully</h2>");
			//request dispatcher is used to transfer the request to the next servlet ...........
			
//			RequestDispatcher rd=request.getRequestDispatcher("BookListServlet");
//			rd.forward(request, response);
		}
		else {
			out.println("<h2>Record is not Registered </h2>");
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	out.println("<a href='index.html'>Home</a>");
	out.println("<br>");
	out.println("<a href='BookListServlet'>Book List</a>");

	
		
		
		
	}
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request,response);
		
		
		
	}

}
