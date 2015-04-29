package chapter1;

public class Rental {


	static final int BASIC_RENTER_POINT = 1;
	static final int ADDITIONAL_RENTER_POINT = 1;
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	int getFrequentRenterPoints() {
		
		int frequentRenterPoints = BASIC_RENTER_POINT;
	
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
		&& getDaysRented() > 1)
			frequentRenterPoints+=ADDITIONAL_RENTER_POINT;
		
		return frequentRenterPoints;
	}
}