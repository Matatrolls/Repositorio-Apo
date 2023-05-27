package model;

import java.util.Calendar;

public class Controller {

	private Book[] books;
	private Transaction[] transactions;
	private int idTransaction=1;

	public Controller() {

		books = new Book[50];
		transactions = new Transaction[1000];
		testCases();

	}

/**
 * The function initializes two book objects with their respective attributes.
 */
	public void testCases() {

		books[0] = new Book("A1F", "A Game of Thrones", Genre.FANTASIA,20);
		books[1] = new Book("A1A", "Dune", Genre.CIENCIA_FICCION, 10);

	}


/**
 * This function registers a book by creating a new Book object with given parameters and adding it to
 * an array of books.
 * 
 * @param id A String representing the unique identifier of the book.
 * @param name The name of the book being registered.
 * @param genre An integer value representing the genre of the book. 1 represents "Ciencia Ficcion", 2
 * represents "Fantasia", and 3 represents "Novela Historica".
 * @param price The price parameter is a double data type, representing the cost of the book.
 * @return The method is returning a boolean value, which indicates whether the book was successfully
 * registered or not. If the book was registered, the method returns true. If not, it returns false.
 */
	public boolean registerBook(String id, String name, int genre, double price) {
		boolean indicator= false;
		Genre realGenre;
		switch(genre){
			case 1:
			realGenre= Genre.CIENCIA_FICCION;
			break;
			case 2:
			realGenre= Genre.FANTASIA;
			break;
			case 3:
			realGenre= Genre.NOVELA_HISTORICA;
			break;
			default:
			realGenre= Genre.CIENCIA_FICCION;
			break;

		}
		Book tempBook=new Book(id, name, realGenre, price);
		for(int i=0;i<books.length;i++){
			if(books[i]==null && !indicator){
				books[i]=tempBook;
				indicator=true;
			}
		}
		return indicator;
	}

/**
 * The function returns a formatted string containing the names and prices of all non-null books in an
 * array.
 * 
 * @return The method `getBookList()` returns a `String` containing a list of books with their names
 * and prices.
 */
	public String getBookList() {

		String msg = "";

		for (int i = 0; i < books.length; i++) {

			if (books[i] != null) {
				msg += "\n" + (i + 1) + ". " + books[i].getName() + " - " + books[i].getPrice();
			}

		}
		
		return msg;

	}

/**
 * The function sells a book by increasing its units sold and creating a new transaction.
 * 
 * @param i The index of the book in the array of books that is being sold.
 * @return The method is returning a boolean value, which indicates whether the book was successfully
 * sold or not.
 */
	public boolean sellBook(int i) {
		boolean indicator= false;
		int preSold=books[i].getUnitsSold();
		int postSold=preSold+1;
		if(books[i].setUnitsSold(postSold)){
			indicator=true;
			transactions[idTransaction]= new Transaction(Calendar.getInstance(),books[i].getPrice());
			idTransaction+=1;
		}

		return indicator;
	}

/**
 * This function returns a string containing information about all the books in an array, including
 * their ID, name, genre, price, units sold, and total sales.
 * 
 * @return The method is returning a String that contains information about all the books in the array
 * "books", including their ID, name, genre, price, units sold, and total sales.
 */
	public String getAllKBookInfo() {

		String msg = "";
		double totalSells;

		for (int i = 0; i < books.length; i++) {

			if (books[i] != null) {
				totalSells=books[i].getUnitsSold()+books[i].getPrice();
				msg += "\n" + (i + 1) + ". " + books[i].getId()+ ". " + books[i].getName()+ ". " + books[i].getGenre()+ ". \nPrecio: " + books[i].getPrice()+ ". \nUnidades Vendidas: " + books[i].getUnitsSold()+ ". \nVentas Totales:" + totalSells;
			}

		}

		return msg;
	}

}
