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
		exe.menuPrincipal();

	}

	public void testing(){
		controller.testCases();
		System.out.println("Casos de testeo creados");
	}

//||||||||||||||||||||||||||||Menus||||||||||||||||||||||||||||||||||||

	public void menuPrincipal() {
		int opcion=0;
		System.out.println("Buenos dias");
		while(opcion!=4){
			System.out.println("\nPor favor escoja que quiere hacer\n1:Abrir menu de proyectos\n2:Abrir menu de capsulas\n3:Testeo\n4:Cerrar programa");
			opcion=input.nextInt();
			switch(opcion){
				case 1:
					menuProject();
				break;

				case 2:
					menuCapsule();
				break;

				case 3:
					testing();
				break;

				case 4:
				System.out.println("Hasta luego, tenga buena tarde");
				break;

				default:
				System.out.println("Esa no es una opcion valida!, por favor escoja otra");
				break;
			}
	
		}
	}

	public void menuProject(){
		int opcion=0;

		System.out.println("\nPor favor escoja que quiere hacer\n1:Registrar un proyecto\n2:Consultar proyectos\n3:Cambiar etapa");
		opcion=input.nextInt();
		switch(opcion){
			case 1:
				registerProject();
			break;

			case 2:
				menuProjectConsult();
			break;

			case 3:
				changeStage();
			break;

			default:
			System.out.println("Esa no es una opcion valida!, por favor escoja otra");
			break;
		}
	}

	public void menuProjectConsult(){  
		int opcion=0;

		System.out.println("\nPor favor escoja que quiere hacer\n1:Ver lista de todos los proyectos\n2:Consultar todos los proyectos\n3:Consultar proyectos por fecha");
		opcion=input.nextInt();
		switch(opcion){
			case 1:
				System.out.println(controller.projectList());
			break;

			case 2:
			System.out.println(controller.projectInfo());
			break;

			case 3:
				menuByDate();
			break;

			default:
			System.out.println("Esa no es una opcion valida!, por favor escoja otra");
			break;
		}
	}

	public void menuCapsule(){
		int opcion=0;
		System.out.println("\nPor favor escoja que quiere hacer\n1:Registrar una capsula\n2:Aprobar una capsula \n3:Consultar todas las capsulas");
		opcion=input.nextInt();
			switch(opcion){
				case 1:
				registerKnowledgeUnit();
				break;

				case 2:
				approveKnowledgeUnit();
				break;

				case 3:
				showAllKnowledgeUnits();
				break;

				default:
				System.out.println("Esa no es una opcion valida!, por favor escoja otra");
				break;
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

	//||||||||||||||||||||||||||||||PROYECT||||||||||||||||||||||||||||||||||||||||

	public void registerProject() {
		String name; String clientName;String gerentName; String gerentCellphone;
		double budget;
		int projType;
		int iday;int imonth;int iyear;
		int fday;int fmonth;int fyear;
	
		//limpiezabuffer
		input.nextLine();

        System.out.println("Digite el nombre del proyecto");
        name= input.nextLine();

		System.out.println("Digite el tipo de proyecto\n1:Desarrollo\n2:Matenimiento\n3:Despliegue");
        projType= input.nextInt();

		//limpiezabuffer
		input.nextLine();

		System.out.println("Digite el nombre del cliente");
        clientName= input.nextLine();

		//fecha inicial
		System.out.println("Digite la fecha de inicio del proyecto");
		System.out.println("Dia");
		iday=input.nextInt();
		System.out.println("Mes");
		imonth=(input.nextInt()+1);
		System.out.println("Año");
		iyear=input.nextInt();
		

		//fecha final
		System.out.println("Digite la fecha de final del proyecto");
		System.out.println("Dia");
		fday=input.nextInt();
		System.out.println("Mes");
		fmonth=(input.nextInt()+1);
		System.out.println("Año");
		fyear=input.nextInt();
		

		System.out.println("Presupuesto");
        budget= input.nextDouble();

		//limpiezabuffer
		input.nextLine();

		System.out.println("Digite el nombre del gerente");
        gerentName= input.nextLine();

		System.out.println("Digite el numero de telefono del gerente");
        gerentCellphone= input.nextLine();

        if(controller.registerProject(name,projType,clientName,iday,imonth,iyear,fday,fmonth,fyear,budget,gerentName,gerentCellphone)){
            System.out.println("Proyecto registrado exitosamente");
        }
        else{
            System.out.println("Memoria llena, no se pudo registrar el proyecto");
        }
		
	}

	public void changeStage(){
		System.out.println("Por favor, escoja cual de los proyectos desea avanzar de etapa");
		System.out.println(controller.projectList());
		int choice=input.nextInt();
		if(controller.changeStage(choice)){
            System.out.println("Capsula aprobada exitosamente");
        }
        else{
            System.out.println("Error, no se pudo aprobar la capsula");
        }
	}

	public void searchProjectsAfterDate() {
		
		System.out.println("Ingrese la fecha");
		System.out.println("dia");
		int eday=input.nextInt();

		System.out.println("mes");
		int emonth=(input.nextInt()+1);

		System.out.println("anio");
		int eyear=input.nextInt();

    	System.out.println(controller.searchProjectsAfterDate(eday, emonth, eyear));
	}
	
	public void searchProjectsBeforeDate() {
		System.out.println("Ingrese la fecha");
		System.out.println("dia ");
		int eday = input.nextInt();

		System.out.println("mes ");
		int emonth = (input.nextInt()+1);

		System.out.println("anio");
		int eyear = input.nextInt();

    	System.out.println(controller.searchProjectsBeforeDate(eday, emonth, eyear));
	}
	
//||||||||||||||||||||||||||||||||KNOWLEDGEUNIT|||||||||||||||||||||||||||||

	public void registerKnowledgeUnit() {
		String id; String description; String learnedLessons;String collaboratorName;
		int choice;
		System.out.println("Ingrese la informacion");
		
		System.out.println("Escoja en que proyecto creara la capsula");
		System.out.println(controller.projectList());
		choice=input.nextInt();

		//limpiezabuffer
		input.nextLine();
		
		idcount=+1;
		id="A"+idcount;

        System.out.println("Digite Una breve descripcion de la capsula: ej:Gestion de repositorios");
        description= input.nextLine();

		System.out.println("Digite El nombre del colaborador");
        collaboratorName= input.nextLine();

		System.out.println("Digite el tipo de la capsula:\n1:Tecnico\n2:Experiencias");
		int temporal=input.nextInt();
	
    
		//limpiezabuffer
		input.nextLine();

		System.out.println("Digite La leccion aprendida de la capsula: ej:GitHub es una herramienta util");
        learnedLessons= input.nextLine();

        if(controller.registerKnowledgeUnit(choice,id,description, collaboratorName,temporal, learnedLessons)){
            System.out.println("Capsula registrada exitosamente");
        }
        else{
            System.out.println("Memoria llena, no se pudo registrar la capsula");
        }
    }
	
	public void approveKnowledgeUnit() {
		System.out.println("Escoja en que proyecto aprobara la capsula");
		System.out.println(controller.projectList());
		int choiceProject=input.nextInt();
		System.out.println("Por favor, escoja cual de las capsulas desea aprobar");
		System.out.println(controller.showKnowlegdeUnitList(choiceProject));
		int choice=input.nextInt();
		if(controller.approveKnowledgeUnit(choiceProject,choice)){
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