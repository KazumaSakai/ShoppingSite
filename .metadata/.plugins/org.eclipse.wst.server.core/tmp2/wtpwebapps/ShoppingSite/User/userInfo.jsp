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
			
			<jsp:include page="../errorMsg.jsp" />
			<jsp:include page="../successMsg.jsp" />
			
			<s:if test="#session.isLogin">
				<form action="ChangeUserNameAction" method="post">
					<table class="inputTable">
						<tr>
							<th colspan="3">ユーザー名変更</th>
						</tr>
						<tr>
							<td>新しいユーザー名</td>
							<td><input type="text" name="newUserName" value='<s:property value="#session.user_name"/>' /></td>
						</tr>
						<tr>
							<td colspan="2" class="text-center"><input type="submit" value="変更" class="mini_linkButton" /></td>
						</tr>
					</table>
				</form>
				<form action="ChangeUserPasswordAction" method="post">
						<table class="inputTable">
						<tr>
							<th colspan="2">パスワード変更</th>
						</tr>
						<tr>
							<td>現在のパスワード</td>
							<td><input type="password" name="nowPassword" /></td>
						</tr>
						<tr>
							<td>新しいパスワード</td>
							<td><input type="password" name="newPassword" /></td>
						</tr>
						<tr>
							<td>確認</td>
							<td><input type="password" name="newPassword2" /></td>
						</tr>
						<tr>
							<td colspan="2" class="text-center"><input type="submit" value="変更" class="mini_linkButton" /></td>
						</tr>
					</table>
				</form>
			</s:if>
			<s:else>
				<p class="errorMessage text-center">
					ログインが必要です。
				</p>
			</s:else>
			
		</jsp:attribute>
	</jsp:param>
</jsp:include>