<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="レビュー削除失敗" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>レビューの削除に失敗致しました</h1>
		<p class="errorMessage text-center">
			申し訳御座いません、レビューの削除に失敗致しました。<br />
			再度実行してください。
		</p>
	</c:param>
</c:import>