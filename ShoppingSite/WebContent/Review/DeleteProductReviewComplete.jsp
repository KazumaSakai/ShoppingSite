<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="レビューが削除されました" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="false" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<s:if test="productReviewDTO == null">
				<p class="text-center errorMessage">レビューの削除に失敗しました。</p>
			</s:if>
			<s:else>
				<p class="text-center errorMessage">以下のレビューが削除されました。</p>
				<table class="review">
					<tr>
						<th class="title">
							<s:property value="productReviewDTO.reviewTitle" />
						</th>
					</tr>
					<tr>
						<td class="comment">
							<s:property value="productReviewDTO.reviewComment" />
						</td>
					</tr>
					<tr>
						<td class="username">
							<s:property value="productReviewDTO.user.useName" />
						</td>
					</tr>
				</table>
				<div class="text-center">
					<input type="button" class="linkButton" value="アイテムのページへ戻る" onclick="location.href='<s:url action='ProductInfoAction?productId=%{ productReviewDTO.productId }'/>'" />
				</div>
			</s:else>
		</jsp:attribute>
	</jsp:param>
</jsp:include>