package testingDaoImplMy8;

import modelo.dao.PerfilesDao;
import modelo.daojdbc.PerfilesDaoImplMy8;
import modelo.javabean.Perfiles;


public class TestPerfilesDaoImplMy8 {

	public static void main(String[] args) {
		
		//Creamos una variable de tipo interface
		
		PerfilesDao pdao = new PerfilesDaoImplMy8();
		
		//testing buscar un perfil con idPerfil
		
		System.out.println("=====================================================");
		System.out.println("Prueba buscar un perfil introduciendo un idPerfil");
		
		//Prueba para el idPerfil= 3
				Perfiles pf = pdao.buscarUno(3);
				
				if(pf != null) {
				System.out.println(pf);
				System.out.println("nombre:" + pf.getNombre());// si solo queremos sacar otro dato de la fila
				}else System.out.println("Empleado no encontrado");
				
		System.out.println("=====================================================");
		System.out.println("Prueba dar de alta una fila introduciendo un Objeto nuevo");
		
		pdao.altaEmpleados( new Perfiles(5, "Director  Supremo",4.5));
		pdao.altaEmpleados( new Perfiles(6, "Director MUY Supremo",4.6));
		
		// vamos a buscarlos para ver que la insercion se ha hecho bien
	
	
		System.out.println(pdao.buscarUno(5));
		System.out.println(pdao.buscarUno(6));
		
		System.out.println("=====================================================");
		System.out.println("Prueba dar de eliminar un fila introduciendo un idPerfil");
		/*
		 * Vamos a eliminar la fila con id_perfil=5 y  que es una de las inserciones
		 * nuevas que hemos hecho en el paso anterior
		 */
		pdao.eliminarUno(5);
		
		/*
		 * volvemos a buscar todos los perfiles para ver que se han eliminado 
		 * correctamente
		 */
		for (Perfiles ele: pdao.bucarTodos()) {
			System.out.println(ele);
		}
		
		System.out.println("====================================================================");
		System.out.println("Prueba para LISTAR todos las filas de la tabla Perfiles");
		
		for (Perfiles ele: pdao.bucarTodos()) {
			System.out.println(ele);
		}
		
		System.out.println("====================================================================");
		System.out.println("Prueba para modificar datos de las filas de la tabla Perfiles");
		
		//Mostramos todas las filas de Perfiles 
		
		for (Perfiles ele: pdao.bucarTodos()) {
			System.out.println(ele);
		} 
		
		//procedemos a la modificacion
		
		System.out.println("Modificacion :");
		
		Perfiles pf1 = new Perfiles();
		pf1.setNombre("Gestion Residuos");
		pf1.setIdPerfil(6);
		pdao.modificarUno(pf1);
		
		//Buscamos al empleado otra vez para ver la modificacion del del nombre
		System.out.println(pdao.buscarUno(6));
		
		
		
		
		
		
		
		
		
		
	}
	

}
