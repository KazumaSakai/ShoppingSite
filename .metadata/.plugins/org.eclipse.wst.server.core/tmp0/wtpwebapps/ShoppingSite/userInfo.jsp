<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="ユーザー情報" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h2 class="text-center">ユーザー情報</h2>
			<s:if test="session.isLogin == true">
				<table class="table center">
					<tr>
						<form action="ChangeUserNameAction">
							<td>ユーザー名</td>
							<td><input type="text" name="newUserName" style="padding: 2px 10px" value='<c:out value="${session.user_name }"/>' /></td>
							<td><input type="submit" value="変更" style="padding: 0px 10px"/></td>
						</form>
					</tr>
					<tr>
						<form action="ChangeUserPasswordAction">
							<td>パスワード</td>
							<td><input type="password" name="newPassword" style="padding: 2px 10px"/><input type="hidden" /></td>
							<td><input type="submit" value="変更" style="padding: 0px 10px"/></td>
						</form>
					</tr>
				</table>
			</s:if>
			<s:if test="session == null || session.isLogin != true">
				<p class="errorMessage text-center">
					ログインが必要です。
				</p>
			</s:if>
			
		</jsp:attribute>
	</jsp:param>
</jsp:include>