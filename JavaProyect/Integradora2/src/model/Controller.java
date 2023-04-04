package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;

	public Controller() {		
		projects = new Project[10];
	}
	
	public void testCases(){
		Calendar initialDate = new GregorianCalendar(2000,2,3); 
		Calendar finalDate = new GregorianCalendar(2000,6,5);
		projects[0] = new Project("Proyecto Base", TypeProject.DESARROLLO,"Juan", initialDate, finalDate, 3000000, "Alberto", "555-2368");
		projects[0].testCases();
	}
//|||||||||||||||||||||||||PROJECTS|||||||||||||||||||||||||||
	public boolean registerProject(String name,int projtype, String clientName, int iday,int imonth, int iyear,int fday,int fmonth,int fyear, double budget,String gerentName,String gerentCellphone){
		boolean indicator=false;
		Calendar initialDate = new GregorianCalendar(iyear,imonth,iday); 
		Calendar finalDate = new GregorianCalendar(fyear,fmonth,fday);
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
		
		Project newProject = new Project(name ,type,clientName, initialDate, finalDate, budget,gerentName,gerentCellphone);
		
		for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) {
                projects[i] = newProject;
				indicator=true;
            
            }
        }
		return indicator;
	}

	public String projectList(){
		String msg="";
		for(int i=0;i<projects.length;i++){
			if(projects[i]==null){
			}
			else{
				msg+=projects[i].getProjectInfoList(i);
			}
		}
		return msg;
	}

	public String projectInfo(){
		String msg="";
		for(int i=0;i<projects.length;i++){
			if(projects[i]==null){
			}
			else{
				msg+=projects[i].getProjectInfo();
			}
		}
		return msg;
	}

	public boolean changeStage(int choice) {
		boolean indicador=true;
		projects[choice-1].changeStage();
		
		return indicador;
	}

	public String searchProjectsAfterDate(int eday, int emonth, int eyear) {
		Calendar estimatedDate = new GregorianCalendar(eyear,emonth,eday);
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
		Calendar estimatedDate = new GregorianCalendar(eyear,emonth,eday);
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
public boolean registerKnowledgeUnit(int choice,String id, String description, String collaboratorName,int temporal, String learnedLessons){
	boolean indicator=false;
	if(projects[choice].registerKnowledgeUnit(id, description, collaboratorName, temporal, learnedLessons)){
		indicator=true;
	}
	return indicator;
}
	
public String showKnowlegdeUnitList(int choiceProject){
	String msg="";
	if(projects[choiceProject]==null){
	}
	else{
		msg+=projects[choiceProject].showKnowlegdeUnitList();
	}
	return msg;
}

public String getAllKnowledgeUnits() {
	String msg="";
	for(int i=0;i<projects.length;i++){
		if(projects[i]==null){
		}
		else{
			msg+=projects[i].getAllKnowledgeUnits();
		}
	}
	return msg;
}

public boolean approveKnowledgeUnit(int choiceProject,int choice){
	boolean indicador=false;
	projects[choiceProject].approveKnowledgeUnit(choice);
	return indicador;
}

}
