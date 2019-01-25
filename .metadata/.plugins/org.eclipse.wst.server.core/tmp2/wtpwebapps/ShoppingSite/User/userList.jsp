<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="ユーザーリスト" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>ユーザーリスト</h1>
			<table class="itemListTable">
				<tr>
					<th style="width: 100px">ID</th>
					<th style="width: 100px">ユーザー名</th>
					<th style="width: 100px">権限</th>
					<th style="width: 100px">登録日</th>
					<th style="width: 100px">削除</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td style="width:200px"><c:out value="${id}" /></td>
						<td style="width:200px"><c:out value="${user_name }" /></td>
						<td style="width:200px">
							<s:if test="admin == true">
								<span style="color:red">管理者</span>
							</s:if>
							<s:if test="admin != true">
								ユーザー
							</s:if>
						</td>
						<td style="width:200px"><c:out value="${insert_date}" /></td>
						<td>
							<s:if test="admin != true">
							 	<form class="text-center" action="AdminDeleteUserAction">
									<input type="hidden" name="id" value='<s:property value="id" />'>
									<input type="submit" value="削除" class="delete inputButton" style="padding: 2px 10px; font-size: 20px" />
							 	</form>
							</s:if>
						</td>
					</tr>
				</s:iterator>
			</table>
		</jsp:attribute>
	</jsp:param>
</jsp:include>