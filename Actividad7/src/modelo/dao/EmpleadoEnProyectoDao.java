package modelo.dao;

import java.util.List;


import javabeans.EmpleadoEnProyecto;

public interface EmpleadoEnProyectoDao {

	int altaEmpleadoEnProyecto(EmpleadoEnProyecto empProy);
	EmpleadoEnProyecto buscarUno(int numeroOrden);
	int modificarUno(EmpleadoEnProyecto empProy);
	int eliminarUno(int numeroOrden);
	List<EmpleadoEnProyecto> buscarTodos();
	List<EmpleadoEnProyecto> empleadoByProyecto(String idProyecto);
	int asignarEmpleadosAProyecto(List<EmpleadoEnProyecto> empleado);
	int horasAsignadasAProyecto(String idProyecto);
	double costeActualDeProyecto(String idProyecto);
	double margenActualProyecto(String idProyecto);
	
}
