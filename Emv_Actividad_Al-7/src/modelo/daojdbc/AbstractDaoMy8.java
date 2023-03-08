package modelo.daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionMy8;

public abstract class AbstractDaoMy8 {
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	protected int filas;
	protected String filas2; //Añadimos otra variable de tipo String
	
	
	public AbstractDaoMy8() {
	
		conn = ConexionMy8.getConexion();
	}
	
	
	
	
	
	
}
