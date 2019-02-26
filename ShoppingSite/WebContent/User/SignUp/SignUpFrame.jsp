<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="SignUpAction" method="post">
	<table class="inputTable">
		<tr>
			<th colspan="2">新規登録フォーム</th>
		</tr>
		<tr>
			<td>ログインID</td>
			<td>
				<input type="text" name="loginId" placeholder="ログインID" required="required" min="4" max="60" />
			</td>
		</tr>
		<tr>
			<td>ユーザー名</td>
			<td>
				<input type="text" name="userName" placeholder="ユーザー名" required="required" min="4" max="60" />
			</td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td>
				<input type="password" name="planeLoginPassword" placeholder="パスワード" required="required" min="8" max="60" />
			</td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td>
				<input type="email" name="email" placeholder="メールアドレス" required="required" max="255" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="loginButton" type="submit" value="登録" style="padding: 3px 30px" />
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