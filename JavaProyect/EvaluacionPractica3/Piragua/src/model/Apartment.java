package model;

public class Apartment extends Property{
    private String codigo;

    private int BASEAPPARTMENTVALUE= 30000;
	private int NIGHTAPPARTMENTVALUE= 30000;

    Apartment(String name, String city, String address, int roomCount, String codigo){
        super(name, city, address, roomCount);
        this.codigo= codigo;
    }

    @Override
    public String priceable(int nights) {
      String msg="";
        int nightsPrice=nights*NIGHTAPPARTMENTVALUE;
        int totalPrice=BASEAPPARTMENTVALUE+nightsPrice;
        msg="\n-------------------------------------------------------------------\nSu total es: "+totalPrice
        +"\nPrecio por noche: "+nightsPrice+
        "\nPrecio Base por servicio: "+BASEAPPARTMENTVALUE+
            "\n-------------------------------------------------------------------";
      return msg;
    }
}
