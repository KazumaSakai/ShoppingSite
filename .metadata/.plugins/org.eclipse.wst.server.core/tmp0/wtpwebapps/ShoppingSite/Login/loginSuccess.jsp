<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="ログイン成功" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>ログイン成功</h1>
			<p class="text-center">
				ログインに成功しました。
				ShoppingSiteへようこそ、「<s:property value="session.user_name" />」さん。
			</p>
		</jsp:attribute>
	</jsp:param>
</jsp:include>