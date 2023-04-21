package model;

import java.util.Calendar;

public class Controller {

	private Book[] books;
	private Transaction[] transactions;

	public Controller() {

		books = new Book[50];
		transactions = new Transaction[1000];
		testCases();

	}

	public void testCases() {

		books[0] = new Book("A1F", "A Game of Thrones", 20);
		books[1] = new Book("A1A", "Dune", 10);

	}

	public boolean registerBook(String id, String name, int genre, double price) {

		return false;
	}

	public String getBookList() {

		String msg = "";

		for (int i = 0; i < books.length; i++) {

			if (books[i] != null) {
				msg += "\n" + (i + 1) + ". " + books[i].getName() + " - " + books[i].getPrice();
			}

		}
		
		return msg;

	}

	public boolean sellBook(int i) {

		return false;
	}

	public String getAllKBookInfo() {

		String msg = "";

		for (int i = 0; i < books.length; i++) {

			if (books[i] != null) {
				msg += "\n" + (i + 1) + ". " + books[i].getName();
			}

		}

		return msg;
	}

}
