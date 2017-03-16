package pkgLibrary;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Book {

	private String id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private Date publish_date;
	private String description;

	private double Cost;

	public Book() {

	}

	public Book(String id, String author, String title, String genre, double price, Date publish_date, String description,double Cost)
	{
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;		
		this.price = price;
		this.publish_date = publish_date;
		this.description = description;

		this.Cost = Cost;
	}

	public Book(String id, Catalog c)
	{
		for(Book b : c.getBooks())
		{
			if(b.getId().equals(id))//sets values to matching values of instance b (instance with matching id)
			{
				this.id = b.getId();
				this.author = b.getAuthor();
				this.title = b.getTitle();
				this.genre = b.getGenre();		
				this.price = b.getPrice();
				this.publish_date = b.getPublish_date();
				this.description = b.getDescription();
				
				this.Cost = b.getCost();
			}

		}
		
		
	}
	
	//override equals method to compare id's of books instead of memory locations of objects
//	@Override
//	public boolean equals(Object b){
//		Book k = (Book) b;
//		return this.id.equals(k.getId());//instance equals id of book passed in
//	}
	
	//book wanted and catalog wanted
	public Book GetBook(Book a, Catalog c) throws BookException
	{
		//either returns book OR throws exception
		for(Book b : c.getBooks())
		{
			if((b.getId()).equals(a.getId()))
			{
				return b;
			}

		}
		throw new BookException("Sorry, book not found.");
		
	}
	
	public static void AddBook(Book a, Catalog c) throws BookException
	{
		
		for(Book b : c.getBooks())
		{
			if((b.getId()).equals(a.getId()))
			{
				throw new BookException("Book already in catalog.");
			}
		}
		
		ArrayList<Book> newCat = c.getBooks();//current catalog
		
		newCat.add(a);//catalog with added book
		
		c.setBooks(newCat);//set catalog to the new catalog
	}



	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	@XmlElement
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	
	public double getCost() {
		return Cost;
	}

	@XmlElement
	public void setCost(double Cost) {
		this.Cost = Cost;
	}


}
