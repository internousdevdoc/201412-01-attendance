package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

/**
 * クラス名:ChangePassWordActionDAO
 *クラスの説明:データベース接続用のDAOクラス
 */

		public class ChangePassWordDAO extends ActionSupport{

		//IDとPassに紐づくUserNameの格納
		public String password;
		public String newpassword;
		public String newpassword2;

		//データベース接続用に初期化を設定
		Connection con = null;
		String sql = null;
		PreparedStatement ps = null;

		//データベースの検索結果判定用の変数
		private boolean resultDAO = false;

		//LoginActionクラスから渡された引数を元にselectメソッドを実行
		public boolean update(String nowpassword, String newpassword_go)throws Exception{

			System.out.println("ChangePasswdDAOのupdateメソッド実行");

			//データベース接続実施
		con = DBconnector.getConnection();

		try {

				//SQL文作成
				String sql ="update login set password = ? where password = ?";


				//接続情報とSQL文を格納する
				PreparedStatement ps= con.prepareStatement(sql);
				System.out.println("接続情報とSQL文を格納する:"+newpassword_go);


				ps.setString(1, newpassword_go);
				ps.setString(2, nowpassword);

				//接続情報を元にSQL文実行
				System.out.println("SQL文実行 ： "+ sql);
				int resultCount = ps.executeUpdate();
				System.out.println("SQLを実行したよ");
				if(resultCount>0){
					System.out.println("実行した件数が１件以上でした");
					//検索結果を判定
					resultDAO=true;
					System.out.println("Returnを返しますね");
				}
			}catch(Exception e) {
				System.out.println("例外が発生したよ");
		     	e.printStackTrace();
			}finally{
				System.out.println("変更");
				con.close();
			}
			return resultDAO;
		}
}