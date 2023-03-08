package testingDaoImplMy8;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.ProyectosConEmpleadosDao;
import modelo.daojdbc.ProyectosConEmpleadosDaoImplMy8;
import modelo.javabean.Empleados;
import modelo.javabean.ProyectoConEmpleados;

public class TestingProyectosConEmpleadosImplMy8 {

	public static void main(String[] args) {
		
		
		ProyectosConEmpleadosDao proyempao = new ProyectosConEmpleadosDaoImplMy8();
		
		System.out.println("==============================================================");
		System.out.println("Prueba para empleados en proyecto ");
		System.out.println(proyempao.empleadosByProyecto("FOR2020001"));
		/*
		 * Prueba saber los empleados que contiene cada proyecto a partir del id_proyecto
		 */
		
		
		System.out.println("==============================================================");
		System.out.println("Prueba: Suma de las horas, de los empleados asignados al proyecto. ");
		
		System.out.println(proyempao.horasAsignadasAProyecto("FOR2020001")+ "Horas");
		
		
		
		System.out.println("==============================================================");
		System.out.println(proyempao.costeActualdeProyecto("FOR2020001"));
		
		
	
		


		
	}

}
