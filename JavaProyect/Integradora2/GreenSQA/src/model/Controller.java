package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;

	public Controller() {
		projects = new Project[10];
	}

/**
 * This method create a base Project in the first position of the array and it calls a method to create two
 * testcases of KnowledgeUnits in the base projects
 */
	public void testCases(){
		Calendar initialDate = new GregorianCalendar(2000,2,3); 
		Calendar finalDate = new GregorianCalendar(2000,6,5);
		projects[0] = new Project("Proyecto Base","Juan", initialDate, finalDate, 3000000, "Alberto", "555-2368");
		projects[0].testCases();
	}

//|||||||||||||||||||||||||PROJECTS|||||||||||||||||||||||||||

/**
 * This method allow the controller to create a new project with the params that the user
 * entered
 * @param name This its the name that the user wants to call the new project
 * @param clientName This its the client name 
 * @param iday This its the day of the creation of the project
 * @param imonth This its the month of the creation of the project
 * @param iyear This its the year of the creation of the project
 * @param fday This its the day of the end of the project
 * @param fmonth This its the month of the end of the project
 * @param fyear This its the year of the end of the project
 * @param budget This its the budget that the project have
 * @param gerentName This its the name of the gerent of the project
 * @param gerentCellphone This its the cellphone of the genert of the project
 * @return indicator This indicates if a new project was created or not
 */
	public boolean registerProject(String name,int durationStage1,int durationStage2,int durationStage3,int durationStage4,int durationStage5,int durationStage6, String clientName, int iday,int imonth, int iyear,int fday,int fmonth,int fyear, double budget,String gerentName,String gerentCellphone){
		boolean indicator=false;
		Calendar initialDate = new GregorianCalendar(iyear,imonth,iday); 
		Calendar finalDate = new GregorianCalendar(fyear,fmonth,fday);
		
		Project newProject = new Project(name ,clientName, initialDate, finalDate, budget,gerentName,gerentCellphone);
		
		for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null && !indicator ) {
                projects[i] = newProject;
				
				projects[i].duration(durationStage1,durationStage2,durationStage3,durationStage4,durationStage5,durationStage6);
				indicator=true;
				
            }
        }
		return indicator;
	}

/**
 * This method evaluate the projects array and calls the method form the class Project getProjectInfoList()
 * if it is different from null, it shows a reduced verison of the Projects
 * @return msg this variable its the concatenation of all the created projects that the method retrieve 
 */
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

/**
 * This method evaluate the projects array and calls the method form the class Project getProjectInfoList()
 * if it is different from null, it shows a full verison of the Projects
 * @return msg this variable its the concatenation of all the created projects that the method retrieve 
 */
	public String projectInfo(){
		String msg="";
		for(int i=0;i<projects.length;i++){
			if(projects[i]==null){
			}
			else{
				msg+=projects[i].getProjectInfo(i);
			}
		}
		return msg;
	}

/**
 * This method call the method from Project changeStage()
 * @param choice its the option that the user introduced after being asked to choice between the created projects
 * @return indicator tells the user if the method was aplied correctly
 */
	public boolean changeStage(int choice,int fyear, int fmonth, int fday, int iyear, int imonth, int iday) {
		boolean indicador=false;
		Calendar initialDate = new GregorianCalendar(iyear,imonth,iday); 
		Calendar finalDate = new GregorianCalendar(fyear,fmonth,fday);
		if(projects[choice-1].changeStage(initialDate,finalDate)){
			indicador=true;
		}
		return indicador;
	}

/**
 * This method creates a date to compare and search projects created before X date
 * @param eday	its the day of the new date
 * @param emonth its the month of the new date
 * @param eyear its the year of the new date
 * @return msg	this its the concatenation of all the projects created before X date
 */
	public String searchProjectsBeforeDate(int eday, int emonth, int eyear) {
		Calendar estimatedDate = new GregorianCalendar(eyear,emonth,eday);
		String msg = "";
		for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
				int var= projects[i].getInitialDate().compareTo(estimatedDate);
				if(var<0){
					msg += "\n"+projects[i].getName();
				}
            }
        }
		return msg;
	}

/**
 * This method creates a date to compare and search projects created after X date
 * @param eday	its the day of the new date
 * @param emonth its the month of the new date
 * @param eyear its the year of the new date
 * @return msg	this its the concatenation of all the projects created after X date
 */
	public String searchProjectsAfterDate(int eday, int emonth, int eyear) {
		Calendar estimatedDate = new GregorianCalendar(eyear,emonth,eday);
		String msg = "";
		for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
				int var= projects[i].getInitialDate().compareTo(estimatedDate);
				if(var>0){
					msg += "\n"+projects[i].getName();
				}
            }
        }
		return msg;
	}

