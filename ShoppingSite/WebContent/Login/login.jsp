<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="ログイン" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="false" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>ログイン</h1>
			
			<s:if test="errorMsg != null">
				<div class="errorBox">
					<p>エラーメッセージ</p>
					<s:property value="errorMsg" />
				</div>
			</s:if>
			
			<jsp:include page="./loginForm.jsp" />
		</jsp:attribute>
	</jsp:param>
</jsp:include>
