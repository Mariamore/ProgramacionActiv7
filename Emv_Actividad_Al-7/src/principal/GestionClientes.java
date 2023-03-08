package principal;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.daojdbc.ClienteDaoImplMy8;
import modelo.javabean.Clientes;

public class GestionClientes {

	public static void main(String[] args) {
		
		 ClienteDaoImplMy8 met = new ClienteDaoImplMy8();
		 Clientes cliente = new Clientes();
		
		
		  Scanner leer= new Scanner (System.in);
			int opcion = 0;
			String cif;
			String nombre;
			String apellidos, domicilio;
			double facturacionAnual;
			int idEmpl;
			
			
			
			
			opcion = pintarMenu();
			
			
			while(opcion !=5) {
			
				switch(opcion) {
				case 1:
			System.out.println("Alta Cliente: ");
			System.out.println("Introduzca cif, nombre, apellidos, domicilio, facturacion y numero empleado");
			System.out.println(met.altaClientes(cliente = new Clientes(cif=leer.next(),nombre=leer.next(), 
												apellidos=leer.next(), domicilio=leer.next(), facturacionAnual=leer.nextDouble(),
												idEmpl=leer.nextInt())));
					break;
				case 2:
					System.out.println("Buscar uno, introduzca el cif :");
					System.out.println(met.buscarUno(cif = leer.next()));
					break;
				case 3:
					System.out.println("Buscar todos : ");
					System.out.println(met.bucarTodos());
					break;
				case 4:
					System.out.println("Eliminar, introduzaca cif : ");
					System.out.println(met.eliminarUno(cif = leer.next()));
					break;
				default:
					System.out.println("opcion erronea ...");
				}
				opcion = pintarMenu();
			}

			System.out.println("FIN DE PROGRAMA");
	}		


	public static int pintarMenu() {
		
		Scanner leer= new Scanner (System.in);
		int opcion = 0;
		System.out.println("1.-Alta Cliente");
		System.out.println("2.-Buscar Cliente");
		System.out.println("3.-Mostrar Todos");
		System.out.println("4.-Eliminar Cliente");
		System.out.println("5.- Salir");
		System.out.println("teclea una opn del 1 al 4, 5 para salir");
		opcion = leer.nextInt();
		
		while(opcion<1 || opcion > 5) {
			System.out.println("del 1 al 5");
			opcion = leer.nextInt();
		}
		
		return opcion;
	}
	
	
	
	
	
	
}
