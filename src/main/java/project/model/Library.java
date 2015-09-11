package project.model;

public class Library {


	String name;
	int barcode;
	String author;
	int pages;
	String isread;
	public Library(){

	}
	public Library(String name, int barcode, String author, int pages, String isread){

		this.name = name;
		this.barcode = barcode;
		this.author = author;
		this.pages = pages;
		this.isread = isread;

	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Library(int barcode){
		this.barcode = barcode;
	}
	public int getBarcode(){
		return barcode;
	}

	public void setBarcode(int barcode){
		this.barcode = barcode;
	}
	public String getAuthor(){
		return author;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	public int getPages(){
		return pages;
	}
	public void setPages(int pages){
		this.pages = pages;
	}

	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	@Override
	public String toString(){

		return " Book [   {     NAME :" +name+ ",\nBARCODE :" +barcode+ ",\nAUTHOR :" +author+ ",\nPAGES :" +pages+ ",\nISREAD :" +isread+ "\n    }  ]" ;
	}

}
