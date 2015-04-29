package chapter1;

public class ReqularMovie extends Movie {

	public ReqularMovie(String title) {
		super(title, Movie.REGULAR);
	}

	@Override
	public double chargeFor(Rental rental) {
		double result = 2;
		if (rental.getDaysRented() > 2)
				result += (rental.getDaysRented() - 2) * 1.5;
		return result;
	}
}
