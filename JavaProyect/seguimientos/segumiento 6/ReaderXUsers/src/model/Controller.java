package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private User[] users;

	public Controller() {

		users = new User[10];
		testCases();

	}

	public void testCases() {

		users[0] = new StandarUser("1234", "John Smith", "Smithy");
		users[1] = new PremiumUser("5678", "Pocahontas", "Pocah",PremiumCategory.DIAMANTE);
	}

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.length; i++) {

			if (users[i] != null) {
				msg += "\n" + (i + 1) + ". " + users[i].getId() + " - " + users[i].getName();
			}

		}

		return msg;

	}

	public boolean registerUser(String id, String name, String nickname,int tipeUserChoice,int categoryChoice) {
		boolean indicator=false;
		Calendar dateCalendar= Calendar.getInstance();

		for(int i=0; i<users.length;i++){
            if(users== null){
				switch(tipeUserChoice){
					case 1:
						users[i] = new StandarUser(id, name, nickname);
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
						users[i] = new PremiumUser(id, name, nickname,category);
						indicator=true;
					break;
				}
			}
		}
		return indicator;
	}

	public boolean editUser(int userPosition) {
		boolean indicator=false;

		return indicator;
	}

	public boolean deleteUser(int userPosition) {
		boolean indicator=true;
		users[userPosition]=null;
		return indicator;
	}

	public String getUserInfo(int option) {

		String msg = "";
		users[option].toString();
		return msg;
	}

	public String getAllUserInfo() {

		String msg = "";

		return msg;
	}

}
