<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="ユーザー情報" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h2 class="text-center">ユーザー情報</h2>

		<jsp:include page="../ErrorMsgFrame.jsp" />
		<jsp:include page="../SuccessMsgFrame.jsp" />

		<s:if test="#session.isLogin">
			<form action="UpdateUserNameAction" method="post">
				<table class="inputTable">
					<tr>
						<th colspan="3">ユーザー名変更</th>
					</tr>
					<tr>
						<th>新しいユーザー名</th>
						<td><input type="text" name="newUserName" value='<s:property value="#session.userName"/>' placeholder="新しいユーザー名" /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input type="submit" value="変更" class="mini_linkButton" /></td>
					</tr>
				</table>
			</form>
			<form action="UpdateUserPasswordAction" method="post">
					<table class="inputTable">
					<tr>
						<th colspan="2">パスワード変更</th>
					</tr>
					<tr>
						<th>現在のパスワード</th>
						<td><input type="password" placeholder="現在のパスワード" name=planePassword /></td>
					</tr>
					<tr>
						<th>新しいパスワード</th>
						<td><input type="password" placeholder="新しいパスワード" name="newPlanePassword" /></td>
					</tr>
					<tr>
						<th>新しいパスワード(確認)</th>
						<td><input type="password" placeholder="新しいパスワード(確認)" name="newPlanePasswordConfirm" /></td>
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
	</c:param>
</c:import>