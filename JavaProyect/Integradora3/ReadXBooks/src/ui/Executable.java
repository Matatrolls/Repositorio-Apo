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

	/**
	 * The main function creates an instance of the Executable class and calls its menu method.
	 */
	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}
//|||||||||||||||||||||||||||||||||||MENUS||||||||||||||||||||||||||||||

	/**
	 * This function displays a menu with options for managing users, products, and uses, and allows the
	 * user to select an option or exit the menu.
	 */
	public void menu() {
		boolean indicator=false;
	
		while(!indicator){
			System.out.println("\nBienvenido a ReadXbook");
			System.out.println("Escoja que desea hacer:");
			System.out.println("1. Menu usuarios");
			System.out.println("2. Menu productos");
			System.out.println("3. Menu Usos");
			System.out.println("0. Salir");
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

				case 0:
					indicator=true;
				break;


				default:
					System.out.println("Esa no es una opcion!");
				break;
			}
		}
	}

	/**
	 * This function displays a menu with options to sell a product, read a product, or view reports and
	 * executes the corresponding function based on the user's choice.
	 */
	public void menuUses() {
		System.out.println("\nEscoja que desea hacer");
		System.out.println("1. Vender Producto");
		System.out.println("2. Leer Producto");
		System.out.println("3. Reportes");
		int option = input.nextInt();
		switch (option) {

			case 1:
				sellProduct();
			break;

			case 2:
				readProduct();
			break;

			case 3:
				menuReports();
			break;

			default:
				System.out.println("Esa no es una opcion!");
			break;
		}
	}

	/**
	 * This function displays a menu of options for generating reports on the total pages read, most read
	 * genre and category, book sales, and subscription sales.
	 */
	public void menuReports() {
		System.out.println("\nEscoja que desea hacer");
		System.out.println("1. Acumulado total de páginas leídas en toda la plataforma");
		System.out.println("2. Informar el género de libro y categoría de revista más leídas en la plataforma");
		System.out.println("3.  Numero de libros vendidos y el valor total de ventas");
		System.out.println("4.  Numero de suscripciones activas y el valor total pagado por suscripciones");
		int option = input.nextInt();
		switch (option) {

			case 1:
				totalReadPages();
			break;

			case 2:
				mostReadGenreAndCategory();
			break;


			case 3:
				sellingsByGenre();
			break;

			case 4:
				sellingsByCategory();
			break;

			default:
				System.out.println("Esa no es una opcion!");
			break;
		}
	}

	/**
	 * This function displays a menu with options to register a product, show all product information, or
	 * modify a product.
	 */
	public void menuProduct() {
		System.out.println("\nEscoja que desea hacer");
		System.out.println("1. Registrar libro");
		System.out.println("2. Consultar informacion registrada en el sistema");
		System.out.println("3. Modificar producto registrado en el sistema");
	
		int option = input.nextInt();

		switch (option) {

			case 1:
				registerProduct();
			break;

			case 2:
				showAllProductInfo();
			break;

			case 3:
				modifyProduct();
			break;

			default:
				System.out.println("Esa no es una opcion!");
			break;
		}
	}

	/**
	 * This function displays a menu for managing user information and performs the selected action based
	 * on user input.
	 */
	public void menuUsers() {
		System.out.println("\nEscoja que desea hacer");
		System.out.println("1. Registrar usuario");
		System.out.println("2. Modificar usuario");
		System.out.println("3. Borrar usuario");
		System.out.println("4. Consultar informacion de un usuario");
		System.out.println("5. Consultar informacion de todos los usuarios registrados");
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
/**
 * This Java function registers a new user by prompting the user to input their personal information
 * and type of user, and then calls a method to register the user in a system.
 */
	public void registerUser() {

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

	/**
	 * This function allows the user to modify an existing user's name, nickname, or category in a system.
	 */
	public void modifyUser() {

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

	/**
	 * This function allows the user to delete a registered user from the system.
	 */
	public void deleteUser() {

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

	/**
	 * This function displays a list of registered users in the system and allows the user to select a
	 * user to view their information.
	 */
	public void showUserInfo() {

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

	/**
	 * This function displays all the user information registered in the system.
	 */
	public void showAllUserInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllUserInfo();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {
			System.out.println(query);
		}

	}

//||||||||||||||||||||||||||||||||PRODUCTS||||||||||||||||||||||||||||||||||||

	/**
	 * This function registers a new product (either a book or a magazine) by prompting the user for
	 * information and calling the appropriate method in the rXSystem object.
	 */
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


		switch(choice){

			case 1:

				input.nextLine();
				System.out.println("Digite la resenia");
				String review = input.nextLine();

				System.out.println("Digite el tipo de genero. \n1. Ciencia Ficcion \n2. Fantasia \n3. Novela historica");
				int genre = input.nextInt();
				System.out.println("Digite el valor de venta");
				double price = input.nextDouble();

				if (rXSystem.registerBook(id, name,pagesNumber, review,publicationDate,genre,url, price)) {

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


			if (rXSystem.registerMagazine(id, name, pagesNumber, category, publicationDate, publicationPeriodicity, url, suscriptionPrice)) {

				System.out.println("Revista registrada exitosamente");
	
			} else {
	
				System.out.println("Memoria llena, no se pudo registrar la revista");
			}
			break;
		}

	}

	/**
	 * This function allows the user to modify a product in the system by selecting the product and
	 * choosing which category to change and what to change it to.
	 */
	public void modifyProduct() {

		String query = rXSystem.getProductList();

		if (query.equals("")) {

			System.out.println("No hay productos registrados");
		} else {

			System.out.println("\nEste es el listado de productos registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el producto a editar");

			int option = input.nextInt();

			int categoryChoice=0;
			String stringChange="";

			System.out.println("\nSeleccione a que categoria desea cambiar\n1:Nombre\n2:Numero de paginas\n3:Fecha de publicacion\n=========Especificos de tipo=========\n4:Categoria/Genero\n5:Periodicidad de publicacion/Review\n6:Precio de suscripcion/Precio\n7:Suscripciones activas/Unidades vendidas");
			int categoryChange = input.nextInt();
			if(categoryChange==4){
				System.out.println("\nSeleccione la/el categoria/genero al que desea cambiarlo \n1:Cientifica/Ciencia ficcion\n2:Disenio/Fantasia\n3:Variedades/novela historica");
				categoryChoice = input.nextInt();
			}
			else{
			System.out.println("\nEscriba su nueva eleccion");
			//limpieza buffer
			input.nextLine();
			stringChange = input.nextLine();
			}

			if (rXSystem.editProduct(option - 1,categoryChange,categoryChoice,stringChange)) {

				System.out.println("\nProducto editado exitosamente");

			} else {

				System.out.println("\nError, el producto no pudo ser editado");
			}

		}

	}

	/**
 * This function allows the user to sell a product by selecting it from a list and choosing a user to
 * sell it to.
 */
	public void sellProduct() {

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

				System.out.println("\nError en la transaccion, su usuario ya tiene la cantidad maxima");
			}

		}

	}

	/**
	 * This Java function displays all the product information registered in the system.
	 */
	public void showAllProductInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllKProductInfo();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}

//||||||||||||||||||||||||||||USES|||||||||||||||||||||||

	/**
	 * This function reads a product from a product library based on user input.
	 */
	public void readProduct() {
		String Userquery = rXSystem.getUserList();
		System.out.println(Userquery);

		int userOption=1;
		if (Userquery.equals("")) {

			System.out.println("No hay Usuarios registrados");
		} else {

			System.out.println("\nSeleccione el usuario con el que leera");

			userOption = input.nextInt();

		}


		String productQuery = rXSystem.getProductLibrary(userOption-1);
		System.out.println("\n==================BIBLIOTECA====================");
		System.out.println(productQuery);
		System.out.println("\nSeleccione el producto a leer");
		String choiceID;
		
		input.nextLine();
		int x = input.nextInt();
		int y = input.nextInt();
		choiceID =rXSystem.getProductFromMatrix(userOption-1, x-1, y-1);
		readingProduct(userOption-1, choiceID);	
	}

	/**
	 * This function allows the user to read a product, navigate through its pages, and return to the
	 * library or main menu.
	 * 
	 * @param userOption The user's selected option for reading a product, such as reading a book or a
	 * magazine. It could be an integer value representing the option chosen from a menu.
	 * @param choiceID The ID of the product that the user wants to read.
	 */
	public void readingProduct(int userOption,String choiceID) {
		String choice="";
		boolean indicator=false;
		int counter = 1;
		System.out.println(rXSystem.readProduct(choiceID, userOption, counter));
		System.out.println("Ingrese A para la pagina Anterior");
		System.out.println("Ingrese S para la pagina Siguiente");
		System.out.println("Ingrese B para la biblioteca");
		System.out.println("Ingrese E para salir");
		input.nextLine();
		while(!indicator){
			
			choice = input.nextLine();
			choice=choice.toUpperCase();
			switch(choice){

				case "A":
				counter--;
				
				System.out.println(rXSystem.readProduct(choiceID, userOption, counter));
				break;

				case "S":
				counter++;
				System.out.println(rXSystem.AddReadedPagesProduct(choiceID, userOption));
				System.out.println(rXSystem.readProduct(choiceID, userOption, counter));
				break;

				case "B":
				indicator=true;
				readProduct();
				break;

				case "E":
				indicator=true;
				menu();
				break;
				
				default:
				break;
			}
			System.out.println("Ingrese A para la pagina Anterior");
			System.out.println("Ingrese S para la pagina Siguiente");
			System.out.println("Ingrese B para la biblioteca");
			System.out.println("Ingrese E para salir");

		}
		
	}


//||||||||||||||||||||||||||||REPORTS||||||||||||||||||||||||||||||||

/**
 * This function prints out the sales by category in a retail system.
 */
public void sellingsByCategory() {
	System.out.println(rXSystem.sellingsByCategory());
}

/**
 * This function prints the sales data by genre in a Java program.
 */
public void sellingsByGenre() {
	System.out.println(rXSystem.sellingsByGenre());
	
}


/**
 * This function prints the most read genre and category in a system.
 */
public void mostReadGenreAndCategory() {
	System.out.println(rXSystem.mostReadGenreAndCategory());
	
}

/**
 * This Java function prints the total number of read pages using the rXSystem object.
 */
public void totalReadPages() {
	System.out.println(rXSystem.totalReadPages());
	
}
}

