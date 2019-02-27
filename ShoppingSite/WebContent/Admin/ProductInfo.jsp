<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="商品情報" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">

		<s:if test="#session.isAdmin">

			<div id="item_slider">
				<s:iterator begin="0" end="%{ productDTO.imageQuantity - 1 }" status="st">
					<div>
						<img src="./Images/ItemImages/${ productDTO.id }/${ st.count }.jpg" />
					</div>
				</s:iterator>
			</div>

			<div style="margin: 0px auto; max-width: 800px">

				<div class="tab" index="0">
					<div name="商品情報変更">
						<jsp:include page="./UpdateProductFrame.jsp" />
					</div>
					<div name="商品画像">
					</div>
					<div name="商品在庫追加">
						<jsp:include page="./IncrementProductQuantityFrame.jsp" />
					</div>
				</div>

			</div>
		</s:if>

	</c:param>
</c:import>