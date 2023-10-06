
import java.util.ArrayList;
import java.util.Scanner;



public class Executable {
    public Executable() {
        input = new Scanner(System.in);
    }

	private Scanner input;

	public static void main(String[] args) {

		Executable executable = new Executable();
		executable.bpoint();

	}

	public void bpoint(){
		int length=0;

		length= input.nextInt();
		int[] numbers = new int[length];

		

		input.nextLine();
		String[] entry= input.nextLine().split(" ");
		for(int i=0;i<entry.length;i++){
			numbers[i] = Integer.parseInt(entry[i]);
		}

		selectionSort(numbers);
		int mid=numbers.length/2;
		System.out.print(numbers[mid]);

	}



	public void selectionSort(int[] arr) {
		selectionSort(arr, 0);
	}

	private void selectionSort(int[] arr, int startIndex) {
		if (startIndex >= arr.length - 1) {
			return;
		}

		int minIndex = min(arr, startIndex);
		if (minIndex != startIndex) {
			swap(arr, startIndex, minIndex);
		}

		selectionSort(arr, startIndex + 1);
	}

	private int min(int[] arr, int startIndex) {
		int minIndex = startIndex;
		for (int i = startIndex + 1; i < arr.length; i++) {
			if (arr[i]<arr[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


  }
