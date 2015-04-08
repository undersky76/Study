package chapter1;

public class Rental {

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

	double amountFor() {
		double result = 0;
		int standard = 0;
		double addedPoint = 0;

		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;

			standard = 2;
			addedPoint = 1.5;
			if (getDaysRented() > standard)
				result += (getDaysRented() - standard) * addedPoint;
			break;
		case Movie.NEW_RELEASE:

			standard = 0;
			addedPoint = 3;
			if (getDaysRented() > standard)
				result += (getDaysRented() - standard) * addedPoint;
			break;
		case Movie.CHILDREN:
			result += 1.5;

			standard = 3;
			addedPoint = 1.5;
			if (getDaysRented() > standard)
				result += (getDaysRented() - standard) * addedPoint;
			break;
		}
		return result;
	}
}