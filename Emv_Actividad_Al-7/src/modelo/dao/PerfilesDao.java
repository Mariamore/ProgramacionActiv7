package modelo.dao;


import java.util.List;

import modelo.javabean.Perfiles;

public interface PerfilesDao {
	
	int eliminarUno(int idPerfil);
	int  modificarUno (Perfiles perfil);
	int altaEmpleados(Perfiles perfil);
	Perfiles buscarUno (int idPerfil);
	List<Perfiles> bucarTodos();
}
