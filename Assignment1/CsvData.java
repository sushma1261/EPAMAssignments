import com.opencsv.bean.CsvBindByName;

public class CsvData {
	@CsvBindByName
	int year;
	
	@CsvBindByName
	int revenue;
	
	@CsvBindByName
	int expenditure;
	
	@CsvBindByName
	int category;

	public int getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(int expenditure) {
		this.expenditure = expenditure;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

}
