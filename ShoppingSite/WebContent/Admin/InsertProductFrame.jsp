<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.isAdmin">
	<form action="AdminInsertProductAction" method="post">
		<table class="table">
			<tr>
				<th>商品名</th>
				<td><input type="text" name="productName" placeholder="商品名" required="required" maxLength="60" /></td>
			</tr>
			<tr>
				<th>商品価格</th>
				<td><input type="number" name="productPrice" placeholder="商品価格" required="required" min="10" max="1000000" /> 円</td>
			</tr>
			<tr>
				<th>販売個数</th>
				<td><input type="number" name="productQuantity" placeholder="販売個数" required="required" min="0" max="2147483647" /> 個</td>
			</tr>
			<tr>
				<th>販売会社ID</th>
				<td><input type="number" name="salesCompanyId" placeholder="販売会社ID" required="required" min="0" max="2147483647" /></td>
			</tr>
			<tr>
				<th>製造会社ID</th>
				<td><input type="number" name="productionCompanyId" placeholder="製造会社ID" required="required" min="0" max="2147483647" /></td>
			</tr>
			<tr>
				<th>説明</th>
				<td><textarea name="productDescription" placeholder="説明" required="required" maxLength="3000" ></textarea>
			</tr>
			<tr>
				<th>商品画像</th>
				<td><input type="number"  name="imageQuantity" placeholder="商品画像" required="required" min="1" max="10" />
			</tr>
		</table>
		<div class="text-center">
			<input class="linkButton" type="submit" value="商品を追加する" />
		</div>
	</form>
</s:if>
