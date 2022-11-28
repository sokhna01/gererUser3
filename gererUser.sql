DROP DATABASE IF EXISTS gererUser;
CREATE DATABASE gererUser;
USE gererUser;

-- Construction de la table des utilisateurs--
CREATE TABLE Utilisateurs(
	id int primary key AUTO_INCREMENT,
	nom varchar(20),
	prenom varchar(20),
	login varchar(20),
	password varchar(20)
);
