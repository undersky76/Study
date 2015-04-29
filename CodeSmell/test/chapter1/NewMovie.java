package chapter1;

public class NewMovie extends Movie {

	public NewMovie(String title) {
		super(title, Movie.NEW_RELEASE);
	}

	@Override
	public double chargeFor(Rental rental) {
		double result = 0;
		if (rental.getDaysRented() > 0)
				result += (rental.getDaysRented() - 0) * (double) 3;

			return result;
	}
}
