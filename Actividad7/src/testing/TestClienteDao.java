package testing;

import javabeans.Cliente;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8;

public class TestClienteDao {

	public static void main(String[] args) {
		//Hemos creado este test para probar el método modificarUno de la clase ClienteDao
		
		ClienteDao cDao = new ClienteDaoImplMy8();
		
		System.out.println("PRUEBA MODIFICAR UN CLIENTE");
		Cliente cl = new Cliente("70828756L", "Alicia", "Herrero", "Tarragona", 150000, 80);
		//primero le damos de alta
		cDao.altaCliente(cl);
		//comprobamos que se ha dado de alta
		for (Cliente ele: cDao.buscarTodos()) {
			System.out.println(ele);
		}
		
		System.out.println("\n");
		//Procedemos a modiificar los datos del cliente
		cl.setNombre("Antonio");
		cl.setApellidos("Garcia");
		cl.setDomicilio("Aviles");
		cl.setFacturacionAnual(65230);
		cl.setNumeroEmpleados(56);
		System.out.println(cDao.modificarUno(cl));
		//Comprobamos que se han modificado
		for (Cliente ele: cDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		//eliminamos ese cliente
		cDao.eliminarUno("70828756L");
		//comprobamos que se ha eliminado
		for (Cliente ele: cDao.buscarTodos()) {
			System.out.println(ele);
		}
	}

}
