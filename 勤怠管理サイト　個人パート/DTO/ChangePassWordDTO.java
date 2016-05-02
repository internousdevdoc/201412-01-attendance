package jp.co.internous.dto;

public class ChangePassWordDTO {


	public  String getPassword() {
		return LoginDTO.getPassword();
	}


	//ChangePassWordDTOクラスから呼び出されるメソッド、passwordの値を返却する
	public  void setPassword(String password) {
		System.out.println("★ChangePassWordDTOのsetPasswordメソッド実行");
		LoginDTO.setPassword(password);
	}

}
