package modelo.dao;

import java.util.List;

import javabeans.Proyecto;

public interface ProyectoDao {
	int altaProyecto(Proyecto proyecto);
	Proyecto buscarUno(String idProyecto);
	int modificarUno(Proyecto proyecto);
	int eliminarUno(String idProyecto);
	List<Proyecto> buscarTodos();
	List<Proyecto> proyectosByEstado(String estado);
	List<Proyecto> proyectosByCliente(String cif);
	List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado);
	double importesVentaProyectosTerminados();
	double margenBrutoProyectosTerminados();
	int diasATerminoProyectoActivo(String idProyecto);
}
