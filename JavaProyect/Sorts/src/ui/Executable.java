import sorts.*;
import java.util.Scanner;
import model.Controller;

public class Executable {
    public Executable() {
        input = new Scanner(System.in);
		controller = new Controller();
    }

	private Scanner input;
	private Controller controller;

	/**
	 * The main function creates an instance of the Executable class and calls its menu method.
	 */
	public static void main(String[] args) {

		Executable executable = new Executable();
		executable.menu();

	}
//|||||||||||||||||||||||||||||||||||MENUS||||||||||||||||||||||||||||||

	/**
	 * This function displays a menu with options for managing users, products, and uses, and allows the
	 * user to select an option or exit the menu.
	 */
	public void menu() {
		boolean indicator=false;
	
		while(!indicator){
			System.out.println("1.bubble sort");
			System.out.println("2.selection sort");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			int option = input.nextInt();

			switch (option) {

				case 1:
					
				break;

				case 2:
					
				break;

				case 3:
					
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
  }
