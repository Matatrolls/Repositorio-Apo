package ui;

import java.util.Scanner;

import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller controller;

	public static void main(String[] args) {

		System.out.println("Welcome to the Book Sorter");
		Executable sorter = new Executable();

		int option = 0;

		do {
			option = sorter.showMenu();
			sorter.executeOperation(option);

		} while (option != 0);

	}

	public Executable() {
		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public int showMenu() {
		int option = 0;

		System.out.println("\nMain Menu \n\nPlease pick an option\n" + "(1) Register a Book \n"
				+ "(2) Show sorted Library\n" + "(0) To leave the application");
		option = reader.nextInt();
		reader.nextLine();
		return option;
	}

	public void executeOperation(int operation) {

		switch (operation) {
		case 0:
			System.out.println("Thanks for using our services!");
			break;
		case 1:
			registerBook();
			break;
		case 2:
			System.out.println("\nThis is the current Book Collection\n\n" + controller.showMatrix());
			break;
		default:
			System.out.println("Error, type a valid option");

		}

	}

	public void registerBook() {

		boolean flag = false;
		int choice = 0;
		int pages=0;

		while (!flag) {

			System.out.println("\nType the information of the new Book\n");

			System.out.println("Type the ID. e.g.: A1F");
			String id = reader.nextLine();

			System.out.println("Type the name");
			String name = reader.nextLine();
			while(pages<1 || pages>999){
				System.out.println("Type the number of pages remebember that it cant pass 999 ");
				pages = reader.nextInt();
			}

			if (controller.registerBook(id, name, pages)) {

				System.out.println("Book successfully registered");

			} else {

				System.out.println("Error! The Book couldn't be registered");
			}

			System.out.println("\nDo you want to add another Book? Type a number \n 1. Yes \n 2. No");
			choice = reader.nextInt();

			reader.nextLine();

			if (choice > 1) {

				flag = true;

			}

		}

	}

}
