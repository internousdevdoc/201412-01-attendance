/**
 *
 */
package jp.co.internous.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.internous.dao.TCDAO;
import jp.co.internous.dto.ErrorMsgDTO;
import jp.co.internous.dto.TCDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internous
 *
 */
public class TCAction extends ActionSupport implements SessionAware {
	// ------------------------------------------------------------------
	public String username = null;
	public String attymd = null;
	// 画面に表示された「【出勤時間変更】出勤時間の値」
	public String atthm = "";
	public String awymd = null;
	public String awhm = "";
	public String date = null;
	// 画面に表示された「出勤時間」の値
	public String attendance = null;
	// 画面に表示された「退勤時間」の値
	public String away = null;
	public String result = null;

	public String mode = null;
	String errormsg = null; // <s:propaty>によりメッセージを表示するため

	public List<TCDTO> itemList = new ArrayList<TCDTO>();
	public List<ErrorMsgDTO> msgList = new ArrayList<ErrorMsgDTO>();
	TCDTO dto = new TCDTO();
	ErrorMsgDTO errDto = new ErrorMsgDTO();
	public Map<String, Object> session;

	// DBの年月を取得するメソッド
	public String execute() throws Exception {
		System.out.println("★Actionの実行");
		String username = session.get("USERNAME").toString();

		System.out.println("入力日付：" + date);
		if (isFuture(date)) {
			addErrorMessage("未来日付が選択されました");
			// createErrorMessageList();
			return "error";
		}

		// TCDAOクラスをインスタンス化
		TCDAO dao = new TCDAO();
		System.out.println("TCDAO初回SELECTの実行");
		System.out.println("DATE:"+date);
		System.out.println("USERNAME:"+username);
		dto = dao.select(date, username);
		System.out.println("TCDAO初回SELECTの実行完了");
		if (dto.getErrormsg() != "") {
			errormsg = dto.getErrormsg();
		}

		// 日付選択
		System.out.println("日付選択");
		if (dto.getMMDD().equals("")) {
			addErrorMessage("日付のデータがありません");
			// createErrorMessageList();
			return "error";
		}
		// 出勤時間、退勤時間の取得
		System.out.println("出勤時間、退勤時間の取得");
		attendance = dto.getAttendance().substring(0, 5);
		away = dto.getAway().substring(0, 5);

		System.out.println("Actionで取得中の出勤の値=" + attendance);// jsp未実装のため、たぶん初期値が出る
		System.out.println("Actionで取得中の退勤の値=" + away);// jsp未実装のため、たぶん初期値が出る
		itemList.addAll(dao.getItemList());

		System.out.println("JSPに出力中の出勤の値=" + attendance);// jsp未実装のため、たぶん初期値が出る
		System.out.println("JSPに出力中の退勤の値=" + away);// jsp未実装のため、たぶん初期値が出る

		// ------------------------------------------------------------------------------------
		// 出勤変更ボタンが押された場合：
		if (atthm != null) {
			System.out.println("【出勤時間変更】処理を実行します。");
			System.out.println("ATTHM:" + atthm);
			System.out.println("ATTHMの長さ:" + atthm.length());
			Pattern p = Pattern.compile("^[0-9]*$");
			Matcher m = p.matcher(atthm);
			if (m.find() == false) {
				addErrorMessage("数値以外が入力されています");
			}
			username =session.get("USERNAME").toString();
//			username = "aaa";(テスト用)
			if (atthm.equals("")) {
			} else {
				if (isTime(atthm)) {
					System.out.println("更新DAO");
					dao.updateByAttendance(username, dto.getMMDD(), atthm);
				} else {
					addErrorMessage("時間を正しく入力してください");
				}
			}

			dto = dao.select(date, username);
			if (dto.getErrormsg() != "") {
				errormsg = dto.getErrormsg();
			}

			// 日付選択
			if (dto.getMMDD().equals("")) {
				addErrorMessage("日付の選択がされていません");
				// createErrorMessageList();
				return "error";
			}
			// 出勤時間、退勤時間の取得
			attendance = dto.getAttendance().substring(0, 5);
			atthm = "";

			System.out.println("Actionで取得中の出勤の値=" + attendance);// jsp未実装のため、たぶん初期値が出る
			itemList.addAll(dao.getItemList());

			System.out.println("JSPに出力中の出勤の値=" + attendance);// jsp未実装のため、たぶん初期値が出る

		} else {
			System.out.println("ELSE突入");
		}
		// ------------------------------------------------------------------------------------
		// 退勤変更ボタンが押された場合：
		if (awhm != null) {
			System.out.println("【退勤時間変更】処理を実行します。");
			System.out.println("AWHM:" + awhm);
			System.out.println("AWHMの長さ:" + awhm.length());
			Pattern p = Pattern.compile("^[0-9]*$");
			Matcher m = p.matcher(awhm);
			if (m.find() == false) {
				addErrorMessage("数値以外が入力されています");
			}
			if (awhm.equals("")) {
			} else {
				if(isTime(awhm)){
				System.out.println("DAOメソッドに入ります。");
				dao.updateByAway(username, dto.getMMDD(), awhm);
				}else{
					addErrorMessage("時間を正しく入力してください");
				}
			}

			System.out.println("エラー発生中？");
			dto = dao.select(date, username);
			System.out.println("すすんだ？");

			if (dto.getErrormsg() != "") {
				System.out.println(1);
				errormsg = dto.getErrormsg();
			}

			// 日付選択
			if (dto.getMMDD().equals("")) {
				System.out.println(2);
				addErrorMessage("日付の選択がされていません");
				return "error";
			}
			// 出勤時間、退勤時間の取得
			System.out.println(3);
			away = dto.getAway().substring(0, 5);
			awhm = "";

			System.out.println("Actionで取得中の退勤の値=" + away);// jsp未実装のため、たぶん初期値が出る
			itemList.addAll(dao.getItemList());

			System.out.println("JSPに出力中の退勤の値=" + away);// jsp未実装のため、たぶん初期値が出る

		}

		// ---------------------------------------------------------------------------------------
		System.out.println("ATTENDANCE" + attendance);
		System.out.println("AWAY" + away);
		System.out.println("ATTHM" + atthm);

		switch (mode) {
		case "date":
			System.out.println("選択ボタンが押されました");
			break;
		case "atthm":
			System.out.println("出勤変更ボタンが押されました");
			System.out.println("DATE:" + date);
			System.out.println("ATTHM:" + atthm);
			System.out.println("AWHM:" + awhm);
			if (date != "" && atthm.equals("") && awhm.equals("")) {
				System.out.println("OK");
			}
			break;

		case "awhm":
			System.out.println("退勤変更ボタンが押されました");
			if (awhm != null && awhm != null) {
				//
			} else {
				addErrorMessage("退勤時間の入力情報がありません");
			}
			break;
		default:
			break;
		}

		result = "error";
		return result;

	}// executeメソッド
	private boolean isTime(String t) {
		if(t.equals("")){
			System.out.println("isTime:値なし");
			return false;
		}
		System.out.println("isTimeメソッドの中[値："+t+"]");
		String HH = t.substring(0, 2);
		System.out.println("isTimeメソッドの中[値HH："+HH+"]");
		String mm = t.substring(2);
		System.out.println("isTimeメソッドの中[値MM："+mm+"]");
		String ss = "00";
		String column = ":";
		String time = HH + column + mm + column + ss;
		System.out.println("isTimeメソッドの中[値time："+time+"]");

		System.out.println("isTimeメソッドの判定開始");
		if (time.compareTo("00:00:00") >= 0 && time.compareTo("23:59:59") <= 0) {
			System.out.println("isTimeメソッドの判定終了：TRUE");
			return true;
		} else {
			System.out.println("isTimeメソッドをでます");
			System.out.println("isTimeメソッドの判定終了：FALSE");
			return false;
		}
	}