//|||||||||||||||||||kNOWLEGDEUNITS||||||||||||||||||||||||||||||

/**
 * This method evocates the method registerKnowledgeUnit froma the class Project, to create a new KnowledgeUnit
 * @param choice this its the project in which the new KnowledgeUnit will be created
 * @param id this its the unique id for the KnowledgeUnit
 * @param description this its the description of the KnowledgeUnit
 * @param collaboratorName this its the name of the creator of the KnowledgeUnit 
 * @param temporal this its to pick a type from the enum CapsType
 * @param learnedLessons this its th learned lesson from the KnowledgeUnit
 * @return indicator tells the user if the method was aplied correctly
 */
public boolean registerKnowledgeUnit(int choice,String id, String description, String collaboratorName,int temporal, String learnedLessons){
	boolean indicator=false;
	if(projects[choice-1].registerKnowledgeUnit(id, description, collaboratorName, temporal, learnedLessons)){
		indicator=true;
	}
	return indicator;
}

/**
 * This method evaluate if the project choosed by the user its empty, and if isnt the case calls the method 
 * showKnowledgeUnitList from the class Project to show a reduced List of the KnowledgeUnits
 * @param choiceProject it its the Project tath the user choosed to see its KnowledgeUnits
 * @return msg it is the concatenation of the KnowledgeUnits
 */
public String showKnowlegdeUnitList(int choiceProject){
	String msg="";
	if(projects[choiceProject-1]==null){
	}
	else{
		msg+=projects[choiceProject-1].showKnowlegdeUnitList();
	}
	return msg;
}

/**
 * This method evaluates every project and if its space isnt null calls the method
 * getAllKnowledgeUnits() of the class Project to show all the KnowledgeUnits created
 * @return msg it is the concatenation of every KnowledgeUnits created
 */
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

/**
 * This Java function returns a message containing a list of approved knowledge units for a given
 * project choice.
 * 
 * @param projtChoice an integer representing the user's choice of project (1 to the total number of
 * projects available)
 * @return A String message containing either an error message if the project does not exist or a list
 * of approved knowledge units for the specified project.
 */
public String showApprovedKnowlegdeUnitList(int projtChoice) {
	String msg="";
	
	if(projects[projtChoice-1]==null){
		msg+="Ese proyecto no existe!";
	}
	else{
		msg+=projects[projtChoice-1].showApprovedKnowlegdeUnitList(projtChoice);
	}
	return msg;
}

/**
 * This function returns a string containing the list of published knowledge units for all projects.
 * 
 * @return The method is returning a String that contains the list of published knowledge units for all
 * projects in the "projects" array.
 */
public String showPublishedKnowlegdeUnitList() {
	String msg="";
	for(int i=0;i<projects.length;i++){
		if(projects[i]==null){
		}
		else{
			msg+=projects[i].showPublishedKnowlegdeUnitList();
		}
	}
	return msg;
}

/**
 * This method calls the method approveKnowledgeUnit from the class Project
 * @param choiceProject this its the project that the user choosed to aprove a KnowledgeUnit from
 * @param choice this its the KnowledgeUnit that the user choosed to approve
 * @return indicator tells the user if the method was aplied correctly
 */
public boolean approveKnowledgeUnit(int choiceProject,int choice){
	boolean indicador=false;
	if(projects[choiceProject-1].approveKnowledgeUnit(choice)){
		indicador=true;
	}
	return indicador;
}

/**
 * This function publishes a knowledge unit for a chosen project and returns a boolean indicating
 * whether the operation was successful or not.
 * 
 * @param choiceProject An integer representing the user's choice of project (presumably from a list of
 * available projects).
 * @param choice The parameter "choice" is not defined in the given method. It is likely a parameter
 * that is passed to the "publishKnowledgeUnit" method within the "projects" array. Without more
 * context or information about the code, it is difficult to determine the exact purpose of this
 * parameter.
 * @return The method is returning a boolean value, which indicates whether the knowledge unit was
 * successfully published or not. If the knowledge unit was published successfully, the method returns
 * true, otherwise it returns false.
 */
public boolean publishKnowledgeUnit(int choiceProject,int choice){
	boolean indicador=false;
	if(projects[choiceProject-1].publishKnowledgeUnit(choice)){
		indicador=true;
	}
	return indicador;
}
}
