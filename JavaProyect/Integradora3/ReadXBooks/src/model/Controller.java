package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Controller {

	private ArrayList<Product> products;
	private ArrayList<User> users;
	private ArrayList<Transaction> transactions;

	public Controller() {

		this.products = new ArrayList<Product>();
		this.users = new ArrayList<User>();
		this.transactions = new ArrayList<Transaction>();
		testCases();

	}

/**
 * The function generates a random advertisement message from a list of eight options.
 * 
 * @return A randomly generated advertising message from a list of 8 options.
 */
	public String ads(){
		String msg="";
		int number = (int)(Math.random()*8+1);

		switch(number){

			case 1:
			msg="Nike - Just Do It.";
			break;

			case 2:
			msg="Coca-Cola - Open Happiness.";
			break;

			case 3:
			msg="M&Ms - Melts in Your Mouth, Not in Your Hands.";
			break;

			case 4:
			msg="¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!";
			break;

			case 5:
			msg="Ahora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.";
			break;

			case 6:
			msg="¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas.";
			break;

			case 7:
			msg="Tienes hambre? recuerda que tenemos 8 proteinas,72+ salsas y 15 panes! Bytes ICESI";
			break;

			case 8:
			msg="Hola, Gamer, juguemos League of Legends ¿Qué te parece si lo descargamos en este preciso momento y descubrimos juntos como se juega? Es fácil de aprender, funciona de esta manera: 2 equipos de 5 jugadores deben destruir la base enemiga combatiendo en un mapa lleno de objetivos y monstruos. Supongamos que de entre los mas de 100 campeones Elijes a Garen, te gusta Garen, es fácil matar a tus enemigos con Garen. Al principio no necesitas ser experto por qué el juego te posiciona con otros jugadores de tu mismo nivel, esto significa que podrás mejorar con solo jugar y divertirte. No hay nada como ganar en League of Legends al lado de 4 nuevos aliados... ¿Hermoso, verdad? Pero piensa que jugar con un grupo de amigos que ya conoces podría ser igual de divertido: Tú podrías ser el tanque, tus amigos pueden ser soportes, arqueros, asesinos o incluso magos, hay muchos roles para escoger según la estrategia que quieras que siga tu campeón durante la partida y con el tiempo comienzas a dominar otros campeones, como Lux con sus poderosos hechizos, a Darius con quien probablemente consigas tu primer Pentakill o Teemo la tierna encarnación de toda la maldad del universo, ya te gustan estos campeones, cada uno con su estilo de juego, aprenderas mas sobre las historias únicas de cada uno y verás como su origen se conecta con sus poderes, hay todo un universo por explorar. Después conocerás otra característica del juego: Las partidas clasificatorias, en las que tus resultados determinan tu posición en un sistema de ligas y divisiones, podrías jugar esto para siempre, pero tómalo con calma y solo diviértete, por que LoL te ofrece un sinfín de experiencias incluso sin competir por un puntaje, por qué esto es League of Legends: Es dinámico, intuitivo y siempre diverso. Cuanto más juegas más te enamoras del juego y después de cada partida no evitaras volver a jugar. Todo eso y más te espera si descargas League of Legends: Tú decides.";
			break;

		}

		return msg;
	}

/**
 * The function initializes and adds products and users to their respective lists.
 */
	public void testCases() {

		products.add(new Book("4AF", "A Game of Thrones",694,"Join adventurers across the seven kingdoms","01/08/1996", Genre.FANTASIA,"AGOT.png",19.99));
		products.add( new Magazine("Z1T","Vogue",40,Category.VARIEDADES,"01/06/2021","Mensual","LMV2021.jpg",4.99));
		
		users.add( new StandarUser("1234", "John Smith", "Smithy"));
		users.add(new PremiumUser("5678", "Pocahontas", "Pocah",PremiumCategory.DIAMANTE));

	}
//|||||||||||||||||||||||||||||PRODUCTS||||||||||||||||||||||||||||||||||||||||||||||
	/**
	 * This function registers a book with its details and adds it to a list of products, sorting the list
	 * in descending order based on price.
	 * 
	 * @param id A unique identifier for the book being registered.
	 * @param name The name of the book being registered.
	 * @param pagesNumber The number of pages in the book.
	 * @param review A string containing a review or description of the book.
	 * @param publicationDate The publication date of the book being registered.
	 * @param genre The genre parameter is an integer that represents the genre of the book being
	 * registered. The switch statement in the code converts this integer value into a corresponding Genre
	 * enum value. The possible integer values and their corresponding Genre enum values are:
	 * @param url The URL parameter is a string that represents the URL or web address of the book's cover
	 * image.
	 * @param price The price of the book being registered.
	 * @return A boolean value indicating whether the book registration was successful or not.
	 */
	public boolean registerBook(String id, String name,int pagesNumber, String review,String publicationDate,int genre,String url ,double price) {
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
		products.add(new Book(id,name,pagesNumber,review,publicationDate,realGenre,url,price));
		indicator=true;
		sortListDescending();
		sortListDescending();
		return indicator;
	}

	/**
	 * This function registers a magazine by creating a new Magazine object with the given parameters and
	 * adding it to a list of products.
	 * 
	 * @param id A string representing the ID of the magazine being registered.
	 * @param name The name of the magazine being registered.
	 * @param pagesNumber an integer representing the number of pages in the magazine.
	 * @param category an integer representing the category of the magazine. It can be 1 for "VARIEDADES",
	 * 2 for "DISENIO", 3 for "CIENTIFICA", or any other integer for "VARIEDADES" (default value).
	 * @param publicationDate A string representing the date of publication of the magazine in the format
	 * "dd/mm/yyyy".
	 * @param publicationPeriodicity The publicationPeriodicity parameter refers to how often the magazine
	 * is published, such as weekly, monthly, or quarterly.
	 * @param url The URL is a string parameter that represents the web address of the magazine's website
	 * or online version.
	 * @param suscriptionPrice The subscription price of the magazine.
	 * @return A boolean value indicating whether the magazine registration was successful or not.
	 */
	public boolean registerMagazine(String id, String name,int pagesNumber,int category,String publicationDate,String publicationPeriodicity, String url,double suscriptionPrice) {
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
		products.add(new Magazine(id, name, pagesNumber, realCategory, publicationDate, publicationPeriodicity, url, suscriptionPrice));
		indicator=true;
		sortListDescending();
		sortListDescending();
		return indicator;
	}

	/**
	 * This Java function returns a formatted string containing the names of all non-null products in a
	 * list.
	 * 
	 * @return The method is returning a String that contains a list of products' names.
	 */
	public String getProductList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) != null) {
				msg += "\n" + (i + 1) + ". " + products.get(i).getName();
			}

		}
		
		return msg;

	}

	/**
	 * This function sells a product to a user and updates the necessary information such as units sold
	 * and active subscriptions.
	 * 
	 * @param productOption The index of the product in the products list that the user wants to sell.
	 * @param userOption The index of the user in the ArrayList of users.
	 * @return The method is returning a boolean value.
	 */
	public boolean sellProduct(int productOption,int userOption) {
		boolean indicator= false;
		double preSold;
		double postSold;
		String temporalString;
		temporalString=(products.get(productOption)).getFormatedPublicationDate();

		if(users.get(userOption) instanceof PremiumUser){
			if(products.get(productOption) instanceof Book){
				preSold=((Book)products.get(productOption)).getUnitsSold();
				 postSold=preSold+1;
				((users.get(userOption)).getProducts()).add(new Book(((Book)products.get(productOption)).getId(),((Book)products.get(productOption)).getName(),((Book)products.get(productOption)).getPagesNumber(),((Book)products.get(productOption)).getReview(),temporalString,((Book)products.get(productOption)).getGenre(),((Book)products.get(productOption)).getUrl(),((Book)products.get(productOption)).getPrice()));
				 preSold=((Book)products.get(productOption)).getUnitsSold();
				 postSold=preSold+1;
				if(((Book)products.get(productOption)).setUnitsSold(postSold)){
					indicator=true;
					transactions.add(new Transaction(Calendar.getInstance(),((Book)products.get(productOption)).getPrice()));
				}
			}
			if(products.get(productOption) instanceof Magazine){
				preSold=((Magazine)products.get(productOption)).getActiveSuscriptions();
				 postSold=preSold+1;
				((users.get(userOption)).getProducts()).add(new Magazine(((Magazine)products.get(productOption)).getId(),((Magazine)products.get(productOption)).getName(),((Magazine)products.get(productOption)).getPagesNumber(),((Magazine)products.get(productOption)).getCategory(),temporalString,((Magazine)products.get(productOption)).getPublicationPeriodicity(),((Magazine)products.get(productOption)).getUrl(), ((Magazine)products.get(productOption)).getSuscriptionPrice()));
				 preSold=((Magazine)products.get(productOption)).getActiveSuscriptions();
				 postSold=preSold+1;
				if(((Magazine)products.get(productOption)).setActiveSuscriptions(postSold)){
					indicator=true;
					transactions.add(new Transaction(Calendar.getInstance(),((Magazine)products.get(productOption)).getSuscriptionPrice()));
				}
			}
		}
		int bookCounter=0;
		int magazineCounter=0;
		if(users.get(userOption) instanceof StandarUser){
			bookCounter=0;
			magazineCounter=0;
			for(int i=0;i< users.get(userOption).getProducts().size();i++){
				Product temporalProduct=users.get(userOption).getProducts().get(i);
				if(temporalProduct instanceof Book){
					bookCounter++;
				}
			}
			for(int i=0;i< users.get(userOption).getProducts().size();i++){
				Product temporalProduct=users.get(userOption).getProducts().get(i);
				if(temporalProduct instanceof Magazine){
					magazineCounter++;
				}
			}
			if(bookCounter>= 5 || magazineCounter>=2){
				return false;
			}
			else{
				if(products.get(productOption) instanceof Book){
					preSold=((Book)products.get(productOption)).getUnitsSold();
					 postSold=preSold+1;
					((users.get(userOption)).getProducts()).add(new Book(((Book)products.get(productOption)).getId(),((Book)products.get(productOption)).getName(),((Book)products.get(productOption)).getPagesNumber(),((Book)products.get(productOption)).getReview(),temporalString,((Book)products.get(productOption)).getGenre(),((Book)products.get(productOption)).getUrl(),((Book)products.get(productOption)).getPrice()));
					 preSold=((Book)products.get(productOption)).getUnitsSold();
					 postSold=preSold+1;
					if(((Book)products.get(productOption)).setUnitsSold(postSold)){
						indicator=true;
						transactions.add(new Transaction(Calendar.getInstance(),((Book)products.get(productOption)).getPrice()));
					}
				}
				if(products.get(productOption) instanceof Magazine){
					preSold=((Magazine)products.get(productOption)).getActiveSuscriptions();
					 postSold=preSold+1;
					((users.get(userOption)).getProducts()).add(new Magazine(((Magazine)products.get(productOption)).getId(),((Magazine)products.get(productOption)).getName(),((Magazine)products.get(productOption)).getPagesNumber(),((Magazine)products.get(productOption)).getCategory(),temporalString,((Magazine)products.get(productOption)).getPublicationPeriodicity(),((Magazine)products.get(productOption)).getUrl(), ((Magazine)products.get(productOption)).getSuscriptionPrice()));
					 preSold=((Magazine)products.get(productOption)).getActiveSuscriptions();
					 postSold=preSold+1;
					if(((Magazine)products.get(productOption)).setActiveSuscriptions(postSold)){
						indicator=true;
						transactions.add(new Transaction(Calendar.getInstance(),((Magazine)products.get(productOption)).getSuscriptionPrice()));
					}
				}
			}
		}
		
		return indicator;
	}

	/**
	 * This function returns a string containing information about all products in a list.
	 * 
	 * @return The method is returning a String that contains information about all the products in the
	 * "products" list.
	 */
	public String getAllKProductInfo() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) != null) {
				msg+=products.get(i).toString();
			}

		}

		return msg;
	}

	/**
	 * This function edits a product's attributes based on user input and returns a boolean indicating
	 * whether the edit was successful or not.
	 * 
	 * @param productOption The index of the product in the products list that needs to be edited.
	 * @param categoryChange an integer representing the category of the product attribute to be edited
	 * (e.g. name, pages number, publication date, category, publication periodicity, price, units sold)
	 * @param categoryChoice The choice of category for a product, represented as an integer value. The
	 * possible values are 1, 2, or 3, each corresponding to a different category.
	 * @param stringChange A string that contains the new value to be set for the selected product's
	 * attribute.
	 * @return The method is returning a boolean value indicating whether the product was successfully
	 * edited or not.
	 */
	public boolean editProduct(int productOption, int categoryChange, int categoryChoice, String stringChange) {
		boolean indicator=false;
		int temporalInt;
		double temporalDouble;
		Calendar temporalCalendar;
		switch(categoryChange){
			case 1:
				products.get(productOption).setName(stringChange);
				indicator =true;
			break;

			case 2:
				temporalInt = Integer.parseInt(stringChange);
				products.get(productOption).setPagesNumber(temporalInt);
				indicator =true;
			break;

			case 3:
				String[] getter;
				int day;
				int month;
				int year;
				getter=stringChange.split("/");
				day=Integer.parseInt(getter[0]);
				month=Integer.parseInt(getter[1]);
				year=Integer.parseInt(getter[2]);
			
				temporalCalendar= new GregorianCalendar(year,month,day);
				products.get(productOption).setPublicationDate(temporalCalendar);
				indicator =true;
			break;
			
			case 4:
				Category temporalCategory= Category.CIENTIFICA;
				Genre temporalGenre= Genre.CIENCIA_FICCION;
				switch(categoryChoice){
					case 1:
					temporalCategory= Category.CIENTIFICA;
				 	temporalGenre= Genre.CIENCIA_FICCION;
					if(products.get(productOption) instanceof Magazine){
						((Magazine)products.get(productOption)).setCategory(temporalCategory);
						return true;
					}
					if(products.get(productOption) instanceof Book){
						((Book)products.get(productOption)).setGenre(temporalGenre);;
						return true;
					}
					
					else{
						return false;
					}

					case 2:
					temporalCategory= Category.DISENIO;
				 	temporalGenre= Genre.FANTASIA;
					if(products.get(productOption) instanceof Magazine){
						((Magazine)products.get(productOption)).setCategory(temporalCategory);
						return true;
					
					}
					if(products.get(productOption) instanceof Book){
						((Book)products.get(productOption)).setGenre(temporalGenre);;
						return true;
					}
					
					else{
						return false;
					}
				

					case 3:
					temporalCategory= Category.VARIEDADES;
				 	temporalGenre= Genre.NOVELA_HISTORICA;
					if(products.get(productOption) instanceof Magazine){
						((Magazine)products.get(productOption)).setCategory(temporalCategory);
						return true;
						
					}
					if(products.get(productOption) instanceof Book){
						((Book)products.get(productOption)).setGenre(temporalGenre);;
						return true;
					}
					
					else{
						return false;
					}
					
				}

			break;

		case 5:
		
			if(products.get(productOption) instanceof Magazine){
				((Magazine)products.get(productOption)).setPublicationPeriodicity(stringChange);
				return true;
				
			}
			if(products.get(productOption) instanceof Book){
				((Book)products.get(productOption)).setReview(stringChange);
				return true;
				}
					
			else{
				return false;
			}
			
			
			
		

		case 6:
			temporalDouble = Double.parseDouble(stringChange);
			if(products.get(productOption) instanceof Magazine){
				((Magazine)products.get(productOption)).setSuscriptionPrice(temporalDouble);
				return true;
					
			}
			if(products.get(productOption) instanceof Book){
				((Book)products.get(productOption)).setPrice(temporalDouble);
				return true;
			}
					
			else{
				return false;
			}
		

		case 7:
			temporalDouble = Double.parseDouble(stringChange);
			if(products.get(productOption) instanceof Magazine){
				((Magazine)products.get(productOption)).setActiveSuscriptions(temporalDouble);
				return true;
					
			}
			if(products.get(productOption) instanceof Book){
				((Book)products.get(productOption)).setUnitsSold(temporalDouble);
				return true;
			}
					
			else{
				return false;
			}
		

		default:
		return false;
		
	}
	return indicator;
	}

