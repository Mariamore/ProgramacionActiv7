package testing;

import javabeans.EmpleadoEnProyecto;


public class TestEmpleadoEnProyecto {

	public static void main(String[] args) {
		
		EmpleadoEnProyecto empProy = new EmpleadoEnProyecto();
		
		System.out.println("PRUEBA COSTE HORAS ASIGNADAS");
		
		System.out.println(empProy.costeHorasAsignadas());
		System.out.println("\n");
		
		//Lo probamos para el número de orden 1
	
		System.out.println(empProy.costeHorasAsignadas(1));
		System.out.println("\n");
		
		//Lo probamos para el número de orden 2
		
		System.out.println(empProy.costeHorasAsignadas(2));
		System.out.println("\n");
		
		//Lo probamos para el número de orden 3
		
		System.out.println(empProy.costeHorasAsignadas(3));
		System.out.println("\n");
		
		//Lo probamos para el número de orden 4
		
		System.out.println(empProy.costeHorasAsignadas(4));
		System.out.println("\n");
	}

}
