<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.isAdmin">
	<form action="AdminInsertProductAction" method="post">
		<table class="table">
			<tr>
				<th colspan="2">管理者用 商品追加フォーム</th>
			</tr>
			<tr>
				<th>商品名</th>
				<td><input type="text" name="productName" required="required" min="3" max="60" /></td>
			</tr>
			<tr>
				<th>商品価格</th>
				<td><input type="number" name="productPrice" required="required" value="10" min="10" max="2147483647" /> 円</td>
			</tr>
			<tr>
				<th>販売個数</th>
				<td><input type="number" name="productQuantity" required="required" min="0" max="2147483647" /> 個</td>
			</tr>
			<tr>
				<th>販売会社ID</th>
				<td><input type="number" name="salesCompanyId" required="required" min="0" max="2147483647" /></td>
			</tr>
			<tr>
				<th>製造会社ID</th>
				<td><input type="number" name="productionCompanyId" required="required" min="0" max="2147483647" /></td>
			</tr>
			<tr>
				<th>説明</th>
				<td><textarea name="productDescription" required="required" min="10" max="3000" ></textarea>
			</tr>
			<tr>
				<th>商品画像</th>
				<td><input type="number"  name="imageQuantity" required="required" min="1" max="10" />
			</tr>
		</table>
		<div class="text-center">
			<input class="linkButton" type="submit" value="商品を追加する" />
		</div>
	</form>
</s:if>
