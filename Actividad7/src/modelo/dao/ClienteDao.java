package modelo.dao;

import java.util.List;

import javabeans.Cliente;

public interface ClienteDao {
	
	int altaCliente(Cliente cliente);
	Cliente buscarUno(String cif);
	int modificarUno(Cliente cliente);
	int eliminarUno(String cif);
	List<Cliente> buscarTodos();
	
}
