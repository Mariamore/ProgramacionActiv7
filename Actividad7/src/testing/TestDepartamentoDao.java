package testing;

import javabeans.Departamento;
import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8;

public class TestDepartamentoDao {

	public static void main(String[] args) {
		DepartamentoDao dDao = new DepartamentoDaoImplMy8();
		System.out.println("PRUEBA DAR DE ALTA UN DEPARTAMENTO");
		Departamento depar = new Departamento(90, "Marketing", "Andorra");
		System.out.println(dDao.altaDepartamento(depar)+ "\n");
		//comprobamos que se ha añadido, ejecutando el método buscarTodos
		for (Departamento ele: dDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR UN DEPARTAMENTO POR ID DEPARTAMENTO");
		System.out.println(dDao.buscarUno(20) + "\n");
		
		System.out.println("PRUEBA ELIMINAR UN DEPARTAMENTO");
		System.out.println(dDao.eliminarUno(90));
		//comprobamos que se ha eliminado, ejecutando el método buscarTodos
				for (Departamento ele: dDao.buscarTodos()) {
					System.out.println(ele);
				}
				System.out.println("\n");
				
		System.out.println("PRUEBA DE MODIFICAR UN DEPARTAMENTO");
		//creamos un nuevo departamento
		Departamento depar1 = new Departamento(60, "Ventas","Alcorcon");
		System.out.println(dDao.altaDepartamento(depar1));
		//comprobamos que efectivamente se ha creado
		for (Departamento ele: dDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		//modificamos los datos de dicho departamento
		depar1.setNombre("Marketing");
		depar1.setDireccion("Torrejon");
		System.out.println(dDao.modificarUno(depar1));
		//comprobamos que los datos se han modificado
		for (Departamento ele: dDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
	

	}

}
