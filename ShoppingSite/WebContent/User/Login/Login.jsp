<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../../template.jsp">
	<c:param value="ログイン" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">

			<h1>ログイン</h1>

			<jsp:include page="../../ErrorMsgFrame.jsp" />
			<jsp:include page="./LoginFrame.jsp" />

	</c:param>
</c:import>
