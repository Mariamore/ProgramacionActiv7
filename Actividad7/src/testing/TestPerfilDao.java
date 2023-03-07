package testing;

import javabeans.Perfil;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8;

public class TestPerfilDao {

	public static void main(String[] args) {
		PerfilDao pDao = new PerfilDaoImplMy8();
		System.out.println("PRUEBA DE DAR DE ALTA UN PERFIL");
		Perfil pf = new Perfil(5, "Marketing");
		System.out.println(pDao.altaPerfil(pf) + "\n");
		//comprobamos que se ha añadido, ejecutando el método buscarTodos
		for(Perfil ele: pDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR UN PERFIL POR ID PERFIL");
		System.out.println(pDao.buscarUno(3) + "\n");
		
		System.out.println("PRUEBA MODIFICAR UN PERFIL");
		pf.setNombre("IT");
		
		System.out.println(pDao.modificarUno(pf));
		//comprobamos que se ha modificado
		for (Perfil ele: pDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA ELIMINAR UN PERFIL");
		System.out.println(pDao.eliminarUno(5) + "\n");
		//comprobamos que se ha eliminado, ejecutando el método buscarTodos
		for(Perfil ele: pDao.buscarTodos()) {
			System.out.println(ele);
		}
		
	}

}
