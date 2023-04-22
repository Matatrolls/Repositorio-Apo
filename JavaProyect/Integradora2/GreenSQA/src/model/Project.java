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

/**
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
		initStages();
	}

//||||||||||||||||||||||KNOWLEGDEUNITS||||||||||||||||||||||||||||||||||||||

/**
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
	for(int i2=0;i2<5;i2++){
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

/**
 * This method change the Status from the KnowledgeUnit from POR_DEFINIR to APROBADA
 * @param choice this its the choosed KnowledgeUnit to approve
 * @return indicator This indicates if a new project was created or not
 */
	public boolean approveKnowledgeUnit(int choice) {
		boolean indicador=true;
		units[choice-1].setStatus(Status.APROBADA);
		
		return indicador;
	}

	public boolean publishKnowledgeUnit(int choice) {
		boolean indicador=true;
		units[choice-1].setStatus(Status.PUBLICADA);
		
		return indicador;
	}

/**
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

/**
 * This function returns a string message containing the approved knowledge unit list for a given
 * project choice.
 * 
 * @param projtChoice an integer representing the project choice selected by the user.
 * @return A String message containing the approved knowledge unit list for a specific project choice.
 */
	public String showApprovedKnowlegdeUnitList(int projtChoice){
		String msg="";
			if(units[projtChoice]==null){
			}
			else{
				msg+="Proyecto "+projtChoice+units[projtChoice-1].toStringApproved(projtChoice-1);
			}
		
		return msg;
	}

/**
 * This function returns a string containing the published knowledge units in an array of units.
 * 
 * @return The method is returning a String that contains the list of published knowledge units.
 */
	public String showPublishedKnowlegdeUnitList(){
		String msg="";
		for(int i=0;i<units.length;i++){
			if(units[i]==null){
			}
			else{
				msg+=units[i].toStringPublished(i);
			}
		}
		return msg;
	}


/**
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

/**
 * This method creates two test cases in the base Project
 */
	public void testCases() {
		String stage="";
		initStages();
		for(int i2=0;i2<5;i2++){
			if(stages[i2].getActive()==true){
				stage+=stages[i2].getStageType();
			}
		}
		
		units[0] = new KnowledgeUnit(name,stage,"A001","Gestion de repositorios", "Juan",CapsType.TECNICO, "#GitHub# es una herramienta util");
		units[1] = new KnowledgeUnit(name,stage,"A002","Gestion de equipos","Pepito", CapsType.TECNICO, "Es importante #definir responsabilidades# claras");
	}

//||||||||||||||||||||||||INFO||||||||||||||||||||||||||||||

/**
 * This method collect all the info from the project
 * @param i this its the project that the user choose
 * @return msg this its the concatenation of all the info from the project
 */
	public String getProjectInfo(int i){
		String msg;
		String state="";
		int stage1=stages[0].getDuration();
		int stage2=stages[1].getDuration();
		int stage3=stages[2].getDuration();
		int stage4=stages[3].getDuration();
		int stage5=stages[4].getDuration();
		int stage6=stages[5].getDuration();
		for(int i2=0;i2<5;i2++){
			if(stages[i2].getActive()==true){
				state+=stages[i2].getStageType();
			}
		}
		//INICIO,ANALISIS,DISENO,EJECUCION,CIERRE,SEGUIMIENTO_Y_CONTROL
		msg="\n\nProyecto "+(i+1)+":\nNombre: " + name + "\n  Etapa: "+state+"\nDuracion en meses etapa INICIO: "+stage1+"\nDuracion  en meses etapa ANALISIS: "+stage2+
		"\nDuracion en meses etapa DISENO: "+stage3+"\nDuracion en meses etapa EJECUCION: "+stage4+"\nDuracion etapa CIERRE: "+stage5+
		"\nDuracion en meses etapa SEGUIMIENTO_Y_CONTROL: "+stage6+"\n  Cliente: " + clientName + "\n  Fecha Inicial: " + getInitialDateFormated() + 
		"\n  Fecha Final: " + getFinalDateFormated() + "\n  Presupuesto: " + budget + "\n  Nombre del Gerente: "+gerentName+"\n  Numero del Gerente: "+gerentCellphone;
		return msg;
	}

/**
 * This method collect the name of the project
 * @param i this its the project that the user chooseS
 * @return msg this its the concatenation of the name and position of the project
 */
	public String getProjectInfoList(int i){
		String msg;
		msg="\n\nProyecto "+(i+1)+":\n Nombre: " + name;
		return msg;
	}

//||||||||||||||||||||||||ETAPAS|||||||||||||||||||||||

/**
 * this method create the default stages for every project 
 */
	public void initStages(){
		//INICIO,ANALISIS,DISENO,EJECUCION,CIERRE,SEGUIMIENTO_Y_CONTROL
		stages[0] = new Stage("INICIO",1,true,initialDate,null);
		stages[1] = new Stage("ANALISIS",1,false,null,null);
		stages[2] = new Stage("DISENO",1,false,null,null);
		stages[3] = new Stage("EJECUCION",1,false,null,null);
		stages[4] = new Stage("CIERRE",1,false,null,null);
		stages[5] = new Stage("SEGUIMIENTO_Y_CONTROL",1,false,null,null);
	}

/**
 * This method change the stage of the project 
 * @param initialDate its the real date of start of the next stage
 * @param finalDate its the real date of end of the current stage
 * @return indicator tells the user if the method was aplied correctly
 */
	public boolean changeStage(Calendar initialDate, Calendar finalDate){
		boolean indicator=false;
		for(int i=0;i<5;i++){
			if(stages[i].getActive()==true){
				stages[i].setActive(false);
				stages[i+1].setActive(true);
				stages[i].setRealEndDate(finalDate);
				stages[i+1].setRealStartDate(initialDate);
				i=5;
				indicator=true;
				return indicator;
			}
		}
		return indicator;
	}

