package testing;

import java.sql.Date;

import javabeans.Cliente;
import javabeans.Proyecto;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8;

public class TestProyectoDao {

	public static void main(String[] args) {
		ProyectoDao pDao = new ProyectoDaoImplMy8();
		
		ClienteDao cDao = new ClienteDaoImplMy8();
		
		System.out.println("PRUEBA DAR DE ALTA PROYECTO");

		Cliente cli = cDao.buscarUno("B33333333");
		String fechaFinP = "2025-10-30";
		Date fechaFinPrevisto= Date.valueOf(fechaFinP);
		String fechaFinR = "2026-05-14";
		Date fechaFinReal = Date.valueOf(fechaFinR);
		Proyecto proy = new Proyecto("FOR2023001", "Formación de nuevos empleados", new Date(System.currentTimeMillis()), fechaFinPrevisto, fechaFinReal, 
						55000, 25000, 30000, "ACTIVO", 117, cli);
		System.out.println(pDao.altaProyecto(proy));
		//comprobamos que se ha insertado el nuevo proyecto
		for (Proyecto ele: pDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR UN PROYECTO POR ID PROYECTO");
		System.out.println(pDao.buscarUno("FOR2020001"));
		System.out.println("\n");
		
		System.out.println("PRUEBA MODIFICAR UN PROYECTO");
		proy.setIdProyecto("FOR2023001");
		proy.setDescripcion("Formación profesores");
		String fechaIni = "2023-04-12";
		Date fechaIniV = Date.valueOf(fechaIni);
		proy.setFechaInicio(fechaIniV);
		String fechaFin = "2026-11-27";
		Date fechaFinV = Date.valueOf(fechaFin);
		proy.setFechaFinPrevisto(fechaFinV);
		String fechaFinR1 = "2026-12-14";
		Date fechaFinRV = Date.valueOf(fechaFinR1);
		proy.setFechaFinReal(fechaFinRV);
		proy.setVentaPrevisto(27500.69);
		proy.setCostesPrevisto(17582.30);
		proy.setCosteReal(18365.22);
		proy.setEstado("INACTIVO");
		proy.setJefeProyecto(118);
		proy.setCliente(cli);
		System.out.println(pDao.modificarUno(proy));
		//comprobamos que se ha modificado el proyecto
				for (Proyecto ele: pDao.buscarTodos()) {
					System.out.println(ele);
				}
		System.out.println("\n");
		
		System.out.println("PRUEBA ELIMINAR UN PROYECTO");
		System.out.println(pDao.eliminarUno("FOR2023001"));
		//comprobamos que se ha eliminado el proyecto
				for (Proyecto ele: pDao.buscarTodos()) {
					System.out.println(ele);
				}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR PROYECTO POR ESTADO");
		for (Proyecto ele: pDao.proyectosByEstado("ACTIVO")) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR PROYECTO POR CLIENTE");
		
		for (Proyecto ele: pDao.proyectosByCliente("A22222222")) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR PROYECTO POR JEFE DE PROYECTO Y POR EMPLEADO");
		for (Proyecto ele: pDao.proyectosByJefeProyectoAndByEstado(114, "TERMINADO")) {
			System.out.println(ele);
		}
		System.out.println("\n");
		// ahora probamos a buscar los proyectos cuyo estado es activo y el jefe de proyecto es 114
		for (Proyecto ele: pDao.proyectosByJefeProyectoAndByEstado(114, "ACTIVO")) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA IMPORTES VENTA PRODUCTOS TERMINADOS");
		System.out.println(pDao.importesVentaProyectosTerminados());
		System.out.println("\n");
		
		System.out.println("PRUEBA MARGEN BRUTO PROYECTOS TERMINADOS");
		System.out.println(pDao.margenBrutoProyectosTerminados());
		System.out.println("\n");
		
		System.out.println("PRUEBA DIAS A TERMINO PROYECTO ACTIVO");
		System.out.println(pDao.diasATerminoProyectoActivo("FOR2021001"));
	}

}
