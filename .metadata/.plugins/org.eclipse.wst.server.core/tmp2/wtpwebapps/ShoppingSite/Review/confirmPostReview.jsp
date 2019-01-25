<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="レビューが投稿されました" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>レビューが投稿されました</h1>
			<table class="review">
				<tr>
					<th class="title">
						<s:property value="title" />
					</th>
				</tr>
				<tr>
					<td class="comment">
						<s:property value="comment" />
					</td>
				</tr>
				<tr>
					<td class="username">
						<s:property value="username" />
						<s:if test="user_id == session.user_id || session.isAdmin == true">
							<span style="color:red; margin-left:5px">
								<a class="delete" href="/ShoppingSite/DeleteItemReviewAction.action?id=<s:property value="id" />">削除</a>
							</span>
						</s:if>
					</td>
				</tr>
			</table>
		</jsp:attribute>
	</jsp:param>
</jsp:include>