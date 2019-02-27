<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="!productReviewDTOList.isEmpty()">
	<s:iterator value="productReviewDTOList">
		<li class="review">
			<p class="title">
				<s:property value="reviewTitle" />
			</p>
			<p class="comment">
				<s:property value="reviewCommentHTML" escape="false" />
			</p>
			<p class="username">
				<s:property value="userDTO.userName" />
			</p>
			<s:if test="userId == #session.userId || #session.isAdmin">
				<div class="button" style="top: -6px; right: -6px" onclick="location.href='<s:url action='DeleteProductReviewAction?productReviewId=%{ id }'/>'">
					<div class="cross"></div>
				</div>
			</s:if>
		</li>
	</s:iterator>
</s:if>
<s:else>
	<p class="text-center" style="font-weight: bold">レビューが投稿されていません</p>
</s:else>