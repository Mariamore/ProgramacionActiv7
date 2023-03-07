package modelo.dao;
import java.util.List;

import javabeans.Empleado;
public interface EmpleadoDao {

	int altaEmpleado(Empleado empleado);
	Empleado buscarUno(int idEmpl);
	int modificarUno(Empleado empleado);
	int eliminarUno(int idEmpl);
	List<Empleado> buscarTodos();
	List<Empleado> empleadosByDepartamento(int idDepar);
	List<Empleado> empleadosBySexo(String genero);
	List<Empleado> empleadosByApellido(String subcadena);
	double salarioTotal();
	double salarioTotal(int idDepar);


}
