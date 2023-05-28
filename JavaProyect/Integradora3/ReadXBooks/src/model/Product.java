package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class Product implements Comparable<Product> {
    private String id;
	private String name;
    private int pagesNumber;
    private Calendar publicationDate;
    private DateFormat formatter;
    private String url;
    private double readedPages;


    Product(String id, String name,int pagesNumber,String publicationDate,String url){
        super();
        String[] getter;
		int day;
		int month;
		int year;
		getter=publicationDate.split("/");
		day=Integer.parseInt(getter[0]);
		month=Integer.parseInt(getter[1]);
		year=Integer.parseInt(getter[2]);
		Calendar temporalCalendar= new GregorianCalendar(year,month,day);
        this.formatter = new SimpleDateFormat("dd/M/yy");
        this.id=id;
        this.name=name;
        this.pagesNumber=pagesNumber;
        this.publicationDate=temporalCalendar;
        this.url=url;
        this.readedPages=0;
    }

    @Override
    public String toString() {
        return "/nProduct [id=" + id + ", name=" + name + ", pagesNumber=" + pagesNumber + ", publicationDate="
            + getFormatedPublicationDate() + ", url=" + url + ", readedPages=" + readedPages + "]";
    }
/**
 * This function compares the publication dates of two products and returns -1, 0, or 1 depending on
 * whether the first product's date is earlier, the same, or later than the second product's date.
 * 
 * @param o The parameter "o" is an object of the class "Product" which is being compared to the
 * current object.
 * @return The method is returning an integer value that represents the result of the comparison
 * between the publication dates of two products. The value returned is -1 if the publication date of
 * the current product is earlier than the publication date of the other product, 1 if it is later, and
 * 0 if they are the same.
 */

    @Override
	public int compareTo(Product o) {
		int compare=0;
        Calendar temporal1 =getPublicationDate();
        Calendar temporal2 =o.getPublicationDate();
		if(temporal1.compareTo(temporal2)== -1){
			compare=-1;
			return compare;
		}
		if(temporal1.compareTo(temporal2)== 1){
			compare=1;
			return compare;
		}
		if(temporal1.compareTo(temporal2)== 0){
			compare=0;
			return compare;
		}
		return compare;
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

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getReadedPages() {
        return readedPages;
    }

    public void setReadedPages(double readedPages) {
        this.readedPages = readedPages;
    }

    public String getFormatedPublicationDate(){
		return formatter.format(this.publicationDate.getTime());
	}	

}
