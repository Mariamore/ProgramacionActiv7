package testing;

import java.sql.Connection;

import conexion.ConexionDaoMy8;

public class TestConexion {

	public static void main(String[] args) {
		Connection conn = ConexionDaoMy8.getConexion();
		Connection conn2 = ConexionDaoMy8.getConexion();
		
		System.out.println(conn);
		System.out.println(conn2);

	}

}
