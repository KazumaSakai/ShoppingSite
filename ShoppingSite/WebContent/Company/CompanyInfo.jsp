<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="${ companyDTO.companyName }" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>
			<s:property value="companyDTO.companyName" />
		</h1>
		<table class="center table" border="1">
			<tr>
				<th style="width: 100px">販売者名</th>
				<td style="width: 300px"><s:property value="companyDTO.companyName" /></td>
			</tr>
			<tr>
				<th>住所</th>
				<td><s:property value="companyDTO.destinationDTO.address" /></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td><s:property value="companyDTO.destinationDTO.phoneNumber" /></td>
			</tr>
			<tr>
				<th>詳細</th>
				<td><s:property value="companyDTO.companyDescription" /></td>
			</tr>
		</table>
	</c:param>
</c:import>