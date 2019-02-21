<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="配達の設定" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="false" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>配達の設定</h1>
			
			<table class="table text-center">
				<tr>
					<th>商品名</th>
					<th>商品画像</th>
					<th>商品価格</th>
					<th>購入数</th>
				</tr>
				<s:iterator value="myCartItemList">
					<tr>
						<th><s:property value="item_name" /></th>
						<td>
							<img src="./Images/ItemImages/${ item_id }/1.jpg" style="width: 50px" />
						</td>
						<td><s:property value="item_price" />円</td>
						<td><s:property value="item_count" />個</td>
					</tr>
				</s:iterator>
				<tr>
					<th>
						合計金額
					</th>
					<td colspan="3">
						<span style="color: red; font-weight: bold">
							<s:property value="totalPrice" />円
						</span>
					</td>
				</tr>
			</table>
			
			<s:form action="BuyCartItemAction" style="margin: 10px 0px">
				<table class="table" border="1">
					<tr>
						<th>配達先</th>
						<td>
							<select name="address" required="required">
								<s:iterator value="addressList">
									<option value="${id }"><c:out value="${address }" /></option>
								</s:iterator>
							</select>
						</td>
						<td>
							<a href='<s:url action="GoAddAddressAction?goBuy=true"/>'>配達先を追加する</a>
						</td>
					</tr>
					<tr>
						<th>配達予定日</th>
						<td colspan="2">
							<input type="datetime-local" name="request_date" required="required" step="3600" min="${ min }" max="${ max }">
						</td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td colspan="2">
							<input type="tel" name="phoneNumber" required="required" />
						</td>
					</tr>
				</table>
				<div class="text-center">
					<input class="linkButton" type="submit" value="購入" />
				</div>
			</s:form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>