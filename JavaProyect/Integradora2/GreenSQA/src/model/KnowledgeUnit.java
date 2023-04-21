package model;


public class KnowledgeUnit {
	private String nameProject;
	private String stageProject;
	private String id;
	private String description;
	private String collaboratorName;
	private CapsType type;
	private String learnedLessons;
	private Status status;
	
/**
 * This method its used to create a new KnowledgeUnit
 * @param nameProject This its the name of the project in which the KnowledgeUnit its being created
 * @param stage This its the stage of the project in which the KnowledgeUnit its being created
 * @param id This its the unique id of the KnowledgeUnit
 * @param description This its the description of the KnowledgeUnit
 * @param collaboratorName This its the name of the creator of the KnowledgeUnit
 * @param type This its the type of the KnowledgeUnit
 * @param learnedLessons This its the learned lesson of the KnowledgeUnit
 */
	public KnowledgeUnit(String nameProject,String stage,String id, String description,String collaboratorName, CapsType type, String learnedLessons) {
		this.nameProject= nameProject;
		this.stageProject= stage;
		this.id = id;
		this.description = description;
		this.collaboratorName= collaboratorName;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.status = Status.POR_DEFINIR;
	}

//|||||||||||||||||||TOSTRINGS||||||||||||||||||||||

/**
 * This method recollect all the info of the KnowledgeUnit
 * @return msg this its the concatenation of all the info of the KnowledgeUnit
 */
public String toString(){
	String msg ="";
	msg = "\n\nNombre del proyecto: "+nameProject+"\nEtapa: "+stageProject+"\nID: " + id +"\nDescripcion: "+ description+"\nNombre del colaborador: "+collaboratorName+"\nTipo: "+type+"\nLeccion Aprendida: "+learnedLessons+"\nAprovada: "+status;
	return msg;
}

/**
 * This method recollect all the info of the unapproved KnowledgeUnits 
 * @param i this its the posicion in the array that the KnowledgeUnit ocuppies
 * @return msg this its the concatenation of the info requested
 */
public String toStringUnaproved(int i){
	String msg ="";
	if(status==Status.POR_DEFINIR){ 
		msg = "\n\n"+(i+1)+":ID: " + id +"\nDescripcion: "+ description;
	}
	return msg;
}


/**
 * This Java function returns a string representation of an approved item's ID and description.
 * 
 * @param i The parameter "i" is an integer used as an index to keep track of the position of the
 * object in a list or array. It is used to display the object's information in a formatted way.
 * @return The method is returning a string message that includes the ID and description of an approved
 * item, as well as the index of the item in a list (i+1).
 */
public String toStringApproved(int i){
	String msg ="";
	if(status==Status.APROBADA){ 
		msg = "\n\n"+(i+1)+":ID: " + id +"\nDescripcion: "+ description;
	}
	return msg;
}

/**
 * This Java function returns a string representation of a published item's ID and description.
 * 
 * @param i The parameter "i" is an integer used as an index to keep track of the position of the
 * published message in a list or array. It is incremented by 1 to display the message number in the
 * output.
 * @return The method is returning a string message that includes the ID and description of an object
 * only if its status is "PUBLICADA". The message also includes a number (i+1) to indicate the position
 * of the object in a list.
 */
public String toStringPublished(int i){
	String msg ="";
	if(status==Status.PUBLICADA){ 
		msg = "\n\n"+(i+1)+":ID: " + id +"\nDescripcion: "+ description;
	}
	return msg;
}

//||||||||||||||||||GETTERS Y SETTERS|||||||||||||||||||||

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public String getStage() {
		return stageProject;
	}

	public void setStage(String stage) {
		this.stageProject = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CapsType getType() {
		return type;
	}

	public void setType(CapsType type) {
		this.type = type;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCollaboratorName(){
		return collaboratorName;
	}

	public void setCollaboratorName(String collaboratorName){
		this.collaboratorName=collaboratorName;
	}

}
