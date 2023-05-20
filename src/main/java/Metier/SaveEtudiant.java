package Metier;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;


@WebServlet("/SaveEtudiant")
public class SaveEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		int age=Integer.parseInt(request.getParameter("age"));
		String ville=request.getParameter("ville");
		
		PrintWriter out=response.getWriter();
		 try
		    {
		      //�tape 1: charger la classe driver
		      Class.forName("com.mysql.jdbc.Driver");
		      //�tape 2: cr�er l'objet de connexion
		      Connection conn = DriverManager.getConnection(
		      "jdbc:mysql://localhost:3306/dbetudiants?useSSL=false", "root", "root");
		      //�tape 3: cr�er l'objet statement 
		      Statement stmt = (Statement) conn.createStatement();
		      //�tape 4: ex�cuter la requ�te
		      System.out.println("Insertion...");
		    
		      String sql = "INSERT INTO tetudiant " +
		                   "VALUES ('code', 'nom','prenom',age,'ville')";
		      ((java.sql.Statement) stmt).executeUpdate(sql);
		      System.out.println("Donn�es ins�r�s dans la table...");
		      //�tape 5: fermez l'objet de connexion
		      conn.close();
		    }
		    catch(Exception e){ 
		      System.out.println(e);
		    }
		  }
		}
		
		    


