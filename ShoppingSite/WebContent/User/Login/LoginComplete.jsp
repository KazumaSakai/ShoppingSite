<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../../template.jsp">
	<c:param value="ログイン成功" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">

			<h1>ログイン成功</h1>
			<p class="text-center">
				ログインに成功しました。
				ShoppingSiteへようこそ、「<s:property value="#session.userName" />」さん。
			</p>

	</c:param>
</c:import>