<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="レビューの削除に失敗致しました" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="false" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>レビューの削除に失敗致しました</h1>
			<p class="errorMessage text-center">
				申し訳御座いません、レビューの削除に失敗致しました。<br />
				再度実行してください。
			</p>
		</jsp:attribute>
	</jsp:param>
</jsp:include>