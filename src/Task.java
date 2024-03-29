public class Task {

	private String name;
	private myDate startDate;
	private myDate endDate;
	private String priority;
	private int percComp;
	private String category;
	private String note;

	// Constructor used to make a generic task
	public Task()
	{
		this.name = "name";
		this.startDate = new myDate(01, 01, 2011);
		this.endDate = new myDate(01, 01, 2011);
		this.priority = "priority";
		this.percComp = 0;
		this.category = "category";
		this.note = "note";
	}

	// Method used to create a task
	public Task(String name, myDate startDate, myDate endDate, String priority, int percComp, String category, String note)
	{
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.percComp = percComp;
		this.category = category;
		this.note = note;
	}

	// Method used to set the task's name
	public void setName(String name) {
		this.name = name;
	}

	// Method used to return the name of the task
	public String getName() {
		return name;
	}

	// Method used to set the task's start date
	public void setStartDate(myDate startDate) {
		this.startDate = startDate;
	}

	// Method used to return the start date of the task
	public myDate getStartDate() {
		return startDate;
	}

	// Method used to set the task's end date
	public void setEndDate(myDate endDate) {
		this.endDate = endDate;
	}

	// Method used to return the end date of the task
	public myDate getEndDate() {
		return endDate;
	}

	// Method used to set the task's priority
	public void setPriority(String priority) {
		this.priority = priority;
	}

	// Method used to return the task's priority
	public String getPriority() {
		return priority;
	}

	// Method used to set the task's percentage complete
	public void setPercentComplete(int percComp) {
		this.percComp = percComp;
	}

	// Method used to return the percentage complete of the task
	public int getPercentComplete() {
		return percComp;
	}
	
	// Method used to set the task's category
	public void setCategory(String category) {
		this.category = category;
	}

	// Method used to return the category of the task
	public String getCategory() {
		return category;
	}
	
	// Method used to set the task notes
	public void setNote(String note) {
		this.note = note;
	}

	// Method used to return the task notes
	public String getNote() {
		return note;
	}

	// Method used to return a textual representation of the task
	public String toString() {
		return "Name: " + getName() + "\n" + "Start Date: " + getStartDate() + "\n" + "End Date: " + getEndDate() + "\n"
				+ "Priority: " + getPriority() + "\n" + "Percent Complete: " + getPercentComplete() + "Category: "
				+ getCategory() + "Note: " + getNote();
	}
	
	// Method used to output the task data used for exporting into files
	public String toStringExport() {
		return getName() +"�"+ getStartDate().getDay() +"�"+ getStartDate().getMonth() +"�"+ getStartDate().getYear() +"�"+ getEndDate().getDay() +"�"+ getEndDate().getMonth() +"�"+ getEndDate().getYear() +"�"+ getPriority() +"�"+ getPercentComplete() +"�"+ getCategory() +"�"+ getNote();
	}
}