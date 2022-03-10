package com.simplilearn.jdbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.jdbc.DBConnection;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/insertProduct")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";
		String userName = "root";
		String pwd = "password";
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		try {
			DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			PreparedStatement stmt  = dConnection.getConnection().prepareStatement("insert into eproduct(ID, name, date_added) values (?, ?, now())");
			
			stmt.setString(2, "PRODUCT_FROM_PREPARED_STMT");
			stmt.setInt(1,7);
			
			stmt.executeUpdate();
			
			stmt.close();
			dConnection.closeConnection();
			
			out.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
