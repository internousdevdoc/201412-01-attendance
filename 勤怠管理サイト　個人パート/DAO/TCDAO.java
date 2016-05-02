package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dto.TCDTO;





public class TCDAO {

	Connection con =null;
	public boolean res=false;
	String sql= null;
	public List<TCDTO> itemList=new ArrayList<TCDTO>();
	PreparedStatement ps = null;

	public TCDTO select(String date, String username) throws SQLException{

		TCDTO dto = new TCDTO();

		con = DBconnector.getConnection();

		sql = "select * from attendance_"+ username +" where MMDD = ?";
//		sql = "select * from attendance_"+"aaa"+" where MMDD = ?";//(テスト用)
		System.out.println("★実行するSQL文確認 = " + sql);
		int count=0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,date);
			System.out.println("MMDD="+date);
			System.out.println("★指定された日付にて該当件数を検索");

			ResultSet rs = ps.executeQuery();
			System.out.println("★検索完了");
//			rs.next();
//			int rsCount = rs.getInt(1);
//			System.out.println(rsCount+"件");
			//検索結果の判定
//			if(rsCount>0){
			if(rs.next()){
				System.out.println("RS.NEXT");
				System.out.println("[0]"+rs.getRow()+"件取得");//件数

			}else{
				System.out.println("0件取得");//件数

					System.out.println("該当する日付がない");
					dto.setMMDD("");
					dto.setAttendance("");
					dto.setAway("");
					dto.setErrormsg("該当する日付がありません");
					return dto;
			}
//			System.out.println(itemList.get(0).getMMDD());
		} catch (SQLException e) {
			System.out.println("例外発生");
			e.printStackTrace();
		}


		sql ="select * from attendance_" + username + " where MMDD = ?";
//		sql ="select * from attendance_aaa where MMDD = ?";//(テスト用)
		System.out.println("★実行するSQL文確認 = " + sql);
		//接続情報とSQL文を格納する
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,date);
			System.out.println("MMDD="+date);
			System.out.println("★接続情報とSQL文を格納する");

			ResultSet rs = ps.executeQuery();
			System.out.println("★接続情報とSQL文を格納完了");
			//検索結果の判定
			while(rs.next()){

				System.out.println("[0]"+rs.getString(1));//日付
				System.out.println("[1]"+rs.getString(2));//出勤時間
				System.out.println("[2]"+rs.getString(3));//退勤時間
				dto.setMMDD(rs.getString(1));
				dto.setAttendance(rs.getString(2));
				dto.setAway(rs.getString(3));
				System.out.println("itemList格納");
				itemList.add(dto);

			}
			System.out.println(itemList.get(0).getMMDD());
		} catch (SQLException e) {
			System.out.println("例外発生");
			e.printStackTrace();
		}
		con.close();

		return dto;
	}
//出勤時間変更メソッド
	public void updateByAttendance(String username,String attymd,String atthm)throws Exception{
		System.out.println("出勤時間変更メソッド内");
		String sql = null;
		PreparedStatement ps = null;
		con = DBconnector.getConnection();

		try{
			//DBに日時を更新する
			sql = "UPDATE attendance_" + username + " SET ATTENDANCE=? WHERE MMDD =?";//set attendanceを更新、where mmd(条件)日時を設定
//			sql = "UPDATE attendance_" + "aaa" + " SET ATTENDANCE=? WHERE MMDD =?";//set attendanceを更新、where mmd(条件)日時を設定(テスト用)

			ps = con.prepareStatement(sql);
			String update_ymd =attymd;
			String update_attendance = atthm+"00";

			ps.setString(1,update_attendance);
			ps.setString(2,update_ymd);
			System.out.println("sql文表示"+sql);
			System.out.println("psを表示"+ps);

			int rsCount = ps.executeUpdate();
			System.out.println("出勤アップデート完了");
			if(rsCount > 0){ //更新が0以上あった場合true
				System.out.println("出勤更新件数："+rsCount);
			}else{//更新がない場合は、false

			}//else

			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
			System.out.println("SQL終わり");
		}//finally


	}//update method

//退勤時間変更メソッド
	public void updateByAway(String username,String awymd,String awhm)throws Exception{
		System.out.println("退勤時間変更メソッド内");
		String sql = null;
		PreparedStatement ps = null;
		con = DBconnector.getConnection();

		try{
			//DBに日時を更新する
			sql = "UPDATE attendance_" + username + " SET AWAY=? WHERE MMDD =?";//set attendanceを更新、where mmd(条件)日時を設定
//			sql = "UPDATE attendance_" + "aaa" + " SET AWAY=? WHERE MMDD =?";//set attendanceを更新、where mmd(条件)日時を設定(テスト用)
			ps = con.prepareStatement(sql);
			String update_ymd = awymd;
			String update_away = awhm+"00";

			ps.setString(1,update_away);
			ps.setString(2,update_ymd);
			System.out.println("sql文を表示"+sql);
			System.out.println("psを表示"+ps);

			int rsCount = ps.executeUpdate();
			System.out.println("退勤アップデート完了");
			if(rsCount > 0){ //更新が0以上あった場合true
			System.out.println("退勤更新件数："+rsCount);
			}else{//更新がない場合は、false

			}//else

			con.close();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
			System.out.println("SQL終わり");
		}//finally

	}//update method

	public List<TCDTO> getItemList() {
		return itemList;
	}
}//class
