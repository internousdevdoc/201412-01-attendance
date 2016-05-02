package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;


public class ResignDAO extends ActionSupport{


	//データベース接続用に初期値を設定
	Connection con = null;
	//データベース検索結果判定用の変数
	private boolean res = false;

	String sql = null;


	//ResignActionクラスから渡された引数を元にexecuteメソッドを実行
	public boolean delete(String userpasswd)throws SQLException{

		System.out.println("■ResignDAO実行");
		//DBconnecterクラスのgetConnection()メソッドを実行
		con = DBconnector.getConnection();
		try {
			//あとでテーブル名とテーブル内のカラム名も変更！！！！
			sql="delete from login where password=?";

			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("■接続情報とSQL文を格納する");
			ps.setString(1, userpasswd);

			System.out.println("◆実行するSQL分を確認"+sql);
			//接続情報を元にSQL文実行
			System.out.println("■SQL文実行じゃーーーーい！");
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("◆Updateの件数表示◆＝"+i);

				res=true;
			} else {res=false;}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			//接続を切断
			con.close();
			System.out.println("■接続をきる");
		}

		return res;
	}

	//ResignActionクラスから渡された引数を元にexecuteメソッドを実行
	public boolean drop(String username)throws SQLException{

		System.out.println("■ResignDAOのDROP実行");
	// Connectionを生成
	con = DBconnector.getConnection();
	System.out.println("Connectionを生成したよ");

	try {
		// Actionjavaからの依頼を実行する
		sql = "drop table attendance_" + username;

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("■接続情報とSQL文を格納する");


		System.out.println("◆実行するSQL分を確認"+sql);
		//接続情報を元にSQL文実行
		System.out.println("■SQL文実行じゃーーーーい！");
		ps.executeUpdate();
		sql = "drop table if exists attendance_" + username;
		ps = con.prepareStatement(sql);
		System.out.println("■接続情報とSQL文を格納する");

		System.out.println("◆実行するSQL分を確認"+sql);
		//接続情報を元にSQL文実行
		System.out.println("■SQL文実行じゃーーーーい！");
		boolean i = ps.execute();

		if (i) {
			System.out.println("◆Dropの件数表示◆＝" + i);
			res = false;


		} else {
			System.out.println("◆Dropの件数表示◆＝" + i);
			res = true;

		}

		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		System.out.println("◆接続をきる");
		con.close();
	}
	return res;
	}

	public boolean delete(String USERNAME, String userpassword) {

		System.out.println("■ResignDAO実行");
		//DBconnecterクラスのgetConnection()メソッドを実行
		con = DBconnector.getConnection();
		try {
			//あとでテーブル名とテーブル内のカラム名も変更！！！！
			sql="delete from login where password=?"+
			"And username=?";

			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("■接続情報とSQL文を格納する");
			ps.setString(1, userpassword);
			ps.setString(2, USERNAME);

			System.out.println("◆実行するSQL文を確認"+sql);
			//接続情報を元にSQL文実行
			System.out.println("■SQL文実行じゃーーーーい！");
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("◆Updateの件数表示◆＝"+i);

				res=true;
			} else {res=false;}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			//接続を切断
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			System.out.println("■接続をきる");
		}

		return res;
	}


}
