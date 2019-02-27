<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="${ userDTO.userName }" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
	
		<h1><s:property value="userDTO.userName" /></h1>
		
		<table class="table">
			<tr>
				<th>
					ユーザー名
				</th>
				<td>
					<s:property value="userDTO.userName" />
				</td>
			</tr>
			<tr>
				<th>
					権限
				</th>
				<td>
					<s:if test="userDTO.admin">
						<span style="color: red">管理者</span>
					</s:if>
					<s:else>
						ユーザー
					</s:else>
				</td>
			</tr>
			<tr>
				<th>
					登録日
				</th>
				<td>
					<s:property value="%{ userDTO.registeredDateFormat }" />
				</td>
			</tr>
		</table>
		
	</c:param>
</c:import>