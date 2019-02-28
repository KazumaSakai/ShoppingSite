<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../../template.jsp">
	<c:param value="登録完了" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">

			<h1>登録が完了致しました</h1>
			<p class="text-center">
				ご登録が完了致しました。<br />
				ログインは完了していません。ログインされる場合は<a href='<s:url action="GoLoginAction"/>'>こちら</a>からできます。
			</p>

	</c:param>
</c:import>
