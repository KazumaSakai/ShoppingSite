<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<table class="itemListTable">
	<tr>
		<th style="width: 100px">商品画像</th>
		<th style="width: 100px">商品名</th>
		<th style="width: 100px">商品価格</th>
		<th style="width: 100px">残量</th>
		<s:if test="session.isLogin == true">
			<th>カート内の数</th>
		</s:if>
		<s:if test="session.isAdmin == true">
			<th>商品の数を追加する</th>
			<th>商品を削除する</th>
		</s:if>
	</tr>
	<s:iterator value="itemList">
		<tr>
			<td>
				<img src="./Images/ItemImages/${item_id }/1.jpg" style="width: 50px"/>
			</td>
			<td>
				<a href="/ShoppingSite/ItemPageAction.action?id=<c:out value='${item_id}' />"><s:property value="item_name" /></a>
			</td>
			<td><s:property value="item_price" />円</td>
			<td><s:property value="item_count" />個</td>
			<s:if test="session.isLogin == true">
				<td class="center">
					<s:if test="myCart_quantity == 0">
						<form action="AddItemAction">
							<input type="number" name="request_Quantity" value='<c:out value="${myCart_quantity }" />' min="0" style="width:50px; text-align: right; padding:2px">個
							<input type="hidden" name="item_id" value='<s:property value="item_id" />'>
							<input type="submit" value="変更"/>
						</form>
					</s:if>
					<s:if test="myCart_quantity != 0">
						<form action="ChangeCartItemQuantityAction">
							<input type="number" name="newQuantity" value='<c:out value="${myCart_quantity }" />' min="0" style="width:50px; text-align: right; padding:2px">個
							<input type="hidden" name="item_id" value='<s:property value="item_id" />'>
							<input type="submit" value="変更"/>
						</form>
					</s:if>
				</td>
			</s:if>
			<s:if test="session.isAdmin == true">
				<td>
					<form class="center" name="AdminAddItemQuantityAction" action="/ShoppingSite/AdminAddItemQuantityAction.action" method="post" class="form">
						<input type="number" name="quantity" value='<s:property value="1" />' style="width:50px; text-align: right; padding:2px">個
						<input type="hidden" name="id" value='<s:property value="item_id" />'>
						<input type="submit" value="追加" />
					</form>
				</td>
				<td>
					<form class="center" name="AdminDeleteItemAction" action="/ShoppingSite/AdminDeleteItemAction.action" method="post" class="form">
						<input type="hidden" name="id" value='<s:property value="item_id" />'>
						<input type="submit" value="削除" />
					</form>
				</td>
			</s:if>
		</tr>
	</s:iterator>
		<tr>
			<s:if test="session.isLogin == true && session.isAdmin != true">
				<td colspan="5"><a href='<s:url action="MyCartAction"/>'>マイカート</a></td>
			</s:if>
			<s:if test="session.isLogin == true && session.isAdmin == true">
				<td colspan="7"><a href='<s:url action="MyCartAction"/>'>マイカート</a></td>
			</s:if>
		</tr>
</table>