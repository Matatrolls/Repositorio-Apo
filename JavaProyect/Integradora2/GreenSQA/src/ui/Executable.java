package ui;

import java.util.Scanner;
import model.Controller;

/**
 * This class its the executable of the GREENSQA PROJECT
 * @author: Rodolfo Moreno
 * @version: 04/05/2023
 */
public class Executable {
//||||||||||||||||VARIABLES OF THE CLASS||||||||||||||
	public int idcount=0;
	private Scanner input;
	private Controller controller;
/**
 * Creator of the class executable
 */
	public Executable() {

		input = new Scanner(System.in);
		controller = new Controller();
		
	}

/**
 * Main method, this executes the principal menu to start all the program
 */
	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menuPrincipal();

	}

	/**
	 * This method is used to call a method in the class controller to create testing cases
	 */
	public void testing(){
		controller.testCases();
		System.out.println("Casos de testeo creados");
	}

//||||||||||||||||||||||||||||MENUS||||||||||||||||||||||||||||||||||||

/**
 * This method is the main menu, which lead to more menus more especific for the user needs
 */
	public void menuPrincipal() {
		int opcion=0;
		System.out.println("Buenos dias");
		while(opcion!=5){
			System.out.println("\nPor favor escoja que quiere hacer\n1:Abrir menu de proyectos\n2:Abrir menu de capsulas\n3:Testeo\n4:Abrir menu de informes\n5:Cerrar programa");
			opcion=input.nextInt();
			switch(opcion){
				case 1:
					menuProject();
				break;

				case 2:
					menuKnowledgeUnit();
				break;

				case 3:
					testing();
				break;

				case 4:
					menuInform();
				break;

				case 5:
				System.out.println("Hasta luego, tenga buena tarde");
				break;

				default:
				System.out.println("Esa no es una opcion valida!, por favor escoja otra");
				break;
			}
	
		}
	}

/**
 * This method is a menu used for the project options that the program allow
 */
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

/**
 * This method its a sub menu for the menuProject() option consult, it shows the list of created projects
 *  and lead to another menu
 */
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

/**
 * This method is a menu used for the KnowledgeUnits options that the program allow
 */
	public void menuKnowledgeUnit(){
		int opcion=0;
		System.out.println("\nPor favor escoja que quiere hacer\n1:Registrar una capsula\n2:Aprobar una capsula \n3:Publicar capsulas aprobadas\n4:Consultar todas las capsulas\n5:Consultar las capsulas publicadas");
		opcion=input.nextInt();
			switch(opcion){
				case 1:
					registerKnowledgeUnit();
				break;

				case 2:
					approveKnowledgeUnit();
				break;

				case 3:
					publishKnowledgeUnit();
				break;

				case 4:
					showAllKnowledgeUnits();
				break;

				case 5:
				showAllPublishedKnowledgeUnits();
				break;

				default:
				System.out.println("Esa no es una opcion valida!, por favor escoja otra");
				break;
			}
	}

/**
 * This method its a sub menu from menuProjectConsult(), this method allow the user to choose between 
 * searchProjectsBeforeDate() and searchProjectsAfterDate()
 */
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

/**
 * This function displays a menu and allows the user to select different options to generate various
 * types of reports.
 */
	public void menuInform(){
		int temporal=0;
		while (temporal==0){
			System.out.println("Por favor, ingrese que quiere hacer\n1:Informe total tipo de capsulas\n2:Informe lecciones por etapa\n3:Informe proyecto con mas capsulas\n4:Informe de busqueda de colaborador\n5:Informar al usuario de capsulas con #");
			temporal=input.nextInt();
			switch(temporal){
				case 1:
					consultKnowledgeUnitType();
				break;

				case 2:
					consultLearnedLeccionByStage();
				break;

				case 3:
					consultMostRegisteredKnowledgeUnitsByProject();
				break;

				case 4:
					consultProjectsByCollaborator();
				break;

				case 5:
					consultByHashtag();
				break;

				default:
				System.out.println("Por favor ingrese una opcion valida");
				temporal=0;
				break;
			}
		}
	}
//||||||||||||||||||||||||||||||PROYECT||||||||||||||||||||||||||||||||||||||||

/**
 * This method allow the user to send params to create a project and send them to the controller 
 */
	public void registerProject() {
		String name; String clientName;String gerentName; String gerentCellphone;
		double budget;
		int iday;int imonth;int iyear;
		int fday;int fmonth;int fyear;
		int durationStage1;int durationStage2;int durationStage3;int durationStage4;int durationStage5;int durationStage6;
	
		//limpiezabuffer
		input.nextLine();

        System.out.println("Digite el nombre del proyecto");
        name= input.nextLine();

		System.out.println("Digite la duracion en meses de la etapa: 1 del proyecto");
		durationStage1= input.nextInt();

		
		System.out.println("Digite la duracion en meses de la etapa: 2 del proyecto");
		durationStage2= input.nextInt();

		
		System.out.println("Digite la duracion en meses de la etapa: 3 del proyecto");
		durationStage3= input.nextInt();

		
		System.out.println("Digite la duracion en meses de la etapa: 4 del proyecto");
		durationStage4= input.nextInt();
		
		System.out.println("Digite la duracion en meses de la etapa: 5 del proyecto");
		durationStage5= input.nextInt();

		
		System.out.println("Digite la duracion en meses de la etapa: 6 del proyecto");
		durationStage6= input.nextInt();

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

        if(controller.registerProject(name,durationStage1,durationStage2,durationStage3,durationStage4,durationStage5,durationStage6,clientName,iday,imonth,iyear,fday,fmonth,fyear,budget,gerentName,gerentCellphone)){
            System.out.println("Proyecto registrado exitosamente");
        }
        else{
            System.out.println("Memoria llena, no se pudo registrar el proyecto");
        }
		
	}

