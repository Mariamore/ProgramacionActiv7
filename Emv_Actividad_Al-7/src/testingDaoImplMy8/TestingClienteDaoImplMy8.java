package testingDaoImplMy8;

import modelo.dao.ClienteDao;
import modelo.daojdbc.ClienteDaoImplMy8;
import modelo.javabean.Clientes;

public class TestingClienteDaoImplMy8 {

	public static void main(String[] args) {
		
		ClienteDao clao = new ClienteDaoImplMy8();
		
		/*
		 * Pruebas de Cliente contra la Base de Datos
		 */
		System.out.println("=====================================================");
		System.out.println("Prueba buscar un Cliente, metiendole el cif");
		
		/*
		 * Metemos el cif de cualquiera de los clientes de la base de deatos y atraves del
		 * método bucar uno, nos saca por consola la busqueda.
		 * Vamos a probar con los dos cif que tenemos en la bases de datos.
		 */
		
		System.out.println(clao.buscarUno("A22222222"));
		System.out.println(clao.buscarUno("B33333333"));

		System.out.println("=====================================================");
		System.out.println("Prueba buscar todos los clientes que tenemos en la BBDD");
		
		
		for (Clientes ele: clao.bucarTodos()) {
			System.out.println(ele);
		}
		
		System.out.println("=====================================================");
		System.out.println("Prueba para insertar un cleinte nuevo");
		
		/*
		 * Vamos a insertar a dos clientes nuevos en la base de datos
		 */
		
		
		clao.altaClientes( new Clientes("C44444444","Adrian", "Garcia", "Málaga", 150000000.00, 180));
		clao.altaClientes(new Clientes("D55555555", "Elisa", "Segura", "Guadalajara", 10000000.00, 14));
		
		/*
		 * A continuacion buscamos otra vez todos los clientes que tenemos en la base de datos para ver
		 * que el alta se ha grabado correctamente
		 */
		System.out.println("Todos los cliente");


		for (Clientes ele: clao.bucarTodos()) {
			System.out.println(ele);
		}
		

		System.out.println("=====================================================");
		System.out.println("Prueba eliminar Clientes");
		/*
		 * Vamos a eliminar los clientes que hemos insertado en el apartado 
		 * anterior, pasandole el cif.
		 */
		
		
		clao.eliminarUno("D55555555");
		
		/*
		 * Un ejecutado el metodo eliminarUno, volvemos a buscar todos los clientes
		 * para ver que el metodo se ha ejecutado correctamente
		 */
	
		for (Clientes ele: clao.bucarTodos()) {
			System.out.println(ele);
		}
		
		System.out.println("=====================================================");
		System.out.println("Prueba modificar Clientes");
		
		Clientes cl1 = new Clientes();
		
		cl1= clao.buscarUno("C44444444"); //vamos a modificar el cliente dado antes de alta
		cl1.setNombre("Manolo");
		cl1.setApellidos("Gonzalez");
		cl1.setDomicilio("Malaga");
		cl1.setFacturacionAnual(1548593.00);
		cl1.setNumeroEmpleados(400);
		clao.modificarUno(cl1);
		
		for (Clientes ele: clao.bucarTodos()) {
			System.out.println(ele);
		}
	}

}
