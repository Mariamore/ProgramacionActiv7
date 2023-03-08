package modelo.dao;

import java.util.List;

import modelo.javabean.ProyectoConEmpleados;

public interface ProyectosConEmpleadosDao {
	
	

	List<ProyectoConEmpleados>empleadosByProyecto(String idProyecto);
	int asignarEmpleadosAProyecto(List<ProyectoConEmpleados> empleados);
	int horasAsignadasAProyecto(String idProyecto);
	double costeActualdeProyecto (String idProyecto);
	double margenActualProyecto (String idProyeto);
	

	
	
	
	
}
