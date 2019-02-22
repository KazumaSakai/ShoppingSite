<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.isAdmin">
	<form action="AdminAddItemAction" method="post">
		<table class="table">
			<tr>
				<th colspan="2">管理者用 商品追加フォーム</th>
			</tr>
			<tr>
				<th>商品名</th>
				<td><input type="text" name="name" required="required" min="3" max="60" /></td>
			</tr>
			<tr>
				<th>商品価格</th>
				<td><input type="number" name="price" required="required" value="10" min="10" max="2147483647" /> 円</td>
			</tr>
			<tr>
				<th>販売個数</th>
				<td><input type="number" name="quantity" required="required" min="0" max="2147483647" /> 個</td>
			</tr>
			<tr>
				<th>販売者ID</th>
				<td><input type="number" name="seller" required="required" min="-2147483647" max="2147483647" /></td>
			</tr>
			<tr>
				<th>説明</th>
				<td><textarea name="description" required="required" min="10" max="3000" ></textarea>
			</tr>
		</table>
	</form>
	<div class="text-center">
		<input class="linkButton" type="submit" value="商品を追加する" />
	</div>
</s:if>
