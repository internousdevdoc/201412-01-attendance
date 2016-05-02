package jp.co.internous.dto;

public class ByeByeTimeDTO {

	private static String mmdd;
	private static String away;

	public static String getMmdd(){
		return mmdd;
	}

	public void setMmdd(String mmdd){
		ByeByeTimeDTO.mmdd=mmdd;
	}

	public static String getAway(){
		return away;
	}

	public void setAway(String away){
		ByeByeTimeDTO.away=away;
	}

}//class
