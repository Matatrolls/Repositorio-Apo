package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Project{
	
	private String name;
	private TypeProject type;
	private Stage stage;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
	private String gerentName;
	private String gerentCellphone;
	private DateFormat formatter;
	private KnowledgeUnit[] units;

	public Project(String name, TypeProject type,String clientName, Calendar initialDate, Calendar finalDate, double budget,String gerentName,String gerentCellphone){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");
		this.name = name;
		this.type = type;
		this.stage = Stage.INICIO;
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
		this.gerentName= gerentName;
		this.gerentCellphone=gerentCellphone;
		units = new KnowledgeUnit[50];
	}
//||||||||||||||||||||||KNOWLEGDEUNITS||||||||||||||||||||||||||||||||||||||
public boolean registerKnowledgeUnit(String id, String description,String collaboratorName ,int temporal, String learnedLessons) {
	CapsType type;
	description="#"+description+"#";

	switch(temporal){
		case 1:
		type=CapsType.TECNICO;
		break;
		case 2:
		type=CapsType.EXPERIENCIAS;
		break;
		default:
		type=CapsType.TECNICO;
		break;
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
			msg+="Proyecto "+(i+1)+units[i].toStringUnaproved(i);
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

	public void testCases() {	
		units[0] = new KnowledgeUnit(name,stage,"A001","Gestion de repositorios", "Juan",CapsType.TECNICO, "#GitHub# es una herramienta util");
		units[1] = new KnowledgeUnit(name,stage,"A002","Gestion de equipos","Pepito", CapsType.TECNICO, "Es importante #definir responsabilidades# claras");
	}

//||||||||||||||||||||||||INFO||||||||||||||||||||||||||||||
	public String getProjectInfo(int i){
		return "\n\nProyecto "+(i+1)+":\nNombre: " + name + "\n  Tipo: "+type+"\n  Etapa: "+stage+"\n  Cliente: " + clientName + "\n  Fecha Inicial: " + getInitialDateFormated() + 
		"\n  Fecha Final: " + getFinalDateFormated() + "\n  Presupuesto: " + budget + "\n  Nombre del Gerente: "+gerentName+"\n  Numero del Gerente: "+gerentCellphone;
	}

	public String getProjectInfoList(int i){
		return "\n\nProyecto "+(i+1)+":\n Nombre: " + name + "\n Tipo: "+type;
	}
//||||||||||||||||||||||||ETAPAS|||||||||||||||||||||||
	public void changeStage(){
		switch(stage){
			case INICIO:
				this.stage=Stage.ANALISIS;
			break;

			case ANALISIS:
				this.stage=Stage.DISENO;
			break;

			case DISENO:
				this.stage=Stage.EJECUCION;
			break;

			case EJECUCION:
				this.stage=Stage.CIERRE;
			break;

			case CIERRE:
				this.stage=Stage.SEGUIMIENTO_Y_CONTROL;
			break;

			case SEGUIMIENTO_Y_CONTROL:
			break;
		}

	}

//||||||||||||||||||||||||GETTERS Y SETTERS||||||||||||||||||||||||||||||||||||||

public String getName(){
	return name;
}

public String getClientName(){
	return clientName;
}

public Stage getStage(){
	return stage;
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
