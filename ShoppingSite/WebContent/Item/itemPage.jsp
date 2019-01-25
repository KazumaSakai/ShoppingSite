<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="${itemDTO.item_name }" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h2 class="text-center" style="font-size: 30px"><c:out value="${itemDTO.item_name }" /></h2>
			<div id="item_slider">
				<c:forEach begin="1" end="${itemDTO.image_num }" step="1" varStatus="status">
					<div><img src="./Images/ItemImages/${itemDTO.item_id }/${status.index }.jpg"/></div>
				</c:forEach>
			</div>
			
			<jsp:include page="./itemDetail.jsp" />
			
			
			
			<p style="text-align: center; font-size: 23px; font-weight: bold">
				レビュー
			</p>
			
			<jsp:include page="./reviewList.jsp" />
			<jsp:include page="./reviewForm.jsp" />
			
			
		</jsp:attribute>
	</jsp:param>
</jsp:include>