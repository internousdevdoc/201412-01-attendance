package jp.co.internous.dto;



public class MenutoMainDTO {

	public String MMDD;//年月日
	public String DBattendance;//出勤タイム
	public String DBaway;//退勤タイム
	public String toDay;

	public String getMMDD(){
		return MMDD;
	}

	public void setMMDD(String date){
		this.MMDD = date;
	}

	public String getDBattendance(){
		return DBattendance;
	}

	public void setDBattendance(String dbattendance){
		this.DBattendance = dbattendance;
	}

	public String getDBaway(){
		return DBaway;
	}

	public void setDBaway(String dbaway){
		this.DBaway = dbaway;
	}

	public String getToDay(){
		return toDay;
	}

	public void setToDay(String toDay){
		this.toDay = toDay;
	}
}//class
