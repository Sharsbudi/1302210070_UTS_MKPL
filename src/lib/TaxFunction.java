package lib;

public class TaxFunction {

	private static final int BASIC_TAX_THRESHOLD = 54000000;
	private static final int MARRIED_BONUS = 4500000;
	private static final int CHILD_BONUS = 1500000;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible,
			boolean isMarried, int numberOfChildren) {

		int tax = 0;

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}

		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}

		if (isMarried) {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible
					- (BASIC_TAX_THRESHOLD + MARRIED_BONUS + (numberOfChildren * CHILD_BONUS))));
		} else {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible
					- BASIC_TAX_THRESHOLD));
		}

		if (tax < 0) {
			return 0;
		} else {
			return tax;
		}

	}

}
