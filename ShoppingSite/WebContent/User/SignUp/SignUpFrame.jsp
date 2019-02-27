<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="SignUpAction" method="post">
	<table class="inputTable text-center">
		<tr>
			<th colspan="2">新規登録フォーム</th>
		</tr>
		<tr>
			<th>ログインID</th>
			<td>
				<input type="text" name="loginId" placeholder="ログインID" required="required" min="4" max="60" />
			</td>
		</tr>
		<tr>
			<th>ユーザー名</th>
			<td>
				<input type="text" name="userName" placeholder="ユーザー名" required="required" min="4" max="60" />
			</td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td>
				<input type="password" name="planeLoginPassword" placeholder="パスワード" required="required" min="8" max="60" />
			</td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td>
				<input type="email" name="email" placeholder="メールアドレス" required="required" max="255" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="loginButton" type="submit" value="登録" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="googleButton" type="button" value="Googleアカウントで登録する" onClick="location.href='<s:url action='StartGoogleOAuthAction?redirectURL=GoogleSignUpAction.action'/>'" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<p>ご登録されたパスワードは、PBKDF2にて暗号化され、管理されます。</p>
			</td>
		</tr>
	</table>
</form>