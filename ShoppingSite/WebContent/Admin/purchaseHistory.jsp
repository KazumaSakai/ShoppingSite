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
			<table class="table" border="1">
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
						<td style="padding: 5px"><s:property value="user_id" /></td>
						<td style="padding: 5px"><img
								src="./Images/ItemImages/${item_id }/1.jpg" style="width: 50px" /></td>
						<td style="padding: 5px">
							<a href="<s:url action='ItemPageAction?id=%{item_id}'/>"><s:property
										value="item_name" /></a>
						</td>
						<td style="padding: 5px"><s:property value="item_price" />円</td>
						<td style="padding: 5px"><s:property value="quantity" />個</td>
						<td style="padding: 5px"><s:property
									value="%{ item_price * quantity }" />円</td>
						<td style="padding: 5px">
							<s:if test="%{ shipmentState == 0 }">保留中</s:if>
							<s:elseif test="%{ shipmentState == 1 }">未出荷</s:elseif>
							<s:elseif test="%{ shipmentState == 2 }">出荷準備中</s:elseif>
							<s:elseif test="%{ shipmentState == 3 }">キャンセル済み</s:elseif>
							<s:elseif test="%{ shipmentState == 4 }">配送中</s:elseif>
							<s:elseif test="%{ shipmentState == 5 }">配達中</s:elseif>
							<s:elseif test="%{ shipmentState == 6 }">配達済</s:elseif>
							<s:else>不明な配達状況</s:else>
						</td>
						<td style="padding: 5px"><s:property value="addressName" /></td>
						<td style="padding: 5px">
							<s:if test="%{ request_date == null }">指定なし</s:if>
							<s:else>
									<s:property value="request_date" />
								</s:else>
						</td>
						<td>
							<a class="delete" href="<s:url action='AdminPurchaseHistoryDeleteAction?id=%{ id }'/>">削除</a>
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