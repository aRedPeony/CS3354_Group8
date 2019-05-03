package domain.comments;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/ReadComments")
public class ReadComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
       
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
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		//String id=request.getParameter("id");
		out.print("<h1>Brief History Coments</h1>");
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
		
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<comments> commentList = new ArrayList<comments>();
		String page="y";
		int count=0;
		String statement="s";
		try{
			conn = db.getConnection();
			
			String pagePlus = request.getParameter("submit");
			page = pagePlus.substring(16);
			statement="select * from comments where page='"+page+"' and reviewed=1";
			ps =conn.prepareStatement(statement);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count++;
				comments c = new comments();
				c.setUsername(rs.getString(2));
				c.setPage(rs.getString(5));
				c.setTime(rs.getLong(1));
				c.setComment(rs.getString(3));
				c.setReviewed(rs.getBoolean(4));
				commentList.add(c);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		String commentString="";
		for(int i=0; i<commentList.size(); i++) {
			commentString=(commentList.get(i)).getUsername()+": "+(commentList.get(i)).getComment()+" Date:  "+(commentList.get(i)).getTime()+"\n";
		}
		request.setAttribute("tMessage",commentString);
		request.getRequestDispatcher("Brief_history_Comments.jsp").forward(request, response);
	}

}
