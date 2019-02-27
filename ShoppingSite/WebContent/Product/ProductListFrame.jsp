<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<ul class="itemList">
	<s:iterator value="productDTOList">
		<li onclick="location.href='<s:url action='ProductInfoAction?productId=%{ id }'/>'">
			<p>
				<img src="./Images/ItemImages/${ id }/1.jpg" />
			</p>
			<p><s:property value="productName" /></p>
			<p>販売価格 : <s:property value="productPrice" />円</p>
			<p>販売個数 : <s:property value="productQuantity" />個</p>

			<div class="itemButton">
				<ul class="dropMenu">
					<li><a href="<s:url action='IncrementProductQuantityAction?productId=%{ id }'/>">カートに追加</a></li>
					<s:if test="#session.isAdmin">
						<li><a href="<s:url action='ProductSalesAction?productId=%{ id }'/>">統計</a></li>
						<li><a href="<s:url action='AdminProductInfoAction?productId=%{ id }'/>">変更</a></li>
						<li><a href="<s:url action='AdminDeleteProductAction?productId=%{ id }'/>" style="color: red">削除</a></li>
					</s:if>
				</ul>
			</div>
		</li>
	</s:iterator>
</ul>