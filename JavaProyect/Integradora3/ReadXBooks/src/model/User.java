package model;

import java.util.ArrayList;

public abstract class User{

	private String id;
	private String name;
	private String nickname;
	private ArrayList<Product> products;

	public User(String id, String name, String nickname) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.products = new ArrayList<Product>();
	}


	/**
	 * This function sorts a list of products in descending order using the compareTo method.
	 */
	public void sortListDescending() {	
		for (int i = 0; i < products.size(); i++) {
				
				
			Product temp1 = products.get(i);
			if(i+1<products.size()){
				Product temp2 = products.get(i+1);
				int compare = temp1.compareTo(temp2);
					if(compare<0){
						products.set(i, temp1);
						products.set(i+1, temp2);
						
					}
					if(compare>0){
						products.set(i, temp2);
						products.set(i+1, temp1);

					}
					if(compare==0){
				}
			}
		}
	}

	/**
	 * This function fills a 5x5 matrix with product IDs from a sorted list in descending order.
	 * 
	 * @return The method `fillMatrix()` returns a 2D array of Strings.
	 */
	public String[][] fillMatrix() {
		int indicator= 0;
		sortListDescending();

		String[][] matrix = new String[5][5];

	
		for (int i2 = 0; i2 < matrix.length; i2++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i2][j]==null){
					if(indicator<products.size()){
						matrix[i2][j]=products.get(indicator).getId();
					indicator++;
					}
				}
				else{	
				}
			}
		
		}
		return matrix;

	}

	/**
	 * The function generates and returns a string representation of a matrix filled with values.
	 * 
	 * @return The method `showMatrix()` returns a string representation of a matrix filled with values.
	 */
	public String showMatrix() {

		String[][] matrix = fillMatrix();

		String print = "|x & y|| 1 | | 2 | | 3 | | 4 | | 5 |\n";
		for (int i = 0; i < matrix.length; i++) {
			print+="|_ "+(i+1)+" _|";
			for (int j = 0; j < matrix[0].length; j++) {
				
				if (matrix[i][j] == null ) {

					print += "|___|" + " ";
				} else {
					print +="|"+ matrix[i][j] + "| ";
				}
				
			}
			print += "\n";
		}

		return print;
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


	public ArrayList<Product> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	

}
