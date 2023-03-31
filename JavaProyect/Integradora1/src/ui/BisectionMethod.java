package ui;
import java.util.Scanner;

//Hola Mundo

public class BisectionMethod {
    public static Scanner input = new Scanner(System.in);
	public static double alimit=0;
	public static double blimit=0;
	public static double epsilon=0.001;
    public static void main(String args[]) {
        int choice=0;
		System.out.println("Se recomienda poner el valor mayor del intervalo en (a)");
        System.out.println("Por favor ingrese su valor del primer digito del intervalo de su raiz(a)");
        alimit= input.nextDouble();
        System.out.println("Por favor ingrese su valor del segundo digito del intervalo de su raiz(b)");
        blimit= input.nextDouble();
		while(choice!=5){
			System.out.println("Escoja que funcion desea realizar");
			System.out.println("1: 2*cos(x^2)");
			System.out.println("2: 3x^3+7x^2+5 ");
			System.out.println("3: x*cos(x) ");
			System.out.println("4: Cambiar los limites");
			System.out.println("5: Salir del programa");
			choice = input.nextInt();
			menu(choice);
            
		}
    }
    /**
	*descripcion: this method its only a menu, and redirect variables to the funcions methods
	*@param opcion int this variable its the choice of the user of what the user wish to use in the algoritm
	*@return void
	*/
    public static void menu(int choice){
		switch(choice){
			case 1:
			funcion1();
			break;
			case 2:
			funcion2();
			break;
			case 3:
			funcion3();
			break;
			case 4:
			System.out.println("Por favor ingrese su valor del primer digito del intervalo de su raiz(a)");
			alimit= input.nextDouble();
			System.out.println("Por favor ingrese su valor del segundo digito del intervalo de su raiz(b)");
			blimit= input.nextDouble();
			break;
			case 5:
			System.out.println("Saliste del programa");
            default:
            System.out.println("Escoja una opcion valida");
            break;
		}
	}
	
	
	//bisection

	/**
	*descripcion: this method its the bisection method for the first funtion on the menu, it is 2cos(x^2)
	*@param alimit double this its the first digit of the limit
	*@param blimit double this its the second digit of the limit
	*@return void
	*/
	public static void funcion1(){
		double N=0;
		double c=0;
		double c_i=0;
		double error=0;
		double a=alimit;
		double b=blimit;
		
		N=abs(b-a);
		
		do{
			c=(a+b)/2;
			
			if(resultF1(a)*resultF1(b)<0){
				b=c;
			} else {
				a=c;
				error=abs(b-a)/(2*N);
			}
		}
		while(error>epsilon); 
		
		do{
			c_i=c; 
			c=(a+b)/2;
			
			if(resultF1(a)*resultF1(b)<0){
				b=c;
			}else{
				a=c;
				error=abs(c-c_i); 
			}
		}while(error>epsilon);

		do{
			c=(a+b)/2;
			
			if(resultF1(a)*resultF1(b)<0) {
				b=c;
			}else{
				a=c;
			}
		}
		while(abs(resultF1(c))>epsilon); 
		
		System.out.println("raiz en "+c);
	}
	
	/**
	*descripcion: this method its the bisection method for the second funtion on the menu, it is 3x^3+7x^2+5
	*@param alimit double this its the first digit of the limit
	*@param blimit double this its the second digit of the limit
	*@return void
	*/
	public static void funcion2(){
		double N=0;
		double c=0;
		double c_i=0;
		double error=0;
		double a=alimit;
		double b=blimit;
		if(resultF2(a)*resultF2(b)<0){
			N=abs(b-a);
			do{
				c=(a+b)/2;
				
				if(resultF2(a)*resultF2(b)<0){
					b=c;
				} else {
					a=c;
					error=abs(b-a)/(2*N);
				}
			}
			while(error>epsilon); 
			
			do{
				c_i=c; 
				c=(a+b)/2;
				
				if(resultF2(a)*resultF2(b)<0){
					b=c;
				}else{
					a=c;
					error=abs(c-c_i); 
				}
			}
			while(error>epsilon);

			do{
				c=(a+b)/2;
				
				if(resultF2(a)*resultF2(b)<0) {
					a=c;
				}else{
					b=c;
				}
			}
			while(abs(resultF2(c))>epsilon); 
		}
		System.out.println("raiz en "+c);
	}

