<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<TITLE></TITLE>

</HEAD>
<BODY topmargin="0" leftmargin="0" marginwidth="0" marginheight="0" bgcolor="#f5f5f5"whitesmoke>
<center><br>
<br>
<center><h1>勤怠管理サイト</h1>
<center><hr size="10" color="#66cdaa" noshade><font size=5></FONT>

<TABLE border="0" width="100%" height="70%" color="#66cdaa">

<tr>
<td
>
<table border="0" width="300" height="300" align="center" bgcolor="#66cdaa">


<TR>
<TD align="center">
<h1><font face="Myriad Web Pro">Login</font></h1>
 <s:form action ="LoginAction" >



   <p><font size="1" color="dimgray">※ユーザー名とパスワードは半角英数字で入力してください※</font></p>
    <br>
    <s:textfield label="ユーザー名" name="userID" placeholder="username"/>
    <s:password label="パスワード" name="password" placeholder="password" />
    <s:submit value="ログイン" align="center"></s:submit>

</s:form>

    <b>新規登録はこちら</b>
    <s:form action="Go2CreateUserAction">

   <s:submit type="submit" value="新規登録"/>
   </s:form>


</div>

</TD>
</TR>
</table>

</tr>
</td>
</body>
</TABLE>
<hr size="10" color="#66cdaa" noshade>
</HTML>