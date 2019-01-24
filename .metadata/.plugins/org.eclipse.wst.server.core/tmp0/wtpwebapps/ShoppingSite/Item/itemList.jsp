<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="商品リスト" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>商品リスト</h1>
			<table class="itemList" border="1">
				<tr>
					<th style="width: 100px">商品名</th>
					<th style="width: 100px">商品価格</th>
					<th style="width: 100px">残量</th>
					<s:if test="session.isLogin == true">
						<th>カートに追加</th>
					</s:if>
					<s:if test="session.isAdmin == true">
						<th></th>
						<th>商品の数を追加する</th>
						<th>商品を削除する</th>
					</s:if>
				</tr>
				<s:iterator value="itemList">
					<tr>
						<td>
							<a href="/ShoppingSite/ItemPageAction.action?id=<c:out value="${item_id}" />"><s:property value="item_name" /></a>
						</td>
						<td><s:property value="item_price" />円</td>
						<td><s:property value="item_count" />個</td>
						<s:if test="session.isLogin == true">
							<td>
								<form name="AddItemAction" action="/ShoppingSite/AddItemAction.action" method="post" class="form">
								<input type="number" name="request_Quantity" value='<s:property value="1" />' style="width:50px; text-align: right; padding:2px">個
								<input type="hidden" name="item_id" value='<s:property value="item_id" />'>
								<input type="submit" value="追加"/>
								</form>
							</td>
						</s:if>
						<s:if test="session.isAdmin == true">
							<td></td>
							<td>
							 	<form name="AdminAddItemQuantityAction" action="/ShoppingSite/AdminAddItemQuantityAction.action" method="post" class="form">
									<input type="number" name="quantity" value='<s:property value="1" />' style="width:50px; text-align: right; padding:2px">個
									<input type="hidden" name="id" value='<s:property value="item_id" />'>
									<input type="submit" value="追加" />
							 	</form>
							</td>
							<td>
							 	<form name="AdminDeleteItemAction" action="/ShoppingSite/AdminDeleteItemAction.action" method="post" class="form">
									<input type="hidden" name="id" value='<s:property value="item_id" />'>
									<input type="submit" value="削除" />
							 	</form>
							</td>
						</s:if>
					</tr>
				</s:iterator>
			</table>
			<s:if test="session.isAdmin == true">
				<div class="center" style="border: solid 1px black; margin: 20px 10px">
					<h2 class="text-center">管理者用 商品追加フォーム</h2>
					<form name="AdminAddItemAction" action="/ShoppingSite/AdminAddItemAction.action" method="post" class="form">
						<table class="center">
							<tr>
								<td style="text-align: left">商品名</td>
								<td style="text-align: left"><input type="text" name="name" /></td>
							</tr>
							<tr>
								<td style="text-align: left">商品価格</td>
								<td style="text-align: left"><input type="number" name="price" /> 円</td>
							</tr>
							<tr>
								<td style="text-align: left">販売個数</td>
								<td style="text-align: left"><input type="number" name="quantity" /> 個</td>
							</tr>
							<tr>
								<td style="text-align: left">販売者ID</td>
								<td style="text-align: left"><input type="number" name="seller" /></td>
							</tr>
							<tr>
								<td style="text-align: left">画像数</td>
								<td style="text-align: left"><input type="number" name="image_num" /></td>
							</tr>
							<tr>
								<td style="text-align: left">説明</td>
								<td style="text-align: left"><textarea name="description" style="width: 300px; height: 100px"/></textarea>
							</tr>
							<tr>
								<td colspan="2" class="text-center" ><input type="submit" value="商品を追加する"/></td>
							</tr>
						</table>
					</form>
				</div>
			</s:if>
		</jsp:attribute>
	</jsp:param>
</jsp:include>