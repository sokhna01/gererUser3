package ConnexionBD;

import java.sql.*;
public class Connexion {

	public static void main(String[] args) throws SQLException {
		int id;
		String nom, prenom, login, password;
		
		//Creation de la connexion
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gererUser","root","");
		
		//Création des requetes
		
		Statement stmt= con.createStatement();
		
		String insertCmd = "INSERT INTO Utilisateurs(nom,prenom,login,password) VALUES('Wade','Maoumi','maoumizer','passer')";
		String updateCmd = "UPDATE Utilisateurs set nom='1' WHERE id=1";
		String deleteCmd = "DELETE from Utilisateurs WHERE id='1'";
		String selectCmd = "Select * from Utilisateurs";
		//Executer la requete
		
		//stmt.execute(insertCmd);
		ResultSet rs =stmt.executeQuery(selectCmd); //Execute la requete dans selectCmd et stock le résultat dans rs
		
		//rs.next() retourne vraie si il y'a un enregistrement suivant dans la table
		while(rs.next()) {
			 id = rs.getInt("id");
			 nom = rs.getString("nom");
			 prenom = rs.getString("prenom");
			 login = rs.getString("login");
			 password = rs.getString("password");
			 
			 System.out.println(id+ "    " + nom+ "   "+ prenom+ "    "+login+"   "+password);
		}
		//Fermer la connection
		con.close();
		
		System.out.println("Requete executée");
		
	}
	
		
}

