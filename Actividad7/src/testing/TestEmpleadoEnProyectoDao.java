package testing;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



import javabeans.EmpleadoEnProyecto;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8;
import modelo.dao.EmpleadoEnProyectoDao;
import modelo.dao.EmpleadoEnProyectoDaoImplMy8;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8;

public class TestEmpleadoEnProyectoDao {
	
	public static void main(String[] args) {
		EmpleadoEnProyectoDao epDao = new EmpleadoEnProyectoDaoImplMy8();
		EmpleadoDao eDao = new EmpleadoDaoImplMy8();
		ProyectoDao pDao = new ProyectoDaoImplMy8();
		
		System.out.println("PRUEBA DAR DE ALTA UN EMPLEADO EN PROYECTO");
		EmpleadoEnProyecto emp = new EmpleadoEnProyecto(8, pDao.buscarUno("FOR2020001"), eDao.buscarUno(118), 200, new Date(System.currentTimeMillis()), 23.5);
		System.out.println(epDao.altaEmpleadoEnProyecto(emp));
		//ahora comprobamos que se haya dado de alta
		for (EmpleadoEnProyecto ele: epDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR UN EMPLEADO EN PROYECTO");
		System.out.println(epDao.buscarUno(3));
		System.out.println("\n");
		
		System.out.println("PRUEBA MODIFICAR UN EMPLEADO EN PROYECTO");
		emp.setProyecto(pDao.buscarUno("FOR2021001"));
		emp.setEmpleado(eDao.buscarUno(120));
		emp.setHorasAsignadas(166);
		emp.setPrecioHora(32.1);
		System.out.println(epDao.modificarUno(emp));
		//ahora comprobamos que se haya dado modificado
				for (EmpleadoEnProyecto ele: epDao.buscarTodos()) {
					System.out.println(ele);
				}
		System.out.println("\n");
		
		System.out.println("PRUEBA ELIMINAR UN EMPLEADO EN PROYECTO");
		System.out.println(epDao.eliminarUno(8));
		//ahora comprobamos que se haya eliminado
				for (EmpleadoEnProyecto ele: epDao.buscarTodos()) {
					System.out.println(ele);
				}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR EMPLEADOS EN PROYECTO POR ID PROYECTO = FOR2020001");
		for (EmpleadoEnProyecto ele: epDao.empleadoByProyecto("FOR2020001")) {
			System.out.println(ele);
		}
		System.out.println("\n");
		System.out.println("PRUEBA BUSCAR EMPLEADOS EN PROYECTO POR ID PROYECTO = FOR2021001");
		for (EmpleadoEnProyecto ele: epDao.empleadoByProyecto("FOR2021001")) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA ASIGNAR EMPLEADOS A PROYECTO");
		EmpleadoEnProyecto emp1 = new EmpleadoEnProyecto(6, pDao.buscarUno("FOR2020001"), eDao.buscarUno(120), 215, new Date(System.currentTimeMillis()), 28.9);
		EmpleadoEnProyecto emp2 = new EmpleadoEnProyecto(7, pDao.buscarUno("FOR2020001"), eDao.buscarUno(116), 158, new Date(System.currentTimeMillis()), 65.3);
		EmpleadoEnProyecto emp3 = new EmpleadoEnProyecto(8, pDao.buscarUno("FOR2020001"), eDao.buscarUno(119), 369, new Date(System.currentTimeMillis()), 36.4);
		List<EmpleadoEnProyecto> empleado = new ArrayList<>();
		empleado.add(emp1);
		empleado.add(emp2);
		empleado.add(emp3);
		System.out.println(epDao.asignarEmpleadosAProyecto(empleado));
		//comprobamos que se han añadido
			
		for (EmpleadoEnProyecto ele: epDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		// los eliminamos
		epDao.eliminarUno(6);
		epDao.eliminarUno(7);
		epDao.eliminarUno(8);
		//comprobamos que se han eliminado
		for (EmpleadoEnProyecto ele: epDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA HORAS ASIGNADAS AL PROYECTO FOR2020001");
		System.out.println(epDao.horasAsignadasAProyecto("FOR2020001"));
		System.out.println("\n");
		
		System.out.println("PRUEBA HORAS ASIGNADAS AL PROYECTO FOR2021001");
		System.out.println(epDao.horasAsignadasAProyecto("FOR2021001"));
		System.out.println("\n");
		
		System.out.println("PRUEBA COSTE ACTUAL DEL PROYECTO CON ID FOR2021001");
		System.out.println(epDao.costeActualDeProyecto("FOR2021001"));
		System.out.println("\n");
		
		System.out.println("PRUEBA COSTE ACTUAL DEL PROYECTO CON ID FOR2020001");
		System.out.println(epDao.costeActualDeProyecto("FOR2020001"));
		System.out.println("\n");
		
		System.out.println("PRUEBA MARGEN ACTUAL DEL PROYECTO CON ID FOR2021001");
		System.out.println(epDao.margenActualProyecto("FOR2021001"));
		System.out.println("\n");
		
		System.out.println("PRUEBA MARGEN ACTUAL DEL PROYECTO CON ID FOR2020001");
		System.out.println(epDao.margenActualProyecto("FOR2020001"));
		System.out.println("\n");
	}

}