//||||||||||||||||||||||||||||||||||||||USERS||||||||||||||||||||||||||||||||||||||||

	/**
	 * This function returns a formatted string containing a list of users' IDs and names.
	 * 
	 * @return The method `getUserList()` returns a `String` containing a list of users with their IDs and
	 * names.
	 */
	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i) != null) {
				msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();
			}

		}

		return msg;

	}

	/**
	 * The function registers a user with their ID, name, nickname, user type, and category choice and
	 * returns a boolean indicating if the registration was successful.
	 * 
	 * @param id A string representing the user's ID.
	 * @param name The name of the user being registered.
	 * @param nickname The nickname parameter is a String that represents the chosen username or alias for
	 * the user being registered.
	 * @param tipeUserChoice An integer representing the type of user to be registered. 1 represents a
	 * standard user and 2 represents a premium user.
	 * @param categoryChoice An integer representing the category choice of a Premium User. It can be 1,
	 * 2, or 3, which correspond to the categories PLATA, ORO, and DIAMANTE respectively.
	 * @return The method is returning a boolean value, which indicates whether the user registration was
	 * successful or not. If the registration was successful, the method returns true, otherwise it
	 * returns false.
	 */
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

	/**
	 * The function edits user information such as name, nickname, and premium category choice.
	 * 
	 * @param userPosition The position of the user in the ArrayList of users that needs to be edited.
	 * @param categoryChange An integer representing the category of user information to be edited.
	 * @param categoryChoice The category choice parameter is an integer that represents the user's choice
	 * of premium category. It is used in the editUser method to determine which premium category to
	 * assign to a user if the categoryChange parameter is set to 3 (indicating a change in premium
	 * category). The possible values for categoryChoice
	 * @param stringchange A string representing the new value to be set for the selected category of the
	 * user.
	 * @return The method returns a boolean value indicating whether the user information was successfully
	 * edited or not.
	 */
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

	/**
	 * This Java function deletes a user from a list of users at a specified position and returns a
	 * boolean indicator of success.
	 * 
	 * @param userPosition userPosition is an integer parameter that represents the position of the user
	 * to be deleted in the list of users. The position starts from 0 for the first user in the list and
	 * increments by 1 for each subsequent user.
	 * @return A boolean value indicating whether the user was successfully deleted or not.
	 */
	public boolean deleteUser(int userPosition) {
		boolean indicator=true;
		users.remove(userPosition);
		return indicator;
	}

	/**
	 * This Java function returns a string containing user information based on the input option.
	 * 
	 * @param option The index of the user in the "users" list whose information is to be retrieved.
	 * @return A string containing information about a user, based on the option parameter passed to the
	 * method.
	 */
	public String getUserInfo(int option) {

		String msg = "";
		msg =users.get(option).toString();
		return msg;
	}

	/**
	 * This function returns a string containing information about all users in a list.
	 * 
	 * @return The method `getAllUserInfo` returns a `String` that contains information about all the
	 * users in the `users` list.
	 */
	public String getAllUserInfo() {

		String msg ="";

		for(int i=0;i<users.size();i++){
		
			msg+=users.get(i).toString();
			
		}
		return msg;
	}

