<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="Index" name="title"  />
	<jsp:param value="true" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>ログイン</h1>
			<s:form action="LoginAction">
				<s:textfield name="login_user_id"/>
				<s:password name="login_pass" />
				<s:submit value="ログイン" />
			</s:form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>