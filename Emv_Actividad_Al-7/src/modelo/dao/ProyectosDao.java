package modelo.dao;

import java.util.List;

import modelo.javabean.Proyectos;



public interface ProyectosDao {
	
	String eliminarUno(String idProyecto);
	int modificarUno (Proyectos proyecto);
	int altaProyectos(Proyectos proyecto);
	Proyectos buscarUno (String idProyecto);
	List<Proyectos> bucarTodos();
	
	/*
	 * Metodos implementados a parte de CRUD y findAll();
	 */
	
	List<Proyectos>proyectosByEstado(String estado);
	List<Proyectos>proyectosByClientes(String cif);
	List<Proyectos>proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado);
	double importesVentaProyectosTerminados();
	double margenBrutoProyectosTerminados();
	int diasATerminoProyectoTerminados(String idProyecto);

	
	
	
	
	

}
