<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form id="LoginAction" name="LoginAction" action="/ShoppingSite/LoginAction.action" method="post" class="form">
	<table class="center">
		<tr>
			<td>ユーザーID</td>
			<td><input type="text" name="login_user_id" value="" id="LoginAction_login_user_id"/></td>
		</tr>
		<tr>
			<td>パスワードID</td>
			<td><input type="password" name="login_pass" id="LoginAction_login_pass"/></td>
		</tr>
		<tr>
			<td colspan="2" class="text-center"><input type="submit" value="ログイン" id="LoginAction_0" style="padding: 3px 30px" /></td>
		</tr>
		<tr>
			<td colspan="2" class="text-center"><a href='<s:url action="StartGoogleOAuthAction?url=GoogleOauthAction.action"/>'>Googleでログイン</a></td>
		</tr>
	</table>
</form>