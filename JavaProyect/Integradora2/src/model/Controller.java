package model;

public class Controller {

	private KnowledgeUnit[] units;
	private Project[] projecUnits;

	public Controller() {

		units = new KnowledgeUnit[25];
		projecUnits = new Projects[10];
		testCases();
		
	}
	
	public void testCases() {
		
		units[0] = new KnowledgeUnit("A001", "Gestion de repositorios", Type.TECNICO, "GitHub es una herramienta util");
		units[1] = new KnowledgeUnit("A002", "Gestion de equipos", Type.TECNICO, "Es importante definir responsabilidades claras");
		
	}
//|||||||||||||||||||||||||PROJECTS|||||||||||||||||||||||||||
	public boolean registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget){
		projecUnit = new Project(name,clientName,initialDate,finalDate,budget);
		boolean indicador =false;
		for(int i=0;i<units.length;i++){
			if(units[i]==null && !indicador){
				units[i]= capsUnit;
				indicador =true;
			}
				
		}
		
		return indicador;
	}

//|||||||||||||||||||kNOWLEGDEUNITS||||||||||||||||||||||||||||||

	public boolean registerKnowledgeUnit(String id, String description, int temporal, String learnedLessons) {
		Type type;
		switch(temporal){
			case 1:
			type=Type.TECNICO;
			break;
			case 2:
			type=Type.EXPERIENCIAS;
			break;
			default:
			type=Type.TECNICO;
			break;
		}
		KnowledgeUnit capsUnit = new KnowledgeUnit(id,description, type, learnedLessons);
		boolean indicador =false;
		for(int i=0;i<units.length;i++){
			if(units[i]==null && !indicador){
				units[i]= capsUnit;
				indicador =true;
			}
				
		}
		
		return indicador;
	}

	public boolean approveKnowledgeUnit(int choice) {
		boolean indicador=true;
		units[choice-1].setStatus(Status.APROBADA);
		
		return indicador;
	}

	public String showKnowlegdeUnitList(){
		String msg="";
		for(int i=0;i<units.length;i++){
			if(units[i]==null){
			}
			else{
				msg+=units[i].toStringUnaproved(i);
			}
		}
		return msg;
	}

	public String getAllKnowledgeUnits() {
		String msg="";
		for(int i=0;i<units.length;i++){
			if(units[i]==null){
			}
			else{
				msg+=units[i].toString();
			}
		}
		return msg;
	}

}
