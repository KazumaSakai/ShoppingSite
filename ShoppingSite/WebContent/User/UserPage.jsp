<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="ユーザーページ" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>ユーザーページ</h1>
			<ul style="margin: 20px; padding: 0; list-style: none">
				<li><a href='<s:url action="UserInfoAction"/>'>ユーザー情報 変更・確認</a></li>
				<li><a href='<s:url action="PurchaseHistoryAction"/>'>購入履歴</a></li>
				<li><a href='<s:url action="GoInsertDestinationAction?goBuy=false"/>'>配達先を追加する</a></li>
			</ul>
			<ul style="margin: 20px; padding: 0; list-style: none">
				<s:if test="#session.isAdmin">
					<li>管理者用</li>
					<li><a href='<s:url action="AdminUserListAction"/>'>ユーザーリスト</a></li>
					<li><a href='<s:url action="ProductListAction"/>'>商品リスト</a></li>
					<li><a href='<s:url action="GoAdminInsertProductAction"/>'>商品追加画面</a></li>
					<li><a href='<s:url action="AdminPurchaseHistoryAction"/>'>すべての購入履歴</a></li>
				</s:if>
			</ul>
		</jsp:attribute>
	</jsp:param>
</jsp:include>