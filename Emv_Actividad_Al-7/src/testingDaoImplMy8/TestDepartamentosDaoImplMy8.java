package testingDaoImplMy8;

import modelo.dao.DepartamentosDao;
import modelo.daojdbc.DepartamentosDaoImplMy8;
import modelo.javabean.Departamentos;
import modelo.javabean.Perfiles;

public class TestDepartamentosDaoImplMy8 {

	public static void main(String[] args) {
		
		DepartamentosDao dpo = new DepartamentosDaoImplMy8();
		
		System.out.println("===========================================");
		System.out.println("Pruebas para buscar todos los departamentos");
		
		for(Departamentos ele: dpo.bucarTodos()) {
			System.out.println(ele);
		}
		
		System.out.println("===========================================");
		System.out.println("Pruebas para buscar un departamento con id_depar=30");
		
		Departamentos dp = dpo.buscarUno(30);
		if(dp != null) {
		System.out.println(dp);
		}else System.out.println("Empleado no encontrado");
		

		System.out.println("===========================================");
		System.out.println("Pruebas para insertar un departamento con id_depar=60");
		
		dpo.altaDepartamentos( new Departamentos(50,"Seguridad","Barcelona"));
		dpo.altaDepartamentos( new Departamentos(70,"SSGG","Bilbao"));
	
		
		/*
		 * comprobamos que las altas se han insertado en la base de datos correctamente.
		 */
		
		for(Departamentos ele: dpo.bucarTodos()) {
			System.out.println(ele);
		}
		
		
		System.out.println("===========================================");
		System.out.println("Pruebas para eleminar un departamento con id_depar=70");
		
		
		dpo.eliminarUno(70);
		
		/*
		 * Buscamos otra vez todos los departamentos para ver que se ha eliminado correctamente
		 * los departamentos
		 */
		
		for(Departamentos ele: dpo.bucarTodos()) {
			System.out.println(ele);
		}

		
		System.out.println("===========================================");
		System.out.println("Pruebas para modificar el nombre un departamento con id_depar=50");
		/*
		 * vamos a modificar el departamento anteriormente creado id_depar=50 y le vamos a
		 * modificar tanto el nombre como la direccion
		 */
		Departamentos depar = new Departamentos();;
		depar.setIdDepar(50);
		depar.setNombre("Gestion Operaciones");
		depar.setDireccion("Valladolid");
		dpo.modificarUno(depar);
		
		//Buscamos el departamento para ver que la modificacion es correcta
		System.out.println(dpo.buscarUno(50));
		
		
		
	
	}

}
