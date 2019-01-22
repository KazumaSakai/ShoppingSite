<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="Googleアカウントで登録" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>Googleアカウントで登録</h1>
			<form name="EmailSignUpAction" action="/ShoppingSite/EmailSignUpAction.action" method="post" class="form">
				<input type="hidden" name="email" value='<c:out value="${email}" />' />
				<table class="center">
					<tr>
						<td>パスワードID</td>
						<td><input type="password" name="login_pass"/></td>
					</tr>
					<tr>
						<td>ユーザー名</td>
						<td><input type="text" name="user_name"/></td>
					</tr>
					<tr>
						<td colspan="2" ><input type="submit" value="登録" style="padding: 3px 30px" /></td>
					</tr>
				</table>
			</form>
			<p class="text-center">
				ご登録されたパスワードは、PBKDF2にて暗号化され、管理されます。
			</p>
		</jsp:attribute>
	</jsp:param>
</jsp:include>