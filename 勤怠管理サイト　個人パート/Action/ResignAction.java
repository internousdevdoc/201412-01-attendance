package jp.co.internous.action;

import java.sql.SQLException;
import java.util.Map;

import jp.co.internous.dao.LoginDAO;
import jp.co.internous.dao.ResignDAO;
import jp.co.internous.dto.LoginDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResignAction extends ActionSupport implements SessionAware{

	private String userpassword;
	private String result;
	private Map<String, Object> sessionMap;
	private String userName;
	private String password;

	//DAOに送る用
	private String msg=null;
	private String resignerrormsg=null;


	public String execute()throws SQLException{

			System.out.println("■ResignActionの実行");
			System.out.println("■JSPに入力されたpassword = " + userpassword);

			//resultの初期値をERRORで設定
			result=ERROR;

			//LoginDAOクラスをインスタンス化
			LoginDAO dao = new LoginDAO();
			//LoginDTOクラスをインスタンス化
			LoginDTO dto = new LoginDTO();
			//LoginDAOクラスのselectメソッドを実行し、return値をboolean型のresultDAOに格納
//			dao.select((String) LoginAction.sessionMap.get("USERNAME"),userpassword);
			System.out.println("ResignActionです。");

			userName=dto.getUserName();
			password=dto.getPassword();

			System.out.println("ユーザ："+LoginAction.sessionMap.get("USERNAME"));
			System.out.println("パスワード："+password);

//			sessionMap.put("USERNAME",dto.getUserID() );
//			System.out.println("--------------sessionUSERNAME-----------"+sessionMap.get("USERNAME"));
//			sessionMap.put("USERPASSWD",dto.getPassword());
//			System.out.println("-------------sessionPASS---------"+sessionMap.get("USERPASSWD"));

			System.out.println("LoginDTO"+LoginDTO.getUserName());

			System.out.println("セッション（パスワード）の値："+LoginAction.sessionMap.get("USERPASSWD"));
			if(userpassword.equals(password)){
				System.out.println("セッションのユーザは一致してたよ");
				//ResignDAOクラスをインスタンス化
				ResignDAO dao2 = new ResignDAO();
				//resigndao.exe(userpassword)によりtrueかfalseが返ってくるので
				boolean res=dao2.delete(userName,userpassword);
				System.out.println("LOGINテーブル：DELETE文を実行したよ");
				if(res){
					System.out.println("一件以上消したよ");
				}
				boolean res2=dao2.drop(userName);
				System.out.println("ATTENDANCEテーブル：DROP文を実行したよ");
				if(res && res2){
					System.out.println("テーブルを消したよ");
					msg=userName+"さんの退会に成功しました";
					System.out.println(msg+"\nおめでとう");
					result=SUCCESS;
				}

			System.out.println("■struts.xmlに返却する値を確認 = " + result);
			}else{
				resignerrormsg="入力に誤りがあるか、パスワードが違います";

			}


			return result;

	}




		/**
		 * @return userpassword
		 */
		public String getUserpassword() {
			return userpassword;
		}




		/**
		 * @param userpassword セットする userpassword
		 */
		public void setUserpassword(String userpassword) {
			this.userpassword = userpassword;
		}


		/**
		 * @return msg
		 */
		public String getMsg() {
			return msg;
		}



		/**
		 * @param msg セットする msg
		 */
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getResignerrormsg() {
			return resignerrormsg;
		}



		/**
		 * @param msg セットする msg
		 */
		public void setResignerrormsg(String msg) {
			this.resignerrormsg = resignerrormsg;
		}


		/**
		 * @return sessionMap
		 */
		public Map<String, Object> getSessionMap() {
			return sessionMap;
		}




		/**
		 * @param sessionMap セットする sessionMap
		 */
		public void setSessionMap(Map<String, Object> sessionMap) {
			this.sessionMap = sessionMap;
		}




		@Override
		public void setSession(Map<String, Object> arg0) {
			this.sessionMap = sessionMap;

		}









}