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
			<table class="table">
				<tr>
					<th style="width: 100px">ID</th>
					<th style="width: 100px">ユーザー名</th>
					<th style="width: 100px">権限</th>
					<th style="width: 100px">登録日</th>
					<th style="width: 100px">削除</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td style="width: 200px"><s:property value="id" /></td>
						<td style="width: 200px"><s:property value="user_name" /></td>
						<td style="width: 200px">
							<s:if test="admin">
								<span style="color: red">管理者</span>
							</s:if>
							<s:else>
								ユーザー
							</s:else>
						</td>
						<td style="width: 200px"><s:property value="insert_date" /></td>
						<td>
							<s:if test="!admin">
								<a class="delete" href="<s:url action='AdminDeleteUserAction?id=%{ id }'/>">削除</a>
							</s:if>
						</td>
					</tr>
				</s:iterator>
			</table>
		</jsp:attribute>
	</jsp:param>
</jsp:include>