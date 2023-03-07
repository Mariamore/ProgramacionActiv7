package modelo.dao;

import java.util.List;

import javabeans.Departamento;

public interface DepartamentoDao {
	int altaDepartamento(Departamento dpto);
	Departamento buscarUno(int idDepar);
	int modificarUno(Departamento dpto);
	int eliminarUno(int idDepar);
	List<Departamento> buscarTodos();
}
