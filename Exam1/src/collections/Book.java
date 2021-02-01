package collections;

public class Book {

	private String name;
	private String author;
	private int releaseYear;
	private String isbn;
	
	
	public Book(String name ,int releaseYear ,String isbn) {
		this.name = name;
		this.releaseYear = releaseYear;
		this.isbn = isbn;
	}
	public Book(String author ,String name) {
		this.author= author;
		this.name = name;		
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}	
}
