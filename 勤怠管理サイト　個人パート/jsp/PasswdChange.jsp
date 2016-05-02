<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM HomePage Builder 2001 V5.0.2 for Windows">
<TITLE>パスワードの変更と退会</TITLE>
</HEAD>
<BODY bgcolor="#f5f5f5">
		<div align="center"><h1>勤怠管理サイト</H1></div>
		<hr size="10" color="#66cdaa" noshade>
<br>
<div align="center"><h3><s:property value="#session.USERNAME"/>さん</h3></div>

<!------------ログイン画面-------------------->

<div align="right">
<s:form action ="Go2MenuAction" >
  <s:submit name="submit" value="メニュー画面へ"/>
</s:form>
</Div>
<hr size="10" color="#66cdaa" noshade>


<!------------ユーザー変更退会文字だけ------------>

<div align="center"><h2>ユーザーパスワードの変更と退会画面</h2>
</div>

<!------------パスワード変更 ModifyTimeAction文字だけ------------->
<table align="center" width="600">
<tr>

<td>
<b>【パスワードの変更を行う】</b>
<br>
・現在のパスワード、変更パスワードをそれぞれ入力してください


<!---------------新しいユーザーパスワードModifyTimeAction用のテーブル--------------->
</td>
<td>
</td>
</tr>
<tr>
<td>
</td>
<td>
<s:form action ="ChangePassWordAction" >

<s:password label="現在のパスワード" name="nowpassword"  placeholder="例）ikeda123" />


<br>


        <s:password label="変更パスワード" name="newpassword"  placeholder="例）ikeda123456"/>



        	<td>

        	   <font size=1 color=red>※再入力</font></td>

     <s:password label="変更パスワード" name="newpassword2" title="確認のため再度パスワードを入力してください"  placeholder="例）ikeda123456"/>



<s:submit name="submit" value="変更" align="left" />


			<Div Align="center">
				<font size="2" color="red"><s:property value="msg"/></font>

</Div>
</s:form>

</tr>
</td>


<br>
<br>
<!-- ------------------------------------退会用の文字だけ------------------------------------------------->
<tr>
<td>
<b>【退会を行う】</b>
<br>
・ユーザーのパスワードを入力してください
<br>
・パスワード入力後退会ボタンをクリックしてください
</td>
</td>
</td>
</tr>

<!-- ----------------------------------ResignActionテーブル------------------------------------------------- -->
<tr>
<td>
</td>
<td>
<div align="center">
<font size="2" color="red"><s:property value="resignerrormsg"/></font>
</div>
<s:form action ="ResignAction" >
<s:password label="ユーザーパスワード" name="userpassword"  placeholder="例）ikeda123" />
<s:submit name="submit" value="退会" />

</s:form>

</tr>
</td>


<br>
<br>
</table>
<hr size="10" color="#66cdaa" noshade>
 <div align="center">
Copyright 2014 INTERNOUS KINTAI CONTROL All Rights Reserved /
</div>
</BODY>
</HTML>
