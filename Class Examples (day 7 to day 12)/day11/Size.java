package day11;

public enum Size {
	SMALL ("Small", "S"),
	MEDIUM ("Medium", "M"),
	LARGE ("Large", "L");
	
	private String description;
	private String simbol;

	private Size(String description, String simbol) {
		this.description = description;
		this.simbol = simbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}
	
	public String toString() {
		return (this.description + " " + this.simbol);

	}
	
	
}
