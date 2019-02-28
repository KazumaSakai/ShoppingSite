<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="LoginAction" method="post">
	<table class="inputTable text-center">
		<tr>
			<th colspan="2">ログインフォーム</th>
		</tr>
		<tr>
			<th>
				ログインID
			</th>
			<td>
				<input class="inputText" type="text" name="loginId" placeholder="ログインID" required="required" maxLength="60" />
			</td>
		</tr>
		<tr>
			<th>
				パスワード
			</th>
			<td>
				<input class="inputText" type="password" name="planeLoginPassword" placeholder="パスワード" required="required" maxLength="60" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="loginButton" type="submit" value="ログイン" required="required" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="googleButton" type="button" value="Googleでログイン" onClick="location.href='<s:url action='StartGoogleOAuthAction?redirectURL=GoogleLoginAction.action'/>'" />
			</td>
		</tr>
	</table>
</form>
