<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.isAdmin">
	<form action="AdminUpdateItemAction" method="post">
		<table class="table">
			<tr>
				<th colspan="2" style="color: red">管理者用 商品情報変更フォーム</th>
			</tr>
			<tr>
				<td style="text-align: left">商品名</td>
				<td style="text-align: left"><input type="text" name="item_name" value="${ itemDTO.item_name }" required="required" /></td>
			</tr>
			<tr>
				<td style="text-align: left">商品価格</td>
				<td style="text-align: left"><input type="number" name="item_price" value="${ itemDTO.item_price }"  required="required"/> 円</td>
			</tr>
			<tr>
				<td style="text-align: left">販売個数</td>
				<td style="text-align: left"> ＋ <input type="number" name="item_quantity" value="0" required="required"/></td>
			</tr>
			<tr>
				<td style="text-align: left">販売者ID</td>
				<td style="text-align: left"><input type="number" name="seller" value="${ itemDTO.seller.id }" required="required" /></td>
			</tr>
			<tr>
				<td style="text-align: left">画像数</td>
				<td style="text-align: left"><input type="number" name="image_num" value="${ itemDTO.image_num }" required="required" /></td>
			</tr>
			<tr>
				<td style="text-align: left">説明</td>
				<td style="text-align: left"><textarea name="description" required="required">${ itemDTO.description }</textarea>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<input type="hidden" name="id" value="${ itemDTO.item_id }" />
					<input class="linkButton" type="submit" value="商品情報を更新する" />
				</td>
			</tr>
		</table>
	</form>
</s:if>
