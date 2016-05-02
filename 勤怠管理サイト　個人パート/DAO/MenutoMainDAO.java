package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dto.MenutoMainDTO;
import jp.co.internous.dto.YearMonthDTO;

import com.opensymphony.xwork2.ActionSupport;

public class MenutoMainDAO extends ActionSupport{

	public boolean action;
	Connection con=null;
	public List<MenutoMainDTO> itemList1 = new ArrayList<MenutoMainDTO>();
	public List<YearMonthDTO> itemList2 = new ArrayList<YearMonthDTO>();


//DB内に現在の日付の有無をチェックするメソッド
	public boolean select(String username, String ymd)throws Exception{

		System.out.println("selectメソッド内");

		action = false;
		con = DBconnector.getConnection();

		try{

			System.out.println("select try 内");
			String attendancetable = "attendance_" + username;
			String sql = "select * from " + attendancetable + " where MMDD = "+"'"+ymd+"'";//SQLのyyyy-mmの日付を検索
			System.out.println("select sqlを表示 - " + sql);

			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			System.out.println("select ps2を表示 - "+ ps2);

			ResultSet rs = ps2.executeQuery();
			System.out.println("executeQueryを実行");

			while(rs.next()){
				action = true;
				MenutoMainDTO dto=new MenutoMainDTO();
				dto.setMMDD(rs.getString(1));

				System.out.println("今日の日付有:"+rs.getDate(1));
			}//while

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}//finally

		System.out.println("日付は"+action);
		return action;
	}//select method



//今月の月日(1日から末日まで)をDBに入れるメソッド
	public void todayInsert(String username,String ym,int i)throws Exception{
		System.out.println("todayinsertメソッド");
		System.out.println("actionから送られてきた値"+username+":"+ym);

		con = DBconnector.getConnection();
		System.out.println("MenutoMainDAOで今日の日付をDBに入れる");

		try{
			String table = "attendance_"+username;
			String tymd = ym+"-"+i;

			System.out.println("todayinsert内のtryの中");

			String sql = "insert into " + table + " values(?,?,?)";
			System.out.println("todayinsert sqlを表示 - " + sql);

			PreparedStatement ps2;
			ps2=con.prepareStatement(sql);
			ps2.setString(1, tymd);
			ps2.setString(2, "");
			ps2.setString(3, "");

			System.out.println("todayinsert sqlの？を表示 - " + sql);
			System.out.println("todayinsert ps2内容を表示 - " + ps2);

			int rsCount = ps2.executeUpdate();
			System.out.println("今日の日付 insert 完了" + rsCount);

			if(rsCount>0){
				System.out.println("更新有り - 今日の日付挿入");
				System.out.println("updateの表示件数"+rsCount);
			}else{
				System.out.println("更新無し");
			}//else
			System.out.println("if and else finish");

			}catch(Exception e){
				e.printStackTrace();
			}finally{
				con.close();
			}//finally

		System.out.println("todayinsert Finish");
		System.out.println("actionにもどる");

		}//todayInsert method


//DB内の1日から末日までを取り出すメソッド と、itemList1に入れる
	public void selectfrom(String username, String year_month, String toDay)throws Exception{
		con = DBconnector.getConnection();

		try{
			System.out.println("selectfrom try 内");
			String sql = "select * from attendance_" + username + " where MMDD "+"like " + year_month;//SQLのyyyy-mmの日付を検索
			System.out.println("selectfrom sqlを表示 - " + sql);

			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			System.out.println("selectfrom ps2を表示 - "+ ps2);

			ResultSet rs = ps2.executeQuery();
			System.out.println("executeQueryを実行");

			while(rs.next()){
				MenutoMainDTO dto=new MenutoMainDTO();
				String str = rs.getString(1);
				String str1 = str.substring(5, 7)+"月";
				String str2 = str.substring(8, 10)+"日";
				String str3 = str1+str2;
				dto.setMMDD(str3);
				System.out.println("selectform - 取得月日変換 - "+str3);

				String strAtt = rs.getString(2);
				String strT1 = strAtt.substring(0,5);
				System.out.println("selectform - strT1 -"+ strT1);
				dto.setDBattendance(strT1);

				String strAway = rs.getString(3);
				String strT2 = strAway.substring(0,5);
				dto.setDBaway(strT2);

				dto.setToDay(toDay);
/*				dto.setMMDD(rs.getString(1));
				dto.setDBattendance(rs.getString(2));
				dto.setDBaway(rs.getString(3));

				dto.setDBattendance(rs.getString(2));
				dto.setDBaway(rs.getString(3));
*/
				System.out.println("取得している日付"+rs.getDate(1));
				itemList1.add(dto);//取り出したデータをitemListにいれる
			}//while

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}//finally

	}//selectfrom method

//DB内の年月を取り出すメソッド と、itemList2に入れる
	public void selectmonth(String username)throws Exception{
		con = DBconnector.getConnection();

		try{
			System.out.println("selectmonth - try 内");
			String attendancetable = "attendance_" + username;
			String sql = "select distinct DATE_Format(MMDD,'%Y-%m') from " + attendancetable;//sqlから年月を制限設定して抽出


			System.out.println("selectmonth - sqlを表示 - " + sql);

			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			System.out.println("selectmonth - ps2を表示 - "+ ps2);

			ResultSet rs = ps2.executeQuery();
			System.out.println("selectmonth - ecuteQueryを実行");

			while(rs.next()){
				YearMonthDTO dto=new YearMonthDTO();
				System.out.println("selectmonth - while中");
/*
				String str = rs.getString(1);
				System.out.println("selectmonth - 取得した年月 - "+ str);
				String str1 = str.substring(0,4) + "年";
				String str2 = str.substring(5,7) + "月";
				String str3 = str1+str2;
				dto.setMM(str3);
				System.out.println("selectmonth - 取得変換した年月 - "+ str3);

*/				dto.setMM(rs.getString(1));
				System.out.println("取得している年月 - "+rs.getString(1));

				itemList2.add(dto);//取り出したデータをitemList2にいれる
				System.out.println("selectmonth - itemlist2に格納完了");
			}//while

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}//finally

	}//selectfrom method

//getter method
	public List<MenutoMainDTO> getItemList1(){
		return itemList1;
	}
	public List<YearMonthDTO> getItemList2(){
		return itemList2;
	}


}//class
