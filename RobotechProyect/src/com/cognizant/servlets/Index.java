package com.cognizant.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.cognizant.dao.ConnectionFile;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/index.jsp";

		try {


		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String fieldId = request.getParameter("fieldId");
			String name = request.getParameter("name");
			String lastname = request.getParameter("lastname");

			PrintWriter out = response.getWriter();

			try {
				Connection c = ConnectionFile.getConexion();
					if (c != null) {
						PreparedStatement ps;
						String sql = "INSERT INTO usuarios(Legajo, Nombre, Apellido) VALUES(?,?,?)";
						ps = c.prepareStatement(sql);
						ps.setInt(1, Integer.parseInt(fieldId));
						ps.setString(2, name);
						ps.setString(3, lastname);
						ps.executeUpdate();
						ps.close();
						
						response.setContentType("text/html");
						response.setCharacterEncoding("UTF-8");
						out.write("La insercción fue exitosa");
						
					}else {
							out.write("No fue posible la conexión a la DB");
					}

			} catch (Exception error) {
				error.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
