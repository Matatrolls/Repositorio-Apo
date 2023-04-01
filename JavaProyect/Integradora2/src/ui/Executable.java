package ui;

import java.util.Scanner;
import model.Controller;


public class Executable {
	public int idcount=0;
	private Scanner input;
	private Controller controller;
	public Executable() {

		input = new Scanner(System.in);
		controller = new Controller();
		
	}

	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menu();

	}

	
	public void menu() {
		int opcion=0;
		System.out.println("Buenos dias");
		while(opcion!=7){
			System.out.println("\nPor favor escoja que quiere hacer\n1:Registrar un proyecto\n2:Consultar proyectos por fecha\n3:Registrar una capsula\n4:Aprobar una capsula \n5:Consultar una capsula\n7:Cerrar programa");
			opcion=input.nextInt();
			switch(opcion){
				case 1:
				registerProject();
				break;

				case 2:
				menuByDate();
				break;

				case 3:
				registerKnowledgeUnit();
				break;

				case 4:
				approveKnowledgeUnit();
				break;

				case 5:
				showAllKnowledgeUnits();
				break;

				case 6:

				break;

				case 7:
				System.out.println("Hasta luego, tenga buena tarde");
				break;

				default:
				System.out.println("Esa no es una opcion valida!, por favor escoja otra");
				break;
			}
	
		}
	}

	//||||||||||||||||||||||||||||||PROYECT||||||||||||||||||||||||||||||||||||||||

	//Incomplete
	public void registerProject() {
		String name; String clientName;
		double budget;
		int projType;
		int iday;int imonth;int iyear;
		int fday;int fmonth;int fyear;
	
		//limpiezabuffer
		input.nextLine();
		

        System.out.println("Digite el nombre del proyecto");
        name= input.nextLine();

		System.out.println("Digite el tipo de proyecto\n1: Desarrollo\n2:Matenimiento\n3:Despliegue");
        projType= input.nextInt();

		System.out.println("Digite el nombre del cliente");
        clientName= input.nextLine();

		//fecha inicial
		System.out.println("Digite la fecha de inicio del proyecto");
		System.out.println("Dia");
		iday=input.nextInt();
		System.out.println("Mes");
		imonth=input.nextInt();
		System.out.println("Año");
		iyear=input.nextInt();
		

		//fecha final
		System.out.println("Digite la fecha de final del proyecto");
		System.out.println("Dia");
		fday=input.nextInt();
		System.out.println("Mes");
		fmonth=input.nextInt();
		System.out.println("Año");
		fyear=input.nextInt();
		

		System.out.println("Presupuesto");
        budget= input.nextDouble();


         if(controller.registerProject(name,projType,clientName,iday,imonth,iyear,fday,fmonth,fyear,budget)){
            System.out.println("Proyecto registrado exitosamente");
        }
        else{
            System.out.println("Memoria llena, no se pudo registrar el proyecto");
        }
		
	}

	public void menuByDate(){
		int temporal=0;
		while (temporal==0){
			System.out.println("Por favor, ingrese que quiere hacer\n1:Buscar proyecto anterior a fecha X\n2:Buscar proyecto despues de fecha X");
			temporal=input.nextInt();
			switch(temporal){
				case 1:
				searchProjectsBeforeDate();
				break;
				case 2:
				searchProjectsAfterDate();
				break;
				default:
				System.out.println("Por favor ingrese una opcion valida");
				temporal=0;
				break;
			}
		}
	}

	public void searchProjectsAfterDate() {
		
		System.out.println("Ingrese la fecha");
		System.out.println("dia ");
		int eday = input.nextInt();

		System.out.println("mes ");
		int emonth = input.nextInt();

		System.out.println("anio");
		int eyear = input.nextInt();

		String information = controller.searchProjectsAfterDate(eday, emonth, eyear);

       

    	System.out.println(information);
	}
	
	public void searchProjectsBeforeDate() {
		System.out.println("Ingrese la fecha");
		System.out.println("dia ");
		int eday = input.nextInt();

		System.out.println("mes ");
		int emonth = input.nextInt();

		System.out.println("anio");
		int eyear = input.nextInt();

		String information = controller.searchProjectsBeforeDate(eday, emonth, eyear);

       

    	System.out.println(information);
	}
	
//||||||||||||||||||||||||||||||||KNOWLEDGEUNIT|||||||||||||||||||||||||||||

	public void registerKnowledgeUnit() {
		String id; String description; String learnedLessons;
		System.out.println("Ingrese la informacion");
		//limpiezabuffer
		input.nextLine();
		
		idcount=+1;
		id="A"+idcount;

        System.out.println("Digite Una breve descripcion de la capsula: ej:Gestion de repositorios");
        description= input.nextLine();

		System.out.println("Digite el tipo de la capsula:\n1:Tecnico\n2:Experiencias");
		int temporal=input.nextInt();
	
    
		//limpiezabuffer
		input.nextLine();

		System.out.println("Digite La leccion aprendida de la capsula: ej:GitHub es una herramienta util");
        learnedLessons= input.nextLine();

        if(controller.registerKnowledgeUnit(id,description, temporal, learnedLessons)){
            System.out.println("Capsula registrada exitosamente");
        }
        else{
            System.out.println("Memoria llena, no se pudo registrar la capsula");
        }
    }
	
	public void approveKnowledgeUnit() {
		System.out.println("Por favor, escoja cual de las capsulas desea aprobar");
		System.out.println(controller.showKnowlegdeUnitList());
		int choice=input.nextInt();
		if(controller.approveKnowledgeUnit(choice)){
            System.out.println("Capsula aprobada exitosamente");
        }
        else{
            System.out.println("Error, no se pudo aprobar la capsula");
        }
	}

	public void showAllKnowledgeUnits() {
		System.out.println(controller.getAllKnowledgeUnits());
	}

}