<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form action="LoginAction" >
	<table class="inputTable">
		<tr>
			<th colspan="2">ログインフォーム</th>
		</tr>
		<tr>
			<td>ユーザーID</td>
			<td><input class="inputText" type="text" name="login_user_id" required="required"/></td>
		</tr>
		<tr>
			<td>パスワードID</td>
			<td><input class="inputText" type="password" name="login_pass" required="required"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="loginButton" type="submit" value="ログイン" required="required" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="googleButton" type="button" value="Googleでログイン" onClick="location.href='<s:url action='StartGoogleOAuthAction?url=GoogleLoginAction.action'/>'" />
			</td>
		</tr>
	</table>
</form>