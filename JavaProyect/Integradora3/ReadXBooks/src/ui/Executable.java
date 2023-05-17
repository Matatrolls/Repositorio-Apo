package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner input;
	private Controller rXSystem;

	public Executable() {

		input = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}
//|||||||||||||||||||||||||||||||||||MENUS||||||||||||||||||||||||||||||

	private void menu() {
		System.out.println("\nBienvenido a ReadXbook");
		System.out.println("Escoja que desea hacer:");
		System.out.println("1. Menu usuarios");
		System.out.println("2. Menu productos");
		System.out.println("3. Menu Usos");
	
		int option = input.nextInt();

		switch (option) {

			case 1:
				menuUsers();
			break;

			case 2:
				menuProduct();
			break;

			case 3:
				menuUses();
			break;

			default:
				System.out.println("Esa no es una opcion!");
			break;
		}
	}

	private void menuUses() {
		System.out.println("\nEscoja que desea hacer");
		System.out.println("1. Vender Producto");
		int option = input.nextInt();
		switch (option) {

			case 1:
				sellProduct();;
			break;


			default:
				System.out.println("Esa no es una opcion!");
			break;
		}
	}

	public void menuProduct() {
		System.out.println("\nEscoja que desea hacer");
		System.out.println("1. Registrar libro");
		
		System.out.println("2. Consultar informacion registrada en el sistema");
	
		int option = input.nextInt();

		switch (option) {

			case 1:
				registerProduct();
			break;

			case 2:
				showAllProductInfo();
			break;

			default:
				System.out.println("Esa no es una opcion!");
			break;
		}
	}

	private void menuUsers() {
		System.out.println("\nEscoja que desea hacer");
		System.out.println("1. Registrar usuario");
		System.out.println("2. Modificar usuario");
		System.out.println("3. Borrar usuario");
		System.out.println("4. Consultar informacion de un usuario");
		System.out.println("5. Consultar informacion de todos los usuarios registrados");
		System.out.println("6. Salir");
		int option = input.nextInt();

		switch (option) {

			case 1:
				registerUser();
			break;
			case 2:
				modifyUser();
			break;
			case 3:
				deleteUser();
			break;
			case 4:
				showUserInfo();
			break;
			case 5:
				showAllUserInfo();
			break;
			default:
				System.out.println("Opcion invalida");
			break;
		}

	}

//|||||||||||||||||||||||||||||||||USERS||||||||||||||||||||||||||||||||||

	private void registerUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		input.nextLine();

		System.out.println("Digite la cedula");
		String id = input.nextLine();

		System.out.println("Digite el nombre");
		String name = input.nextLine();

		System.out.println("Digite el nickname");
		String nickname = input.nextLine();
		int tipeUserChoice=0;
		int categoryChoice=0;

		while(tipeUserChoice==0){
			System.out.println("Digite el tipo de usuario:\n1:Regular \n2:Premium ");
			tipeUserChoice = input.nextInt();
			switch(tipeUserChoice){
				case 1:
				
				break;
				
				case 2:
					System.out.println("Digite el rango de premium:\n1:Plata \n2:Oro \n3:Diamante");
					categoryChoice = input.nextInt();
				break;

				default:
				tipeUserChoice=0;
				System.out.println("Esa no es una opcion valida!");
				break;
			}
		}
	
		
		
		if (rXSystem.registerUser(id, name, nickname,tipeUserChoice,categoryChoice)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}
	}

	private void modifyUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a editar");

			int option = input.nextInt();

			int categoryChoice=0;
			String stringChange="";

			System.out.println("\nSeleccione a que categoria desea cambiar\n1:Nombre\n2:Nickname\n3:Categoria");
			int categoryChange = input.nextInt();
			if(categoryChange==3){
				System.out.println("\nSeleccione el rango al que desea cambiarlo \n0:Estandar\n1:Plata\n2:Oro\n3:Diamante");
				categoryChoice = input.nextInt();
			}
			else{
			System.out.println("\nEscriba su nueva eleccion");
			//limpieza buffer
			input.nextLine();
			stringChange = input.nextLine();
			}

			if (rXSystem.editUser(option - 1,categoryChange,categoryChoice,stringChange)) {

				System.out.println("\nUsuario editado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser editado");
			}

		}

	}

	private void deleteUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a borrar");

			int option = input.nextInt();

			if (rXSystem.deleteUser(option - 1)) {

				System.out.println("\nUsuario borrado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser borrado");
			}

		}

	}

	private void showUserInfo() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a consultar");

			int option = input.nextInt();

			String query2 = rXSystem.getUserInfo(option-1);

			if (query2.equals("")) {
				System.out.println("La operación no pudo realizarse");
			} else {
				System.out.println(query2);
			}

		}

	}

	private void showAllUserInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllUserInfo();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {
			System.out.println(query);
		}

	}