	public boolean isFuture(String date) {
		System.out.println("isFutureメソッドの中");
		if(date.equals("")){
			System.out.println("DATEの中身が空なので終了します\nisFutureメソッドをでます");
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("SDFを宣言したよ");
		Date s = null;
		try {
			s = sdf.parse(date);
			System.out.println("日付をparseしたよ");
			System.out.println("入力日付:" + s.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date d = new Date();
		System.out.println("比較日付:" + d.toString());

		int diff = d.compareTo(s);
		if (diff < 0) {
			System.out.println("比較日付は入力日付より未来。");
			return true;
		}
		System.out.println("isFutureメソッドをでます");
		return false;
	}

	public void addErrorMessage(String errmsg) {
		if (errormsg != "") {
			errDto.setM(errmsg);
			msgList.add(errDto);
			System.out.println("エラーメッセージ：" + errmsg);
		} else {
			errormsg = errmsg;
			System.out.println("エラーメッセージ：" + errmsg);

		}
	}

	public void createErrorMessageList() {
		String[] s = errormsg.split(",");
		String src = "";
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("null")) {

			} else {
				src = src + s[i] + ",";
				System.out.println(src);
			}

			s = src.split(",");
			for (int j = 0; j < s.length; j++) {
				if (s[j].equals("null")) {
					System.out.println("DTOに値は入らない");
				} else {
					System.out.println("DTOに値が入る");
					errDto.setM(s[j]);

				}
				System.out.println("s[" + j + "]:" + s[j]);

			}
			msgList.add(errDto);
			System.out.println("エラーメッセージは" + msgList.size() + "件");
		}
	}

	public String createErrorMsg(String msg) {
		if (errormsg != null) {
			System.out.println(errormsg);
			msg = errormsg + "\n" + msg;
		} else {
			System.out.println(msg);
			msg = "";
		}
		errormsg = msg;
		return msg;
	}

	/**
	 * @return mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode
	 *            セットする mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return attymd
	 */
	public String getAttymd() {
		return attymd;
	}

	/**
	 * @param attymd
	 *            セットする attymd
	 */
	public void setAttymd(String attymd) {
		this.attymd = attymd;

	}

	/**
	 * @return atthm
	 */
	public String getAtthm() {
		return atthm;
	}

	/**
	 * @param atthm
	 *            セットする atthm
	 */
	public void setAtthm(String atthm) {
		this.atthm = atthm;
	}

	/**
	 * @return awymd
	 */
	public String getAwymd() {
		return awymd;
	}

	/**
	 * @param awymd
	 *            セットする awymd
	 */
	public void setAwymd(String awymd) {
		this.awymd = awymd;
	}

	/**
	 * @return awhm
	 */
	public String getAwhm() {
		return awhm;
	}

	/**
	 * @param awhm
	 *            セットする awhm
	 */
	public void setAwhm(String awhm) {
		this.awhm = awhm;
	}

	/**
	 * @return itemList
	 */
	public List<TCDTO> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList
	 *            セットする itemList
	 */
	public void setItemList(List<TCDTO> itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return msgList
	 */
	public List<ErrorMsgDTO> getMsgList() {
		return msgList;
	}

	/**
	 * @param msgList
	 *            セットする msgList
	 */
	public void setMsgList(List<ErrorMsgDTO> msgList) {
		this.msgList = msgList;
	}

	/**
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            セットする date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return attendance
	 */
	public String getAttendance() {
		return attendance;
	}

	/**
	 * @param attendance
	 *            セットする attendance
	 */
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	/**
	 * @return away
	 */
	public String getAway() {
		return away;
	}

	/**
	 * @param away
	 *            セットする away
	 */
	public void setAway(String away) {
		this.away = away;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return errormsg
	 */
	public String getErrormsg() {
		return errormsg;
	}

	/**
	 * @param errormsg
	 *            セットする errormsg
	 */
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

}// class
