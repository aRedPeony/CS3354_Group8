package domain.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;
import javax.servlet.http.Cookie;;

@WebServlet("/commentsO")
public class commentsO extends HttpServlet {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	private static final long serialVersionUID = 1L;
	
	public commentsO() {}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		conn = db.getConnection();
		String page = request.getParameter("submit");
		try {
			ps =conn.prepareStatement("select * from customer where userId=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}