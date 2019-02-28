<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="配達設定" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>配達の設定</h1>

		<s:form action="SettlementCartAction" style="margin: 10px 0px">
			<table class="table" border="1">
				<tr>
					<th>
						配達先
					</th>
					<td>
						<select name="destinationId" required="required">
							<s:iterator value="destinationDTOList">
								<option value="${id }"><c:out value="${address }" /></option>
							</s:iterator>
						</select>
					</td>
					<td>
						<a href='<s:url action="GoInsertDestinationAction?goBuy=true"/>'>配達先を追加する</a>
					</td>
				</tr>
				<tr>
					<th>
						配達予定日
					</th>
					<td colspan="2">
						<input type="date" name="requestDeliveryDate" min="${ minDate }" max="${ maxDate }">
						<input type="time" name="requestDeliveryTime" min="08:00" max="19:59" />
					</td>
				</tr>
			</table>
			<div class="text-center">
				<input class="linkButton" type="submit" value="購入" />
			</div>
		</s:form>


		<table class="table text-center">
			<tr>
				<th>商品名</th>
				<th>商品画像</th>
				<th>商品価格</th>
				<th>購入数</th>
			</tr>
			<s:iterator value="productDTOList">
				<tr>
					<th>
						<s:property value="productName" />
					</th>
					<td>
						<img src="./Images/ItemImages/${ id }/1.jpg" />
					</td>
					<td>
						<s:property value="productPrice" />円
					</td>
					<td>
						<s:property value="productQuantity" />個
					</td>
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
	</c:param>
</c:import>