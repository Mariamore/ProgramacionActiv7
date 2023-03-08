package testingDaoImplMy8;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import modelo.dao.DepartamentosDao;
import modelo.dao.EmpleadosDao;
import modelo.dao.PerfilesDao;
import modelo.daojdbc.DepartamentosDaoImplMy8;
import modelo.daojdbc.EmpleadosDaoImplMy8;
import modelo.daojdbc.PerfilesDaoImplMy8;
import modelo.javabean.Departamentos;
import modelo.javabean.Empleados;
import modelo.javabean.Perfiles;

public class TestEmpleadoDaoImpl8 {

	public static void main(String[] args) {

		/*
		 * Creamos una variable de tipo Interface e implementamos
		 */
		
		EmpleadosDao edao= new EmpleadosDaoImplMy8();
		PerfilesDao pdao = new PerfilesDaoImplMy8();
		DepartamentosDao dpo = new DepartamentosDaoImplMy8();
		
		
		/*
		 * testing empleado para buscar uno.
		 * 
		 * Si la sentencia la vamos a ejecutar mas de una vez, cogemos una variable del tipo 
		 * que devuelve y utlilizamos esa variable, asi optimizamos y solo tenemos que ir 
		 * una vez. (siempre y cuando sea la misma sentencia) 
		 * 
		 */
		System.out.println("====================================================================");
		System.out.println("Prueba buscar un empleado por idEmpl");
		
		//Prueba para el empleado con idEmpl=100
		Empleados emp = edao.buscarUno(100);
		
		if(emp != null) {
		System.out.println(emp);
		System.out.println(emp.getApellidos());
		}else System.out.println("Empleado no encontrado"); 
		
		/*
		 * Tirando del toString nos muestra todo, pero podriamos poner lo que queremos que nos 
		 * muestre, en este cado lo vamos a probar con los apellidos del idEmpl 100
		
		 */
		System.out.println("====================================================================");
		System.out.println("Prueba para LISTAR todos los empleados");
		for (Empleados ele: edao.bucarTodos()) {
			System.out.println(ele);
		}
		
		System.out.println("====================================================================");
		System.out.println("Prueba para dar de alta un empleado");
		
		
		Perfiles pf = pdao.buscarUno(4);
		Departamentos dp = dpo.buscarUno(10);
		
		String fechaIngreso ="2022-03-06";
		String fechaNacimiento="1995-08-16";
		
		Date fechaIn = Date.valueOf(fechaIngreso);//convertimos con valueOf 
		Date fechaNa = Date.valueOf(fechaNacimiento);
		
		
		Empleados emple = new Empleados(500,"ana","medina","M","ana","ana@tt.com",45000.00,
				fechaIn, fechaNa,dp,pf);
	
		
		edao.altaEmpleados(emple);
		
		//Buscamosde nuevo todos los empleados para ver que se ha insertado correctamente
		
		for (Empleados ele: edao.bucarTodos()) {
			System.out.println(ele);
		}
		
		
		
		System.out.println("====================================================================");
		System.out.println("Prueba de eliminar empleado pasandole el id_empl=500");
		
		System.out.println(edao.eliminarUno(120));
		/* Volvemos a mostrar todos los empleados para aseguranos que hemos eliminado al empleado
		 * con idEmpl 120.
		*/
		for (Empleados ele: edao.bucarTodos()) {
			System.out.println(ele);
		}
		
		
		System.out.println("====================================================================");
		System.out.println("Prueba de modifificar un dato de empleado");
		
		Empleados emp1 = edao.buscarUno(500);
		
		
		emp1.setNombre("Julia");
		emp1.setApellidos("Loro");
		emp1.setSexo("M");
		emp1.setEmail("loroJulia@empl.com");
		emp1.setPassword("lorito");
		emp1.setSalario(25000.00);
		
		String fechaIngre ="2020-03-06";
		String fechaNacimto="1997-08-16";
		
		Date fechaI = Date.valueOf(fechaIngre);//convertimos con valueOf 
		Date fechaN = Date.valueOf(fechaNacimto);
		
		emp1.setFechaIngreso(fechaI);
		emp1.setFechaNacimiento(fechaN);
		
		edao.modificarUno(emp1);;
		
		/*
		 * volvemos a sacar todos los empleados para ver si la modificacion es correcta
		 */
		
		for (Empleados ele: edao.bucarTodos()) {
			System.out.println(ele);
		}
		
		
		/*
		 * Hacemos las pruebas de buscar un empleado por apellido, en este caso 
		 */
		System.out.println("====================================================================");
		System.out.println("Prueba de buscar empleados por Apellido, el apellido buscado es Diaz");
		
		Empleados emple1 = new Empleados(); 
		emple1.setApellidos("diaz");
		String subcadena = emple1.getApellidos();
	
		
		for (Empleados ele: edao.empleadosByApellido(subcadena)) {
			System.out.println(ele);
		}	
		
		/*
		 * Prueba: Buscar empleados pasandole un departamento, en este caso el departamento 10 y 20
		 * que son los que tienen empelados.
		 * Si pusiesemos un departamento que no existe nos devolvería la lista vacía.
		 */
		System.out.println("====================================================================");
		System.out.println("Prueba buscar empleados pasandole un departamento");
		
		System.out.println("Empleados del Departamento id_depar =10");
		for (Empleados ele: edao.empleadosByDepartamento(10)) {
			System.out.println(ele);
		}	
		
		System.out.println("Empleados del Departamento id_depar =20");
		for (Empleados ele: edao.empleadosByDepartamento(20)) {
			System.out.println(ele);
		}	
			
		/*
		 * Prueba para buscar empleados pasandole el genero, en esta rueba probaremos con 
		 * el genero = "H"
		 */
		System.out.println("====================================================================");
		System.out.println("Prueba buscar empleados pasandole el sexo");
		
		
		for (Empleados ele: edao.empleadosBySexo("H")) {
			System.out.println(ele);
		}
		
		
		
		System.out.println("====================================================================");
		System.out.println("Prueba para buscar el salario total de la tabla empleados");
		
		System.out.println(edao.salario());
		
		
		System.out.println("====================================================================");
		System.out.println("Prueba para buscar el salario total de la tabla empleados");
		
		System.out.println(edao.salarioTotal(20));
		
		
		
		
		
}
}