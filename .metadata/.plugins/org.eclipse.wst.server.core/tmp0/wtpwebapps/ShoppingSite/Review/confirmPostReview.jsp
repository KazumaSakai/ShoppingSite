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
			<ul class="reviewList">
				<li>
					<h3 class="title">
						<s:property value="title" />
					</h3>
					<p class="comment">
						<s:property value="comment" />
					</p>
					<p class="username">
						<s:property value="username" />
					</p>
				</li>
			</ul>
		</jsp:attribute>
	</jsp:param>
</jsp:include>