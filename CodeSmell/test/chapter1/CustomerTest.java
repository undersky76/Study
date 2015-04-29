package chapter1;

import static org.junit.Assert.*;
import jdk.nashorn.internal.ir.annotations.Ignore;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer customer;
	
	@Before
	public void setUp(){
		this.customer = new Customer("name");
		assertNotNull(customer);
	}
	
	@Test
	public void whenCustomerNotRentMovie() {
		
		String expecteds = "Rental Record for name\n"
				+"Amount owed is 0.0\n"
				+"You earned 0frequent renter points";
		thenAssertEquals(expecteds, customer.statement());
	}
	
	@Test
	public void whenCustomerRentOneMovie() {
		
		whenAddRetal(Movie.REGULAR, 0);
		
		String expecteds = "Rental Record for name\n"
				+"	title	2.0\n"
				+"Amount owed is 2.0\n"
				+"You earned 1frequent renter points";
		thenAssertEquals(expecteds, customer.statement());
	}
	
	@Test
	public void whenCustomerRentOneMovieThreeDays() {
		
		whenAddRetal(Movie.REGULAR, 3);
		
		String expecteds = "Rental Record for name\n"
				+"	title	3.5\n"
				+"Amount owed is 3.5\n"
				+"You earned 1frequent renter points";
		
		thenAssertEquals(expecteds, customer.statement());
	}
	
	@Test
	public void whenCustomerRentOneNewReleaseMovie() {
		
		whenAddRetal(Movie.NEW_RELEASE, 0);
		
		String expecteds = "Rental Record for name\n"
				+"	title	0.0\n"
				+"Amount owed is 0.0\n"
				+"You earned 1frequent renter points";
		thenAssertEquals(expecteds, customer.statement());
	}
	
	@Test
	public void whenCustomerRentOneNewReleaseMovie2Day() {
		
		whenAddRetal(Movie.NEW_RELEASE, 2);
		
		String expecteds = "Rental Record for name\n"
				+"	title	6.0\n"
				+"Amount owed is 6.0\n"
				+"You earned 2frequent renter points";
		thenAssertEquals(expecteds, customer.statement());
	}

	@Test
	public void whenCustomerRentOneChildrenMovie() {
		
		whenAddRetal(Movie.CHILDREN, 0);
		
		String expecteds = "Rental Record for name\n"
				+"	title	1.5\n"
				+"Amount owed is 1.5\n"
				+"You earned 1frequent renter points";
		thenAssertEquals(expecteds, customer.statement());
	}

	@Test
	public void whenCustomerRentOneChildrenMovie4Days() {
		
		whenAddRetal(Movie.CHILDREN, 4);
		
		String expecteds = "Rental Record for name\n"
				+"	title	3.0\n"
				+"Amount owed is 3.0\n"
				+"You earned 1frequent renter points";
		
		thenAssertEquals(expecteds, customer.statement());
	}
	
	@Test
	public void whenCustomerRentOneOrderMovie() {
		
		whenAddRetal(10, 4);
		
		String expecteds = "Rental Record for name\n"
				+"	title	0.0\n"
				+"Amount owed is 0.0\n"
				+"You earned 1frequent renter points";
		
		thenAssertEquals(expecteds, customer.statement());
	}
	
	private void whenAddRetal(int priceCode, int daysRented) {
		Movie movie = new Movie("title" , priceCode );
		Rental retal = new Rental(movie, daysRented);	
		this.customer.addRetal(retal);
	}

	private void thenAssertEquals(String expecteds, String actual) {
		assertEquals(expecteds, this.customer.statement());
	}

}
