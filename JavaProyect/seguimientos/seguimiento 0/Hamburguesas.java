import java.util.Scanner;

public class Hamburguesas{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double cantidad=0;
        double PRECIO=25000;
        double impuesto=0;
        double precioTotal=0;
        double precioFinal=0;
        System.out.println("Por favor ingrese cuantas hamburguesas desea comprar");
        cantidad = input.nextDouble();
        precioTotal=calculo1(cantidad,PRECIO);
        impuesto=calculo2(precioTotal);
        precioFinal=calculo3(precioTotal,impuesto);
        System.out.println("======================================================");
        System.out.println("El total de las hamburguesas fue: "+precioTotal);
        System.out.println("El impuesto fue: "+impuesto);
        System.out.println("El total a pagar es: "+precioFinal);
        System.out.println("======================================================");
    }
    public static double calculo1(double cantidad,double PRECIO) {
        double resultado1= cantidad*PRECIO;
        return resultado1;
    }
    public static double calculo2(double precioTotal) {
        double resultado2= precioTotal*0.08;
        return resultado2;
    }
    public static double calculo3(double precioTotal, double impuesto) {
        double resultado3=precioTotal+impuesto;
        return resultado3;
    }

}