//|||||||||||||||||||||||||||||||||USES|||||||||||||||||||||||||||||||||||||||||||||||||||\
    /**
	 * This function returns a string message containing a matrix of products sorted in descending
	 * order based on a user's option.
	 * 
	 * @param userOption The index of the user in the list of users.
	 * @return A string message containing the product library of a user, sorted in descending order
	 * and displayed as a matrix.
	 */
	public String getProductLibrary(int userOption) {

		String msg = "";
		users.get(userOption).sortListDescending();
		msg=users.get(userOption).showMatrix();

		return msg;
    }

	/**
	 * This function sorts a list of products in descending order using the compareTo method.
	 */
	public void sortListDescending() {	
		for (int i = 0; i < products.size(); i++) {
			
			
			Product temp1 = products.get(i);
			if(i+1<products.size()){
				Product temp2 = products.get(i+1);

				int compare = temp1.compareTo(temp2);

				if(compare<0){
					products.set(i, temp1);
					products.set(i+1, temp2);
				}
				if(compare<0){
					products.set(i, temp2);
					products.set(i+1, temp1);
				}
				if(compare==0){
				}
			}
		}
	}

	/**
	 * This function reads a specific product (book or magazine) for a user and displays the current page
	 * number, along with advertisements at certain intervals.
	 * 
	 * @param productOption A String representing the ID of the product that the user wants to read.
	 * @param userOption The index of the user in the ArrayList of users.
	 * @param counter The current page number being read by the user.
	 * @return A String message containing information about the product being read, including its name,
	 * the current page being read, and any advertisements that should be displayed based on the user's
	 * type and the type of product being read.
	 */
	public String readProduct(String productOption, int userOption,int counter) {
		String msg="Sesion de lectura en proceso: \n Leyendo: ";
		String temporalID="";
		String temporalName="";
		int temporalPage=0;
		int definite=0;
		

		if(users.get(userOption).getProducts().size() == 0){
			msg="Ese producto no existe";
			return msg;
		}

		for(int i=0;temporalID != productOption.toUpperCase();i++){
			temporalID=users.get(userOption).getProducts().get(i).getId();
			temporalName=users.get(userOption).getProducts().get(i).getName();
			
			definite = i;
			
		}

		
		temporalPage=users.get(userOption).getProducts().get(definite).getPagesNumber();
		if(counter== 0 || counter==temporalPage ){
			counter=1;
		}
		msg+=temporalName+"\n";
		if(users.get(userOption) instanceof StandarUser){
			if(users.get(userOption).getProducts().get(definite) instanceof Book){
				if(counter%20 == 0){
					msg+=ads()+"\n";
				}
			}
			if(users.get(userOption).getProducts().get(definite) instanceof Magazine){
				if(counter%5 == 0){
					msg+=ads()+"\n";
				}
			}
		}
		
		
		msg+="\nLeyendo pagina "+counter+" de "+ temporalPage;

		return msg;
	}

	/**
	 * This Java function adds one to the number of pages read for a specific product in a user's list of
	 * products.
	 * 
	 * @param productOption A String representing the ID of the product that the user wants to add readed
	 * pages to.
	 * @param userOption The index of the user in the ArrayList of users.
	 * @return A String message is being returned.
	 */
	public String AddReadedPagesProduct(String productOption, int userOption){
		String temporalID="";
		String msg="";
		int definite=0;
		if(users.get(userOption).getProducts().size() == 0){
			msg="Ese producto no existe";
			return msg;
		}
		for(int i=0;temporalID != productOption.toUpperCase();i++){
			temporalID=users.get(userOption).getProducts().get(i).getId();
			
			definite = i;

		}
		double temporalPage=products.get(definite).getReadedPages();
		temporalPage++;
		products.get(definite).setReadedPages(temporalPage);
		return msg;
	}

	/**
	 * This function returns the ID of a product in a matrix based on user input and the position of the
	 * product in the user's list of products.
	 * 
	 * @param userOption The index of the user in the "users" list.
	 * @param x The x parameter represents the column number of the product in a matrix.
	 * @param y The y parameter represents the vertical position of the product in a matrix.
	 * @return The method is returning a String that represents the ID of a product from a matrix, based
	 * on the user option, x and y coordinates provided as parameters. If the product does not exist, the
	 * method returns a message indicating that the product does not exist.
	 */
	public String getProductFromMatrix(int userOption,int x, int y) {
		int calculate=x+5*y;
		String msg;

		if(users.get(userOption).getProducts().size() == 0){
			msg="Ese producto no existe";
			return msg;
		}
		msg =users.get(userOption).getProducts().get(calculate).getId();
		return msg;
	}


