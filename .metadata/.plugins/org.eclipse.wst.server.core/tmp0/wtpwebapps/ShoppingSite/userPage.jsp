<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="ユーザーページ" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>ユーザーページ</h1>
			<ul style="margin: 20px; padding: 0; list-style: none">
				<li><a href='<s:url action="ChangeNameAction"/>'>ユーザー名を変更する</a></li>
			</ul>
		</jsp:attribute>
	</jsp:param>
</jsp:include>