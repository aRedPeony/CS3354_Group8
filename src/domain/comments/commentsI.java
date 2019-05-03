package domain.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import javax.servlet.http.Cookie;;

@WebServlet("/commentsI")
public class commentsI extends HttpServlet {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	private static final long serialVersionUID = 1L;
	
	public commentsI() {}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("comment");
		String pagePlus = request.getParameter("submit");
		String page = pagePlus.substring(11);
		Cookie[] ck=request.getCookies();
		comments c = new comments();
		c.setComment(comment);
		c.setTime();
		c.setUsername(ck[0].getValue());
		c.setReviewed(false);
		c.setPage(page);
		
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into comments values(?,?,?,?,?)");
			ps.setString(2, c.getUsername());
			ps.setString(3, c.getComment());
			Date date = new Date(c.getTime());
			ps.setDate(1, date);
			ps.setBoolean(4, c.getReviewed());
			ps.setString(5, c.getPage());
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		request.setAttribute("cMessage", "Comment submitted for review!");
		request.getRequestDispatcher("Brief_history_Comments.jsp").forward(request, response);
	}
}