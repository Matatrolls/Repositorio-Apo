package model;

public class Controller {

	private KnowledgeUnit[] units;

	public Controller() {

		units = new KnowledgeUnit[25];
		testCases();

	}
	
	public void testCases() {
		
		units[0] = new KnowledgeUnit("A001", "Gestion de repositorios", "Tecnico", "GitHub es una herramienta util");
		units[1] = new KnowledgeUnit("A002", "Gestion de equipos", "Experiencias", "Es importante definir responsabilidades claras");
		
	}

	public boolean registerKnowledgeUnit(String id, String description, String type, String learnedLessons) {
		
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
		boolean approved=true;
		units[choice-1].setApproved(approved);
		
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
