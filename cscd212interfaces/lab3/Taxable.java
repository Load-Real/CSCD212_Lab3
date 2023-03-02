package cscd212interfaces.lab3;

public interface Taxable {
	//Fields
	static final double BASE_TAX_RATE = 0.09;
	
	//Abstract method
	public abstract double calculateTaxes();
}
