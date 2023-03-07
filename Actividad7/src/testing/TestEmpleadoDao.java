package testing;



import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javabeans.Departamento;
import javabeans.Empleado;
import javabeans.Perfil;
import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8;

public class TestEmpleadoDao {

	public static void main(String[] args) {
		EmpleadoDao eDao = new EmpleadoDaoImplMy8();
		PerfilDao pDao = new PerfilDaoImplMy8();
		DepartamentoDao dDao = new DepartamentoDaoImplMy8();
		
		System.out.println("PRUEBA DAR DE ALTA UN EMPLEADO");
		Perfil pf1 = pDao.buscarUno(2);
		Departamento dp1 = dDao.buscarUno(30);
		String fechaNac = "1984-10-30";
		Date fechaUtil = Date.valueOf(fechaNac);
		Empleado emp1 = new Empleado(60, "Ana", "Casas", "M", "acasas@tt.es", "ana", 56000, new Date(System.currentTimeMillis()),
			fechaUtil, pf1, dp1);
		
		System.out.println(eDao.altaEmpleado(emp1));
		//comprobamos que se ha dado de alta
		for (Empleado ele: eDao.buscarTodos()) {
					System.out.println(ele);
		}	
		System.out.println("\n");
		
		System.out.println("PRUEBA MODIFICAR UN EMPLEADO");
		emp1.setNombre("Elena");
		emp1.setApellidos("Alonso");
		emp1.setEmail("ealonso@tt.es");
		emp1.setPassword("elena");
		emp1.setSalario(65230);
		String fechaNac1 = "1991-03-02";
		Date fechaUtil1 = Date.valueOf(fechaNac1);
		emp1.setFechaNacimiento(fechaUtil1);
		eDao.modificarUno(emp1);
		//comprobamos que se ha modificado
		for (Empleado ele: eDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR TODOS");
		for (Empleado ele: eDao.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA ELIMINAR UN EMPLEADO");
		System.out.println(eDao.eliminarUno(60));
		//comprobamos que se ha eliminado
		for (Empleado ele: eDao.buscarTodos()) {
				System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA BUSCAR UN EMPLEADO POR SU ID");
		System.out.println(eDao.buscarUno(117) + "\n");
		
		System.out.println("BUSCAR EMPLEADOS POR ID DEPARTAMENTO");
		for (Empleado ele: eDao.empleadosByDepartamento(20)) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("BUSCAR EMPLEADOS POR APELLIDO");
		for (Empleado ele: eDao.empleadosByApellido("Himuro")) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO SALARIO TOTAL");
		System.out.println(eDao.salarioTotal());
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO SALARIO TOTAL POR ID DEPARTAMENTO");
		System.out.println(eDao.salarioTotal(10));
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO BUSCAR POR GÉNERO HOMBRES");
		for (Empleado ele: eDao.empleadosBySexo("H")) {
			System.out.println(ele);
		}
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO BUSCAR POR GÉNERO MUJERES");
		for (Empleado ele: eDao.empleadosBySexo("M")) {
			System.out.println(ele);
		}
		
	}

}
