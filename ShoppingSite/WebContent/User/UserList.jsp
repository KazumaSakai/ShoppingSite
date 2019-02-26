<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="ユーザーリスト" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>ユーザーリスト</h1>
			<table class="table text-center">
				<tr>
					<th>ID</th>
					<th>ユーザー名</th>
					<th>権限</th>
					<th>登録日</th>
					<th>削除</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="userName" /></td>
						<td>
							<s:if test="admin">
								<span style="color: red">管理者</span>
							</s:if>
							<s:else>
								ユーザー
							</s:else>
						</td>
						<td><s:property value="%{ registeredDateFormat }" /></td>
						<td>
							<s:if test="!admin">
								<a class="delete" href="<s:url action='AdminDeleteUserAction?userId=%{ id }'/>">削除</a>
							</s:if>
						</td>
					</tr>
				</s:iterator>
			</table>
		</jsp:attribute>
	</jsp:param>
</jsp:include>