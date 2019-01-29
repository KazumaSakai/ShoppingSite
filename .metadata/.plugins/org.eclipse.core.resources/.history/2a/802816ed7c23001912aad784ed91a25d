<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="レビューが削除されました" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<p class="text-center errorMessage">以下のレビューが削除されました</p>
			<table class="review">
				<tr>
					<th class="title">
						<s:property value="review.title" />
					</th>
				</tr>
				<tr>
					<td class="comment">
						<s:property value="review.comment" />
					</td>
				</tr>
				<tr>
					<td class="username">
						<s:property value="review.username" />
					</td>
				</tr>
			</table>
		</jsp:attribute>
	</jsp:param>
</jsp:include>