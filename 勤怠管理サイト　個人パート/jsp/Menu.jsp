<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM HomePage Builder 2001 V5.0.2 for Windows">
<TITLE>Menu</TITLE>
</HEAD>
<BODY bgcolor="#f5f5f5">
<div align="center"><h1>勤怠管理サイト</h1></div>
<hr size="10" color="#66cdaa" noshade>
 <div align="center">
 <s:if test="{#session.USERNAME.length() !=0}">
  <font size=3><B><s:property value="#session.USERNAME"/>さんようこそ</B></FONT>
</s:if>
  </div>
<P><div align="right">
<s:form action ="LogoutAction" >
<s:submit type="submit" value="ログイン画面へ"/>

</s:form></div>

<hr size="10" color="#66cdaa" noshade>
<br>
<br>
<br>
<br>
<br>
<br>
<table border="0" align="center">
  <TBODY>
    <TR>
      <th>
      <td>
      <s:form action="MenutoMainAction"><s:submit type="submit" value="出勤、退勤を行う" class="css3button">
  			   <s:hidden name="sessionname" value="%{#session.USERNAME}"/>
            </s:submit></s:form>
<br>
<br></TD></TR>

    <TR>
      <th>
      <TD>
     <s:form action="Go2PasswdChangeAction"><s:submit type="submit" value="ユーザーパスワードの変更、退会" class="css3button"></s:submit></s:form>
      <br>
<br>
<br>
<br>
<br>
<br>
<br>
</TD></TR>
  </TBODY></TABLE>
<hr size="10" color="#66cdaa" noshade>
 <div align="center">
<FONT size="3">Copyright 2015 INTERNOUS KINTAI CONTROL All
  Rights Reserved /</FONT>
</div>
</BODY></HTML>