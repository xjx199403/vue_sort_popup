

import java.io.Serializable;

public class dataResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String sendCity;
	private String income;
	private String tariff;
	private String grade;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getSendCity() {
		return sendCity;
	}
	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getTariff() {
		return tariff;
	}
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}