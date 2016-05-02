package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterDAO extends ActionSupport{

	//データベース検索結果判定用の変数
	Connection con = null;
	String rsgsql = null;
	PreparedStatement ps2 = null;
	private boolean resultDAO = false;


	public boolean select(String username,String password1)throws Exception{

		System.out.println("RegisterDAOを実行");

		con = DBconnector.getConnection();
		try {
			//データベース接続実施

			//データベース接続用に初期値を設定





//			String sql ="insert into login (username,password)";
	//		sql+= "value(\""+ username+"";
	//		sql+= "\",\""+ password1 +"\");" ;

			String sql ="insert into login (username,password)";
			sql+= "value(\""+ username+"";
			sql+= "\",\""+ password1 +"\");" ;


			System.out.println("★実行するSQL分を確認"+sql);
			//接続情報とSQL文を格納する
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("★接続情報とSQL文を格納する");

			System.out.println("★sql文を実行！！");
			//接続情報を元にSQL文実行
			ps.executeUpdate();

			resultDAO=true;
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		//NewloginActionにboolean型を返す
		return resultDAO;
	}

}


