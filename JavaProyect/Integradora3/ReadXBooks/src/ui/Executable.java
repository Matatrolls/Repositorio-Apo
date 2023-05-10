package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner input;
	private Controller shop;

	public Executable() {

		input = new Scanner(System.in);
		shop = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	public void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("\n1. Registrar libro");
			System.out.println("2. Vender libro");
			System.out.println("3. Consultar informacion registrada en el sistema");
			System.out.println("4. Salir");
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

			case 4:
				flag = true;
				break;

			}

		}

	}

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

		if (shop.registerBook(id, name, genre, price)) {

			System.out.println("Libro registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el libro");
		}
	}

	private void sellBook() {

		String query = shop.getBookList();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {

			System.out.println("\nEste es el listado de libros registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el libro a vender");

			int option = input.nextInt();

			if (shop.sellBook(option - 1)) {

				System.out.println("\nTransaccion realizada exitosamente");

			} else {

				System.out.println("\nError en la transaccion");
			}

		}

	}

	public void showAllBookInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = shop.getAllKBookInfo();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}

}