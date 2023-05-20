				package Metier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Etudiant;
@WebServlet("/save")

/**
 * Servlet implementation class SaveEtudiant
 */

public class SaveEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int age = Integer.parseInt(request.getParameter("age"));
		String ville = request.getParameter("ville");
		
		String url = "jdbc:mysql://localhost:3306/DBEtudiants";
		String query = "insert into TEtudiant values('"
				+ code +"', '"+nom+"', '"+prenom+"', '"+age+"', '"+ville+"')";
		String query2 = "select * from TEtudiant";
		List<Etudiant> list_e = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection(url,"root","");
				Statement s = con.createStatement();
				s.executeUpdate(query);
				ResultSet resultat = s.executeQuery(query2);
				
				while(resultat.next()) {
					Etudiant e = new Etudiant();
					e.setCode(resultat.getString("code"));
					e.setNom(resultat.getString("nom"));
					e.setPrenom(resultat.getString("prenom"));
					e.setAge(resultat.getInt("age"));
					e.setVille(resultat.getString("ville"));
					list_e.add(e);
				}
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("liste", list_e);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
