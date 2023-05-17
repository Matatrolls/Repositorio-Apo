package model;

public class House extends Property{
    private int pisos;

    private int BASEHOUSEVALUE= 40000;	
    private int NIGHTHOUSEVALUE= 40000;

    House(String name, String city, String address, int roomCount,int pisos){
        super(name, city, address, roomCount);
        this.pisos=pisos;
    }


    @Override
    public String priceable(int nights) {
      String msg="";
        int nightsPrice=nights*NIGHTHOUSEVALUE;
        int totalPrice=BASEHOUSEVALUE+nightsPrice;
        msg="\n-------------------------------------------------------------------\nSu total es: "+totalPrice
        +"\nPrecio por noche: "+nightsPrice+
        "\nPrecio Base por servicio: "+BASEHOUSEVALUE+
            "\n-------------------------------------------------------------------";
      return msg;
    }



}
