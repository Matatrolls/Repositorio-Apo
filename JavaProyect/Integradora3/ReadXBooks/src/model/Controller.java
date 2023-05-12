package model;

import java.util.Calendar;
import java.util.ArrayList;

public class Controller {

	private ArrayList<Book> books;
	private ArrayList<Transaction> transactions;
	private ArrayList<User> users;

	public Controller() {

		this.books = new ArrayList<Book>();
		this.transactions = new ArrayList<Transaction>();
		this.users = new ArrayList<User>();
		testCases();

	}


	public void testCases() {

		books.add(new Book("A1F", "A Game of Thrones", Genre.FANTASIA,20));
		books.add( new Book("A1A", "Dune", Genre.CIENCIA_FICCION, 10));
		
		users.add( new StandarUser("1234", "John Smith", "Smithy"));
		users.add(new PremiumUser("5678", "Pocahontas", "Pocah",PremiumCategory.DIAMANTE));

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

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i) != null) {
				msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();
			}

		}

		return msg;

	}

	public boolean registerUser(String id, String name, String nickname,int tipeUserChoice,int categoryChoice) {
		boolean indicator=false;

		for(int i=0; i<users.size();i++){
           
			switch(tipeUserChoice){
				case 1:
					users.add(new StandarUser(id, name, nickname));
					indicator=true;
				break;

				case 2:
					PremiumCategory category=PremiumCategory.PLATA;
					switch(categoryChoice){
						case 1:
						category=PremiumCategory.PLATA;
						break;
						case 2:
						category=PremiumCategory.ORO;
						break;
						case 3:
						category=PremiumCategory.DIAMANTE;
						break;
					}
					users.add(new PremiumUser(id, name, nickname,category));
					indicator=true;
				break;
			}
		}
		return indicator;
	}

	public boolean editUser(int userPosition,int categoryChange, int categoryChoice,String stringchange) {
		boolean indicator=false;
		switch(categoryChange){
			case 1:
				users.get(userPosition).setName(stringchange);
				indicator =true;
			break;

			case 2:
				users.get(userPosition).setNickname(stringchange);
				indicator=true;
			break;

			case 3:
				PremiumCategory temporal= PremiumCategory.PLATA;
				switch(categoryChoice){
					case 0:
					if(users.get(userPosition) instanceof PremiumUser){
						users.add(new StandarUser(users.get(userPosition).getId(),users.get(userPosition).getName() , users.get(userPosition).getNickname()));
						return true;
					}
					
					else{
						return false;
					}
					case 1:
					temporal=PremiumCategory.PLATA;
					break;

					case 2:
					temporal=PremiumCategory.ORO;
					break;

					case 3:
					temporal=PremiumCategory.DIAMANTE;
					break;
				}

				if(users.get(userPosition) instanceof PremiumUser){
					((PremiumUser)users.get(userPosition)).setPremiumcategory(temporal);
					return true;
				}
				if(users.get(userPosition) instanceof StandarUser){
					users.add(new PremiumUser(users.get(userPosition).getId(),users.get(userPosition).getName() , users.get(userPosition).getNickname(), temporal));
					return true;
				}
			break;
		}
		return indicator;
	}

	public boolean deleteUser(int userPosition) {
		boolean indicator=true;
		users.remove(userPosition);
		return indicator;
	}

	public String getUserInfo(int option) {

		String msg = "";
		msg =users.get(option).toString();
		return msg;
	}

	public String getAllUserInfo() {

		String msg ="";

		for(int i=0;i<users.size();i++){
		
			msg+=users.get(i).toString();
			
		}
		return msg;
	}

}

