package model;


public class Magazine extends Product{
    //String id
	//String name
	//int pagesNumber
	private Category category;
    //String publicationDate
	private String publicationPeriodicity;
	//String url
	private double suscriptionPrice;
	private double activeSuscriptions;
	//double readedPages

    public Magazine(String id, String name,int pagesNumber,Category category,String publicationDate,
        String publicationPeriodicity, String url,
		double suscriptionPrice) {
		super(id,name,pagesNumber,publicationDate,url);
		this.category=category;
        this.publicationPeriodicity=publicationPeriodicity;
        this.suscriptionPrice=suscriptionPrice;
        this.activeSuscriptions=0;
        this.setReadedPages(0);

	}

    
	@Override
    public String toString() {
        return "\nMagazine [id=" + this.getId() + ", name=" + this.getName() + ", pagesNumber=" + this.getPagesNumber() + ", publicationDate="
        + this.getFormatedPublicationDate() + ", url=" + this.getUrl() + ", readedPages=" + this.getReadedPages() + " category=" + category + ", publicationPeriodicity=" + publicationPeriodicity
                + ", suscriptionPrice=" + suscriptionPrice + ", activeSuscriptions=" + activeSuscriptions + "]";
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }


    public String getPublicationPeriodicity() {
        return publicationPeriodicity;
    }



    public void setPublicationPeriodicity(String publicationPeriodicity) {
        this.publicationPeriodicity = publicationPeriodicity;
    }



    public double getSuscriptionPrice() {
        return suscriptionPrice;
    }



    public void setSuscriptionPrice(double suscriptionPrice) {
        this.suscriptionPrice = suscriptionPrice;
    }



    public double getActiveSuscriptions() {
        return activeSuscriptions;
    }



    public boolean setActiveSuscriptions(double activeSuscriptions) {
        this.activeSuscriptions = activeSuscriptions;
        return true;
    }
}
