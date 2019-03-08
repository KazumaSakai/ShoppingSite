<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="商品リスト" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="false" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
			<form action="ProductListAction" method="get">
				<table class="searchTable">
					<tr>
						<td>AND検索<input name="andSearch" type="checkbox" value="true"/></td>
						<td><input name="searchWords" type="text" placeholder="検索ワード" /></td>
						<td><input type="submit" value="検索" class="mini_linkButton" /></td>
					</tr>
				</table>
			</form>

			<jsp:include page="./ProductListFrame.jsp" />
			
			<ul class="pager">
				<s:iterator value="pager" var="v">
				<c:if test="${ (page + 1) == v }"> 
					<li class="disable">
						<s:property value="v" />
					</li>
				</c:if>
				<c:if test="${ (page + 1) != v }">
					<li onclick="location.href='<s:url action="ProductListAction"><s:param name="page" value="v" /><s:param name="searchWords" value="searchWords" /><s:param name="andSearch" value="andSearch" /></s:url>'">
						<s:property value="v" />
					</li>
				</c:if>
				</s:iterator>
			</ul>
			
	</c:param>
</c:import>
