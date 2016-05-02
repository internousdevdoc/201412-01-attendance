package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.internous.dto.ByeByeTimeDTO;

public class ByeByeTimeDAO {
		Connection con = null;
		String sql = null;
		PreparedStatement ps = null;
		public boolean selres;
		public boolean res;

		public boolean select(String username,String ymd)throws Exception{//attendanceの出勤時間チェック
			con = DBconnector.getConnection();
			selres = false;
			try{
				System.out.println("ByeBeyTime - select try 内");
				String sql = "select attendance from attendance_" + username + " where MMDD = "+"'"+ymd+"'";//SQLのyyyy-mmの日付を検索
				System.out.println("select sqlを表示 - " + sql);

				PreparedStatement ps2;
				ps2 = con.prepareStatement(sql);
				System.out.println("select ps2を表示 - "+ ps2);

				ResultSet rs = ps2.executeQuery();
				System.out.println("ByeTimeDAO - executeQueryを実行");

				while(rs.next()){
					String str = rs.getString(1);
					System.out.println("ByeTimeDAO - select - "+rs.getString(1));
					if(str.equals("00:00:00")){
						System.out.println("ByeTimeDAO - if ");
						selres = false;
						System.out.println("ByeTimeDAO - select while -" + selres);
					}else{
					selres = true;
					System.out.println("ByeTimeDAO - selres while-" +selres);
					}

					System.out.println(ymd+"の出勤時間:"+rs.getString(1));
				}//while
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				con.close();
			}//finally
			System.out.println("ByeTimeDAO - 返す値selres -"+selres);
			return selres;
		}//select

		public boolean update(String username, String ymd, String hm)throws Exception{

			con = DBconnector.getConnection();

			try{
				//DBに日時を更新する
				sql = "UPDATE attendance_" + username + " SET AWAY=? WHERE MMDD=?";//set ByeByeTimeを更新、where mmd(条件)日時を設定
				ps = con.prepareStatement(sql);
				String update_ymd = ymd;
				String update_away = hm;

				ps.setString(1,update_away);
				ps.setString(2,update_ymd);

				System.out.println("ByeByeTimeDAO - psの内容 - "+ ps);

				int rsCount = ps.executeUpdate();
				System.out.println("ByeByeTimeDAO - executeUpdate完了");

				if(rsCount > 0){ //更新が0以上あった場合true
					res = true;
					ByeByeTimeDTO dto = new ByeByeTimeDTO();

					dto.setMmdd(update_ymd);
					dto.setAway(update_away);

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