<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.isAdmin">
	<form action="AdminUpdateItemAction" method="post">
		<table class="table">
			<tr>
				<th>商品名</th>
				<td><input type="text" name="item_name" value="${ itemDTO.item_name }" required="required" /></td>
			</tr>
			<tr>
				<th>商品価格</th>
				<td><input type="number" name="item_price" value="${ itemDTO.item_price }"  required="required"/> 円</td>
			</tr>
			<tr>
				<th>販売個数</th>
				<td> ＋ <input type="number" name="item_quantity" value="0" required="required"/></td>
			</tr>
			<tr>
				<th>販売者ID</th>
				<td><input type="number" name="seller" value="${ itemDTO.seller.id }" required="required" /></td>
			</tr>
			<tr>
				<th>画像数</th>
				<td><input type="number" name="image_num" value="${ itemDTO.image_num }" required="required" /></td>
			</tr>
			<tr>
				<th>説明</th>
				<td><textarea name="description" required="required">${ itemDTO.description }</textarea>
			</tr>
		</table>
		<div class="text-center">
			<input type="hidden" name="id" value="${ itemDTO.item_id }" />
			<input class="linkButton" type="submit" value="商品情報を更新する" />
		</div>
	</form>
</s:if>
