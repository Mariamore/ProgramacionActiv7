package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMy8 {
	
	// Vamos a conectarnos a la base de datos 
	
		private static String url, user, pwd;
		private static Connection conn;
	//Todos los datos estaticos, porque el metodo tambien lo es.
		
		
		public ConexionMy8() {
			
			url= "jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023?serverTimezone=UTC";
			user="root";
			pwd="root";
			
			try {
				conn = DriverManager.getConnection(url, user, pwd);
				System.out.println("CONEXION ESTABLECIDAD");
			} catch (SQLException e) {
				System.out.println("CONEXION NO ESTABLECIDA");
				e.printStackTrace();
			}
		}
		
		public static Connection getConexion() {
			if (conn==null) {
				new ConexionMy8();
			}
			return conn;
		}
		
		
		
		
		
		
	}

	
	
	
	
	
	
	


