<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="${sellerDTO.name}" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>
				<s:property value="sellerDTO.name" />
			</h1>
			<table class="center table" border="1">
				<tr>
					<th style="width: 100px">販売者名</th>
					<td style="width: 300px"><s:property value="sellerDTO.name" /></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><s:property value="sellerDTO.address" /></td>
				</tr>
				<tr> 
					<th>詳細</th>
					<td><s:property value="sellerDTO.description" /></td>
				</tr>
			</table>
		</jsp:attribute>
	</jsp:param>
</jsp:include>