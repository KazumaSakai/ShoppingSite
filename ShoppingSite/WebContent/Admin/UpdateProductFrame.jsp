<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.isAdmin">
	<form action="AdminUpdateProductAction" method="post">
		<table class="table">
			<tr>
				<th>商品名</th>
				<td><input type="text" name="productName" value="${ productDTO.productName }" required="required" /></td>
			</tr>
			<tr>
				<th>商品価格</th>
				<td><input type="number" name="productPrice" value="${ productDTO.productPrice }"  required="required"/> 円</td>
			</tr>
			<tr>
				<th>販売会社ID</th>
				<td><input type="number" name="salesCompanyId" value="${ productDTO.salesCompanyId }" required="required" /></td>
			</tr>
			<tr>
				<th>製造会社ID</th>
				<td><input type="number" name="productionCompanyId" value="${ productDTO.productionCompanyId }" required="required" /></td>
			</tr>
			<tr>
				<th>画像数</th>
				<td><input type="number" name="imageQuantity" value="${ productDTO.imageQuantity }" required="required" /></td>
			</tr>
			<tr>
				<th>説明</th>
				<td><textarea name="productDescription" required="required">${ productDTO.productDescription }</textarea>
			</tr>
		</table>
		<div class="text-center">
			<input type="hidden" name="productId" value="${ productDTO.id }" />
			<input class="linkButton" type="submit" value="商品情報を更新する" />
		</div>
	</form>
</s:if>
