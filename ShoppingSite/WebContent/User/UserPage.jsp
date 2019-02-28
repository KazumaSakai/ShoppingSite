<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="ユーザーページ" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>ユーザーページ</h1>
		<ul style="margin: 20px; padding: 0; list-style: none">
			<li><a href='<s:url action="UserInfoAction"/>'>ユーザー情報 変更・確認</a></li>
			<li><a href='<s:url action="PurchaseHistoryAction"/>'>購入履歴</a></li>
			<li><a href='<s:url action="DestinationListAction"/>'>宛先一覧</a></li>
			<li><a href='<s:url action="GoInsertDestinationAction?goBuy=false"/>'>宛先登録</a></li>
		</ul>
		<ul style="margin: 20px; padding: 0; list-style: none">
			<s:if test="#session.isAdmin">
				<li>管理者用</li>
				<li><a href='<s:url action="AdminUserListAction"/>'>ユーザー一覧</a></li>
				<li><a href='<s:url action="ProductListAction"/>'>商品リスト</a></li>
				<li><a href='<s:url action="GoAdminInsertProductAction"/>'>商品追加画面</a></li>
				<li><a href='<s:url action="AdminPurchaseHistoryAction"/>'>すべての購入履歴</a></li>
			</s:if>
		</ul>
	</c:param>
</c:import>
