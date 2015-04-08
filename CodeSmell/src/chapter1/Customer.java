package chapter1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	}

	public void addRetal(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {

		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			// 포인트(frequent renter points) 추가
			frequentRenterPoints++;

			// 최신을 이틀이상 대여하는 경우 추가 포인트 제공
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;

			// 이 대여에 대한 요금 계산 결과 표시
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.amountFor()) + "\n";
			totalAmount += each.amountFor();
		}

		// footer 추가
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ "frequent renter points";

		return result;
	}
}