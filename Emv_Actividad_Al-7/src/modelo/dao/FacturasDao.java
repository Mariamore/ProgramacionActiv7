package modelo.dao;

import java.util.List;

import modelo.javabean.Facturas;



public interface FacturasDao {
	
	String eliminarUno(String idFactura);
	String  modificarUno (Facturas factura);
	String altaFacturas(Facturas factura);
	Facturas buscarUno (String idFactura);
	List<Facturas> bucarTodos();

}
