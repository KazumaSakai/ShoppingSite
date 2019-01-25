<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="商品リスト" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
		
			<h1>商品リスト</h1>
			
			<jsp:include page="./itemListTable.jsp" />
			
			<s:if test="session.isLogin == true">
				<p class="text-center">
					<s:if test="session.isAdmin != true">
						<input class="linkButton" type="button" value="マイカート" onClick="location.href='<s:url action='MyCartAction'/>'">
					</s:if>
					<s:if test="session.isAdmin == true">
						<input class="linkButton" type="button" value="マイカート" onClick="location.href='<s:url action='MyCartAction'/>'">
					</s:if>
				</p>
			</s:if>
			
			<jsp:include page="./addItemForm.jsp" />
			
		</jsp:attribute>
	</jsp:param>
</jsp:include>