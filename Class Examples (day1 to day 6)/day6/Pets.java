package day6;

public class Pets {
	private String name;
	private String species;
	private int days;
	private double price;
	private double CareExpense;
	private double profit = 0.15;
	
	public Pets(String name, String species, int days, double price, double careExpense) {
		super();
		this.name = name;
		this.species = species;
		this.days = days;
		this.price = price;
		this.CareExpense = careExpense;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCareExpense() {
		return CareExpense;
	}
	public void setCareExpense(double careExpense) {
		CareExpense = careExpense;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	
	public int getDays() {
		return days;
	}
　
	public void setDays(int days) {
		this.days = days;
	}

	public double final_sales_price () {
		double finalPrice = (1 + this.profit) * (this.price + this.CareExpense * this.days);
		return finalPrice;
	}

	public String toString() {
		return "Pets [name=" + name + ", species=" + species + ", price=" + price + ", CareExpense=" + CareExpense
				+ ", profit=" + profit + "]";
	}
	
	
	

}
