<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="統計" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="false" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
		<script>
			var item_id = <s:property value="item_id" />;
		</script>
		<style>
			svg {
				width: 320px;
				height: 240px;
				border: 1px solid black;
			}
			
			#myGraph rect {
				stroke: rgb(160, 0, 0);
				stroke-width: 1px;
				fill: rgb(255, 0, 0);
			}
			
			.axis text {
				font-family: sans-serif;
				font-size: 11px;
			}
			
			.axis path, .axis line {
				fill: none;
				stroke: black;
			}
		</style>
		
		<div class="text-center">
			<svg id="myGraph"></svg>
		</div>
		<script type="text/javascript" src="./JavaScript/d3.js"></script>
		</jsp:attribute>
	</jsp:param>
</jsp:include>