package chapter1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		this._name = name;
	}

	public void addRetal(Rental arg) {
		this._rentals.addElement(arg);
	}

	public String getName() {
		return this._name;
	}

	public String statement() {
		String result = getHeaderStatement();
		result += getRentalStatement();
		result += getFooterStatement();

		return result;
	}

	private String getHeaderStatement() {
		String result = "Rental Record for " + getName() + "\n";
		return result;
	}

	private String getFooterStatement() {
		String result = "Amount owed is " + String.valueOf(getTotalAmount())
				+ "\n";
		result += "You earned "
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "frequent renter points";
		return result;
	}

	private String getRentalStatement() {
		String result = "";
		while (_rentals.elements().hasMoreElements()) {
			Rental each = (Rental) _rentals.elements().nextElement();

			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getMovie().chargeFor(each)) + "\n";
		}
		return result;
	}

	public int getTotalFrequentRenterPoints() {
		int result = 0;

		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}

		return result;
	}

	public double getTotalAmount() {
		double result = 0;

		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getMovie().chargeFor(each);
		}

		return result;
	}
}