package jp.co.internous.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.internous.dto.AttendanceDTO;

import com.opensymphony.xwork2.ActionSupport;
public class AttendanceDAO extends ActionSupport{

	Connection con = null;
	String sql = null;
	PreparedStatement ps = null;

	public boolean res;

	public boolean update(String username, String ymd, String hm)throws Exception{

		con = DBconnector.getConnection();

		try{
			//DBに日時を更新する
			sql = "UPDATE attendance_" + username + " SET ATTENDANCE=? WHERE MMDD=?";//set attendanceを更新、where mmd(条件)日時を設定
			ps = con.prepareStatement(sql);
			String update_ymd = ymd;
			String update_attendance = hm;

			ps.setString(1,update_attendance);
			ps.setString(2,update_ymd);

			System.out.println("AttendanceDAO - psの内容 - "+ ps);

			int rsCount = ps.executeUpdate();
			System.out.println("AttendanceDAO - executeUpdate完了");

			if(rsCount > 0){ //更新が0以上あった場合true
				res = true;
				AttendanceDTO dto = new AttendanceDTO();

				dto.setMmdd(update_ymd);
				dto.setAttendance(update_attendance);

			}else{//更新がない場合は、false
				res = false;
			}//else

			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}//finally

		return res;

	}//update method

}//class
