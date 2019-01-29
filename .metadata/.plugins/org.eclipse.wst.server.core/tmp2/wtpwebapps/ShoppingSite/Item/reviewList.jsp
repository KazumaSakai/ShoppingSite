<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="reviewExists">
	<s:iterator value="itemReviewList">
		<table class="review">
			<tr>
				<th class="title"><s:property value="title" /></th>
			</tr>
			<tr>
				<td class="comment"><s:property value="comment" /></td>
			</tr>
			<tr>
				<td class="username"><s:property value="username" /> <s:if
						test="user_id == #session.user_id || #session.isAdmin">
						<span style="color: red; margin-left: 5px"> <a
							class="delete"
							href="<s:url action='DeleteItemReviewAction?id=%{ id }' />">削除</a>
						</span>
					</s:if></td>
			</tr>
		</table>
	</s:iterator>
</s:if>
<s:if test="!reviewExists">
	<table class="review">
		<tr>
			<td style="background-color: white" class="text-center">
				<p>レビューが投稿されていません</p>
			</td>
		</tr>
	</table>
</s:if>