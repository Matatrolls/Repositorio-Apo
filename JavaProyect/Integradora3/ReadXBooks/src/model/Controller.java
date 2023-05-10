package model;

import java.util.Calendar;
import java.util.ArrayList;

public class Controller {

	private ArrayList<Book> books;
	private ArrayList<Transaction> transactions;

	public Controller() {

		this.books = new ArrayList<Book>();
		transactions = new ArrayList<Transaction>();
		testCases();

	}


	public void testCases() {

		books.add(new Book("A1F", "A Game of Thrones", Genre.FANTASIA,20));
		books.add( new Book("A1A", "Dune", Genre.CIENCIA_FICCION, 10));

	}

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
		
		for(int i=0;i<books.size();i++){
			if(books.get(i)==null && !indicator){
				books.add(new Book(id, name, realGenre, price));
				indicator=true;
			}
		}
		return indicator;
	}

	public String getBookList() {

		String msg = "";

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i) != null) {
				msg += "\n" + (i + 1) + ". " + books.get(i).getName() + " - " + books.get(i).getPrice();
			}

		}
		
		return msg;

	}

	public boolean sellBook(int i) {
		boolean indicator= false;
		int preSold=books.get(i).getUnitsSold();
		int postSold=preSold+1;
		if(books.get(i).setUnitsSold(postSold)){
			indicator=true;
			transactions.add( new Transaction(Calendar.getInstance(),books.get(i).getPrice()));
		}

		return indicator;
	}

	public String getAllKBookInfo() {

		String msg = "";
		double totalSells;

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i) != null) {
				totalSells=books.get(i).getUnitsSold()+books.get(i).getPrice();
				msg += "\n" + (i + 1) + ". " + books.get(i).getId()+ ". " + books.get(i).getName()+ ". " + books.get(i).getGenre()+ ". \nPrecio: " + books.get(i).getPrice()+ ". \nUnidades Vendidas: " + books.get(i).getUnitsSold()+ ". \nVentas Totales:" + totalSells;
			}

		}

		return msg;
	}

}
