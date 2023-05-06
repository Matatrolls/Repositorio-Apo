package model;

public class PremiumUser extends User {
    private PremiumCategory Premiumcategory;

    public PremiumUser(String id, String name, String nickname, PremiumCategory Premiumcategory) {
		super(id, name, nickname);
        this.Premiumcategory = Premiumcategory;
	}
    @Override
    public String toString() {
        String msg="\nID: "+this.getId()+"\nNombre: "+getName()+"\nNickname: "+getNickname()+"\nCategoria: "+Premiumcategory;
        return msg;
    }
    public void setPremiumcategory(PremiumCategory premiumcategory) {
        Premiumcategory = premiumcategory;
    }
}