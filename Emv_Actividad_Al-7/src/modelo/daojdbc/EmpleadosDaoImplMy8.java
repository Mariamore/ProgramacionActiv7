package modelo.daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.dao.DepartamentosDao;
import modelo.dao.EmpleadosDao;
import modelo.dao.PerfilesDao;
import modelo.javabean.Departamentos;
import modelo.javabean.Empleados;
import modelo.javabean.Perfiles;

public class EmpleadosDaoImplMy8 extends AbstractDaoMy8 implements EmpleadosDao{
	


	@Override
	public List<Empleados> empleadosByDepartamento(int idDepar) {
		//ejecutamos la sentencia
		sql= "select * from empleados where id_depar=?";
		
		List<Empleados> lista = new ArrayList<>(); //Creamos la lista
		DepartamentosDao dpo = new DepartamentosDaoImplMy8();
		PerfilesDao pdo = new PerfilesDaoImplMy8();
		
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			rs = ps.executeQuery();
			Departamentos departamento = dpo.buscarUno(idDepar);
			
			while(rs.next()) {
				Empleados empleado = new Empleados();
				
				empleado.setIdEmpl(rs.getInt("id_empl"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellidos(rs.getNString("apellidos"));
				empleado.setSexo(rs.getNString("genero"));
				empleado.setEmail(rs.getNString("email"));
				empleado.setPassword(rs.getNString("password"));
				empleado.setSalario(rs.getDouble("salario"));
				empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				empleado.setFechaIngreso(rs.getDate("fecha_ingreso"));
				empleado.setDepartamento(departamento);
				empleado.setPerfil(pdo.buscarUno(rs.getInt("id_perfil")));
				
				lista.add(empleado);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}


	@Override
	public List<Empleados> empleadosBySexo(String sexo) { 
		sql="select * from empleados where genero=?"; // cambiamos la sentencia ahora queremos todos.
		List<Empleados> lista = new ArrayList<>(); //Creamos una lista
		Empleados empleado = null;
		
		DepartamentosDao dpo = new DepartamentosDaoImplMy8();
		PerfilesDao pdo = new PerfilesDaoImplMy8();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setNString(1, sexo);
			rs= ps.executeQuery();
			
			while(rs.next()){ 
				empleado = new Empleados(); //construimos otra vez el objeto
				
				empleado.setIdEmpl(rs.getInt("id_Empl"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellidos(rs.getNString("apellidos"));
				empleado.setSexo(rs.getNString("genero"));
				empleado.setEmail(rs.getNString("email"));
				empleado.setPassword(rs.getNString("password"));
				empleado.setSalario(rs.getDouble("salario"));
				empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				empleado.setFechaIngreso(rs.getDate("fecha_ingreso"));
				empleado.setDepartamento(dpo.buscarUno(rs.getInt("id_depar")));
				empleado.setPerfil(pdo.buscarUno(rs.getInt("id_perfil")));
				
				
				lista.add(empleado);
			}
			/*
			 * tratamos fila a fila
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return lista;
	
	}


	@Override
	public List<Empleados> empleadosByApellido(String subcadena) {
		sql="select * from empleados where apellidos=?"; // cambiamos la sentencia ahora queremos todos.
		List<Empleados> lista = new ArrayList<>(); //Creamos una lista
		Empleados empleado = null;
		
		DepartamentosDao dpo = new DepartamentosDaoImplMy8();
		PerfilesDao pdo = new PerfilesDaoImplMy8();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setNString(1, subcadena);
			rs= ps.executeQuery();
			
			while(rs.next()){ 
				empleado = new Empleados(); //construimos otra vez el objeto
				
				empleado.setIdEmpl(rs.getInt("id_Empl"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellidos(rs.getNString("apellidos"));
				empleado.setSexo(rs.getNString("genero"));
				empleado.setEmail(rs.getNString("email"));
				empleado.setPassword(rs.getNString("password"));
				empleado.setSalario(rs.getDouble("salario"));
				empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				empleado.setFechaIngreso(rs.getDate("fecha_ingreso"));
				empleado.setDepartamento(dpo.buscarUno(rs.getInt("id_depar")));
				empleado.setPerfil(pdo.buscarUno(rs.getInt("id_perfil")));
				lista.add(empleado);
			}
			/*
			 * tratamos fila a fila
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return lista;
		
	}


	@Override
	public double salario() {
		sql="select sum(salario) as salario from empleados";
		Double suma =0.0; //Creamos variable sdouble suma porque  es tipo de dato q nos devuelva la BBDD
		try {
			ps=conn.prepareStatement(sql);
			rs =ps.executeQuery();
			if(rs.next()) {
				suma=rs.getDouble("salario");
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return suma;
	}


	@Override
	public double salarioTotal(int idDepar) {
		sql="select sum(salario) as salario from empleados where id_depar=?";
		Double suma =0.0; //Creamos variable sdouble suma porque  es tipo de dato q nos devuelva la BBDD
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			rs =ps.executeQuery();
			while(rs.next()) {
				
				suma=rs.getDouble("salario");
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return suma;
	
	}


	@Override
	public int eliminarUno(int idEmpl) {
		
		sql="delete from empleados where id_empl=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			filas= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}


	@Override
	public int modificarUno(Empleados empleado) {

		sql="update empleados set  nombre=?, apellidos=?, genero=?, email=?, password=?, salario=?,"
		+"fecha_ingreso=?, fecha_nacimiento=?, id_perfil=?, id_depar=? where id_empl=?";	
		
		  try {
				ps= conn.prepareStatement(sql);
				ps.setString(1,empleado.getNombre());
				ps.setString(2,empleado.getApellidos());
				ps.setString(3,empleado.getSexo()); 
				ps.setString(4,empleado.getEmail());
				ps.setString(5,empleado.getPassword());
				ps.setDouble(6,empleado.getSalario());
				ps.setDate(7,empleado.getFechaIngreso());
				ps.setDate(8,empleado.getFechaNacimiento());
				ps.setInt(9,empleado.getPerfil().getIdPerfil());
				ps.setInt(10, empleado.getDepartamento().getIdDepar());
				ps.setInt(11, empleado.getIdEmpl());
				filas = ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return filas;
	}


	@Override
	public int altaEmpleados(Empleados empleado) {
		
		 //Primero preparamos la sentencia sql
		// Cuantos campo tenemos para dar de alta??
		  sql= "insert into empleados values(?,?,?,?,?,?,?,?,?,?,?)";
		  
		  try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1,empleado.getIdEmpl());
			ps.setString(2,empleado.getNombre());
			ps.setString(3,empleado.getApellidos());
			ps.setString(4,empleado.getSexo()); 
			ps.setString(5,empleado.getEmail());
			ps.setString(6,empleado.getPassword());
			ps.setDouble(7,empleado.getSalario());
			ps.setDate(8,empleado.getFechaIngreso());
			ps.setDate(9,empleado.getFechaNacimiento());
			ps.setInt(10,empleado.getPerfil().getIdPerfil());
			ps.setInt(11,empleado.getDepartamento().getIdDepar());
		
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}


	@Override
	public Empleados buscarUno(int idEmpl) {
		
		sql="Select * from empleados where id_empl=?";
		Empleados empleado = null; //devuelve nulo para los atributos
		DepartamentosDao dpo= new DepartamentosDaoImplMy8(); 
		PerfilesDao pdo = new PerfilesDaoImplMy8();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			rs= ps.executeQuery();
			
			if(rs.next()){
				empleado = new Empleados();
				empleado.setIdEmpl(rs.getInt("id_Empl"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellidos(rs.getNString("apellidos"));
				empleado.setSexo(rs.getNString("genero"));
				empleado.setEmail(rs.getNString("email"));
				empleado.setPassword(rs.getNString("password"));
				empleado.setSalario(rs.getDouble("salario"));
				empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				empleado.setFechaIngreso(rs.getDate("fecha_ingreso"));
				empleado.setDepartamento(dpo.buscarUno(rs.getInt("id_depar")));
				empleado.setPerfil(pdo.buscarUno(rs.getInt("id_perfil")));
				
			
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return empleado;
	}


	@Override
	public List<Empleados> bucarTodos() {
		sql="Select * from empleados"; // cambiamos la sentencia ahora queremos todos.
		List<Empleados> lista = new ArrayList<>(); //Creamos una lista
		PerfilesDao pdo = new PerfilesDaoImplMy8();
		DepartamentosDao dpo= new DepartamentosDaoImplMy8();
		try {
			ps=conn.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()){ 
				Empleados empleado = new Empleados(); //construimos otra vez el objeto
				empleado.setIdEmpl(rs.getInt("id_Empl"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellidos(rs.getNString("apellidos"));
				empleado.setSexo(rs.getNString("genero")); //Tratamos como String
				empleado.setEmail(rs.getNString("email"));
				empleado.setPassword(rs.getNString("password"));
				empleado.setSalario(rs.getDouble("salario"));
				empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				empleado.setFechaIngreso(rs.getDate("fecha_ingreso"));
				empleado.setDepartamento(dpo.buscarUno(rs.getInt("id_depar")));
				empleado.setPerfil(pdo.buscarUno(rs.getInt("id_perfil")));
				lista.add(empleado);
			}
			/*
			 * tratamos fila a fila
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return lista;
		
	}
	

}
