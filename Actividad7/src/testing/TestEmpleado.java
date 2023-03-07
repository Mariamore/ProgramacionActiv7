package testing;

import javabeans.Empleado;

public class TestEmpleado {

	public static void main(String[] args) {
		Empleado emp = new Empleado();
		//seleccionamos un empleado de la tabla
		emp.setIdEmpl(101);
		System.out.println("PRUEBA MÉTODO salarioBruto()");
		System.out.println(emp.salarioBruto());
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO salarioMensual()");
		System.out.println(emp.SalarioMensual(12));
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO nombreCompleto()");
		System.out.println(emp.nombreCompleto());
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO literalSexo()");
		System.out.println(emp.literalSexo());
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO obtenerEmail()");
		System.out.println(emp.obtenerEmail());

	}

}
