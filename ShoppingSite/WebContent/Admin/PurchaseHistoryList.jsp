<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="すべての購入履歴" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>すべての購入履歴</h1>
		<s:if test="%{ !purchaseHistoryList.isEmpty() }">
			<ul class="verticalItemList">
				<s:iterator value="purchaseHistoryList">
					<li>
						<div class="left">
							<div>
								<a href="<s:url action='ProductInfoAction?productId=%{ productId }' />">
									<img src="./Images/ItemImages/${productId }/1.jpg" />
									<p>
										<s:property value="productDTO.productName" />
									</p>
								</a>
							</div>
						</div>

						<div class="right">
							<div>
								<table>
									<tr>
										<th>
											購入者
										</th>
										<td>
											<s:property value="userDTO.userName" />
										</td>
									</tr>
									<tr>
										<th>
											購入個数
										</th>
										<td>
											<s:property value="productQuantity" />個
										</td>
									</tr>
									<tr>
										<th>
											合計金額
										</th>
										<td>
											<s:property value="%{ productDTO.productPrice * productQuantity}" />円
										</td>
									</tr>
									<tr>
										<th>
											住所
										</th>
										<td>
											<s:property value="destinationDTO.postalCode" /> <s:property value="destinationDTO.address" />
										</td>
									</tr>
									<tr>
										<th>
											配達指定日
										</th>
										<td>
											<s:if test="%{ requestDeliveryDate == null }">指定なし</s:if>
											<s:else>
												<s:property value="requestDeliveryDateFormat" />
											</s:else>
										</td>
									</tr>
									<tr>
										<th>
											配達状況
										</th>
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
									</tr>
									<tr>
										<th>
											配達会社
										</th>
										<td>
											--- 未実装 ---
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="button" style="top: -6px; right: -6px" onclick="location.href='<s:url action='PurchaseHistoryDeleteAction?purchaseHistoryId=%{ id }'/>'">
							<div class="cross"></div>
						</div>
					</li>
				</s:iterator>
			</ul>
		</s:if>
		<s:else>
			<p class="errorMessage text-center">
				購入履歴が存在しません。
			</p>
		</s:else>
	</c:param>
</c:import>