package jp.co.internous.action;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.internous.dao.MenutoMainDAO;
import jp.co.internous.dto.MenutoMainDTO;
import jp.co.internous.dto.YearMonthDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MenutoMainAction extends ActionSupport implements SessionAware{

	int year;
	int month;
	int date;
	int hour;
	int minute;
	int second;
	int maxDays;
	public String MM = null;
	public String ymd;
	public String ym;
	public String toDay;//今日の日付
	public String hms;
	public String strmonth;
	public String strdate;
	public String year_month;
	public String username;

	public Date attendance;
	public Date away;
	public List<MenutoMainDTO> itemList1 = new ArrayList<MenutoMainDTO>();
	public List<YearMonthDTO> itemList2 = new ArrayList<YearMonthDTO>();
	private String result = "SUCCESS";
	public boolean resultDAO;
	private Map<String, Object> sessionMap;

	public String execute() throws Exception{
		System.out.println("JSP側からの取得"+MM);

		String username = sessionMap.get("USERNAME").toString();

		Calendar cal=Calendar.getInstance();//ローカルタイムをインスタンス化

		year = cal.get(Calendar.YEAR);//method+get(static field)
		month = cal.get(Calendar.MONTH)+1;
		date = cal.get(Calendar.DATE);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
		second = cal.get(Calendar.SECOND);
		maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//その月の最大値を取得

		ym = year + "-" +month;//年月生成に必要
		System.out.println("MenutoMainAction - ym -"+ym);
		String strmon = String.valueOf(month);
		if(strmon.length() == 1){
			strmonth = 0+strmon;
		}
		else{
			strmonth = strmon;
		}

		String strdt = String.valueOf(date);
		if(strdt.length() == 1){
			strdate = 0+strdt;
		}
		else{
			strdate = strdt;
		}

		toDay = strmonth +"月"+ strdate+"日";
		System.out.println("MenutoMainAction - toDay - "+toDay);

//今月1日の日付の有無をチェック(ない場合 falseをリターン)
		MenutoMainDAO dao = new MenutoMainDAO();
		System.out.println("actionからselectにusernameと月日をおくる");
		ymd = year + "-" + month + "-" +1;
		boolean resultdao = dao.select(username,ymd);

//今月のデータがない場合、月の日付をDAOに送る
		if(resultdao == false){
		System.out.println("actionからtodayinsertに日付を送る");
		System.out.println("username=" + username + ":月日="+ymd);
		for(int i=1; i<=maxDays;i++){
		dao.todayInsert(username,ym,i);
		}//for
		}//if

//daoのitemListを持ってきてActionのitemList(1,2)に格納
		System.out.println("actionからselectfromに移動");
		System.out.println("username:"+username+":year:"+year+":month:"+month);


		year_month = "'%"+ year + "-" + 0 + month + "%'";

		if(MM != null){//jspから取得したMMに値が入っている場合year_monthに代入される
			String str= MM;
			String str1 = str.substring(0, 4);
			String str2 =str.substring(5,7);

			year_month ="'%" + str1 +"-"+ str2 + "%'";//MMのフォームを変換(oooo年oo月)→(oooo-oo)
			System.out.println("MenutoMainAction - year_month - "+ year_month);
		}//if
		dao.selectfrom(username,year_month,toDay);
		itemList1.addAll(dao.getItemList1());//日付、出勤、退勤時間のデータ
		System.out.println("itemlist1を取得");
		System.out.println("itemlist1を確認"+itemList1);

		dao.selectmonth(username);
		itemList2.addAll(dao.getItemList2());//年、月のデータ
		System.out.println("itemlist2を取得");
		System.out.println("itemlist2を確認"+itemList2);

		return result;

	}//select


	public String getMM(){
		return MM;
	}
	public void setMM(String mm){
		this.MM=mm;
	}

	public Map<String, Object> getSession() {
		return sessionMap;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}//class
