package model;

public class KnowledgeUnit {

	private String id;
	private String description;
	private String type;
	private String learnedLessons;
	private boolean approved;

	public KnowledgeUnit(String id, String description, String type, String learnedLessons) {

		this.id = id;
		this.description = description;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.approved = false;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}
	
	public boolean getApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String toString(){
		String msg ="";
		String approvedshow="";
		if(approved==true){
			approvedshow+="Verdadero";
		}
		else{
			approvedshow+="Falso";
		}
		msg = "\nID: " + id +"\nDescripcion: "+ description+"\nTipo: "+type+"\nLeccion Aprendida: "+learnedLessons+"\nAprovada: "+approvedshow;
		return msg;
	}
	
	public String toStringUnaproved(int i){
		String msg ="";
		if(approved==false){ 
		msg = "\n"+(i+1)+":ID: " + id +"\nDescripcion: "+ description;
		}
		return msg;
	}
}
