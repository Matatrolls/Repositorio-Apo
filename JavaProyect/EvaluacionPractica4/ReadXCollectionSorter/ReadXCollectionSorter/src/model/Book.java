package model;

public class Book implements Comparable<Book>{

	private String id;
	private String name;
	private int pages;


	@Override
	public String toString() {
		if(pages<9){
			return id+"-00"+pages;
		}
		else if(pages<99){
			return id+"-0"+pages;
		}
		else{
			return id+"-"+pages;
		}
	}

	public Book(String id, String name, int pages) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
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

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public int compareTo(Book o) {
		int compare=0;
		if(getPages() < o.getPages()){
			compare=-1;
			return compare;
		}
		if(getPages() > o.getPages()){
			compare=1;
			return compare;
		}
		if(getPages() == o.getPages()){
			compare=0;
			return compare;
		}
		return compare;
	}


}
