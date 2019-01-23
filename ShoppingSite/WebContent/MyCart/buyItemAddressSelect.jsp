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
				<s:iterator value="buyItemList">
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
			<form style="margin: 10px">
				<table class="center" >
					<tr>
						<td>配達先</td>
						<td>
							<s:if test="addressList.size == 0">
								<a href='<s:url action="GoHomeAction"/>'>配達先を追加する</a>
								
							</s:if>
							<s:if test="addressList.size != 0">
								<s:iterator value="addressList">
									<option value="${name }"><c:out value="${name }" /></option>
								</s:iterator>
							</s:if>
						</td>
					</tr>
					<tr>
						<td>配達予定日</td>
						<td>
							<input type="date" name="request_date">
						</td>
					</tr>
				</table>
			</form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>