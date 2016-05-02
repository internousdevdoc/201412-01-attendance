package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.dto.LoginDTO;

import com.opensymphony.xwork2.ActionSupport;

/**
 * クラス名：LoginDAO
 * クラスの説明：データベース接続用のDAOクラス
 */
public class LoginDAO extends ActionSupport {

	//IDとPassに紐づくUserNameの格納
	private String DBuserName;
	public String DBuserID;
	public String DBpassword;
	LoginDTO loginDto = new LoginDTO();

	Connection con = null;
	String sql = null;
	PreparedStatement ps = null;

	//データベース検索結果判定用の変数
	private boolean resultDAO = false;

	//LoginActionクラスから渡された引数を元にselectメソッドを実行
	public boolean select(String userID, String password) throws SQLException{

		System.out.println("★LoginDAO実行");

		con = DBconnector.getConnection();
		//con = DBconnecter.getConnection();により
		//DBconnecterクラスの getConnection() コンストラクタ（自動処理により）データベース接続が行われる

		try {


				//SQL文作成
//				String sql = "SELECT * FROM login_table where username = \"";
				//String sql = "SELECT * FROM login where username = \"";
		//		sql += userID + "\" AND password = \"" + password + "\"" ;

//				AND userName = \"" + userName + "\""
				String sql = "select * from login where username = ? AND password=?";

				System.out.println("★実行するSQL文確認 = " + sql);

				//接続情報とSQL文を格納する
				ps = con.prepareStatement(sql);
				ps.setString(1, userID);
				ps.setString(2, password);


				System.out.println("★接続情報とSQL文を格納する");

				//接続情報を元にSQL文実行
				ResultSet rs = ps.executeQuery();
				System.out.println("result set 実行");

				//検索結果を判定
				while(rs.next()){

					//DB検索成功なので結果判定用の変数をtrueに変更
					resultDAO = true;

					//LoginDTOクラスをインスタンス化
					LoginDTO logindto = new LoginDTO();

					//LoginDTOをのメソッドを実行し、DBから取得した値を格納
					DBuserID = logindto.setUserID(rs.getString(2));
					DBpassword = logindto.setPassword(rs.getString(3));
//					String DBuserName = logindto.setUserName(rs.getString(3));
					DBuserName=rs.getString(1);
					//検索結果をコンソールで確認
					System.out.println("DBから取得したuserID =" + DBuserID );
					System.out.println("DBから取得したuserPassword =" + DBpassword );
//					System.out.println("DBから取得したuserName =" + DBuserName );

				}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//データベース接続を止める
		//つなぎっぱはサーバーの枯渇につながる
		con.close();


		//DB検索判定をLoginActionにリターンする
		return resultDAO;
	}

	//LoginActionクラスから渡された引数を元にselectメソッドを実行
	public LoginDTO select(String password) throws SQLException{

		System.out.println("★LoginDAO実行");

		con = DBconnector.getConnection();
		//con = DBconnecter.getConnection();により
		//DBconnecterクラスの getConnection() コンストラクタ（自動処理により）データベース接続が行われる

		try {


				//SQL文作成
				String sql = "SELECT * FROM login where password = \"" + password + "\"" ;

				System.out.println("★実行するSQL文確認 = " + sql);

				//接続情報とSQL文を格納する
				ps = con.prepareStatement(sql);

				System.out.println("★接続情報とSQL文を格納する");

				//接続情報を元にSQL文実行
				ResultSet rs = ps.executeQuery();
				System.out.println("loginDAO - rs実行 -" + rs );
				//検索結果を判定
				while(rs.next()){
					System.out.println("loginDAO - while中");
					//DB検索成功なので結果判定用の変数をtrueに変更
					resultDAO = true;

					//LoginDTOをのメソッドを実行し、DBから取得した値を格納
					DBuserID = loginDto.setUserID(rs.getString(2));
					DBpassword = loginDto.setPassword(rs.getString(3));
//					String DBuserName = logindto.setUserName(rs.getString(3));
					DBuserName=rs.getString(1);
					//検索結果をコンソールで確認
					System.out.println("DBから取得したuserID =" + DBuserID );
					System.out.println("DBから取得したuserPassword =" + DBpassword );
//					System.out.println("DBから取得したuserName =" + DBuserName );

				}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//データベース接続を止める
		//つなぎっぱはサーバーの枯渇につながる
		con.close();


		//DB検索判定をLoginActionにリターンする
		System.out.println("LoginDAOをでます。Return="+resultDAO);
		return loginDto;
	}

	public String dbname(){
		return DBuserName;
	}
	public String dbuserID(){
		return DBuserID;
	}

}
