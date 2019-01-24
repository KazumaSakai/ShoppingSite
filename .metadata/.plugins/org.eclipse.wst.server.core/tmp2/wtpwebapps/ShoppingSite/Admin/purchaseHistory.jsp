<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="すべての購入履歴" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>すべての購入履歴</h1>
			<s:if test="purchaseHistoryList.size != 0">
			<table class="purchaseHistoryList text-center center" border="1">
				<tr>
					<th style="width: 100px">ユーザーID</th>
					<th style="width: 100px">商品画像</th>
					<th style="width: 100px">商品名</th>
					<th style="width: 100px">商品金額</th>
					<th style="width: 100px">数量</th>
					<th style="width: 100px">合計金額</th>
					<th style="width: 100px">配送状況</th>
					<th style="width: 100px">配達先</th>
					<th style="width: 100px">配達時刻</th>
					<th style="width: 100px">変更</th>
				</tr>
				<s:iterator value="purchaseHistoryList">
					<tr>
						<td style="padding: 5px"><c:out value="${user_id }"/></td>
						<td style="padding: 5px"><img src="./Images/ItemImages/${item_id }/1.jpg" style="width: 50px"/></td>
						<td style="padding: 5px">
							<a href="/ShoppingSite/ItemPageAction.action?id=<c:out value="${item_id}" />"><c:out value="${item_name }" /></a>
						</td>
						<td style="padding: 5px"><c:out value="${item_price }" />円</td>
						<td style="padding: 5px"><c:out value="${quantity }" />個</td>
						<td style="padding: 5px"><c:out value="${item_price * quantity }" />円</td>
						<td style="padding: 5px">
							<c:if test="${shipmentState == 0 }">保留中</c:if>
							<c:if test="${shipmentState == 1 }">未出荷</c:if>
							<c:if test="${shipmentState == 2 }">出荷準備中</c:if>
							<c:if test="${shipmentState == 3 }">キャンセル済み</c:if>
							<c:if test="${shipmentState == 4 }">配送中</c:if>
							<c:if test="${shipmentState == 5 }">配達中</c:if>
							<c:if test="${shipmentState == 6 }">配達済</c:if>
						</td>
						<td style="padding: 5px"><c:out value="${address }" /></td>
						<td style="padding: 5px">
							<c:if test="${request_date == null }">指定なし</c:if>
							<c:if test="${request_date != null }"><c:out value="${request_date }" /></c:if>
						</td>
						<td>
							<input type="submit" value="変更" />
						</td>
					</tr>
				</s:iterator>
			</table>
			</s:if>
			<s:if test="purchaseHistoryList.size == 0">
				<p class="errorMessage text-center">
					購入履歴が存在しません。
				</p>
			</s:if>
		</jsp:attribute>
	</jsp:param>
</jsp:include>