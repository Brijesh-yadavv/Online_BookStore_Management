

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String query="update bookdata set BOOKNAME=? , BOOKEDITION=?,BOOKPRICE=? where id=?";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		//getting the edited data we want to edit.................
		String bookName =request.getParameter("bookName");
		String bookEdition =request.getParameter("bookEdition");
		float bookPrice=Float.parseFloat(request.getParameter("bookPrice"));
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		try {
			Connection con=CreateConnection.createConnection();
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, bookName);
			ps.setString(2, bookEdition);
			ps.setFloat(3, bookPrice);
			ps.setInt(4,id);
			
			
			int count=ps.executeUpdate();
			if(count==1) {
				out.println("<h2> Record is updated successfully.. </h2>");
			}
			else {
				out.println("<h2> Record not updated.. </h2>");
			}
			out.println("<br>");
			out.println("<a href='BookListServlet'>Book List</a>");
			
			
			
			
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
