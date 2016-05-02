package jp.co.internous.action;

import java.sql.SQLException;
import java.util.Map;

import jp.co.internous.dao.LoginDAO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * クラス名：LoginAction
 * クラスの説明：Login用のアクションクラス
 */
public class LoginAction extends ActionSupport implements SessionAware{

//	String dbname="test";

	private String userID;
	private String password;
	private String result;
	public Map<String, Object> sessionMap;

	//struts.xmlの情報を元に、executeメソッドが実行される
	public  String execute() throws SQLException{

		System.out.println("★LoginAction実行");

		System.out.println("★JSPに入力されたuserID = " + userID);
		System.out.println("★JSPに入力されたpassword = " + password);

		//return値の初期値をERRORに設定
		result = ERROR;

		//LoginDAOクラスをインスタンス化
		LoginDAO logindao = new LoginDAO();

		//LoginDAOクラスのselectメソッドを実行し、return値をboolean型のresultDAOに格納
		boolean resultDAO = logindao.select(userID,password);

		//データベースの検索結果がtrueならば、変数resultの値をSUCCESSに変更
		if(resultDAO){
			result = SUCCESS;
		}
		sessionMap.put("USERNAME",logindao.DBuserID );
		System.out.println("--------------sessionUSERNAME-----------"+sessionMap.get("USERNAME"));
		sessionMap.put("USERPASSWD",logindao.DBpassword);
		System.out.println("-------------sessionPASS---------"+sessionMap.get("USERPASSWD"));


		System.out.println("★struts.xmlに返却する値を確認 = " + result);
		//struts.xmlに値を返却
		return result;
	}

	//遷移元のjspからformのname属性を取得
	public String setUserID(String userID){
		System.out.println("★LoginActionのsetUserIDメソッド実行");
		return this.userID = userID;
	}

	//遷移元のjspからformのname属性を取得
	public void setPassword(String password){
		System.out.println("★LoginActionのsetPasswordメソッド実行");
		this.password = password;
	}



	//セッション用setter getter ----------------------------------------

		/**
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}


	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

		public Map<String, Object> getSessionMap() {
			return sessionMap;
		}

		/**
		 * @param sessionMap セットする sessionMap
		 */
		public void setSession(Map<String, Object> sessionMap) {
			this.sessionMap = sessionMap;
		}

}
