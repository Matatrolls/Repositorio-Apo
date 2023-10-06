
import java.util.ArrayList;
import java.util.Scanner;



public class Executable {
    public Executable() {
        input = new Scanner(System.in);
    }

	private Scanner input;

	public static void main(String[] args) {

		Executable executable = new Executable();
		executable.apoint();

	}

	public void apoint(){
		int length=0;

		length= input.nextInt();
		int[] numbers = new int[length];

		

		input.nextLine();
		String[] entry= input.nextLine().split(" ");
		for(int i=0;i<entry.length;i++){
			numbers[i] = Integer.parseInt(entry[i]);
		}

		selectionSort(numbers);

		int min=countMin(numbers);
		ArrayList<Integer> pairs = new ArrayList<Integer>();
		for(int i=0;i<numbers.length;i++){
			if(i+1<numbers.length){
				if(diff(numbers[i], numbers[i+1])==min){
					pairs.add(numbers[i]);
					pairs.add(numbers[i+1]);
				}
			}
		}


		for(int i=0;i<pairs.size();i++){
			System.out.print(pairs.get(i)+" ");
		}

	}

	public int countMin(int[] arr){
		int min=10000;
		int tempMin;
		for(int i=0;i<arr.length;i++){
			if(i+1<arr.length){
				tempMin=diff(arr[i], arr[i+1]);
				if(tempMin<min){
					min=tempMin;
				}
			}
		}
		return min;
	}

	public int diff(int a, int b){

		int c=b-a;
		return c;
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