//||||||||||||||||||||||||||||REPORTS||||||||||||||||||||||||||||||||
/**
 * This Java function calculates the total number of pages read for books and magazines in a list of
 * products.
 * 
 * @return The method is returning a String message that displays the total number of pages read for
 * books and magazines in the products list.
 */
	public String totalReadPages() {
		String msg = "";
		double readedBooks=0;
		double readedMagazines=0;
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Book){
				readedBooks+=products.get(i).getReadedPages();
			}
			if(products.get(i) instanceof Magazine){
				readedMagazines+=products.get(i).getReadedPages();
			}
			
		}
		msg+="\nTotal de paginas leidas:\nLibros: "+readedBooks+"\nRevistas: "+readedMagazines;
		return msg;
	}

/**
 * This function calculates the total sales for each category of magazines in a list of products.
 * 
 * @return A string message with the total sales for each category of magazines.
 */
	public String sellingsByCategory() {
		String msg = "";
		double readedVariedades=0;
		Category temGenre;
		double readedDisenio=0;
		double readedCientifica=0;
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Magazine){
				temGenre=Category.VARIEDADES;

				if(((Magazine) products.get(i)).getCategory()==temGenre){
					double price=((Magazine)products.get(i)).getSuscriptionPrice();
					readedVariedades+=price;
				}
				
			}
			if(products.get(i) instanceof Magazine){
				temGenre=Category.DISENIO;

				if(((Magazine) products.get(i)).getCategory()==temGenre){
					double price=((Magazine)products.get(i)).getSuscriptionPrice();
					readedDisenio+=price;
				}
				
			}
			if(products.get(i) instanceof Magazine){
				temGenre=Category.CIENTIFICA;

				if(((Magazine) products.get(i)).getCategory()==temGenre){
					double price=((Magazine)products.get(i)).getSuscriptionPrice();
					readedCientifica+=price;
				}
				
			}
			
		}
		msg+="\nTotal de ventas\nVariedades: "+readedVariedades+"\nDisenio: "+readedDisenio+"\nCientifica: "+readedCientifica;
		return msg;
	}

