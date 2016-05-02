<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

p { margin-top: 0; margin-bottom: 0 }

</style>

<TITLE></TITLE>
</HEAD>
<BODY  bgcolor="#f5f5f5"whitesmoke topmargin="0" leftmargin="0" marginwidth="0" marginheight="0">

<br>
<br>
<center><h1><nobr>勤怠管理サイト</nobr></h1></center>
<center><hr size="10" color="#66cdaa" noshade><font size=5></FONT></center>


<TABLE border="0" width="100%" height="70%">
<tr>
<td
>
<table border="0" width="300" height="300" align="center" bgcolor="#66cdaa">
<TR>
<TD align="center">
 <h1>Login</h1>
   <p><font size="1" color="red">※ユーザー名、またはパスワードが違います※</font></p>
 <p><font size="1" color="red">※ユーザー名とパスワードを再度入力してください※</font></p>


    <s:form action ="LoginAction" >

    <br>
    <s:textfield label="ユーザー名" name="userID" placeholder="username"/>
    <s:password label="パスワード" name="password" placeholder="password" />
    <s:submit value="ログイン" align="center"></s:submit>

</s:form>

    <b>新規登録はこちら</b>
    <s:form action="Go2CreateUserAction">

   <s:submit type="submit" value="新規登録" align="left"/>
   </s:form>





</TD>
</TR>
</table>
</td>
</tr>

</TABLE>
<hr size="10" color="#66cdaa" noshade>
</HTML>

