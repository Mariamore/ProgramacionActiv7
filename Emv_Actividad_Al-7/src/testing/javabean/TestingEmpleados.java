package testing.javabean;

import java.text.SimpleDateFormat;
import java.util.Date;

import modelo.javabean.Departamentos;
import modelo.javabean.Empleados;
import modelo.javabean.Perfiles;

public class TestingEmpleados {

	public static void main(String[] args) {

		


		Empleados emp = new Empleados(); //Creamos el objeto
		
		System.out.println("PRUEBAS PARA LOS METODOS DE LA CLASE EMPLEADOS");
		System.out.println("======================================================================");
		System.out.println("Probamos el metodo salarioBruto()");
		
		emp.setSalario(45000); // Añadimos el salario con el metodo setSalario
		System.out.println(emp.salarioBruto());
		
		System.out.println("======================================================================");
		System.out.println("Prueba metodo salarioMensual()");
		
	
		emp.salarioMensual();
		
		System.out.println("======================================================================");
		System.out.println("Prueba metodo literalSexo");
		
		emp.setSexo("H"); //Añadimos el sexo con el metodo setSexo
		System.out.println("Es un@ : " + emp.literalSexo());
		
	
		System.out.println("======================================================================");
		System.out.println("Prueba del metodo nombreCompleto()");
		
		emp.setNombre("Angel"); //añadimos nombre
		emp.setApellidos("merino");// añadimos apellido
		
		System.out.println("El nombre completo: " + emp.nombreCompleto());
		
		System.out.println("======================================================================");
		System.out.println("Prueba del metodo  obtenerEmail");
		
		System.out.println(emp.obtenerEmail());
		
	
		
		
		
		
		
		
		
	}

}
