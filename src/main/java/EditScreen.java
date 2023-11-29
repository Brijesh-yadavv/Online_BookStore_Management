

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
 * Servlet implementation class EditScreen
 */
@WebServlet("/editScreen")
public class EditScreen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String query="select  BOOKNAME ,BOOKEDITION,BOOKPRICE from bookdata where ID=?";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditScreen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		//get the id of the book that we want to edit or delete................
		int id=Integer.parseInt(request.getParameter("id"));
		
		try {
			Connection con=CreateConnection.createConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			
			rs.next();
			
			
			out.println("<center><h1>Edit book Details </h1></center>");
			out.println("<form action='EditServlet?id="+id+"' method='post'>");
			out.println("<table border=\"1\" width=\"400px\" height=\"auto\" align ='center'");
			
			
			out.println("<tr>");
			out.println("<td>Book Name : </td>");
			out.println("<td> <input type='text' name='bookName' value='"+rs.getString(1)+"'> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Book Edition : </td>");
			out.println("<td> <input type='text' name='bookEdition' value='"+rs.getString(2)+"'> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Book Price : </td>");
			out.println("<td> <input type='text' name='bookPrice' value='"+rs.getFloat(3)+"'> </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			
			out.println("<td> <input type='submit' value='Edit'> </td>");
		    out.println("<td> <input type='reset' value='Cancel'> </td>");
	
			out.println("</tr>");
			
			
			out.println("</table>");
			out.println("</form>");
			
			
			
			
			
		
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
