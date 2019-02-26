<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="商品リスト" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="false" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">

			<h1>商品リスト</h1>

			<form action="ProductListAction" method="post">
				<table class="inputTable">
					<tr>
						<td>AND検索</td>
						<td><input name="andSearch" type="radio" value="true"/></td>
						<td><input name="searchWords" type="text"/></td>
						<td><input type="submit" value="検索" class="mini_linkButton" /></td>
					</tr>
				</table>
			</form>

			<jsp:include page="./ProductListFrame.jsp" />

		</jsp:attribute>
	</jsp:param>
</jsp:include>