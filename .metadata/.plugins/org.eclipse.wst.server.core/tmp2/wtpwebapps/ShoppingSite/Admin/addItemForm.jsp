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
				<td style="text-align: left">商品名</td>
				<td style="text-align: left"><input type="text" name="name" required="required" min="3" max="60" /></td>
			</tr>
			<tr>
				<td style="text-align: left">商品価格</td>
				<td style="text-align: left"><input type="number" name="price" required="required" value="10" min="10" max="2147483647" /> 円</td>
			</tr>
			<tr>
				<td style="text-align: left">販売個数</td>
				<td style="text-align: left"><input type="number" name="quantity" required="required" min="0" max="2147483647" /> 個</td>
			</tr>
			<tr>
				<td style="text-align: left">販売者ID</td>
				<td style="text-align: left"><input type="number" name="seller" required="required" min="-2147483647" max="2147483647" /></td>
			</tr>
			<tr>
				<td style="text-align: left">画像数</td>
				<td style="text-align: left"><input type="number" name="image_num" required="required" min="0" max="10" /></td>
			</tr>
			<tr>
				<td style="text-align: left">説明</td>
				<td style="text-align: left"><textarea name="description" required="required" min="10" max="3000" ></textarea>
			</tr>
			<tr>
				<td colspan="2" class="text-center"><input type="submit" value="商品を追加する" /></td>
			</tr>
		</table>
	</form>
</s:if>