/**
 * This method allow the user to change the stage of a previusly created project
 */
	public void changeStage(){
		System.out.println("Por favor, escoja cual de los proyectos desea avanzar de etapa");
		System.out.println(controller.projectList());
		int choice=input.nextInt();
			
		System.out.println("Ingrese la fecha de finalizacion de la etapa actual ");
		System.out.println("dia");
		int fday=input.nextInt();

		System.out.println("mes");
		int fmonth=(input.nextInt()+1);

		System.out.println("anio");
		int fyear=input.nextInt();

				
		System.out.println("Ingrese la fecha de inicion de la siguiente etapa ");
		System.out.println("dia");
		int iday=input.nextInt();

		System.out.println("mes");
		int imonth=(input.nextInt()+1);

		System.out.println("anio");
		int iyear=input.nextInt();

		if(controller.changeStage(choice,fyear,fmonth,fday,iyear,imonth,iday)){
            System.out.println("Etapa avanzada exitosamente");
        }
        else{
            System.out.println("Error, no se pudo avanzar de etapa");
        }
	}

/**
 * This method allow the user to search Projects created after X date
 */
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
	
/**
 * This method allow the user to search Projects created before X date
 */
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

/**
 * This method allow the user to send params to create a KnowledgeUnit and send them to the controller 
 */
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

		System.out.println("Digite el tipo de la capsula:\n1:Tecnico\n2:Gestion\n3:Dominio\n4:Experiencias");
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
	
/**
 * This method allow the user to change the state of a KnowledgeUnit from POR_DEFINIR to APROBADA of a 
 * previously created Knowledgeunit
 */
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

/**
 * This function allows a user to select a project and a knowledge unit to publish, and then publishes
 * the selected knowledge unit if it has been approved.
 */
	public void publishKnowledgeUnit(){
		System.out.println("Por favor, escoja en cual de los siguientes proyectos desea publicar");
		System.out.println(controller.projectList());
		int projtChoice=input.nextInt();
		System.out.println("Por favor, escoja cual de las capsulas desea publicar");
		System.out.println(controller.showApprovedKnowlegdeUnitList(projtChoice));
		int choice=input.nextInt();
		if(controller.publishKnowledgeUnit(projtChoice,choice)){
            System.out.println("Capsula publicada exitosamente");
        }
        else{
            System.out.println("Error, no se pudo publicar la capsula, recuerde que para publicarse debe estar aprovaba antesd");
        }

	
	}

/**
 * This method allow the user to see all the created KnowledgeUnits
 */
	public void showAllKnowledgeUnits() {
		System.out.println(controller.getAllKnowledgeUnits());
	}

/**
 * This Java function prints a list of all published knowledge units using a controller.
 */
	public void showAllPublishedKnowledgeUnits() {
		System.out.println(controller.showPublishedKnowlegdeUnitList());
	}

//||||||||||||||||||||||||||||||INFORMS||||||||||||||||||||||||||||

/**
 * This function prints the result of consulting the knowledge unit type from a controller.
 */
	public void consultKnowledgeUnitType(){
		System.out.println(controller.consultKnowledgeUnitType());
	}

/**
 * This function prompts the user to choose a project stage and returns the learned lessons for that
 * stage.
 */
	public void consultLearnedLeccionByStage(){
		System.out.println("Por favor escoga de que etapa quiere saber sus lecciones aprendidas\n1:INICIO\n2:ANALISIS\n3:DISENO\n4:EJECUCION\n5:CIERRE\n6:SEGUIMIENTO Y CONTROL");
		int choice=input.nextInt();
		System.out.println(controller.consultLearnedLeccionByStage(choice));
	}

/**
 * This function prints out the result of a query to the controller for the most registered knowledge
 * units by project.
 */
	public void consultMostRegisteredKnowledgeUnitsByProject(){
		System.out.println(controller.consultMostRegisteredKnowledgeUnitsByProject());
	}

/**
 * This Java function prompts the user to input a collaborator's name and then displays a list of
 * projects created by that collaborator.
 */
	public void consultProjectsByCollaborator(){
		//limpieza buffer
		input.nextLine();
		System.out.println("Por favor escriba el nombre del Colaborador del cual desea buscar sus capsulas creadas");
		String choice=input.nextLine();
		System.out.println("Las capsulas escritas por el colaborador son:\n"+controller.consultProjectsByCollaborator(choice));
	}

/**
 * This Java function prompts the user to input a hashtag and then displays a list of capsules
 * associated with that hashtag.
 */
	public void consultByHashtag(){
		//limpieza buffer
		input.nextLine();
		System.out.println("Por favor escriba el ## el cual desea buscar sus capsulas creadas");
		String choice=input.nextLine();
		System.out.println("Las capsulas con la busqueda son:\n"+controller.consultByHashtag(choice));
	}
}