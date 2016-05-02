/**
 *
 */
package jp.co.internous.dto;

/**
 * @author internous
 *
 */
public class TCDTO {
	String MMDD, attendance, away;
	String errormsg;

	/**
	 * @return mMDD
	 */
	public String getMMDD() {
		return MMDD;
	}

	/**
	 * @param mMDD セットする mMDD
	 */
	public void setMMDD(String mMDD) {
		MMDD = mMDD;
	}

	/**
	 * @return attendance
	 */
	public String getAttendance() {
		return attendance;
	}

	/**
	 * @param attendance セットする attendance
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
	 * @param away セットする away
	 */
	public void setAway(String away) {
		this.away = away;
	}

	/**
	 * @return errormsg
	 */
	public String getErrormsg() {
		return errormsg;
	}

	/**
	 * @param errormsg セットする errormsg
	 */
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}



}
