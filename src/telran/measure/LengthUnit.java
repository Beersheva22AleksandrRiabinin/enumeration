package telran.measure;

public enum LengthUnit {

	MM(1), CM(10), IN(25.4f), M(1000), KM(1_000_000);

	float value;

	LengthUnit(float value) {
		this.value = value;
	}

	public Length between(Length l1, Length l2) {
//		float l1inMM = l1.getAmount() * l1.getUnit().getValue();
//		float l2inMM = l2.getAmount() * l2.getUnit().getValue();
//		return new Length((l2inMM - l1inMM) / value, LengthUnit.this);
		Length length1 = l1.convert(this);
		Length length2 = l2.convert(this);
		return new Length(length2.getAmount() - length1.getAmount(), this);
	}

	public float getValue() {
		return value;
	}

}
