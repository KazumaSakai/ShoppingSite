<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="マイカート" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>マイカート</h1>
			<s:if test="itemList.size != 0">
			<table class="itemList" border="1">
				<tr>
					<th style="width: 100px">商品名</th>
					<th style="width: 100px">商品価格</th>
					<th style="width: 100px">数量</th>
					<s:if test="session.isLogin == true">
						<th>数を変更</th>
					</s:if>
				</tr>
				<s:iterator value="itemList">
					<tr>
						<td><s:property value="item_name" /></td>
						<td><s:property value="item_price" />円</td>
						<td><s:property value="item_count" />個</td>
						<s:if test="session.isLogin == true">
							<td>
								<form name="DeleteItemAction" action="/ShoppingSite/DeleteItemAction.action" method="post" class="form">
								<input type="number" name="newQuantity" value='<s:property value="item_count" />' style="width:50px; text-align: right; padding:2px">個
								<input type="hidden" name="item_id" value='<s:property value="item_id" />'>
								<input type="submit" value="変更"/>
								</form>
							</td>
						</s:if>
					</tr>
				</s:iterator>
				<tr>
					<th colspan="4" style="text-align:center">
						<form name="BuyCartItemAction" action="/ShoppingSite/BuyCartItemAction.action" method="post" class="form">
							<input type="submit" value="購入する" style="padding: 5px 30px" />
						</form>
					</th>
				</tr>
			</table>
			</s:if>
			<s:if test="itemList.size == 0">
				<p class="errorMessage text-center">
					カートの中身が空です。
				</p>
				<p class="text-center">
          			商品は<a href='<s:url action="ItemListAction"/>'>こちら</a>からご購入できます。
				</p>
			</s:if>
		</jsp:attribute>
	</jsp:param>
</jsp:include>