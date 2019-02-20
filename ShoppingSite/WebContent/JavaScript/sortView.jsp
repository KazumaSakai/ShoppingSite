<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="Sort可視化" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>MergeSort</h1>
			<div class="text-center" >
				<canvas id="cv" width="1000" height="480" style="border: 1px solid black">
				</canvas>
				<p>
					JavaScriptのCanvasでソートを可視化しました。
				</p>
			</div>
			<script type="text/javascript" src="./JavaScript/sortView.js"></script>
		</jsp:attribute>
	</jsp:param>
</jsp:include>