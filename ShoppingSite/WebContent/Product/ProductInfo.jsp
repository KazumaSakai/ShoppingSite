<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="${ productDTO.productName }" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h2 class="text-center" style="font-size: 30px">
			<s:property value="productDTO.productName" />
		</h2>

		<div style="margin: 0px 20px 40px 20px">
			<jsp:include page="../ErrorMsgFrame.jsp" />

			<div id="item_slider">
				<s:iterator begin="0" end="%{ productDTO.imageQuantity - 1 }" status="st">
					<div>
						<img src="./Images/ItemImages/${ productDTO.id }/${ st.count }.jpg" class="popupImage" />
					</div>
				</s:iterator>
			</div>


			<s:if test="#session.isLogin">
				<form class="text-center" action="IncrementProductQuantityAction" method="post">
					<input type="hidden" name="productQuantity" value='1' min="0">
					<input type="hidden" name="productId" value="${ productDTO.id }">
					<input class="linkButton" type="submit" value="カートに追加する" />
				</form>
			</s:if>
			<s:else>
				<p class="text-center">
					商品を購入するには、ログインが必要です。ログインは<a href='<s:url action="GoLoginAction"/>'>こちら</a>からできます。
				</p>
			</s:else>
		</div>


		<div style="margin: 0px 20px 40px 20px">
			<div class="tab" index="0">
				<div name="詳細">
					<jsp:include page="./ProductInfoFrame.jsp" />
				</div>
				<s:if test="#session.isAdmin">
					<div name="詳細変更">
						<jsp:include page="../Admin/UpdateProductFrame.jsp" />
					</div>
				</s:if>
			</div>
		</div>

		<div style="margin: 0px 20px 40px 20px">
			<div class="tab" index="0">
				<div name="レビュー" class="tabBox">
					<jsp:include page="./ProductReviewListFrame.jsp" />
				</div>
				<div name="レビュー投稿">
					<jsp:include page="./PostProductReviewFrame.jsp" />
				</div>
			</div>
		</div>
	</c:param>
</c:import>
