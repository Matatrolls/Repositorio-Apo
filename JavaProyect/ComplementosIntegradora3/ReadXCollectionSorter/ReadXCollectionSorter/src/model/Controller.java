package model;

import java.util.ArrayList;

public class Controller {

	private ArrayList<Book> bookList;

	public Controller() {
		bookList = new ArrayList<Book>();
		testCases();

	}

	public void testCases() {

		bookList.add(new Book("AF3", "Las mil y una noches", 125));
		bookList.add(new Book("E42", "El viejo y el mar", 223));

	}

	public boolean registerBook(String id, String name, int pages) {

		bookList.add(new Book(id,name,pages));
		return true;
	}

	public void sortListDescending() {	
		for (int i = 0; i < bookList.size(); i++) {
			Book temp1 = bookList.get(i);
			if(i+1<bookList.size()){
				Book temp2 = bookList.get(i+1);

				int compare = temp1.compareTo(temp2);

				System.out.println(compare+"Compare");

				if(compare<0){
					bookList.set(i, temp1);
					bookList.set(i+1, temp2);
				}
				if(compare<0){
					bookList.set(i, temp2);
					bookList.set(i+1, temp1);
				}
				if(compare==0){

			}
			}
			
		}
	}

	// Pending
	public String[][] fillMatrix() {
		int indicator= 0;
		sortListDescending();

		String[][] matrix = new String[5][5];

	
		for (int i2 = 0; i2 < matrix.length; i2++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i2][j]==null){
					if(indicator<bookList.size()){
						matrix[i2][j]=bookList.get(indicator).toString();
					indicator++;
					}
				}
				else{	
				}
			}
		
		}
		return matrix;

	}

	public String showMatrix() {

		String[][] matrix = fillMatrix();
		boolean indicator= false;

		String print = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == null ) {

					print += "|_______|" + " ";
				} else {
					print +="|"+ matrix[i][j] + "| ";
				}

			}
			print += "\n";
		}

		return print;
	}

}