//||||||||||||||||||||||||||||||||PRODUCTS||||||||||||||||||||||||||||||||||||

	public void registerProduct() {

		System.out.println("Digite a continuacion la informacion de un nuevo producto");

		// Limpieza de buffer
		
		System.out.println("Digite el tipo de producto:\n1:Libro\n2:Revista");
		int choice = input.nextInt();

		input.nextLine();
		
		System.out.println("Digite el identificador. Ej.: A1F");
		String id = input.nextLine();

		System.out.println("Digite el nombre");
		String name = input.nextLine();

		System.out.println("Digite el numero de paginas");
		int pagesNumber = input.nextInt();
		
		System.out.println("Digite la fecha de publicacion.Ej:01/01/2000");
		String publicationDate = input.nextLine();

		input.nextLine();
		System.out.println("Digite la url. Ej: Ejemplo.png");
		String url = input.nextLine();

		System.out.println("Digite la cantidad de paginas leidas. Ej: 1234567897654321L , ponga la L si el valor es muy alto");
		long readedPages = input.nextLong();

		switch(choice){

			case 1:

				input.nextLine();
				System.out.println("Digite la resenia");
				String review = input.nextLine();

				System.out.println("Digite el tipo de genero. \n1. Ciencia Ficcion \n2. Fantasia \n3. Novela historica");
				int genre = input.nextInt();
				System.out.println("Digite el valor de venta");
				double price = input.nextDouble();
				System.out.println("Digite las unidades vendidas. Ej:123456753241D, ponga la D si el valor es muy grande");
				double unitsSold = input.nextDouble();

				if (rXSystem.registerBook(id, name,pagesNumber, review,publicationDate,genre,url, price,unitsSold,readedPages)) {

					System.out.println("Libro registrado exitosamente");
		
				} else {
		
					System.out.println("Memoria llena, no se pudo registrar el libro");
				}
			break;

			case 2:
			input.nextLine();
			System.out.println("Digite el tipo de categoria. \n1.Variedades \n2. Disenio \n3. Cientifica");
			int category = input.nextInt();
			System.out.println("Digite la periodicidad de publicacion.Ej: Mensual");
			String publicationPeriodicity = input.nextLine();
			System.out.println("Digite el valor de suscripcion");
			double suscriptionPrice = input.nextDouble();
			System.out.println("Digite las suscripciones activas. Ej:123456753241D, ponga la D si el valor es muy grande");
			double activeSuscriptions = input.nextDouble();

			if (rXSystem.registerMagazine(id, name, pagesNumber, category, publicationDate, publicationPeriodicity, url, suscriptionPrice, activeSuscriptions, readedPages)) {

				System.out.println("Revista registrada exitosamente");
	
			} else {
	
				System.out.println("Memoria llena, no se pudo registrar la revista");
			}
			break;
		}

	}

	private void sellProduct() {

		String productQuery = rXSystem.getProductList();

		if (productQuery.equals("")) {

			System.out.println("No hay productos registrados");
		} else {

			System.out.println("\nEste es el listado de productos registrados en el sistema");

			System.out.println(productQuery);

			System.out.println("\nSeleccione el producto a vender");

			int productOption = input.nextInt();

			String Userquery = rXSystem.getUserList();
			System.out.println(Userquery);

			int userOption=1;
			if (Userquery.equals("")) {

				System.out.println("No hay Usuarios registrados");
			} else {

				System.out.println("\nSeleccione el usuario a vender");

				userOption = input.nextInt();

			}
			if (rXSystem.sellProduct(productOption - 1,userOption-1)) {

				System.out.println("\nTransaccion realizada exitosamente");

			} else {

				System.out.println("\nError en la transaccion");
			}

		}

	}

	public void showAllProductInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllKProductInfo();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}

}