/**
 * This function sets the duration of each stage in an array based on input parameters and returns a
 * boolean value.
 * 
 * @param durationStage1 The duration (in some unit of time) for the first stage of a process.
 * @param durationStage2 The duration (in some unit of time) for the second stage of a process or
 * project.
 * @param durationStage3 The duration (in some unit of time) for the third stage of a process.
 * @param durationStage4 The duration (in some unit of time) for the fourth stage of a process or
 * project.
 * @param durationStage5 The duration (in some unit of time) for the fifth stage of a process.
 * @param durationStage6 The duration (in some unit of time) for the sixth stage of a process.
 * @return A boolean value, but its value is always false because the variable "indicador" is never set
 * to true.
 */
	public boolean duration(int durationStage1,int durationStage2,int durationStage3,int durationStage4,int durationStage5,int durationStage6){
		boolean indicador=false;
		int duration=0;
		for(int i=0;i<5;i++){
			switch(i){
				case 0:
					duration=durationStage1;
				break;

				case 1:
					duration=durationStage2;
				break;

				case 2:
					duration=durationStage3;
				break;

				case 3:
					duration=durationStage4;
				break;

				case 4:
					duration=durationStage5;
				break;

				case 5:
					duration=durationStage6;
				break;
			}
			stages[i].setDuration(duration);
		}
		
		return indicador;
	}

//||||||||||||||||||||||||||||||||INFORMS|||||||||||||||||||||||||||||||||||||||

/**
 * This function counts the number of knowledge units in a specific stage based on a given integer
 * parameter.
 * 
 * @param temp an integer representing the stage of a knowledge unit (1 for "INICIO", 2 for "ANALISIS",
 * 3 for "DISENO", 4 for "EJECUCION", 5 for "CIERRE", and 6 for "SEGUIMIENT
 * @return The method is returning an integer value, which represents the number of knowledge units
 * that belong to a specific stage, based on the input parameter "temp".
 */
public int consultKnowledgeUnitType(int temp){
	String temporal="";
	int counter=0;
	for(int i=0;i<units.length;i++){
		if(units[i]==null){
		}
		else{
			temporal=units[i].getStage();
			switch(temp){
				case 1:
					if(temporal.equalsIgnoreCase("INICIO")){
						counter++;
					}
				break;

				case 2:
					if(temporal.equalsIgnoreCase("ANALISIS")){
						counter++;
					}
				break;

				case 3:
					if(temporal.equalsIgnoreCase("DISENO")){
						counter++;
					}
				break;

				case 4:
					if(temporal.equalsIgnoreCase("EJECUCION")){
						counter++;
					}
				break;

				case 5:
					if(temporal.equalsIgnoreCase("CIERRE")){
						counter++;
					}
				break;

				case 6:
				if(temporal.equalsIgnoreCase("SEGUIMIENTO_Y_CONTROL")){
					counter++;
				}
				break;
			}
		}
	}
	return counter;
}

/**
 * This function returns a string containing the learned lessons for a given stage in a project.
 * 
 * @param choice An integer representing the stage of a project management process. The possible values
 * are 1, 2, 3, 4, 5, or 6, which correspond to the stages of "Inicio", "Analisis", "Diseno",
 * "Ejecucion", "Cierre", "Seguimiento y control"
 * @return The method is returning a String that contains the learned lessons for a specific stage of a
 * project. The stage is determined by the integer parameter "choice", which corresponds to a specific
 * stage in the switch statement. The method iterates through an array of "units" and checks if the
 * stage of each unit matches the chosen stage. If it does, the method adds the learned lessons of that
 * unit to the
 */
public String consultLearnedLeccionByStage(int choice){
	String msg="";
	String temporal="";
	String temString="";
	switch(choice){
		case 1:
			temporal="INICIO";
		break;

		case 2:
			temporal="ANALISIS";
		break;

		case 3:
			temporal="DISENO";
		break;

		case 4:
			temporal="EJECUCION";
		break;

		case 5:
			temporal="CIERRE";
		break;

		case 6:
			temporal="SEGUIMIENTO_Y_CONTROL";
		break;
	}
	for(int i=0;i<units.length;i++){
		if(units[i]==null){
		}
		else{
			if(temporal.equalsIgnoreCase(units[i].getStage())){
				temString=units[i].getLearnedLessons();
				msg+="\n"+temString;
			}
		}
	}

	return msg;
}

/**
 * This function returns the number of registered knowledge units in a project.
 * 
 * @return The method is returning an integer value, which represents the number of registered
 * knowledge units in all projects.
 */
public int consultMostRegisteredKnowledgeUnitsByProject(){
	int msg=0;
	for(int i=0;i<units.length;i++){
		if(units[i]==null){
		}
		else{
			msg++;
		}
	}
	return msg;
}

/**
 * This Java function returns a string message containing the IDs of projects that have a specific
 * collaborator.
 * 
 * @param choice The name of the collaborator whose projects are being consulted.
 * @return The method is returning a String that contains the IDs of all the projects that have a
 * collaborator with the name specified in the parameter "choice".
 */
public String consultProjectsByCollaborator(String choice){
	String msg="";
	String temString="";
	for(int i=0;i<units.length;i++){
		if(units[i]==null){
		}
		else{
			if(choice.equalsIgnoreCase(units[i].getCollaboratorName())){
				temString=units[i].getId();
				msg+="\n"+temString;
			}
		}
	}
	return msg;
}

public String consultByHashtag(){
	String msg="";

	return msg;
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
