package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Empleados;


public interface EmpleadosDao {
	
	/*
	 * Métodos de EmpleadoDao, además de los CRUD, y findAll():
	 * empleadosByDepartamento(int idDepar): List<Empleado>
	 * empleadosBySexo(char sexo): List<Empleado>
	 * empleadosByApellido(String subcadena): List<Empleado>
     * salarioTotal(): double
     * salarioTotal(int idDepar): double. 
	 */

	List<Empleados> empleadosByDepartamento (int idDepar);
	List<Empleados> empleadosBySexo (String sexo); //Tratamos el sexo como String
	List<Empleados> empleadosByApellido(String subcadena);
	double salario();
	double salarioTotal(int idDepar);
	
	
	int eliminarUno(int idEmpl);
	int  modificarUno (Empleados empleado);
	int altaEmpleados(Empleados empleado);
	Empleados buscarUno (int idEmpl);
	
	List<Empleados> bucarTodos();
	
}
	
