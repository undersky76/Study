package chapter1;

public class ChildrenMovie extends Movie {

	public ChildrenMovie(String title) {
		super(title, Movie.CHILDREN);
	}

	@Override
	public double chargeFor(Rental rental) {
		double result = 1.5;
		if (rental.getDaysRented() > 3)
				result += (rental.getDaysRented() - 3) * 1.5;
		return result;
	}
}
