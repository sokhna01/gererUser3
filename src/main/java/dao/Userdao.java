package dao;

import java.util.ArrayList;
import java.sql.*;
import beans.User;



public class Userdao {
	
	private static ArrayList<User> utilisateurs = new ArrayList<User>();
	
//	public static void main(String[] args) throws SQLException{
//		
//		int id;
//	
//
//      	//Creation de la connexion
//		
//		
//		//Création des requetes
//		
//	}
	
	public static void ajouter(String nom, String prenom, String login, String password) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gererUser","root","");
		preparedStatement stmt;
		
//		try( stmt= con.prepareStatement("INSERT INTO Utilisateurs(nom,prenom,login,password) VALUES(?,?,?,?)" ) ){
//		
//		stmt.setString(2,nom);
//		stmt.setString(3,prenom);
//		stmt.setString(4,login);
//		stmt.setString(5,password);
//		
//		  int numRowsAffected = stmt.executeUpdate();
//		   Logger.getLogger(PatientBase.class).log(Level.DEBUG, numRowsAffected + " were inserted");
//		} catch (SQLException ex) {
//		     Logger.getLogger(PatientBase.class).log(Level.SEVERE, null, ex);
//		    }
		
		   try(stmt = conn.prepareStatement("INSERT INTO patients (id, surname) VALUES (?, ?)") {
			   stmt.setInt(1, 1);
			   stmt.setString(2, mySurname);

			   int numRowsAffected = stmt.executeUpdate();
			   Logger.getLogger(PatientBase.class).log(Level.DEBUG, numRowsAffected + " were inserted");
			} catch (SQLException ex) {
			     Logger.getLogger(PatientBase.class).log(Level.SEVERE, null, ex);
			    }

	
	}
	
	
	public static ArrayList<User> lister() throws SQLException{
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gererUser","root","");
		String insertCmd = "SELECT * FROM Utilisateurs";
		Statement stmt= con.createStatement();
		ResultSet rs = stmt.executeQuery(insertCmd);
		ArrayList<User> utilisateurs = new ArrayList<>();
		
		while(rs.next()) {
		  User utilisateur = new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"),rs.getString("password"));
	        utilisateurs.add(utilisateur);
		}
		return utilisateurs;
		
	}  
	
	public static boolean supprimer(int id) {

		for(User utilisateur : utilisateurs) {
			if(utilisateur.getId()==id) {
				utilisateurs.remove(utilisateur);
			}
			return true;
		}
		return false;
	}
	
	public static boolean modifier(User utilisateur ) {

		for(User user : utilisateurs) {
			if(user.getId()==utilisateur.getId()) 
			{
				user.setNom(utilisateur.getNom());
				user.setPrenom(utilisateur.getPrenom());
				user.setLogin(utilisateur.getLogin());
				user.setPassword(utilisateur.getPassword());
			}
			return true;
		}
		return false;
	}
	
	public static User get(int id) {
		
		for(User utilisateur : utilisateurs) {
			if(utilisateur.getId()==id) {
				return utilisateur;
			}
		}
		return null;

	}

	
	
}
