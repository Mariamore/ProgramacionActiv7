package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDaoMy8 {
	private static Connection conn;
	private static String url, user, pwd;
	
	
	private ConexionDaoMy8() {
		url="jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023?serverTimezone=UTC";
		user="root";
		pwd="root";
	
		
		try {
		
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Conexión no establecida");
		}
	}
	
	public static Connection getConexion() {
		if (conn == null) {
			new ConexionDaoMy8();
		}
		return conn;
	}
	
}
