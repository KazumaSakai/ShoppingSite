<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="ユーザー情報" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="false" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h2 class="text-center">ユーザー情報</h2>
			<s:if test="#confirmChangeUserName">
				<div style="text-align: center">
					正常にユーザー名が変更されました。
				</div>
			</s:if>
			<s:if test="#session.isLogin">
				<table class="inputTable">
					<tr>
						<form action="ChangeUserNameAction">
							<td>ユーザー名</td>
							<td><input type="text" name="newUserName" value='<s:property value="#session.user_name"/>' /></td>
							<td><input type="submit" value="変更" class="mini_linkButton" /></td>
						</form>
					</tr>
					<tr>
						<form action="ChangeUserPasswordAction">
							<td>パスワード</td>
							<td><input type="password" name="newPassword" /></td>
							<td><input type="submit" value="変更" class="mini_linkButton" /></td>
						</form>
					</tr>
				</table>
			</s:if>
			<s:else>
				<p class="errorMessage text-center">
					ログインが必要です。
				</p>
			</s:else>
			
		</jsp:attribute>
	</jsp:param>
</jsp:include>