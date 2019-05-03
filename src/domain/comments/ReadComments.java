package domain.comments;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/ReadComments")
public class ReadComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadComments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		//String id=request.getParameter("id");
		out.print("<h1>Brief History Comments</h1>");
		out.print("<table border='1'><tr><th>Date</th><th>ID</th><th>Comment</th><th>Reviewed</th><th>Page</th></tr>");
		
		try
		{	
			String myDriver = "com.mysql.jdbc.Driver";
		    String myUrl = "jdbc:mysql://127.0.0.1:3306/coursedatabase?autoReconect=true&useSSL=false";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "Peony", "itSaFLOWER77");
			
		    Statement st=conn.createStatement();
		    ResultSet rs=st.executeQuery("select * from comments");
		    
		    while(rs.next())
		    {
		    	out.print("<tr><td>");
		    	out.print(rs.getDate(1));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getString(2));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getString(3));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getBoolean(4));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getString(5));
		    	out.print("</td>");
		    	out.print("</tr>");
		    		
		    }
		}
		catch(Exception p)
		{
			System.out.println(p);
		}
		out.print("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//String id=request.getParameter("id");
		out.print("<h1>Brief History Comments</h1>");
		out.print("<table border='1'><tr><th>Date</th><th>ID</th><th>Comment</th><th>Reviewed</th><th>Page</th></tr>");
		
		try
		{	
			String myDriver = "com.mysql.jdbc.Driver";
		    String myUrl = "jdbc:mysql://127.0.0.1:3306/coursedatabase?autoReconect=true&useSSL=false";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "Peony", "itSaFLOWER77");
			
		    Statement st=conn.createStatement();
		    ResultSet rs=st.executeQuery("select * from comments");
		    
		    while(rs.next())
		    {
		    	out.print("<tr><td>");
		    	out.print(rs.getDate(1));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getString(2));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getString(3));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getBoolean(4));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getString(5));
		    	out.print("</td>");
		    	out.print("</tr>");
		    		
		    }
		}
		catch(Exception p)
		{
			System.out.println(p);
		}
		out.print("</table>");
		
		doGet(request, response);
	}

}
