package jp.co.internous.action;

import java.util.Map;

import jp.co.internous.dao.ChangePassWordDAO;
import jp.co.internous.dto.ChangePassWordDTO;
import jp.co.internous.dto.LoginDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * クラス名:ChangePassWordActionDAO
 *クラスの説明:データベース接続用のDAOクラス
 */

public class ChangePassWordAction extends ActionSupport implements SessionAware{

		//nowpassの格納
		private String nowpassword;
		private String newpassword;
		private String newpassword2;
		private String newpassword_go;



		//DAOに送る用
		private String msg =null;


		//<s:propaty>によりメッセージを出せるように
		private Map<String,Object> sessionMap;
		private String result;

		//LoginActionクラスから渡された引数を元にselectメソッドを実行
		public String execute() throws Exception{

			System.out.println("ChangePasswdAction実行");

			System.out.println("入力された現在のパスワード"+nowpassword);
			System.out.println("入力された新しいパスワード"+newpassword);
			System.out.println("入力された新しいパスワード"+newpassword2);

			//resultの初期値をerrorに
			result =ERROR;

			//ログイン中のパスワードと入力されたパスワードが合っているか判定
			if(nowpassword.equals(LoginDTO.getPassword())){

				//newpassとnewpass2があっているかどうか
				if(newpassword.equals(newpassword2)){
				 newpassword_go=newpassword;

				 	//ChangePasswdDAOをインスタンス化する
					ChangePassWordDAO dao=new ChangePassWordDAO();
					//chpw.execute(newpassword)によりtrueかfalseが返ってくるか
					boolean resultDAO = dao.update(nowpassword, newpassword_go);
					sessionMap.put("USERPASSWD",newpassword_go);
				 	//ChangePasswdDTOをインスタンス化する
					ChangePassWordDTO dto=new ChangePassWordDTO();
					dto.setPassword(newpassword_go);
					if(resultDAO){
						msg="パスワードを変更しました";
						result=SUCCESS;
					}
				System.out.println("★struts.xmlに返却する値を確認 = " + result);

				}else{
					msg="パスワード入力に誤りがあります。";
					}
			}else{
				msg="現在のパスワード入力が違います。";

			return result;
			}
			return result;
		}

		public String getNowpassword(){
		return nowpassword;
		}

		public void setNowpassword(String nowpassword) {
			this.nowpassword = nowpassword;
		}
		public String getNewpassword() {
			return newpassword;
		}
		public void setNewpassword(String newpassword) {
			this.newpassword = newpassword;
		}
		public String getNewpassword2() {
			return newpassword2;
		}
		public void setNewpassword2(String newpassword2) {
			this.newpassword2 = newpassword2;
		}
		public String getNewpassword_go() {
			return newpassword_go;
		}
		public void setNewpassword_go(String newpassword_go) {
			this.newpassword_go = newpassword_go;
		}
		public Map<String, Object> getSession() {
			return sessionMap;
		}
		public void setSession(Map<String, Object> sessionMap) {
			this.sessionMap = sessionMap;
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



}
