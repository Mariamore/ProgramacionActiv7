package principal;

import java.util.Scanner;

import javabeans.Cliente;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8;

public class GestionClientes {
	private static Scanner leer;
	static {
		leer = new Scanner(System.in);
	}
	public static void main(String[] args) {
		int opcion = 0;
		String cif, nombre, apellidos, domicilio, cif1, cif2;
		double facturacionAnual;
		int numeroEmpleados;
		opcion = pintarMenu();
		
		while (opcion != 5) {
			ClienteDao cdao = new ClienteDaoImplMy8();
			Cliente cliente = new Cliente();
			switch (opcion) {
			case 1:
				System.out.println("Introduce el cif del cliente");
				cif = leer.next() + leer.nextLine();
				cliente.setCif(cif);
				System.out.println("Introduce el nombre del cliente");
				nombre = leer.next() + leer.nextLine();
				cliente.setNombre(nombre);
				System.out.println("Introduce los apellidos del cliente");
				apellidos = leer.nextLine();
				cliente.setApellidos(apellidos);
				System.out.println("Introduce el domicilio del cliente");
				domicilio = leer.nextLine();
				cliente.setDomicilio(domicilio);
				System.out.println("Introduce la facturación anual del cliente");
				facturacionAnual = leer.nextDouble();
				cliente.setFacturacionAnual(facturacionAnual);
				System.out.println("Introduce el número de empleados del cliente");
				numeroEmpleados = leer.nextInt();
				cliente.setNumeroEmpleados(numeroEmpleados);
				
				cdao.altaCliente(cliente);
				break;
			case 2:
				System.out.println("Introduce el cif del cliente a buscar");
				cif1 = leer.next();
				System.out.println(cdao.buscarUno(cif1));
				break;
			case 3:
				for (Cliente ele: cdao.buscarTodos()) {
					System.out.println(ele);
				}
				break;
			case 4:
				System.out.println("Introduce el cif del cliente a eliminar");
				cif2 = leer.next() + leer.nextLine();
				System.out.println(cdao.eliminarUno(cif2));
				break;
			default:
				System.out.println("Introduce una opción válida.");
			}
			opcion = pintarMenu();
		}
		System.out.println("---FIN DEL PROGRAMA---");
	}

	
	public static int pintarMenu() {
		int opcion  = 0;
		System.out.println("--- MENÚ ---");
		System.out.println("1. Alta del cliente");
		System.out.println("2. Buscar un cliente");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Eliminar un cliente");
		System.out.println("5. Salir");
		
		opcion = leer.nextInt();
		
		while (opcion < 1 || opcion > 5) {
			System.out.println("Escoge una opción del 1 al 5");
			opcion = leer.nextInt();
		}
		
		return opcion;
	}
}

	