package model;


public abstract class User {

	private String id;
	private String name;
	private String nickname;

	public User(String id, String name, String nickname) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


}
