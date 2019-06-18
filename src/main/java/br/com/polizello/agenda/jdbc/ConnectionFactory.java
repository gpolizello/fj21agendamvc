package br.com.polizello.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection(){
		try{
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5434/polizello", "postgres", "postgres");
		}catch(SQLException err){
			throw new RuntimeException("Erro ao obter conexção com o banco de dados.", err);
		}
	}
	
}
