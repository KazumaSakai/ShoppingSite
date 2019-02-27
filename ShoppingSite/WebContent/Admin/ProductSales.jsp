<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="商品売り上げ" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<script>
			var productId = <s:property value="productId" />;
			var productSalesJson = <s:property value="resultData" escape="false" />
		</script>
		<style>
			svg
			{
				border: 1px solid black;
			}

			#myGraph rect
			{
				stroke: rgb(160, 0, 0);
				stroke-width: 1px;
				fill: rgb(255, 0, 0);
			}

			.axis text
			{
				font-family: sans-serif;
				font-size: 11px;
			}

			.axis path, .axis line
			{
				fill: none;
				stroke: black;
			}
		</style>

		<div class="text-center">
			<svg id="myGraph"></svg>
			<p>JavaScript svg d3.jsで作成しました。</p>
		</div>
		<script type="text/javascript" src="./JavaScript/d3.js"></script>
	</c:param>
</c:import>