<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="マイカート" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>マイカート</h1>
		<s:if test="!productDTOList.isEmpty()">
			<ul class="verticalItemList">
				<s:iterator value="productDTOList">
					<li>
						<div class="left">
							<div>
								<a href="<s:url action='ProductInfoAction.action' />?productId=${id }">
									<img src="./Images/ItemImages/${id }/1.jpg" />
									<p>
										<s:property value="productName" />
									</p>
								</a>
							</div>
						</div>
						<div class="right">
							<div>
								<table>
									<tr>
										<th>
											商品価格
										</th>
										<td>
											<s:property value="productPrice" />円
										</td>
									</tr>
									<tr>
										<th>
											商品数
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
											<span class="price"><s:property value="%{ productPrice * productQuantity }" />円</span>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="button" style="top: -6px; right: 60px" onclick="location.href='<s:url action='IncrementCartProductQuantityAction' />?productId=${id }&toCart=true'">
							<div class="plus"></div>
						</div>
						<div class="button" style="top: -6px; right: 27px" onclick="location.href='<s:url action='DecrementCartProductQuantityAction' />?productId=${id }&toCart=true'">
							<div class="minus"></div>
						</div>
						<div class="button" style="top: -6px; right: -6px" onclick="location.href='<s:url action='DeleteCartProductAction' />?productId=${id }&toCart=true'">
							<div class="cross"></div>
						</div>
					</li>
				</s:iterator>
			</ul>
			<div class="windowTag text-center" style="top: calc(100vh - 155px)">
				カート合計金額 : <span class="totalPrice"><s:property value="totalPrice" /></span>円
				<span class="rightBorder"></span>
			</div>
			<div class="windowTag text-center" style="top: calc(100vh - 80px); background-color: rgb(247, 211, 88);" onclick="location.href='<s:url action='GoBuyAction' />'" >
				購入する
				<span class="rightBorder"></span>
			</div>
		</s:if>
		<s:else>
			<p class="errorMessage text-center">
				カートの中身が空です。
			</p>
			<p class="text-center">
         			商品は<a href='<s:url action="ProductListAction"/>'>こちら</a>からご購入できます。
			</p>
		</s:else>
	</c:param>
</c:import>