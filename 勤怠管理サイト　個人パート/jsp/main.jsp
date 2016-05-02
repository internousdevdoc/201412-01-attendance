<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メイン画面</title>
<script>
	<!--
		var toDoubleDigits = function(num) {
		  num += "";
		  if (num.length === 1) {
		    num = "0" + num;
		  }
		 return num;
		};

		function myFunc(){
		var d = new Date();
		var year = d.getFullYear();
		var month = d.getMonth()+1;
		var date = d.getDate();

		var hour = toDoubleDigits(d.getHours());
		var minutes = toDoubleDigits(d.getMinutes());
		var seconds = toDoubleDigits(d.getSeconds());
		var today = year+"/"+month+"/"+date;
		var hms = "時間: "+hour+":"+minutes+":"+seconds;

		document.myForm.hms.value = hms;
	}
	-->
	</script>
</head>


<body bgcolor="#f5f5f5"  onload="setInterval('myFunc()',1000);">

<h1>出退勤管理画面</h1>
<hr size="10" color="#66cdaa" Width="100%">
<table style="border:4px solid #f5f5f5f; border-collapse:collapse;width:1000;"  align="left">
	<tr>
	<td>
		<form name="myForm">
		<input type="text" style="border:none;font-size:50px;color:gray; background-color:#f5f5f5;"name="hms">
		</form>
	</td>
	</tr>
		<tr>
	<td style="font-size:1.5em;">
		ようこそ○○さん
	</td>
	</tr>
</table>
<br clear="left">
<!-- --------------------------------------------------------------------------------------- -->
<table width=1495>
<tr>
<td height=40; align="center" style="vertical-align:middle;background-color:#66cdaa;">
<form action="MenutoMainAction">
	<select name="MM" style="width:150px; font-size:1.4em; backgtound-color:#fffafa;">
	<option>年月選択</option>
		<s:iterator value="itemList2" status="itemList2">
		<option><s:property value="MM"/></option>
		</s:iterator>
	</select>
	<input type="submit" value="変更" style="background-color:#fff8dc; color:gray; border-color:white; text-align:center; vertical-align:middle; font-size:1.4em;"/>
</form>
</td>
<td align="center" style="background-color:#66cdaa; font-size:1.5em; color:#fffafa">
出勤時間
</td>
<td align="center" style="background-color:#66cdaa; font-size:1.5em; color:#fffafa">
退勤時間
</td>
<td height=30; align="right" style="background-color:#66cdaa;">
<s:form action="LogoutAction" style="margin:0px; float:right;">
<s:submit type="submit" value="ログアウト" style="background-color:#fff8dc; color:gray; border-color:white; border-style:; text-align:center; vertical-align:middle; font-size:1.2em;"/>
</s:form>
<s:form action="Go2MenuAction" style="margin:0px; float:right;">
<s:submit type="submit" value="メニューに戻る" style="background-color:#fff8dc; color:gray; border-color:white; border-style:; text-align:center; vertical-align:middle; font-size:1.2em;"/>
</s:form>
<s:form action="TimeChangeAction" style="margin:0px; float:right;">
<s:submit type="submit" value="時間変更" style="background-color:#fff8dc; color:gray; border-color:white; border-style:; text-align:center; vertical-align:middle; font-size:1.2em;"/>
</s:form>
</td>
</tr>
	<s:iterator value="itemList1" status="itemList1">
	<tr>
		<td width=300; height=30; align="center" style='background-color:white; color:gray;  vertical-align:middle; font-size:1.3em'>
		<s:property value="MMDD"/>
		</td>
		<td width=300; align="center" style='background-color:white; color:gray; vertical-align:middle; font-size:1.3em'>
			<s:if test="%{DBattendance != '00:00'}">
				<s:property value="DBattendance"/>
			</s:if>
			<s:elseif test="%{DBattendance == '00:00' && MMDD == toDay}">
				<s:form action="AttendanceAction" style="margin:0px; float:center;">
				<s:submit type="submit" value="出勤" style="background-color:#f4a460;  color:white; border-color:#f4a460; text-align:center; font-size:1.2em;" />
				</s:form>
			</s:elseif>
			<s:else>
			--:--
			</s:else>
		</td>
		<td width=300; align="center" style='background-color:white; color:gray; vertical-align:middle;font-size:1.3em'>
			<s:if test="%{DBaway != '00:00'}">
				<s:property value="DBaway"/>
			</s:if>
			<s:elseif test="%{DBaway == '00:00' && MMDD == toDay}">
				<s:form action="ByeByeTimeAction">
				<s:submit type="submit" value="退勤" style="background-color:#4169e1;  color:white; border-color:#4169e1; text-align:center; font-size:1.2em;" />
				</s:form>
			</s:elseif>
			<s:else>
			--:--
			</s:else>
		</td>
		<td style="background-color:white;">
		</td>
	</tr>
	</s:iterator>
</table>

<hr size="10" color="#66cdaa" Width="100%">

<div>
<ul>
<li>Copyright 2015 INTERNOUS KINTAI CONTROL All Rights Reserved / </li>
</ul>
</div>

</body>
</html>