/**
 * This function calculates the total sales of books in three different genres and returns a message
 * with the results.
 * 
 * @return A string message with the total sales for each genre of books.
 */
	public String sellingsByGenre() {
		String msg = "";
		double readedVariedades=0;
		Genre temGenre;
		double readedDisenio=0;
		double readedCientifica=0;
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Magazine){
				temGenre=Genre.CIENCIA_FICCION;

				if(((Book) products.get(i)).getGenre()==temGenre){
					double price=((Book)products.get(i)).getPrice();
					readedVariedades+=price;
				}
				
			}
			if(products.get(i) instanceof Magazine){
				temGenre=Genre.FANTASIA;

				if(((Book) products.get(i)).getGenre()==temGenre){
					double price=((Book)products.get(i)).getPrice();
					readedDisenio+=price;
				}
				
			}
			if(products.get(i) instanceof Magazine){
				temGenre=Genre.NOVELA_HISTORICA;

				if(((Book) products.get(i)).getGenre()==temGenre){
					double price=((Book)products.get(i)).getPrice();
					readedCientifica+=price;
				}
				
			}
			
		}
		msg+="\nTotal de ventas\nCiencia ficcion: "+readedVariedades+"\nFantasia: "+readedDisenio+"\nNovela historica: "+readedCientifica;
		return msg;
	}


/**
 * The function returns a message indicating the most read genre and category of products (books and
 * magazines) based on the number of pages read.
 * 
 * @return A String message indicating the most read genre and category, along with the number of pages
 * read for each.
 */
public String mostReadGenreAndCategory() {
	String msg = "";
	double readedBooks=0;
	double readedMagazines=0;
	int temporalBookID=0;
	int temporalMagazineID=0;
	
	for(int i=0;i<products.size();i++){
		if(products.get(i) instanceof Book){
			
			if(readedBooks<products.get(i).getReadedPages()){
				readedBooks=products.get(i).getReadedPages();
				temporalBookID=i;
			}
		}
		if(products.get(i) instanceof Magazine){
			
			if(readedMagazines<products.get(i).getReadedPages()){
				readedMagazines=products.get(i).getReadedPages();
				temporalMagazineID=i;
			}
		}
	}

	msg+="Genero mas leido: "+((Book)products.get(temporalBookID)).getGenre()+" Con " +products.get(temporalBookID).getReadedPages()+" Paginas leidas"
	+"Categoria mas leida: "+((Magazine)products.get(temporalMagazineID)).getCategory()+" Con " +products.get(temporalBookID).getReadedPages()+" Paginas leidas";
	return msg;
}


}

