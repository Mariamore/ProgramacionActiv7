package modelo.dao;

import java.util.List;

import javabeans.Perfil;

public interface PerfilDao {

	int altaPerfil(Perfil perfil);
	Perfil buscarUno(int idPerfil);
	int modificarUno(Perfil perfil);
	int eliminarUno(int idPerfil);
	List<Perfil> buscarTodos();
}
