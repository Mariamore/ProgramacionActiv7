package testingDaoImplMy8;

import java.sql.Date;

import modelo.dao.ClienteDao;
import modelo.dao.EmpleadosDao;
import modelo.dao.ProyectosDao;
import modelo.daojdbc.ClienteDaoImplMy8;
import modelo.daojdbc.EmpleadosDaoImplMy8;
import modelo.daojdbc.ProyectosDaoImplMy8;
import modelo.javabean.Clientes;
import modelo.javabean.Empleados;
import modelo.javabean.Proyectos;

public class TestProyectosDaoImplMy8 {

	public static void main(String[] args) {
	
		ProyectosDao prao = new ProyectosDaoImplMy8();
		
		System.out.println("===========================================");
		System.out.println("Pruebas para buscar todos los proyectos");
		
		for (Proyectos ele: prao.bucarTodos()) {
			System.out.println(ele);
		}
		
		System.out.println("===========================================");
		System.out.println("Pruebas para buscar un proyecto con id_proyecto=FOR2021001");
		
		System.out.println(prao.buscarUno("FOR2021001"));
		System.out.println(prao.buscarUno("FOR2021002"));
		
		/*
		 * Tanto el empleado, el cliente y la factura nos dan nulo, porque no necesitamos
		 * esos datos en Proyectos, modificando el metodo toString de la Clase Proyectos 
		 * valdría para que no apareciede
		 */
		
		
		
		
		System.out.println("===========================================");
		System.out.println("Pruebas para eleminar un proyecto con id_proyecto ");
		
		
		//prao.eliminarUno("FOR2021002"); Funciona!! 
		
		/*
		 * Para comprobar que hemos eliminado correctamente el proyecto volvemos a buscarlos todos
		 */
		
		for (Proyectos ele: prao.bucarTodos()) {
			System.out.println(ele);
		
	
		
		System.out.println("===========================================");
		System.out.println("Prueba para informar del estado de los proyectos");
		
		/*
		 * En este caso los proyectos se de dividen en dos categorias o biene
		 * estam ACTIVOS o TERMINADOS
		 */
		
	
		for (Proyectos ele2: prao.proyectosByEstado("activo")) {
			System.out.println(ele);
		}
		
		
		System.out.println("===========================================");
		System.out.println("Prueba para informar los proyectos de los clientes");
		
		/*
		 * Usamos el metodo proyectosByClientes() le asiganmos el cif del 
		 * cliente y no puestra el proyecto asociado a ese cif.
		 */
		
		
		for (Proyectos ele2: prao.proyectosByClientes("A22222222")) {
			System.out.println(ele);
		}
		
		System.out.println("===========================================");
		System.out.println("Prueba para informar proyectosByJefeProyectoAndByEstado");
		
		
		/*
		 * Le pasamos los dos parametros a la funcion y nos imprime el proyecto asociado
		 * a los dos parametros
		 */
	
		System.out.println(prao.proyectosByJefeProyectoAndByEstado(114,"TERMINADO" ));
		
		System.out.println("===========================================");
		System.out.println("Prueba para infomar del importe de la venta de los proyectos termiandos");
		
		
		Proyectos proye = new Proyectos();
		proye.setEstado("terminado");
		System.out.println("Importe venta: " + prao.importesVentaProyectosTerminados());
		
	
		System.out.println("===========================================");
		System.out.println("Prueba margen bruto de los proyectos termindados");
		
		System.out.println("el margen de los proyectos es : "+ prao.margenBrutoProyectosTerminados());
		
		
		
		System.out.println("===========================================");
		System.out.println("Días que quedan para terminar el proyecto "
				+ "(diferencia entre fecha_fin_previsto y la fecha de hoy)");
		
		System.out.println("Quedan: " + prao.diasATerminoProyectoTerminados("FOR2020001")+ " días" +
		" para terminar el proyecto");
		
		/*
			== NO FUNCIONA ==
			
		System.out.println("===========================================");
		System.out.println("Pruebas para modificar un proyecto con id_proyecto=FOR2021001");
		
	
		Proyectos pro = prao.buscarUno("FOR2021001");
		
		pro.setIdProyecto("FOR2021001");
		pro.setDescripcion("Formacion Artes");
		
		String fechaI1 = "2021-02-15";
		Date fechaIniNueva1 = Date.valueOf(fechaI1);
		pro.setFechaInicio(fechaIniNueva1);
		
		String fechaFinPr1 = "2024-01-13";
		Date fechaFinPreNueva1 = Date.valueOf(fechaFinPr1);
		pro.setFechaFinPrevisto(fechaFinPreNueva1);
		
		String fechaFinRe1 = "2019-02-04";
		Date fechaFinReNueva1 = Date.valueOf(fechaFinRe1);
		pro.setFechaFinReal(fechaFinReNueva1);
		
		pro.setVentaPrevisto(59000.00);
		pro.setCostesPrevisto(17582.30);
		pro.setCosteReal(18365.22);
		pro.setEstado("ACTIVO");
		pro.setJefeProyecto(220);
		pro.setCif("B5958524");
		
		
		prao.modificarUno(pro);
		
		for (Proyectos ele1: prao.bucarTodos()) {
			System.out.println(ele);
		}
		
		
		System.out.println("===========================================");
		System.out.println("Pruebas para insertar un un proyecto con id_proyecto=???????");
		
		EmpleadosDao empao = new EmpleadosDaoImplMy8();
		ClienteDao clao = new ClienteDaoImplMy8();
		Clientes cli = new Clientes();
		
		cli = clao.buscarUno("C44444444");
		String fechaI = "2021-02-15";
		Date fechaIniNueva = Date.valueOf(fechaI);
		
		String fechaFinPr = "2019-04-23";
		Date fechaFinPreNueva = Date.valueOf(fechaFinPr);
		
		String fechaFinRe = "2019-01-07";
		Date fechaFinReNueva = Date.valueOf(fechaFinRe);
		
		String fechaHoy ="2023-03-06";
		Date fechaHoyNueva = Date.valueOf(fechaHoy);
		
		
		Proyectos proy = new Proyectos("FOR20001", "Formación de limpieza", fechaIniNueva, fechaFinPreNueva,fechaFinReNueva, 
						850000.00, 755000.00, 2834700, "ACTIVO", 117, cli);
		
		
		System.out.println(prao.altaProyectos(proy));
		
		//comprobamos que se ha insertado el nuevo proyecto
		
		for (Proyectos ele: prao.bucarTodos()) {
			System.out.println(ele);
		}
		
		
		*/
		
		
		
		
	}
			
}
				
}	
				
				
				
				