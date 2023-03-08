package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.EmpleadosDao;
import modelo.dao.ProyectosConEmpleadosDao;
import modelo.javabean.Empleados;
import modelo.javabean.Perfiles;
import modelo.javabean.ProyectoConEmpleados;
import modelo.javabean.Proyectos;

public class ProyectosConEmpleadosDaoImplMy8 extends AbstractDaoMy8 implements ProyectosConEmpleadosDao {

	@Override
	public List<ProyectoConEmpleados> empleadosByProyecto(String idProyecto) {

		sql="select * from proyecto_con_empleados where id_proyecto=?";
		
		List<ProyectoConEmpleados> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setNString(1, idProyecto);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				ProyectoConEmpleados proyemp = new ProyectoConEmpleados();;
				
				proyemp.setNumeroOrden(rs.getInt("numero_orden"));
				proyemp.setIdProyecto(rs.getNString("id_proyecto"));
				proyemp.setIdEmpl(rs.getInt("id_empl"));
				proyemp.setHorasAsignadas(rs.getInt("horas_asignadas"));
				proyemp.setFechaIncorporación(rs.getDate("fecha_incorporacion"));
				
				lista.add(proyemp);	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}
		


	@Override
	public int horasAsignadasAProyecto(String idProyecto) {
		
		sql="select sum(horas_asignadas)as horas from proyecto_con_empleados where id_proyecto=?";
		int horas=0;
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setNString(1,idProyecto);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				horas=rs.getInt("horas");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return horas;
	}

	

	
	@Override
	public double costeActualdeProyecto(String idProyecto) {

		/*
		 * horas*coste_hora de cada empleado asignado al proyecto.
		 */
		sql="select sum(horas_asignadas)as horas from proyecto_con_empleados where id_proyecto=?";
		int horas=0;
		Empleados emp = new Empleados();
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setNString(1,idProyecto);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				horas=rs.getInt("horas");
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return horas;
	}
	
	
	

	@Override
	public double margenActualProyecto(String idProyeto) {

		//margenActualProyecto(String codigoProyecto): double. 
		//Importe_venta del proyecto – costeActual del Proyecto
		
		return 0;
	}

	
	
	
	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleados> empleados) {
		
		for (ProyectoConEmpleados ele: empleados) {
			sql= "insesrt into proyecto_con_empleados values (?,?,?,?,?)";
			
			try {
				ps= conn.prepareStatement(sql);
				ps.setInt(1, ele.getNumeroOrden());
				ps.setNString(2, ele.getIdProyecto());
				ps.setInt(3, ele.getEmpleado().getIdEmpl());
				ps.setInt(4, ele.getHorasAsignadas());
				ps.setDate(5, ele.getFechaIncorporación());
				filas = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return filas;
	}

	
	
	
	
	
}
