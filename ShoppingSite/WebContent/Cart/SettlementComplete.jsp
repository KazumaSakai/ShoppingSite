<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="購入完了" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>購入が完了しました</h1>
		<table class="table text-center" border="1">
			<tr>
				<th>
					商品名
				</th>
				<th>
					商品画像
				</th>
				<th>
					商品価格
				</th>
				<th>
					購入数
				</th>
			</tr>
			<s:iterator value="purchasedProductList">
				<tr>
					<th>
						<s:property value="productName" />
					</th>
					<td>
						<img src="./Images/ItemImages/${id }/1.jpg" class="popupImage" />
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
					<span style="color: red; font-weight: bold"><s:property value="totalPrice" />円</span>
				</td>
			</tr>
		</table>
		<p class="text-center">
			ご購入ありがとう御座いました。<br />
			またのご利用をお待ちしております。
		</p>
	</c:param>
</c:import>