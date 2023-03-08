package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestingSingleton {

	public static void main(String[] args) {

		/*
		 * Creamos varios objetos Conexion
		 */
		
		Connection conn1 = ConexionMy8.getConexion();
		Connection conn2 = ConexionMy8.getConexion();
		Connection conn3 = ConexionMy8.getConexion();
		
		/*
		 * Probamos las conexiones, todas las conexiones tienen que apuntar al mismo sitio+
		 * por lo tanto tienen que dar el mismo resultado.
		 * Diferentes variables conexion que apuntan al mismo lado. Asi nos aseguramos que solo
		 * tenemos una conexion. Con esta única conexion es con la que vamos a trabajar.
		 */
		
		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
		
		
		
		
		
	}
	
}
