package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private KnowledgeUnit[] units;
	private Project[] projects;

	public Controller() {

		units = new KnowledgeUnit[25];
		projects = new Project[10];
		testCases();
		
	}
	
	public void testCases() {
		
		units[0] = new KnowledgeUnit("A001", "Gestion de repositorios", Type.TECNICO, "GitHub es una herramienta util");
		units[1] = new KnowledgeUnit("A002", "Gestion de equipos", Type.TECNICO, "Es importante definir responsabilidades claras");
		
	}
//|||||||||||||||||||||||||PROJECTS|||||||||||||||||||||||||||
	public boolean registerProject(String name,int projtype, String clientName, int iday,int imonth, int iyear,int fday,int fmonth,int fyear, double budget){
		boolean indicator=false;
		Calendar initialDate = new GregorianCalendar(iday,imonth,iyear); 
		Calendar finalDate = new GregorianCalendar(fday,fmonth,fyear);
		TypeProject type;
		switch(projtype){
			case 1:
			type= TypeProject.DESARROLLO;
			break;

			case 2:
			type=TypeProject.MANTENIMIENTO;
			break;

			case 3:
			type=TypeProject.DESPLIEGUE;
			break;

			default:
			type= TypeProject.DESARROLLO;
			break;
		}
		
		Project newProject = new Project(name ,type, clientName, initialDate, finalDate, budget);
		
		for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) {
                projects[i] = newProject;
				indicator=true;
            
            }
        }
		return indicator;
	}

	public String searchProjectsAfterDate(int eday, int emonth, int eyear) {
		Calendar estimatedDate = new GregorianCalendar(eday,emonth,eyear);
		String msg = "";
		for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
				int var= projects[i].getInitialDate().compareTo(estimatedDate);
				if(var==1){
					msg += projects[i].getName() + "\n"+ projects[i].getClientName();
				}
            }
        }
		return msg;
	}

	public String searchProjectsBeforeDate(int eday, int emonth, int eyear) {
		Calendar estimatedDate = new GregorianCalendar(eday,emonth,eyear);
		String msg = "";
		for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
				int var= projects[i].getFinalDate().compareTo(estimatedDate);
				if(var==-1){
					msg += projects[i].getName() + "\n"+ projects[i].getClientName();
				}
            }
        }
		return msg;
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
