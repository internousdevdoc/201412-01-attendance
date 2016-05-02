package jp.co.internous.dto;


/**
 * クラス名：LoginDTO
 * クラスの説明：データベース検索結果格納用のDTOクラス
 */
public class LoginDTO {

	//LoginDTO用の変数
	private static String userID;
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

	private static String password;
//	private static String userNameik;

	//LoginDAOクラスから呼び出されるメソッド、userIDの値を返却する
	public  String setUserID(String userID) {
		System.out.println("★LoginDTOのsetUserIDメソッド実行");
		return LoginDTO.userID = userID;
	}

	//LoginDAOクラスから呼び出されるメソッド、passwordの値を返却する
	public  String setPassword(String password) {
		System.out.println("★LoginDTOのsetPasswordメソッド実行");
		return LoginDTO.password = password;
	}
	//LoginDAOクラスから呼び出されるメソッド、userNameの値を返却する
//		public  String setUserName(String userName) {
//			System.out.println("★LoginDTOのsetUserNameメソッド実行");
//			return LoginDTO.userNameik = userName;
//		}

}