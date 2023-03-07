package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.ConexionDaoMy8;

public abstract class AbstractDaoMy8 {
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	protected int filas;
	
	public AbstractDaoMy8() {
		conn = ConexionDaoMy8.getConexion();
	}
}
