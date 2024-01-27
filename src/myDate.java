public class myDate {

	// Initialize the date variables
	private int day;
	private int month;
	private int year;

	// Method used to create a date instance
	public myDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// Method used to set the day of this instance
	public void setDay(int day) {
		this.day = day;
	}

	// Method used to return the day of this instance
	public int getDay() {
		return day;
	}

	// Method used to set the month of this instance
	public void setMonth(int month) {
		this.month = month;
	}

	// Method used to return the month of this instance
	public int getMonth() {
		return month;
	}

	// Method used to set the year of this instance
	public void setYear(int year) {
		this.year = year;
	}

	// Method used to return the year of this instance
	public int getYear() {
		return year;
	}
	
	@Override
	// Method used to return a textual representation of this date instance
	public String toString() {
		return day + "/" + month + "/" + year;
	}
}