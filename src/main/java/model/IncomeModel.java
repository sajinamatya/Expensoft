package model; 
import java.time.LocalDate;

public class IncomeModel {
	private int user_id;
	private float income_amount;
	private LocalDate income_date;
	private String income_category;
	private String income_description;
	/**
	 * @param user_id
	 * @param income_amount
	 * @param income_date
	 * @param income_category
	 * @param income_description
	 */
	public IncomeModel(int user_id, float income_amount, LocalDate income_date, String income_category, String income_description) {
		super();
		this.user_id = user_id;
		this.income_amount = income_amount;
		this.income_date = income_date;
		this.income_category = income_category;
		this.income_description = income_description;
	}
	/**
	 * @return
	 */
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public float getIncome_amount() {
		return income_amount;
	}
	public void setIncome_amount(float income_amount) {
		this.income_amount = income_amount;
	}
	public LocalDate getIncome_date() {
		return income_date;
	}
	public void setIncome_date(LocalDate income_date) {
		this.income_date = income_date;
	}
	public String getIncome_category() {
		return income_category;
	}
	public void setIncome_category(String income_category) {
		this.income_category = income_category;
	}
	public String getIncome_description() {
		return income_description;
	}
	public void setIncome_description(String income_description) {
		this.income_description = income_description;
	}
	
	
	
	
}