package model;
import java.time.LocalDate;

public class ExpenseModel{
	private int user_id;
	private float expense_amount;
	private LocalDate expense_date;
	private String expense_category;
	private String expense_description;
	
	public ExpenseModel(int user_id, float expense_amount, LocalDate expense_date, String expense_category,
			String expense_description) {
		super();
		this.user_id = user_id;
		this.expense_amount = expense_amount;
		this.expense_date = expense_date;
		this.expense_category = expense_category;
		this.expense_description = expense_description;
	}
	public float getExpense_amount() {
		return expense_amount;
	}
	public void setExpense_amount(int expense_amount) {
		this.expense_amount = expense_amount;
	}
	public LocalDate getExpense_date() {
		return expense_date;
	}
	public void setExpense_date(LocalDate expense_date) {
		this.expense_date = expense_date;
	}
	public String getExpense_category() {
		return expense_category;
	}
	public void setExpense_category(String expense_category) {
		this.expense_category = expense_category;
	}
	public String getExpense_description() {
		return expense_description;
	}
	public void setExpense_description(String expense_description) {
		this.expense_description = expense_description;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}