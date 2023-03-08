package modelo.dao;

import java.util.List;

import modelo.javabean.Clientes;

public interface ClienteDao {
	
	String eliminarUno(String cif);
	String  modificarUno (Clientes cliente);
	String altaClientes(Clientes cliente);
	Clientes buscarUno (String cif);
	List<Clientes> bucarTodos();

}
