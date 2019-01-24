<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="登録が完了致しました" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>登録が完了致しました</h1>
			<p class="text-center">
				ご登録が完了致しました。<br/>
				ログインは完了していません。ログインされる場合は<a href='<s:url action="GoLoginAction"/>'>こちら</a>からできます。
			</p>
		</jsp:attribute>
	</jsp:param>
</jsp:include>