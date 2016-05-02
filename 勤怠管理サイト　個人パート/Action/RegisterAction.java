package jp.co.internous.action;
import jp.co.internous.dao.RegisterCreateAttendance_UserNameTableDAO;
import jp.co.internous.dao.RegisterDAO;

import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport{

	private String successmsg;
	private String errormsg5;
	private String result;
	private String username;
	private String password1;
	private String password2;
	private String errormsg6;
	boolean resultDAO;
	boolean resultDAO2;




	public String execute()throws Exception{


		System.out.println("★NewloginAction実行");
		//resultの初期値をerrorに設定
		result="error";


		System.out.println("★入力されたNewusername:"+username);
		System.out.println("★入力されたNewpassword:"+password1);
		System.out.println("★入力されたNewpassword2:"+password2);

            if(username.isEmpty()){
            	errormsg5="usernameを入力してください。";
            }
/*            if(password1.isEmpty()){

            	errormsg6="passwordを入力してください。";
            }

			if(password1.equals(password2)){
        //NewloginActionDAOをインスタンス化
		RegisterDAO dao = new RegisterDAO();
		//NewloginActionDAOのselectメソッドにnewusername,newpasswordを渡して実行
		//return値をboolean型のresultDAOに格納
		boolean resultDAO =  dao.select(username,password1);

		if(resultDAO){
			result = "success";
			successmsg="登録成功できました。";
		}//if result


			}//if pass
*/
            if(!password1.isEmpty()){



			if(password1.equals(password2)){

				//NewloginActionDAOをインスタンス化
				RegisterDAO dao = new RegisterDAO();
				//NewloginActionDAOのselectメソッドにnewusername,newpasswordを渡して実行
				//return値をboolean型のresultDAOに格納
				resultDAO =  dao.select(username,password1);

				//RegisterCreateAttendance_UserNameTableDAOをインスタンス化
				RegisterCreateAttendance_UserNameTableDAO dao2
				= new RegisterCreateAttendance_UserNameTableDAO();
				//RegisterCreateAttendance_UserNameTableDAOのcreatetableメソッドにnewusernameを渡して実行
				//return値をboolean型のresultDAOに格納
				resultDAO2 =  dao2.createtable(username);

			}//if pass

            }//if emp
            else{
            	errormsg6="passwordを入力してください。";
            }

		if(resultDAO && resultDAO2){
			result = "success";
			successmsg="登録成功できました。";
		}//if result




		System.out.println("★struts.xmlに返却する値を確認 = " + result);
		return result;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getErrormsg5() {
		return errormsg5;
	}

	public void setErrormsg5(String successmsg) {
		this.errormsg5 = successmsg;
	}
	public String getSuccessmsg() {
		return successmsg;
	}
	public void setSuccessmsg(String successmsg) {
		this.successmsg = successmsg;
	}
	public String getErrormsg6() {
		return errormsg6;
	}

	public void setErrormsg6(String errormsg6) {
		this.errormsg6= errormsg6;
	}


    }
