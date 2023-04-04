package model;


public class KnowledgeUnit {

	private String id;
	private String description;
	private String collaboratorName;
	private CapsType type;
	private String learnedLessons;
	private Status status;
	

	public KnowledgeUnit(String id, String description,String collaboratorName, CapsType type, String learnedLessons) {

		this.id = id;
		this.description = description;
		this.collaboratorName= collaboratorName;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.status = Status.POR_DEFINIR;
	}

//||||||||||||||||||GETTERS Y SETTERS|||||||||||||||||||||

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

//|||||||||||||||||||TOSTRINGS||||||||||||||||||||||

	public String toString(){
		String msg ="";
		msg = "\nID: " + id +"\nDescripcion: "+ description+"\nNombre del colaborador"+collaboratorName+"\nTipo: "+type+"\nLeccion Aprendida: "+learnedLessons+"\nAprovada: "+status;
		return msg;
	}
	
	public String toStringUnaproved(int i){
		String msg ="";
		if(status==Status.POR_DEFINIR){ 
		msg = "\n"+(i+1)+":ID: " + id +"\nDescripcion: "+ description;
		}
		return msg;
	}
}
