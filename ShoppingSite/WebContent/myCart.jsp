<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="マイカート" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>マイカート</h1>
			<table class="itemList" border="1">
				<tr>
					<th style="width: 100px">商品名</th>
					<th style="width: 100px">商品価格</th>
					<th style="width: 100px">数量</th>
					<s:if test="session.isLogin == true">
						<th>カートに追加</th>
					</s:if>
				</tr>
				<s:iterator value="itemList">
					<tr>
						<td><s:property value="item_name" /></td>
						<td><s:property value="item_price" />円</td>
						<td><s:property value="item_count" />個</td>
						<s:if test="session.isLogin == true">
							<td>
								<form id="LoginAction" name="AddItemAction" action="/ShoppingSite/AddItemAction.action" method="post" class="form">
								<input type="hidden" name="item_id" value='<s:property value="item_id" />'>
								<input type="submit" value="追加"/>
								</form>
							</td>
						</s:if>
					</tr>
				</s:iterator>
			</table>
		</jsp:attribute>
	</jsp:param>
</jsp:include>