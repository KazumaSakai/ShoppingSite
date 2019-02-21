<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="reviewExists">
	<s:iterator value="itemReviewList">
		<li class="review">
			<p class="title">
				<s:property value="title" />
			</p>
			<p class="comment">
				<s:property value="comment" />
			</p>
			<p class="username">
				<s:property value="username" />
				<s:if test="user_id == #session.user_id || #session.isAdmin">
					<span style="color: red; margin-left: 5px">
						<a class="delete" href="<s:url action='DeleteItemReviewAction?id=%{ id }' />">
							削除
						</a>
					</span>
				</s:if>
			</p>
		</li>
	</s:iterator>
</s:if>
<s:if test="!reviewExists">
	<p class="text-center" style="font-weight: bold">レビューが投稿されていません</p>
</s:if>