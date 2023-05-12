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
		
	}

	public void menuLibros() {
		System.out.println("\nEscoja que desea hacer");
		System.out.println("1. Registrar libro");
		System.out.println("2. Vender libro");
		System.out.println("3. Consultar informacion registrada en el sistema");
	
		int option = input.nextInt();

		switch (option) {

			case 1:
				registerBook();
			break;

			case 2:
				sellBook();
			break;

			case 3:
				showAllBookInfo();
			break;

			default:
				System.out.println("Esa no es una opcion!");
			break;
		}
	}

	private void menuUsuarios() {
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

//||||||||||||||||||||||||||||||||BOOKS||||||||||||||||||||||||||||||||||||

	public void registerBook() {

		System.out.println("Digite a continuacion la informacion de un nuevo libro");

		// Limpieza de buffer
		input.nextLine();
		
		System.out.println("Digite el identificador. Ej.: A1F");
		String id = input.nextLine();

		System.out.println("Digite el nombre");
		String name = input.nextLine();

		System.out.println("Digite el tipo de genero. \n1. Ciencia Ficcion \n2. Fantasia \n3. Novela historica");
		int genre = input.nextInt();

		System.out.println("Digite el valor de venta");
		double price = input.nextDouble();

		if (rXSystem.registerBook(id, name, genre, price)) {

			System.out.println("Libro registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el libro");
		}
	}

	private void sellBook() {

		String query = rXSystem.getBookList();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {

			System.out.println("\nEste es el listado de libros registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el libro a vender");

			int option = input.nextInt();

			if (rXSystem.sellBook(option - 1)) {

				System.out.println("\nTransaccion realizada exitosamente");

			} else {

				System.out.println("\nError en la transaccion");
			}

		}

	}

	public void showAllBookInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllKBookInfo();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}
}

