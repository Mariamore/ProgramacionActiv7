package testing.javabean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.javabean.Proyectos;


public class TestingProyectos {
	
	public static void main(String[] args) throws ParseException {
		
		Proyectos proye = new Proyectos(); //Creamos el objeto

		/*
		 *	margenPrevisto():double. Importe de venta – coste previsto
			margenReal(): double Importe de venta – gastos reales
			diferenciaGastos(): double. Gasto real – gasto previsto
			diferenciaFinPrevistoReal(): int . Días entre fin previsto y fin real
		 */
		
		System.out.println("PRUEBAS PARA LOS METODOS DE LA CLASE PROYECTOS");
		System.out.println("======================================================================");
		
		System.out.println("Prueba metodo margenPrevisto()");
		 proye.setVentaPrevisto(48500.00);	
		 proye.setCostesPrevisto(15000.00);
		 
		System.out.println("El margen previsto es : " + proye.margenPrevisto());
		
		System.out.println("======================================================================");
		System.out.println("Prueba metodo margenreal()");
		
		proye.setVentaPrevisto(58500.00); 
		proye.setCosteReal(5000);
		
		System.out.println("El margen es: " + proye.margenReal());
		
		System.out.println("======================================================================");
		System.out.println("Prueba metodo diferenciaGastos()");
		
		proye.setCosteReal(800000);
		proye.setCostesPrevisto(750000);
		
		System.out.println("La diferencia de gastos es: " + proye.diferenciaGastos());
		
		System.out.println("======================================================================");
		System.out.println("Prueba metodo diferenciaFinPrevistoReal()");
		
	/*
	 * 
	 */
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
		
		Date fechaFinPrevisto = new Date();
		Date fechaInicio = new Date();
		
		fechaFinPrevisto= sdf.parse("2022-03-08");
		fechaInicio = sdf.parse("2021-03-08");
		
		
		
		
		proye.diferenciaFinPrevistoReal();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			Date fechaFinPrevisto = sdf.parse("2023-02-21");
			Date fechaInicio= sdf.parse("2022-02-21");
			
			long dias = fechaFinPrevisto.getTime()-fechaInicio.getTime(); 
			
			TimeUnit diasTotal = TimeUnit.DAYS;
			
			long tiempoTranscurrido = diasTotal.convert(dias,TimeUnit.MILLISECONDS);
			System.out.println(tiempoTranscurrido);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
	}
	
}

