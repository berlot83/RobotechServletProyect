		package com.cognizant.servlets;
		
		import java.io.IOException;
		import java.io.PrintWriter;
		import java.sql.Connection;
		import java.sql.ResultSet;
		import java.sql.Statement;
		
		import javax.servlet.ServletException;
		import javax.servlet.annotation.WebServlet;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		
		import com.cognizant.dao.ConnectionFile;
		
		/**
		 * Servlet implementation class ServletResults
		 */
		@WebServlet("/ServletResults")
		public class ServletResults extends HttpServlet {
			private static final long serialVersionUID = 1L;

			public ServletResults() {
				super();
				// TODO Auto-generated constructor stub
			}

			protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
				PrintWriter out = response.getWriter();
				String url = "/results.jsp";
		
				try {

		
				} catch (Exception error) {
					out.write("Se ha producido un error");
					error.printStackTrace();
				}
				
				getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
		
			}
		

			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
				PrintWriter out = response.getWriter();
		
				try {
		
					Connection c = ConnectionFile.getConexion();
		
					if (c != null) {
						Statement st;
						String sql = "SELECT Legajo, Nombre, Apellido FROM usuarios";
						st = c.createStatement();
						ResultSet rs = st.executeQuery(sql);
		
						while (rs.next()) {
							int fieldId = rs.getInt("Legajo");
							String name = rs.getString("Nombre");
							String lastname = rs.getString("Apellido");
		
							out.write("<tr>");
							out.write("<td>");
							out.write(fieldId);
							out.write("</td>");
							out.write("<td>");
							out.write(name);
							out.write("</td>");
							out.write("<td>");
							out.write(lastname);
							out.write("</td>");
							out.write("</tr>");
						}
					}
		
				} catch (Exception error) {
					error.printStackTrace();
				}
		
			}
		
		}
