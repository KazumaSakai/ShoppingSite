<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="配達の設定" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>配達の設定</h1>
			<table class="itemList" border="1">
				<tr>
					<th colspan="4">購入する商品</th>
				</tr>
				<tr>
					<th style="width: 100px">商品画像</th>
					<th style="width: 100px">商品名</th>
					<th style="width: 100px">商品価格</th>
					<th style="width: 100px">購入数</th>
				</tr>
				<s:iterator value="myCartItemList">
					<tr>
						<td>
							<img src="./Images/ItemImages/${item_id }/1.jpg" style="width: 50px"/>
						</td>
						<td><s:property value="item_name" /></td>
						<td><s:property value="item_price" />円</td>
						<td><s:property value="item_count" />個</td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="2">
						合計金額
					</td>
					<td colspan="2">
						<c:out value="${totalPrice }" />円
					</td>
				</tr>
			</table>
			<form action="BuyCartItemAction" style="margin: 10px">
				<table class="center table"  border="1">
					<tr>
						<td>配達先</td>
						<td>
							<select name="address" style="width:100px">
								<s:iterator value="addressList">
									<option value="${id }"><c:out value="${address }" /></option>
								</s:iterator>
							</select>
						</td>
						<td>
							<a href='<s:url action="GoAddAddressAction"/>?goBuy=true'>配達先を追加する</a>
						</td>
					</tr>
					<tr>
						<td>配達予定日</td>
						<td colspan="2">
							<input type="datetime-local" name="request_date" required="required" step="3600" min="${min }" max="${max }">
						</td>
					</tr>
					<tr>
						<td>電話番号</td>
						<td colspan="2"><input type="tel" name="phoneNumber" required="required" /></td>
					</tr>
					<tr>
						<td colspan="3" class="text-center"  style="width: 430px"><input type="submit" value="購入" /></td>
					</tr>
				</table>
			</form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>