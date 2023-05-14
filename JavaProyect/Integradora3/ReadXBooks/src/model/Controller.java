package model;

import java.util.ArrayList;

public class Controller {

	private ArrayList<Product> products;
	private ArrayList<User> users;

	public Controller() {

		this.products = new ArrayList<Product>();
		this.users = new ArrayList<User>();
		testCases();

	}


	public void testCases() {

		products.add(new Book("4AF", "A Game of Thrones",694,"Join adventurers across the seven kingdoms","01/08/1996", Genre.FANTASIA,"AGOT.png",19.99,212018485,4888789521362L));
		products.add( new Magazine("Z1T","Vogue",40,Category.VARIEDADES,"01/06/2021","Mensual","LMV2021.jpg",4.99,122867,7533456212L));
		
		users.add( new StandarUser("1234", "John Smith", "Smithy"));
		users.add(new PremiumUser("5678", "Pocahontas", "Pocah",PremiumCategory.DIAMANTE));

	}
//|||||||||||||||||||||||||||||PRODUCTS||||||||||||||||||||||||||||||||||||||||||||||
	public boolean registerBook(String id, String name,int pagesNumber, String review,String publicationDate,int genre,String url ,double price,double unitsSold,long readedPages) {
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
		products.add(new Book(id,name,pagesNumber,review,publicationDate,realGenre,url,price,unitsSold,readedPages));
		indicator=true;

		return indicator;
	}

	public boolean registerMagazine(String id, String name,int pagesNumber,int category,String publicationDate,String publicationPeriodicity, String url,double suscriptionPrice,double activeSuscriptions,long readedPages) {
		boolean indicator= false;
		Category realCategory;
		switch(category){
			case 1:
				realCategory= Category.VARIEDADES;
			break;
			case 2:
				realCategory= Category.DISENIO;
			break;
			case 3:
				realCategory= Category.CIENTIFICA;
			break;
			default:
				realCategory=  Category.VARIEDADES;
			break;
		}
		products.add(new Magazine(id, name, pagesNumber, realCategory, publicationDate, publicationPeriodicity, url, suscriptionPrice, activeSuscriptions, readedPages));
		indicator=true;
		return indicator;
	}

	public String getProductList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) != null) {
				msg += "\n" + (i + 1) + ". " + products.get(i).getName();
			}

		}
		
		return msg;

	}

	public boolean sellProduct(int productOption,int userOption) {
		boolean indicator= false;

		if(products.get(productOption) instanceof Book){
			((users.get(userOption)).getProducts()).add(new Book(((Book)products.get(productOption)).getId(),((Book)products.get(productOption)).getName(),((Book)products.get(productOption)).getPagesNumber(),((Book)products.get(productOption)).getReview(),((Book)products.get(productOption)).getPublicationDate(),((Book)products.get(productOption)).getGenre(),((Book)products.get(productOption)).getUrl(),((Book)products.get(productOption)).getPrice(),((Book)products.get(productOption)).getUnitsSold(),((Book)products.get(productOption)).getReadedPages()));
			double preSold=((Book)products.get(productOption)).getUnitsSold();
			double postSold=preSold+1;
			if(((Book)products.get(productOption)).setUnitsSold(postSold)){
				indicator=true;
			}
		}
		if(products.get(productOption) instanceof Magazine){
			((users.get(userOption)).getProducts()).add(new Magazine(((Magazine)products.get(productOption)).getId(),((Magazine)products.get(productOption)).getName(),((Magazine)products.get(productOption)).getPagesNumber(),((Magazine)products.get(productOption)).getCategory(),((Magazine)products.get(productOption)).getPublicationDate(),((Magazine)products.get(productOption)).getPublicationPeriodicity(),((Magazine)products.get(productOption)).getUrl(), ((Magazine)products.get(productOption)).getSuscriptionPrice(),((Magazine)products.get(productOption)).getActiveSuscriptions(),((Magazine)products.get(productOption)).getReadedPages()));
			double preSold=((Magazine)products.get(productOption)).getActiveSuscriptions();
			double postSold=preSold+1;
			if(((Magazine)products.get(productOption)).setActiveSuscriptions(postSold)){
				indicator=true;
			}
		}
	
		return indicator;

		
	}

	public String getAllKProductInfo() {

		String msg = "";
		double totalSells;

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) != null) {
				msg+=products.get(i).toString();
			}

		}

		return msg;
	}

//||||||||||||||||||||||||||||||||||||||USERS||||||||||||||||||||||||||||||||||||||||

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

