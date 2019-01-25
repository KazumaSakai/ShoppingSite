<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="マイカート" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>マイカート</h1>
			<s:if test="itemList.size != 0">
			<table class="itemListTable">
				<tr>
					<th style="width: 100px">商品画像</th>
					<th style="width: 100px">商品名</th>
					<th style="width: 100px">商品価格</th>
					<th style="width: 100px">数量</th>
					<th>数を変更</th>
				</tr>
				<s:iterator value="itemList">
					<tr>
						<td>
							<img src="./Images/ItemImages/${item_id }/1.jpg" style="width: 50px"/>
						</td>
						<td><a href="/ShoppingSite/ItemPageAction.action?id=<c:out value="${item_id}" />"><s:property value="item_name" /></a></td>
						<td><s:property value="item_price" />円</td>
						<td><s:property value="item_count" />個</td>
						<td>
							<form action="ChangeCartItemQuantityAction">
								<input type="hidden" name="toCart" value="true" />
								<input type="number" name="newQuantity" value='<s:property value="item_count" />' min="0" style="width:50px; text-align: right; padding:2px">個
								<input type="hidden" name="item_id" value='<s:property value="item_id" />'>
								<input type="submit" value="変更"/>
							</form>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="2">
						合計金額
					</td>
					<td colspan="3">
						<span style="color: red; font-weight:bold"><c:out value="${totalPrice }" />円</span>
					</td>
				</tr>
				<tr>
					<td colspan="5" class="text-center form">
						<form action="GoBuyAction" >
							<input class="linkButton" type="submit" value="購入する" />
						</form>
					</td>
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