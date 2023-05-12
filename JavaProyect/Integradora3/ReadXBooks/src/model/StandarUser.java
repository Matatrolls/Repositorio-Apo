package model;

public class StandarUser extends User{
    public StandarUser(String id, String name, String nickname) {
		super(id, name, nickname);
	}
	@Override
    public String toString() {
        String msg="\nID: "+this.getId()+"\nNombre: "+getName()+"\nNickname: "+getNickname();
        return msg;
    }
}