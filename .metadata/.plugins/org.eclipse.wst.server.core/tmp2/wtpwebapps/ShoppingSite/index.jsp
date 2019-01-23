<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="ShoppingSite" name="title"  />
	<jsp:param value="true" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="false" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>SubTitle</h1>
			<p>Hello Index</p>
		</jsp:attribute>
	</jsp:param>
</jsp:include>