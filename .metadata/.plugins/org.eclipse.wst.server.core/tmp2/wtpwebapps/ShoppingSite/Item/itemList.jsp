<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="商品リスト" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
		
			<h1>商品リスト</h1>
			<form action="ItemListAction">
				<table class="inputTable" style="min-width: 500px">
					<tr>
						<td><input name="searchWords" type="text"/></td>
						<td><input type="submit" value="検索" style="padding: 3px 20px" /></td>
					</tr>
				</table>
			</form>
			<jsp:include page="./itemListTable.jsp" />
			
			<s:if test="#session.isLogin">
				<p class="text-center">
					<input class="linkButton" type="button" value="マイカート" onClick="location.href='<s:url action='MyCartAction'/>'">
				</p>
			</s:if>
			
			<jsp:include page="./addItemForm.jsp" />
			
		</jsp:attribute>
	</jsp:param>
</jsp:include>