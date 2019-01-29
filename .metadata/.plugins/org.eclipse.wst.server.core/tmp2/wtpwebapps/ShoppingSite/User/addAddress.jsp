<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="住所を追加" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>住所を追加</h1>
			<form action="AddAddressAction" class="inputTable">
				<input type="hidden" name="goBuy" value="<s:property value='goBuy'/>" />
				<table class="center">
					<tr>
						<td>住所</td>
						<td><input type="text" name="address" /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input class="linkButton" value="住所を登録" type="submit" /></td>
					</tr>
				</table>
			</form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>