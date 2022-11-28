package dao;

import java.util.ArrayList;
import java.sql.*;
import beans.User;



public class Userdao {

	public static boolean ajouter(User utilisateur) throws SQLException {

		
		try {
			//COnnexion a la BDD
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gererUser","root","");
			
			//Creer la requete
			String insertCmd = "INSERT INTO utilisateurs(nom,prenom,login,password)" + "VALUES (?, ?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(insertCmd);
			preparedStmt.setString(1,utilisateur.getNom());
			preparedStmt.setString(2,utilisateur.getPrenom());
			preparedStmt.setString(3,utilisateur.getLogin());
			preparedStmt.setString(4,utilisateur.getPassword());
			
			//Execute la requete
			preparedStmt.executeUpdate();
			
			//fermer la connexion
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	public static ArrayList<User> lister() throws SQLException{
		
		//COnnexion a la BDD
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gererUser","root","");
		
		//Creation de la requete
		String insertCmd = "SELECT * FROM utilisateurs";
		Statement stmt= con.createStatement();
		
		//Execution de la requete 
		ResultSet rs = stmt.executeQuery(insertCmd);
		ArrayList<User> utilisateurs = new ArrayList<>();
		
		while(rs.next()) {
		  User utilisateur = new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"),rs.getString("password"));
	        utilisateurs.add(utilisateur);
		}
		
		//fermeture de la connexion
		con.close();
		return utilisateurs;
		
	}  
	
	public static boolean supprimer(int id) {

		try {
			//Connexion a la BDD
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gererUser","root","");
			String deleteCmd = "DELETE FROM utilisateurs WHERE  id=?";
			
			//Création de la requete
			PreparedStatement preparedStmt = con.prepareStatement(deleteCmd);
			preparedStmt.setInt(1, id);
			
			//Execution de la requete
			preparedStmt.execute();
			con.close();
			
			//fermeture de la connexion
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean modifier(User utilisateur ) {

		try {
			//Connexion a la BDD
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gererUser","root","");
			String updateCmd = "UPDATE utilisateurs set nom=?,prenom=?,login=?,password=? where id=?";
			
			//Création de la requete
			PreparedStatement preparedStmt = con.prepareStatement(updateCmd);
			
			preparedStmt.setString(1,utilisateur.getNom());
    		preparedStmt.setString(2,utilisateur.getPrenom());
    		preparedStmt.setString(3,utilisateur.getLogin());
    		preparedStmt.setString(4,utilisateur.getPassword());
    		preparedStmt.setInt(5,utilisateur.getId());
    		
    		//Exécutioon de la requete
			preparedStmt.executeUpdate();
			
			//fermeture de la connexion
			con.close();
			return true;
			} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static User get(int id) {
		 try {
			//Connexion a la BDD
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gererUser","root","");
				String getCmd = "SELECT * FROM utilisateurs WHERE id = ?";
				
			//Création de la requete
	            PreparedStatement stmt = con.prepareStatement(getCmd);
	            stmt.setInt(1, id);
	            
	        //Execution de la requete
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	             User utilisateur = new User(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"), rs.getString("login"), rs.getString("password"));
	      
	        //Fermeture de la connexion     
	             con.close();   
	             return utilisateur;
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
		 return null;

	}	
}
