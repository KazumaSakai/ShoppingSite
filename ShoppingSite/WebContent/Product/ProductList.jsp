<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="商品リスト" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
			<h1>商品リスト</h1>

			<form action="ProductListAction" method="post">
				<table class="searchTable">
					<tr>
						<td>AND検索<input name="andSearch" type="radio" value="true"/></td>
						<td><input name="searchWords" type="text" placeholder="検索ワード" /></td>
						<td><input type="submit" value="検索" class="mini_linkButton" /></td>
					</tr>
				</table>
			</form>

			<jsp:include page="./ProductListFrame.jsp" />
	</c:param>
</c:import>