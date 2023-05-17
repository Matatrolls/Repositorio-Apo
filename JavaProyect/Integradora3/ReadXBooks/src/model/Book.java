package model;

public class  Book extends Product{
	//String id
	//String name
	//int pagesNumber
	private String review;
	//String publicationDate
	private Genre genre;
	//String url
	private double price;
	private double unitsSold;
	//long readedPages



	public Book(String id, String name,int pagesNumber,String review,String publicationDate, 
		Genre genre, String url,
		double price) {
		super(id,name,pagesNumber,publicationDate,url);
		this.review=review;
		this.genre = genre;
		this.price = price;
		this.unitsSold=0;
		this.setReadedPages(0);
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public Genre getGenre() {
		return genre;
	}



	public void setGenre(Genre genre) {
		this.genre = genre;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getUnitsSold() {
		return unitsSold;
	}



	public boolean setUnitsSold(double unitsSold) {
		this.unitsSold = unitsSold;
		return true;
	}
}
