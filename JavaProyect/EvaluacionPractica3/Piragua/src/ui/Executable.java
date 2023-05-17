package ui;

import java.util.Scanner;

import model.Controller;

public class Executable {

	public Scanner reader;
	public Controller controller;

	public static void main(String[] args) {
		Executable piragua = new Executable();
		piragua.showMainMenu();
	}

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public void showMainMenu() {

		System.out.println("Bienvenido a Piragua");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nDigite una opcion");
			System.out.println("1. Registrar una Propiedad");
			System.out.println("2. Reservar un Hospedaje");
			System.out.println("0. Salir");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 1:
				registerProperty();
				break;
			case 2:
				bookProperty();
				break;
			case 0:
				System.out.println("Gracias por usar el sistema");
				stopFlag = true;
				break;
			default:
				System.out.println("Por favor digite una opcion valida");
				break;

			}

		}

	}

	public void registerProperty() {

		// Buffer refresh
		reader.nextLine();

		System.out.println("Digite el nombre de la Propiedad: ");
		String propertyName = reader.nextLine();

		System.out.println("Digite el nombre de la Ciudad: ");
		String city = reader.nextLine();

		System.out.println("Digite la Direcci�n: ");
		String address = reader.nextLine();

		System.out.println("Digite el n�mero de habitaciones");
		int roomCount = reader.nextInt();

		System.out.println("Digite el tipo de propiedad\n1:Casa\n2:Apartamento");
		int choice = reader.nextInt();
		String especial="";
		reader.nextLine();
		switch(choice){
			case 1:
				System.out.println("Digite el numero de pisos");
				especial= reader.nextLine();
			break;

			case 2:
				System.out.println("Digite el codigo de apartamento");
				especial= reader.nextLine();
			break;
		}


		if (controller.registerProperty(propertyName, city, address, roomCount,choice,especial)) {

			System.out.println("Propiedad registrada existosamente");

		} else {

			System.out.println("Error, la Propiedad no pudo registrarse");
		}

	}

	public void bookProperty() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = controller.getProperties();

		if (query.equals("")) {
			System.out.println("No hay propiedades registradas");
		} else {
			System.out.println(query);

			System.out.println("Que propiedad desea reservar?");
			int bookedProperty = reader.nextInt();

			System.out.println("Cuantas noches desea reservarla?");
			int nights =  reader.nextInt();

			System.out.println("El costo de la reservacion es:"+ controller.bookProperty(bookedProperty-1,nights));
		}

	}

}
