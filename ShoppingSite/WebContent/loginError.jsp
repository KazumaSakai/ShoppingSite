<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="ログインエラー" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>ログイン</h1>
			<p class="errorMessage text-center">
				ログインに失敗しました。<br />
				IDまたはパスワードが間違っています。
			</p>
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
						<td colspan="2" ><input type="submit" value="ログイン" id="LoginAction_0" style="padding: 3px 30px" /></td>
					</tr>
				</table>
			</form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>