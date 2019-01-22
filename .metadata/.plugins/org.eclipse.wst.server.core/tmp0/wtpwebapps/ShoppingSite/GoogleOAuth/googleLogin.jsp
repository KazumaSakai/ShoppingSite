<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="Googleアカウントでログイン" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>Googleアカウントでログイン</h1>
			<form id="EmailLoginAction" action="/ShoppingSite/EmailLoginAction.action" method="post" class="form">
				<input type="hidden" name="email" value='<c:out value="${email}" />' />
				<table class="center table">
					<tr>
						<td>パスワードID</td>
						<td><input type="password" name="login_pass"/></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input type="submit" value="ログイン" style="padding: 3px 30px" /></td>
					</tr>
				</table>
			</form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>
