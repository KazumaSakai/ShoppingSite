<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="住所を追加" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>住所を追加</h1>
			<form action="AddAddressAction">
				<input type="hidden" name="goBuy" value="<c:out value='${goBuy }'/>" />
				<table class="center">
					<tr>
						<td style="width: 200px">住所</td>
						<td style="width: 200px"><input type="text" name="address" /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input type="submit" /></td>
					</tr>
				</table>
			</form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>