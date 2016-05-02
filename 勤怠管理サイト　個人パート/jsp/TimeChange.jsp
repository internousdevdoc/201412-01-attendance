<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

    <!DOCTYPE HTML>
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<SCRIPT>
<!--
// 数値のみを入力可能にする
function numOnly() {
  m = String.fromCharCode(event.keyCode);
  if("0123456789\b\r".indexOf(m, 0) < 0) return false;
  return true;
}
//-->
</SCRIPT>
<title>勤怠管理サイト</title>

</head>

<body bgcolor="#f5f5f5">

<h1>勤怠管理サイト</h1>
<hr size="10" color="#66cdaa">

 <h3>出・退勤時間変更画面</h3>
<hr size="10" color="#66cdaa">

   <s:form action="TCAction">
   <font size="2" color="red">
<s:iterator value="msgList" status="msgList">
<s:property value="m"/>
</s:iterator>
</font><br>
<table style="border: 1px solid #CCC;border-collapse: collapse;" width="600">
  <tr>
    <td style="padding:10px;border: 1px solid #CCC;background-color: #F4F8FF;font-weight: bold;padding: 5px;"><nobr>日付選択</nobr></td>
    <td style="padding:10px;border: 1px solid #CCC;background-color: #f4a460;font-weight: bold;padding: 5px;color: #f0ffff;"><nobr>出勤時間</nobr></td>
    <td style="padding:10px;border: 1px solid #CCC;background-color: #4169e1;font-weight: bold;padding: 5px;color: #f0ffff;"><nobr>退勤時間</nobr></td>
  </tr>
  <tr>

    <td style="padding:10px;border: 1px solid #CCC;background-color: #F9FCFE">
	<input type="hidden" name="mode" value="date"/>
	<input type="date" name="date" value='<s:property value="date"/>'><!-- 日付選択フォーム -->
    <td style="padding:10px;border: 1px solid #CCC;background-color: #F9FCFE"><s:property value="attendance"/></td><!-- 選択された日のattendanceの値を入れる -->
    <td style="padding:10px;border: 1px solid #CCC;background-color: #F9FCFE"><s:property value="away"/></td><!-- 選択された日のawayの値の値を入れる -->
  </tr>
 </table>
 <table  align="left"border="0" bordercolor="#CCC" bgcolor="#f5f5f5" width="600">

	<s:submit name="botan" value="選 択" style="WIDTH: 80px; HEIGHT: 23px;font-size:80%" align="left"/><!-- 選択ボタン -->
 </table>
  	</s:form>
<br>
<br><br>
<!-- ----------------------------------出勤・退勤変更------------------------------------- -->
<table  align="left"border="1" bordercolor="#CCC"bgcolor="#F9FCFE"width="600">
<tr>
<td>
<div align="center">【出勤時間変更】<br>
<br>
例)10:00の場合⇒"1000"<br>


<s:form action ="TCAction" >
				<input type="hidden" name="mode" value="atthm"/>
				<input type="hidden" name="date" value='<s:property value="date"/>'/>
				<s:textfield label="出勤時間" name="atthm" size="1" maxlength="4" onkeyDown="return numOnly()" /><br>
  				<s:submit name="submit" value="変更する" align="center"  />
			</s:form>

</div>
<br>
</td>
<!-- ---------------------------------------------------------------------------------------- -->
<td>
<div align="center">【退勤時間変更】<br>
<br>
例)20:30の場合⇒"2030"<br>

<s:form action ="TCAction" >
				<input type="hidden" name="mode" value="awhm"/>
				<input type="hidden" name="date" value='<s:property value="date"/>'/>
				<s:textfield label="退勤時間" name="awhm" size="1" maxlength="4" onkeyDown="return numOnly()" /><br>
  				<s:submit name="submit" value="変更する" align="center" />
			</s:form>

</div><br>
</td>
</table>
<!-- ------------------------------なんとなく改行----------------------------------- -->

<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<!-- -----------------------------------戻る---------------------------------------- -->

	<s:form action ="Go2MainAction" >
  				<s:submit name="submit" value="前のページに戻る" Align="right"/>
			</s:form>

<hr size="10" color="#66cdaa">
<div>
<ul>
<li><nobr>Copyright 2015 INTERNOUS KINTAI CONTROL All Rights Reserved / </nobr></li>
</ul>
</div>
</body>

</html>
