package testingDaoImplMy8;

import modelo.dao.FacturasDao;
import modelo.daojdbc.FacturasDaoImplMy8;
import modelo.javabean.Facturas;
import modelo.javabean.Perfiles;

public class TestFacturasDaoImplMy8 {

	public static void main(String[] args) {
		
		
		FacturasDao fco = new FacturasDaoImplMy8();
		
		System.out.println("=====================================================");
		System.out.println("Prueba dar de alta/insertar una fila introduciendo el objeto");
		
		fco.altaFacturas( new Facturas("F2020002", "Formacion a cliente 105", "FOR2020001"));
		fco.altaFacturas( new Facturas("F2020003", "Formacion a cliente 250", "FOR2020001"));
		
		/*
		 * Despues sacamos las lista de todas las facturas, para ver que las altas introducidas 
		 * son correctas
		 */
		
		for (Facturas ele: fco.bucarTodos()) {
			System.out.println(ele);
		}
		
		
		System.out.println("=====================================================");
		System.out.println("Prueba dar de eliminar un fila introduciendo un idPerfil");
		/*
		 * Vamos a eliminar la fila con los id_factura que hemos insertado 
		 * en la prueba de altaFactura(), son los id_factura = F2020002 y F2020003
		 * 
		 */
		fco.eliminarUno("F2020002");
		fco.eliminarUno("F2020003");
		
		/*
		 * sacamos las lista de todas las facturas, para comprobar que se han eliminado correctamente
		 * las facturas deseadas.
		 */
		for (Facturas ele: fco.bucarTodos()) {
			System.out.println(ele);
		}
		
		/*
		 * En la siguiente prueba vamos a buscar una factura, metiendo su id_factura, 
		 * si la factura existe nos la mostrara por consola, si no existe saldra por 
		 * consola "factura no encontrada"
		 * 
		 * Tambien, podemos buscar dentro de la tabla facturas y sacar cualquiera de sus atributos/columnas,
		 * en este caso, vamos a buscar solo descripcion de la factura que hemos buscado en el caso anterior.
		 * 
		 */
		System.out.println("=====================================================");
		System.out.println("Prueba para buscar una factura por idFactura");
		
		
		Facturas fc = fco.buscarUno("F2020001");
		
		if(fc != null) {
		System.out.println(fc);
		}else System.out.println("Factura no encontrada");
		
		System.out.println("Descripcion factura F2020001 : ");
		System.out.println(fc.getDescripcion());
	
		
	
		System.out.println("=====================================================");
		System.out.println("Prueba modificar ");
		
		Facturas fc1 = new Facturas();
		
		fc1 = fco.buscarUno("F2020001");
		
		fc1.setIdFacturas("F2020001");
		fc1.setDescripcion("Limpieza");
		fc1.setIdProyecto("E2022F");
		
		fco.modificarUno(fc1);
		
		for (Facturas ele: fco.bucarTodos()) {
			System.out.println(ele);
		}
		
		
		
		
	}

}
