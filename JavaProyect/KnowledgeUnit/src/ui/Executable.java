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
		while(opcion!=4){
			System.out.println("\nPor favor escoja que quiere hacer\n1:Registrar una capsula\n2:Aprobar una capsula \n3:Consultar una capsula\n4:Cerrar programa");
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

				case 4:
				System.out.println("Hasta luego, tenga buena tarde");
				break;

				default:
				System.out.println("Esa no es una opcion valida!, por favor escoja otra");
				break;
			}
	
		}
	}
	
	public void registerKnowledgeUnit() {
		String id; String description; String type; String learnedLessons;
		System.out.println("Ingrese la informacion");
		//limpiezabuffer
		input.nextLine();
		
		idcount=+1;
		id="A"+idcount;

        System.out.println("Digite Una breve descripcion de la capsula: ej:Gestion de repositorios");
        description= input.nextLine();

		System.out.println("Digite el tipo de la capsula:\n1:Tecnico\n2:Experiencias");
		int temporal=input.nextInt();
		switch(temporal){
			case 1:
			type="Tecnico";
			break;
			case 2:
			type="Experiencias";
			break;
			default:
			type="Tecnico";
			break;
		}
    
		//limpiezabuffer
		input.nextLine();

		System.out.println("Digite La leccion aprendida de la capsula: ej:GitHub es una herramienta util");
        learnedLessons= input.nextLine();

        if(controller.registerKnowledgeUnit(id,description, type, learnedLessons)){
            System.out.println("Capsula registrada exitosamente");
        }
        else{
            System.out.println("Memoria llena, no se pudo registrar la capsula");
        }
    }
	
	
	private void approveKnowledgeUnit() {
		System.out.println(controller.showKnowlegdeUnitList());
		System.out.println("Por favor, escoja cual de las capsulas desea aprobar");
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