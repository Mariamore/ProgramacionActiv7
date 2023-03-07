 package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Departamento;
import javabeans.Empleado;
import javabeans.Perfil;

public class EmpleadoDaoImplMy8 extends AbstractDaoMy8 implements EmpleadoDao {
	
	private DepartamentoDao dDao;
	private PerfilDao pDao;

	public EmpleadoDaoImplMy8() {
		dDao = new DepartamentoDaoImplMy8();
		pDao = new PerfilDaoImplMy8();
	}
	@Override
	public int altaEmpleado(Empleado empleado) {
		sql = "insert into empleados values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empleado.getIdEmpl());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellidos());
			ps.setString(4, empleado.getGenero());
			ps.setString(5, empleado.getEmail());
			ps.setString(6, empleado.getPassword());
			ps.setDouble(7, empleado.getSalario());
			ps.setDate(8, empleado.getFechaIngreso());
			ps.setDate(9, empleado.getFechaNacimiento());
			ps.setInt(10, empleado.getPerfil().getIdPerfil());
			ps.setInt(11, empleado.getDpto().getIdDepar());
			filas = ps.executeUpdate();
			filas = 1;;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Empleado buscarUno(int idEmpl) {
		sql = "select * from empleados where id_empl = ?";
		Empleado emp = null;
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				emp = new Empleado();
				crearObjetoEmpleado(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int modificarUno(Empleado empleado) {
		sql = "update empleados set nombre = ?, apellidos = ?, genero = ?, email = ?, password = ?, salario = ?, fecha_ingreso = ?"
				+ ", fecha_nacimiento = ?, id_perfil = ?, id_depar= ? where id_empl= ?";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, empleado.getGenero());
			ps.setString(4, empleado.getEmail());
			ps.setString(5, empleado.getPassword());
			ps.setDouble(6, empleado.getSalario());
			ps.setDate(7, empleado.getFechaIngreso());
			ps.setDate(8, empleado.getFechaNacimiento());
			ps.setInt(9, empleado.getPerfil().getIdPerfil());
			ps.setInt(10, empleado.getDpto().getIdDepar());
			ps.setInt(11, empleado.getIdEmpl());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarUno(int idEmpl) {
		sql = "delete from empleados where id_empl = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Empleado> buscarTodos() {
		sql = "select *  from empleados";
		List<Empleado> lista = new ArrayList<>();
		Empleado emp = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while  (rs.next()) {
				emp = new Empleado();
				crearObjetoEmpleado(emp);
				lista.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		sql = "select * from empleados where id_depar = ?";
		List<Empleado> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Empleado emp = new Empleado();
				crearObjetoEmpleado(emp);
				lista.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Empleado> empleadosBySexo(String genero) {
		sql = "select * from empleados where genero = ?";
		List<Empleado> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, genero);
			rs = ps.executeQuery();
			while ( rs.next()) {
				Empleado emp = new Empleado();
				crearObjetoEmpleado(emp);
				lista.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		sql = "select * from empleados where apellidos like ?";
		List<Empleado> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + subcadena + "%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Empleado emp = new Empleado();
				crearObjetoEmpleado(emp);
				lista.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public double salarioTotal() {
		sql = "select sum(salario) as salario_total from empleados;";
		double suma = 0;
		
		try {
			ps= conn.prepareStatement(sql);
			rs  = ps.executeQuery();
			
			if (rs.next()) {
				suma = rs.getDouble("salario_total");			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suma;
	}

	@Override
	public double salarioTotal(int idDepar) {
		sql = "select sum(salario) from empleados where id_depar = ?";
		double suma = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			rs = ps.executeQuery();
			
			if ( rs.next()) {
				suma = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suma;
	}

	private void crearObjetoEmpleado(Empleado emp) throws SQLException {
		
		emp.setIdEmpl(rs.getInt("id_empl"));
		emp.setNombre(rs.getString("nombre"));
		emp.setApellidos(rs.getString("apellidos"));
		emp.setGenero(rs.getString("genero"));
		emp.setEmail(rs.getString("email"));
		emp.setPassword(rs.getString("password"));
		emp.setSalario(rs.getDouble("salario"));
		emp.setFechaIngreso(rs.getDate("fecha_ingreso"));
		emp.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
		emp.setPerfil(pDao.buscarUno(rs.getInt("id_perfil")));
		emp.setDpto(dDao.buscarUno(rs.getInt("id_depar")));
		
	}
	
}
