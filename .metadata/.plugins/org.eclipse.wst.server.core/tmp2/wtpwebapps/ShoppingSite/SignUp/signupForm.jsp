<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form action="SignUpAction">
	<table class="inputTable">
		<tr>
			<th colspan="2">新規登録フォーム</th>
		</tr>
		<tr>
			<td>ユーザーID</td>
			<td><input type="text" name="login_id" required="required"/></td>
		</tr>
		<tr>
			<td>ユーザー名</td>
			<td><input type="text" name="user_name" required="required"/></td>
		</tr>
		<tr>
			<td>パスワードID</td>
			<td><input type="password" name="login_pass" required="required"/></td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td><input type="email" name="email" required="required"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="signupButton" type="submit" value="登録" style="padding: 3px 30px" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="googleButton" type="button" value="Googleアカウントで登録する" onClick="location.href='<s:url action='StartGoogleOAuthAction?url=GoogleSignUpAction.action'/>'" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<p>
					ご登録されたパスワードは、PBKDF2にて暗号化され、管理されます。
				</p>
			</td>
		</tr>
	</table>
</form>