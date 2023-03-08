package modelo.dao;

import java.util.List;

import modelo.javabean.Departamentos;


public interface DepartamentosDao {

	int eliminarUno(int idDepar);
	int  modificarUno (Departamentos departamento);
	int altaDepartamentos(Departamentos departamento);
	Departamentos buscarUno (int idPerfil);
	List<Departamentos> bucarTodos();
	
	
	
	
	
}
