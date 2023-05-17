package model;

public class Controller {

	private Property[] properties;
	
	public Controller() {

		this.properties = new Property[10];
		testCases();

	}

	public void testCases() {

		properties[0] = new House("Vila Verde", "Cali", "Cra 4 # 57 - 23", 3,1);
		properties[1] = new Apartment("Palmar", "Palmira", "Calle 6 # 4 - 12", 4,"201B");
	}

	public String getProperties() {

		String propertiesRegistered = "";

		for (int i = 0; (i < properties.length); i++) {

			if (properties[i] != null) {

				propertiesRegistered += "\n" + (i + 1) + ". " + properties[i].getName() + " - "+ properties[i].getCity();

			}

		}

		return propertiesRegistered;

	}

	public boolean registerProperty(String propertyName, String city, String address, int roomCount,int choice,String especial) {


		for (int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				switch(choice){
					case 1:
						int floors = Integer.parseInt(especial);
						properties[i] = new House(propertyName, city, address, roomCount,floors);
					break;
					case 2:

						properties[i] = new Apartment(propertyName, city, address, roomCount,especial);
					break;
				}
				

				return true;
			}

		}

		return false;
	}

	public String bookProperty(int bookedProperty, int nights){
		String msg="";
		if(properties[bookedProperty] instanceof House){
			msg+=((House)properties[bookedProperty]).priceable(nights);
		}
		if(properties[bookedProperty] instanceof Apartment){
			msg+=((Apartment)properties[bookedProperty]).priceable(nights);
		}
		return msg;
	}

}
