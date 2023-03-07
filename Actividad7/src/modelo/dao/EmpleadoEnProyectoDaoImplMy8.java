package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Empleado;

import javabeans.EmpleadoEnProyecto;

public class EmpleadoEnProyectoDaoImplMy8 extends AbstractDaoMy8 implements EmpleadoEnProyectoDao{
	
	private EmpleadoDao eDao;
	private ProyectoDao pDao;
	
	public EmpleadoEnProyectoDaoImplMy8() {
		eDao = new EmpleadoDaoImplMy8();
		pDao = new ProyectoDaoImplMy8();
	}

	@Override
	public int altaEmpleadoEnProyecto(EmpleadoEnProyecto empProy) {
		sql = "insert into proyecto_con_empleados values (?, ?, ?, ?, ?, ?)";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empProy.getNumeroOrden());
			ps.setString(2, empProy.getProyecto().getIdProyecto());
			ps.setInt(3, empProy.getEmpleado().getIdEmpl());
			ps.setInt(4, empProy.getHorasAsignadas());
			ps.setDate(5, empProy.getFechaIncorporacion());
			ps.setDouble(6, empProy.getPrecioHora());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public EmpleadoEnProyecto buscarUno(int numeroOrden) {
		sql = "select * from proyecto_con_empleados where numero_orden = ?";
		EmpleadoEnProyecto empProy = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroOrden);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				empProy = new EmpleadoEnProyecto();
				crearObjetoEmpleadoEnProyecto(empProy);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empProy;
	}

	@Override
	public int modificarUno(EmpleadoEnProyecto empProy) {
		sql = "update proyecto_con_empleados set id_proyecto = ?, id_empl = ?, horas_asignadas = ?, fecha_incorporacion = ?, precio_hora = ? "
				+ " where numero_orden = ?";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, empProy.getProyecto().getIdProyecto());
			ps.setInt(2, empProy.getEmpleado().getIdEmpl());
			ps.setInt(3, empProy.getHorasAsignadas());
			ps.setDate(4, empProy.getFechaIncorporacion());
			ps.setDouble(5, empProy.getPrecioHora());
			ps.setInt(6, empProy.getNumeroOrden());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarUno(int numeroOrden) {
		sql = "delete from proyecto_con_empleados where numero_orden = ?";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroOrden);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}
	
	@Override
	public List<EmpleadoEnProyecto> buscarTodos() {
		sql = "select * from proyecto_con_empleados";
		List<EmpleadoEnProyecto> lista = new ArrayList<>();
		EmpleadoEnProyecto empProy = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				empProy = new EmpleadoEnProyecto();
				crearObjetoEmpleadoEnProyecto(empProy);
				lista.add(empProy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<EmpleadoEnProyecto> empleadoByProyecto(String idProyecto) {
		sql = "select * from proyecto_con_empleados where id_proyecto = ?";
		List<EmpleadoEnProyecto> lista = new ArrayList<>();
		EmpleadoEnProyecto empProy = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				empProy = new EmpleadoEnProyecto();
				crearObjetoEmpleadoEnProyecto(empProy);
				lista.add(empProy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public int asignarEmpleadosAProyecto(List<EmpleadoEnProyecto> empleados) {
		
		for (EmpleadoEnProyecto ele: empleados) {
			
			sql = "insert into proyecto_con_empleados values (?, ?, ?, ?, ?, ?)";
			filas = 0;
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ele.getNumeroOrden());
				ps.setString(2, ele.getProyecto().getIdProyecto());
				ps.setInt(3, ele.getEmpleado().getIdEmpl());
				ps.setInt(4, ele.getHorasAsignadas());
				ps.setDate(5, ele.getFechaIncorporacion());
				ps.setDouble(6, ele.getPrecioHora());
				filas = ps.executeUpdate();
				filas = 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return filas;
	}

	@Override
	public int horasAsignadasAProyecto(String idProyecto) {
		sql = "select sum(horas_asignadas) from proyecto_con_empleados where id_proyecto = ?";
		int suma = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				suma = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suma;
	}

	@Override
	public double costeActualDeProyecto(String idProyecto) {
		sql = "select sum(horas_asignadas * precio_hora) as coste_proyecto from proyecto_con_empleados where id_proyecto = ?";
		double coste = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				coste = rs.getDouble("coste_proyecto");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coste;
	}

	@Override
	public double margenActualProyecto(String idProyecto) {
		sql = "select (p.venta_previsto - sum(pe.horas_asignadas * pe.precio_hora)) as margen_actual "
				+ " from proyectos p, proyecto_con_empleados pe"
				+ " where (p.id_proyecto = pe.id_proyecto) and (pe.id_proyecto = ?);";
		
		double margen = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				margen = rs.getDouble("margen_actual");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return margen;
	}

	
	private void crearObjetoEmpleadoEnProyecto(EmpleadoEnProyecto empProy) throws SQLException {
		
		empProy.setNumeroOrden(rs.getInt("numero_orden"));
		empProy.setProyecto(pDao.buscarUno(rs.getString("id_proyecto")));
		empProy.setEmpleado(eDao.buscarUno(rs.getInt("id_empl")));
		empProy.setHorasAsignadas(rs.getInt("horas_asignadas"));
		empProy.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
		empProy.setPrecioHora(rs.getDouble("precio_hora"));
	}

	
}
