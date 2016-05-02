package jp.co.internous.dto;

public class AttendanceDTO {

	private static String mmdd;
	private static String attendance;

	public static String getMmdd(){
		return mmdd;
	}

	public void setMmdd(String mmdd){
		AttendanceDTO.mmdd=mmdd;
	}

	public static String getAttendance(){
		return attendance;
	}

	public void setAttendance(String attendance){
		AttendanceDTO.attendance=attendance;
	}

}//class
