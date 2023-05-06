package model;


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

		for(int i=0; i<users.length;i++){
            if(users[i]== null && !indicator){
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

	public boolean editUser(int userPosition,int categoryChange, int categoryChoice,String stringchange) {
		boolean indicator=false;
		switch(categoryChange){
			case 1:
			users[userPosition].setName(stringchange);
			indicator =true;
			break;

			case 2:
			users[userPosition].setNickname(stringchange);
			indicator=true;
			break;

			case 3:
			PremiumCategory temporal= PremiumCategory.PLATA;
			switch(categoryChoice){
				case 0:
				if(users[userPosition] instanceof PremiumUser){
					for(int i =0;i<users.length;i++){
						if(users[i]==null){
							StandarUser temporalUser = new StandarUser(users[userPosition].getId(),users[userPosition].getName() , users[userPosition].getNickname());
							users[userPosition]=temporalUser;
							return true;
						}
					}
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

			if(users[userPosition] instanceof PremiumUser){
				((PremiumUser)users[userPosition]).setPremiumcategory(temporal);
				return true;
			}
			if(users[userPosition] instanceof StandarUser){
				for(int i =0;i<users.length;i++){
					if(users[i]==null){
						PremiumUser temporalUser = new PremiumUser(users[userPosition].getId(),users[userPosition].getName() , users[userPosition].getNickname(), temporal);
						users[userPosition]=temporalUser;
						return true;
					}
				}
			}
		}
		return indicator;
	}

	public boolean deleteUser(int userPosition) {
		boolean indicator=true;
		users[userPosition]=null;
		return indicator;
	}

	public String getUserInfo(int option) {

		String msg = "";
		msg =users[option].toString();
		return msg;
	}

	public String getAllUserInfo() {

		String msg ="";

		for(int i=0;i<users.length;i++){
			if(users[i] == null){
				
			}
			else{
				msg+=users[i].toString();
			}
		}
		return msg;
	}

}
