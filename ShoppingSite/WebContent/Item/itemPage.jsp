<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="${itemDTO.item_name }" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">

			<h2 class="text-center" style="font-size: 30px">
				<s:property value="itemDTO.item_name" />
			</h2>

			<div style="margin: 0px 20px 40px 20px">
				<jsp:include page="../errorMsg.jsp" />

				<div id="item_slider">
					<s:iterator begin="0" end="%{ itemDTO.image_num - 1 }" status="st">
						<div>
							<img src="./Images/ItemImages/${ itemDTO.item_id }/${ st.count }.jpg" />
						</div>
					</s:iterator>
				</div>


				<s:if test="#session.isLogin">
					<form class="text-center" action="AddItemAction" method="post">
						<input type="hidden" name="request_Quantity" value='1' min="0">
						<input type="hidden" name="item_id" value="${ itemDTO.item_id }">
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
						<jsp:include page="./itemDetail.jsp" />
					</div>
					<s:if test="#session.isAdmin">
						<div name="詳細変更">
							<jsp:include page="../Admin/itemUpdateForm.jsp" />
						</div>
					</s:if>
				</div>
			</div>

			<div style="margin: 0px 20px 40px 20px">
				<div class="tab" index="0">
					<div name="レビュー" class="tabBox">
						<jsp:include page="./reviewList.jsp" />
					</div>
					<div name="レビュー投稿">
						<jsp:include page="./reviewForm.jsp" />
					</div>
				</div>
			</div>

		</jsp:attribute>
	</jsp:param>
</jsp:include>