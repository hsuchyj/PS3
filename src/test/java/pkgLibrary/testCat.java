package pkgLibrary;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.File;
import pkgMain.*;
import java.util.Date;

public class testCat {

	@Test
	public void testGetBook() throws BookException
	{
		Catalog c = new Catalog();
		c = XMLReader.read(c);
		Book foo = new Book();//accessor
		Book b = new Book("bk105", c);
		Book b1 = new Book("bk105", "1", "s","c",  181, new Date(), "class", 20);
		
		Book b2 = new Book("c", "1", "s","c",  181, new Date(), "class", 20);
		
		assertEquals((foo.GetBook(b,c)).getId(), b1.getId());//GetBook working		
	}
	
	@Test
	public void testAddBook() throws BookException
	{
		Catalog c = new Catalog();
		c = XMLReader.read(c);
		Book foo = new Book();
		Book b = new Book("bk105", c);
		Book b1 = new Book("bk105", "1", "s","c",  181, new Date(), "class", 20);
		
		Book b2 = new Book("c", "1", "s","c",  181, new Date(), "class", 20);

		assertEquals(c.getBooks().size(), 12);
		Book.AddBook(b2, c);
		assertEquals(c.getBooks().size(), 13);//since add book works size is now 13 instead of 12
	}

}
