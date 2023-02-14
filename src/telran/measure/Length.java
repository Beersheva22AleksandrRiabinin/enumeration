package telran.measure;

public class Length implements Comparable<Length> {
	private final float amount;
	private final LengthUnit lengthUnit;

	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}

	@Override
	/**
	 * equals two Length objects according to LengthUnit and amount 10m == 10000mm
	 */
	public boolean equals(Object obj) {

		return compareTo((Length) obj) == 0;
	}

	@Override
	/**
	 * 
	 * @param o
	 * @return < 0 "this" object less than "o" object, > 0 "this" object greater
	 *         than "o" object, == 0 "this" object equals "o" object,
	 */
	public int compareTo(Length o) {
//		float mm1 = amount * lengthUnit.value;
//		float mm2 = o.amount * o.getUnit().getValue();
//		return (int)(mm1 - mm2);
		return Float.compare(amount, o.convert(lengthUnit).amount);
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit example,
	 *         convert(LengthUnit.M) returns Length in meters
	 */
	public Length convert(LengthUnit unit) {

//		float mm = amount * lengthUnit.value;
//		return new Length(mm / unit.value, unit);
		return new Length(amount * this.lengthUnit.getValue() / unit.getValue(), unit);
	}

	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20.0M (string expression of Length object presenting 20 meters)
	 */
	public String toString() {
		
//		return "" + amount + lengthUnit;
		String amountStr = Float.toString(amount);
		return amountStr + lengthUnit.toString();
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}

}