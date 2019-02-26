<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="購入履歴" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>購入履歴</h1>
			<s:if test="purchaseHistoryList.isEmpty()">
				<p class="errorMessage text-center">
					購入履歴が存在しません。
				</p>
			</s:if>
			<s:else>
				<ul class="verticalItemList">
					<s:iterator value="purchaseHistoryList">
						<li>
							<div class="left">
								<div>
									<img src="./Images/ItemImages/${id }/1.jpg" />
									<p style="margin: 0px; padding: 0px">
										<a href="<s:url action='ItemPageAction.action?id=%{ id }' />">
											<s:property value="productDTO.productName" />
										</a>
									</p>
								</div>
							</div>

							<div class="right">
								<div>
									<ul>
										<li>
											購入個数 : <s:property value="productQuantity" />個
										</li>
										<li>
											<s:property value="%{ productDTO.productPrice * productQuantity }" />円
										</li>
										<li>
											<s:if test="%{ shipmentState == 0 }">保留中</s:if>
											<s:elseif test="%{ shipmentState == 1 }">未出荷</s:elseif>
											<s:elseif test="%{ shipmentState == 2 }">出荷準備中</s:elseif>
											<s:elseif test="%{ shipmentState == 3 }">キャンセル済み</s:elseif>
											<s:elseif test="%{ shipmentState == 4 }">配送中</s:elseif>
											<s:elseif test="%{ shipmentState == 5 }">配達中</s:elseif>
											<s:elseif test="%{ shipmentState == 6 }">配達済</s:elseif>
											<s:else>不明な配達状況</s:else>
										</li>
										<li>
											<s:property value="destinationDTO.address" />
										</li>
										<li>
											<s:if test="%{ requestDeliveryDate == null }">指定なし</s:if>
											<s:else>
												<s:property value="requestDeliveryDate" />
											</s:else>
										</li>
										<li>
											<a class="delete" href="<s:url action='PurchaseHistoryDeleteAction?purchaseHistoryId=%{ id }'/>">削除</a>
										</li>
									</ul>
								</div>
							</div>
						</li>
					</s:iterator>
				</ul>
			</s:else>
		</jsp:attribute>
	</jsp:param>
</jsp:include>