package model;

public abstract class Product {
    private String id;
	private String name;
    private int pagesNumber;
    private String publicationDate;
    private String url;
    private double readedPages;


    Product(String id, String name,int pagesNumber,String publicationDate,String url){
        super();
        this.id=id;
        this.name=name;
        this.pagesNumber=pagesNumber;
        this.publicationDate=publicationDate;
        this.url=url;
        this.readedPages=0;
    }

    @Override
    public String toString() {
        return "/nProduct [id=" + id + ", name=" + name + ", pagesNumber=" + pagesNumber + ", publicationDate="
                + publicationDate + ", url=" + url + ", readedPages=" + readedPages + "]";
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

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
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


}
