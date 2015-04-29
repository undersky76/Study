package chapter1;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	public double chargeFor(Rental rental) {
		double result = 0;
		int standard = 0;
		double addedPoint = 0;
	
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			standard = 2;
			addedPoint = 1.5;
			if (rental.getDaysRented() > standard)
				result += (rental.getDaysRented() - standard) * addedPoint;
			break;
		case Movie.NEW_RELEASE:
			standard = 0;
			addedPoint = 3;
			if (rental.getDaysRented() > standard)
				result += (rental.getDaysRented() - standard) * addedPoint;
			break;
		case Movie.CHILDREN:
			result += 1.5;
			standard = 3;
			addedPoint = 1.5;
			if (rental.getDaysRented() > standard)
				result += (rental.getDaysRented() - standard) * addedPoint;
			break;
		}
		return result;
	}
}