	/**
	*descripcion: this method its the bisection method for the third funtion on the menu, it is xcos(x)
	*@param alimit double this its the first digit of the limit
	*@param blimit double this its the second digit of the limit
	*@return void
	*/
	public static void funcion3(){
		double N=0;
		double c=0;
		double c_i=0;
		double error=0;
		double a=alimit;
		double b=blimit;

		if(resultF3(a)*resultF3(b)<0){
			N=abs(b-a);
			do{
				c=(a+b)/2;
				
				if(resultF3(a)*resultF3(b)<0){
					b=c;
				} else {
					a=c;
					error=abs(b-a)/(2*N);
				}
			}
			while(error>epsilon); 
			
			do{
				c_i=c; 
				c=(a+b)/2;
				
				if(resultF3(a)*resultF3(b)<0){
					b=c;
				}else{
					a=c;
					error=abs(c-c_i); 
				}
			}
			while(error>epsilon);

			do{
				c=(a+b)/2;
				
				if(resultF3(a)*resultF3(b)<0) {
					a=c;
				}else{
					b=c;
				}
			}
			while(abs(resultF3(c))>epsilon); 
		}
		System.out.println("raiz en "+c);
	}

    
	
	
	//Image of y by x

	/**
	*descripcion: this method its the first funtion on the menu, it is 2cos(x^2)
	*@param x double this its the variable that will be on the x space on the funtion
	*@return result double this its the result of the funcion evaluated
	*/
	
	public static double resultF1(double x){
		double result=2*cos(power(x,2));
		return result;
	}

	/**
	*descripcion: this method its the first funtion on the menu, it is 3x^3+7x^2+5
	*@param x double this its the variable that will be on the x space on the funtion
	*@return result double this its the result of the funcion evaluated
	*/
	public static double resultF2(double x){
		double result=3*power(x,3)+7*power(x,2)+5;
		return result;
	}

	/**
	*descripcion: this method its the first funtion on the menu, it is xcos(x)
	*@param x double this its the variable that will be on the x space on the funtion
	*@return result double this its the result of the funcion evaluated
	*/
	public static double resultF3(double x){
		double result=x*cos(x);
		return result;
	}
	
	
	//maths

	/**
	*descripcion: this method is to do a cosine operation
	*@param x double this variable work as the x in the cosine operation
	*@return result double this its de cosine result of x
	*/
    public static double cos(double x){
        double result=0;
        double a,b,c,d,e;
        for(int i=0;i<=100;i++){
            a=-1;
            b=power(a,i);
            c=2*i;
            d=fact(c);
            e=power(x,c);
            result+=(b/d)*e;
        }
    return result;
    }
    /**
	*descripcion: this method let the user do a exponential operation
	*@param a double this variable work as the base for the exponential operation
    *@param b double this variable work as the exponent for the exponential operation
	*@return result double this its the result of the exponencial operation
	*/
    public static double power(double a,double b){
        double result = 1;
        if(b==0){
            return result;
        }
        else{
            while (b != 0) {
                result = result * a;
                b--;
            }
            return result;
        }
        
    }
    /**
	*descripcion: this method let the user do a factorial operation 
	*@param number double this its the number thats is going to be used for the factoral 
	*@return result1 double this its the result of the factorial operation
	*/
    public static double fact(double number) {
        double b=1; 
        double result;
        if(number==0){
            return b;
        }
        else{
            for (double i=number;i>1;i--){
                b=b*i;
            }
            result=b;
        }
        
        return result;
    }
     /**
	*descripcion: this method let the user do a absolute valor operation 
	*@param number double this its the number thats is going to be used for the absolute valor
	*@return result double this its the absolute valor of the variable number double
	*/
    public static double abs(double number){
        double result;
        if(number<0){
            result=number*(-1);
        }
        else{
            result=number;
        }
        return result;
    }
    
}