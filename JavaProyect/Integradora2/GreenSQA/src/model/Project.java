package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Project{
	
	private String name;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
	private String gerentName;
	private String gerentCellphone;
	private DateFormat formatter;
	private KnowledgeUnit[] units;
	private Stage[] stages;

/*
 * This method create a new Project with the info that the user provides
 * @param name This its the name that the user wants to call the new project
 * @param clientName This its the client name 
 * @param initialDate this its the date of start of the Project
 * @param finalDate this its the date of end of the Project
 * @param budget This its the budget that the project have
 * @param gerentName gerentName This its the name of the gerent of the project
 * @param gerentCellphone  This its the cellphone of the genert of the project
 */
	public Project(String name,String clientName, Calendar initialDate, Calendar finalDate, double budget,String gerentName,String gerentCellphone){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");
		this.name = name;
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
		this.gerentName= gerentName;
		this.gerentCellphone=gerentCellphone;
		units = new KnowledgeUnit[50];
		stages = new Stage[6];
		Stage();
	}

//||||||||||||||||||||||KNOWLEGDEUNITS||||||||||||||||||||||||||||||||||||||

/*
 * This method creates a new KnowledgeUnit in the project
 * @param id its the unique id of the KnowledgeUnit
 * @param description it the description of the KnowledgeUnit
 * @param collaboratorName Its the name of the creator of the KnowledgeUnit
 * @param temporal its used to change the type from the KnowledgeUnit
 * @param learnedLessons it the lesson learned from the KnowledgeUnit
 * @return indicator This indicates if a new project was created or not
 */
	public boolean registerKnowledgeUnit(String id, String description,String collaboratorName ,int temporal, String learnedLessons) {
	CapsType type;
	description="#"+description+"#";

	switch(temporal){
		case 1:
			type=CapsType.TECNICO;
		break;

		case 2:
			type=CapsType.GESTION;
		break;

		case 3:
			type=CapsType.DOMINIO;
		break;

		case 4:
			type=CapsType.EXPERIENCIAS;
		break;

		default:
			type=CapsType.TECNICO;
		break;
	}

	String stage="";
	for(int i2=0;i2==5;i2++){
		if(stages[i2].getActive()==true){
			stage=stages[i2].getStageType();
		}
	}
	KnowledgeUnit capsUnit = new KnowledgeUnit(name,stage,id,description,collaboratorName, type, learnedLessons);
	boolean indicador =false;
	for(int i=0;i<units.length;i++){
		if(units[i]==null && !indicador){
			units[i]= capsUnit;
			indicador =true;
		}
			
	}
	
	return indicador;
}

/*
 * This method change the Status from the KnowledgeUnit from POR_DEFINIR to APROBADA
 * @param choice this its the choosed KnowledgeUnit to approve
 * @return indicator This indicates if a new project was created or not
 */
	public boolean approveKnowledgeUnit(int choice) {
		boolean indicador=true;
		units[choice-1].setStatus(Status.APROBADA);
		
		return indicador;
	}

/*
 * This method evaluate the KnowledgeUnits array and in the not null spaces uses the method toStringUnapproved 
 * @return msg this variable its the concatenation of all the not approved KnowledgeUnits that the method returns 
 */
	public String showKnowlegdeUnitList(){
		String msg="";
		for(int i=0;i<units.length;i++){
			if(units[i]==null){
			}
			else{
				msg+="Proyecto "+(i+1)+units[i].toStringUnaproved(i);
			}
		}
		return msg;
	}

	/*
 * This method evaluate the KnowledgeUnits array and in the not null spaces uses the method toString 
 * @return msg this variable its the concatenation of all the KnowledgeUnits that the method returns 
 */
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

/*
 * This method creates two test cases in the base Project
 */
	public void testCases() {
		String stage="";
		for(int i2=0;i2==5;i2++){
			if(stages[i2].getActive()==true){
				stage=stages[i2].getStageType();
			}
		}
		units[0] = new KnowledgeUnit(name,stage,"A001","Gestion de repositorios", "Juan",CapsType.TECNICO, "#GitHub# es una herramienta util");
		units[1] = new KnowledgeUnit(name,stage,"A002","Gestion de equipos","Pepito", CapsType.TECNICO, "Es importante #definir responsabilidades# claras");
	}

//||||||||||||||||||||||||INFO||||||||||||||||||||||||||||||

/*
 * This method collect all the info from the project
 * @return msg this its the concatenation of all the info from the project
 */
	public String getProjectInfo(int i){
		String msg;
		String state="";
		for(int i2=0;i2==5;i2++){
			if(stages[i2].getActive()==true){
				state=stages[i2].getStageType();
			}
		}
		msg="\n\nProyecto "+(i+1)+":\nNombre: " + name + "\n  Etapa: "+state+"\n  Cliente: " + clientName + "\n  Fecha Inicial: " + getInitialDateFormated() + 
		"\n  Fecha Final: " + getFinalDateFormated() + "\n  Presupuesto: " + budget + "\n  Nombre del Gerente: "+gerentName+"\n  Numero del Gerente: "+gerentCellphone;
		return msg;
	}

/*
 * This method collect the name of the project
 * @return msg this its the concatenation of the name and position of the project
 */
	public String getProjectInfoList(int i){
		String msg;
		msg="\n\nProyecto "+(i+1)+":\n Nombre: " + name;
		return msg;
	}

//||||||||||||||||||||||||ETAPAS|||||||||||||||||||||||

/*
 * 
 */
	public void Stage(){
		//INICIO,ANALISIS,DISENO,EJECUCION,CIERRE,SEGUIMIENTO_Y_CONTROL
		stages[0] = new Stage("INICIO",true,initialDate,null);
		stages[1] = new Stage("ANALISIS",false,null,null);
		stages[2] = new Stage("DISENO",false,null,null);
		stages[3] = new Stage("EJECUCION",false,null,null);
		stages[4] = new Stage("CIERRE",false,null,null);
		stages[5] = new Stage("SEGUIMIENTO_Y_CONTROL",false,null,null);
	}

/*
 * This method change the stage of the project 
 * @return indicator tells the user if the method was aplied correctly
 */
	public boolean changeStage(Calendar initialDate, Calendar finalDate){
		boolean indicator=false;
		for(int i=0;i==5;i++){
			if(stages[i].getActive()==true){
				stages[i].setActive(false);
				stages[i+1].setActive(true);
				stages[i].setRealEndDate(finalDate);
				stages[i+1].setRealStartDate(initialDate);
				i=5;
				indicator=true;
			}
		}
		return indicator;
	}

//||||||||||||||||||||||||GETTERS Y SETTERS||||||||||||||||||||||||||||||||||||||

	public String getName(){
		return name;
	}

	public String getClientName(){
		return clientName;
	}

	public Calendar getInitialDate(){
		return initialDate;
	}

	public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}

	public String getGerentName(){
		return gerentName;
	}

	public String getGerentCellphone(){
		return gerentCellphone;
	}

}
