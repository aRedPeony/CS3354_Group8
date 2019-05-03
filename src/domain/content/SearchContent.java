package domain.content;

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
@WebServlet("/SearchContent")
public class SearchContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String page=request.getParameter("page");
		out.print("<h1>Display the Records</h1>");
		out.print("<table border='1'><tr><th>Id</th><th>Name</th><th>Address</th></tr>");
		
		try
		{	
			String myDriver = "com.mysql.jdbc.Driver";
		    String myUrl = "jdbc:mysql://127.0.0.1:3306/coursedatabase?autoReconect=true&useSSL=false";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "Peony", "itSaFLOWER77");
			
		    Statement st=conn.createStatement();
		    ResultSet rs=st.executeQuery("select * from content where page="+page+"");
		    
		    while(rs.next())
		    {
		    	out.print("<tr><td>");
		    	out.print(rs.getInt(1));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getString(2));
		    	out.print("</td>");
		    	out.print("<td>");
		    	out.print(rs.getString(3));
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
