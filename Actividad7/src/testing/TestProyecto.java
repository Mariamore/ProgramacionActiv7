package testing;

import javabeans.Proyecto;

public class TestProyecto {

	public static void main(String[] args) {
		Proyecto proy = new Proyecto();
		proy.setIdProyecto("FOR2020001");
		System.out.println("PRUEBA MÉTODO MARGEN PREVISTO");
		System.out.println(proy.margenPrevisto());
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO MARGEN REAL");
		System.out.println(proy.margenReal());
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO DIFERENCIA GASTOS");
		System.out.println(proy.diferenciaGastos());
		System.out.println("\n");
		
		System.out.println("PRUEBA MÉTODO DIFERENCIA FECHA");
		proy.setIdProyecto("FOR2021001");
		System.out.println(proy.diferenciaFinPrevistoReal());
	}

}
