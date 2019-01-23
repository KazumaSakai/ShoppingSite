<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="MergeSort" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>MergeSort</h1>
			<canvas id="cv" width="700" height="500" style="border: 1px solid black">
			</canvas>
			<script type="text/javascript" src="./JavaScript/mergeSortView.js"></script>					
		</jsp:attribute>
	</jsp:param>
</jsp:include>