package jp.co.internous.action;

import java.util.Calendar;
import java.util.Map;

import jp.co.internous.dao.ByeByeTimeDAO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ByeByeTimeAction extends ActionSupport implements SessionAware{

		int year;
		int month;
		int date;
		int hour;
		int minute;
		int second;

		String username;
		String ymd;
		String hm;
		private String result ="SUCCESS";
		private Map<String, Object> sessionMap;


		public String execute() throws Exception{

			String username = sessionMap.get("USERNAME").toString();

			Calendar cal = Calendar.getInstance();
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			date = cal.get(Calendar.DATE);
			hour = cal.get(Calendar.HOUR_OF_DAY);
			minute = cal.get(Calendar.MINUTE);

			ymd = year+ "-" +month+"-"+date;
			hm = hour + ":" +minute;
			System.out.println("ByeByeTimeAction - ymd - "+ymd);
			System.out.println("ByeByeTimeAction - hm - "+hm);
			
			ByeByeTimeDAO dao = new ByeByeTimeDAO();
			System.out.println("ByeByeTimeAction - 中");

			boolean selectbol = dao.select(username,ymd);
			System.out.println("ByeTimeAction - ByeTimeDAOの戻り値 -"+ selectbol);

			if(selectbol){//trueだった場合はいる
				boolean bol = dao.update(username,ymd,hm);
				System.out.println("ByeByeTimeAction - DAOの戻り値 - " + bol);


				if(bol){
					result = "SUCCESS";
				}else{
					result = "SUCCESS";
				}//else

			}//if

			System.out.println("ByeByeTimeAction - result - " + result);
			return result;
		}//execute method

		public Map<String, Object> getSession() {
			return sessionMap;
		}

		public void setSession(Map<String, Object> sessionMap) {
			this.sessionMap = sessionMap;
		}

	}//class


