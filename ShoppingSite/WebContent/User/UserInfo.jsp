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

			<jsp:include page="../ErrorMsgFrame.jsp" />
			<jsp:include page="../SuccessMsgFrame.jsp" />

			<s:if test="#session.isLogin">
				<form action="UpdateUserNameAction" method="post">
					<table class="inputTable">
						<tr>
							<th colspan="3">ユーザー名変更</th>
						</tr>
						<tr>
							<td>新しいユーザー名</td>
							<td><input type="text" name="newUserName" value='<s:property value="#session.userName"/>' /></td>
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
							<td>現在のパスワード</td>
							<td><input type="password" placeholder="現在のパスワード" name=planePassword /></td>
						</tr>
						<tr>
							<td>新しいパスワード</td>
							<td><input type="password" placeholder="新しいパスワード" name="newPlanePassword" /></td>
						</tr>
						<tr>
							<td>新しいパスワード(確認)</td>
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

		</jsp:attribute>
	</jsp:param>
</jsp:include>