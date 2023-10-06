import sorts.*;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
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

			int option = input.nextInt();

			switch (option) {

				case 1:
					bubbleSort();
				break;

				case 2:
					selectionSort();
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
 
	public void selectionSort() {
		// ej int
		Integer[] numbers = {4, 2, 9, 1, 5, 6};
		SelectionSort<Integer> sort1 = new SelectionSort<>();
		sort1.selectionSort(numbers);
		System.out.println(Arrays.toString(numbers));

		// ej string
		String[] strings = {"a", "z", "j", "d", "e"};
		SelectionSort<String> sort2 = new SelectionSort<>();
		sort2.selectionSort(strings);
		System.out.println(Arrays.toString(strings));
		
	}

	public void bubbleSort() {
		Integer[] numbers = {5, 2, 9, 1, 5, 6};
		BubbleSort<Integer> sort = new BubbleSort<>();
		sort.bubbleSort(numbers, numbers.length);

		System.out.println("Arreglo ordenado:");
		for (Integer number : numbers) {
			System.out.print(number + " ");
		}
		System.out.print("\n");
	}
  }
