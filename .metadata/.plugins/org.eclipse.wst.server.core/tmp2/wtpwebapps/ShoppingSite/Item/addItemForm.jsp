<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.isAdmin">
	<form action="AdminAddItemAction">
		<table class="table">
			<tr>
				<th colspan="2">管理者用 商品追加フォーム</th>
			</tr>
			<tr>
				<td style="text-align: left">商品名</td>
				<td style="text-align: left"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td style="text-align: left">商品価格</td>
				<td style="text-align: left"><input type="number" name="price" /> 円</td>
			</tr>
			<tr>
				<td style="text-align: left">販売個数</td>
				<td style="text-align: left"><input type="number" name="quantity" /> 個</td>
			</tr>
			<tr>
				<td style="text-align: left">販売者ID</td>
				<td style="text-align: left"><input type="number" name="seller" /></td>
			</tr>
			<tr>
				<td style="text-align: left">画像数</td>
				<td style="text-align: left"><input type="number" name="image_num" /></td>
			</tr>
			<tr>
				<td style="text-align: left">説明</td>
				<td style="text-align: left"><textarea name="description"></textarea>
			</tr>
			<tr>
				<td colspan="2" class="text-center"><input type="submit" value="商品を追加する" /></td>
			</tr>
		</table>
	</form>
</s:if>
