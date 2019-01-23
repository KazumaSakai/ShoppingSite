<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="新規登録" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>新規登録</h1>
			<p class="errorMessage text-center">
				申し訳御座いません、登録に失敗致しました。<br />
				再度送信されるか、ユーザIDを変更してください。
			</p>
			<form id="LoginAction" name="SignUpAction" action="/ShoppingSite/SignUpAction.action" method="post" class="form">
				<table class="center">
					<tr>
						<td>ユーザーID</td>
						<td><input type="text" name="login_id" value=""/></td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><input type="email" name="email" /></td>
					</tr>
					<tr>
						<td>パスワードID</td>
						<td><input type="password" name="login_pass"/></td>
					</tr>
					<tr>
						<td>ユーザー名</td>
						<td><input type="text" name="user_name"/></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input type="submit" value="登録" style="padding: 3px 30px" /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><a href='<s:url action="StartGoogleOAuthAction?url=GoogleSignUpAction.action"/>'>Googleアカウントで登録する</a></td>
					</tr>
				</table>
			</form>
			<p class="text-center">
				ご登録されたパスワードは、PBKDF2にて暗号化され、管理されます。
			</p>
		</jsp:attribute>
	</jsp:param>
</jsp:include>