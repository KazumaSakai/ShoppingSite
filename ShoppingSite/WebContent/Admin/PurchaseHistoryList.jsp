<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="すべての購入履歴" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>すべての購入履歴</h1>
			<s:if test="%{ !purchaseHistoryList.isEmpty() }">
			<table class="table text-center" border="1">
				<tr>
					<th>ユーザーID</th>
					<th>商品名</th>
					<th>数量</th>
					<th>配送状況</th>
					<th>配達先</th>
					<th>配達時刻</th>
					<th>変更</th>
				</tr>
				<s:iterator value="purchaseHistoryList">
					<tr>
						<th>
							<s:property value="userId" />
						</th>
						<td>
							<a href="<s:url action='ProductInfoAction?productId=%{productId}'/>">
								<s:property value="productDTO.productName" />
							</a>
						</td>
						<td>
							<s:property value="productQuantity" />個
						</td>
						<td>
							<s:if test="%{ shipmentState == 0 }">保留中</s:if>
							<s:elseif test="%{ shipmentState == 1 }">未出荷</s:elseif>
							<s:elseif test="%{ shipmentState == 2 }">出荷準備中</s:elseif>
							<s:elseif test="%{ shipmentState == 3 }">キャンセル済み</s:elseif>
							<s:elseif test="%{ shipmentState == 4 }">配送中</s:elseif>
							<s:elseif test="%{ shipmentState == 5 }">配達中</s:elseif>
							<s:elseif test="%{ shipmentState == 6 }">配達済</s:elseif>
							<s:else>不明な配達状況</s:else>
						</td>
						<td><s:property value="destinationDTO.address" /></td>
						<td>
							<s:if test="%{ requestDeliveryDate == null }">指定なし</s:if>
							<s:else>
								<s:property value="requestDeliveryDate" />
							</s:else>
						</td>
						<td>
							<a class="delete" href="<s:url action='AdminPurchaseHistoryDeleteAction?purchaseHistoryId=%{ id }'/>">削除</a>
						</td>
					</tr>
				</s:iterator>
			</table>
			</s:if>
			<s:else>
				<p class="errorMessage text-center">
					購入履歴が存在しません。
				</p>
			</s:else>
		</jsp:attribute>
	</jsp:param>
</jsp:include>