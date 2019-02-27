<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:import url="../template.jsp">
	<c:param value="SortView" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>SortView</h1>
		<div class="text-center" >
			<canvas id="cv" width="1000" height="480" style="border: 1px solid black">
			</canvas>
			<p>
				JavaScriptのCanvasでソートを可視化しました。
			</p>
		</div>
		<script type="text/javascript" src="./JavaScript/sortView.js"></script>
	</c:param>
</c:import>