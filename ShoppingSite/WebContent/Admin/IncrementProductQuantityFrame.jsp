<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.isAdmin">
	<form action="AdminIncrementProductQuantityAction" method="post">
		<table class="table">
			<tr>
				<th>
					商品追加個数
				</th>
				<td>
					<input type="number" name="productQuantity" required="required" value="0" min="0" max="2147483647" /> 個
				</td>
			</tr>
			<tr>
				<th>
					現在の商品個数
				</th>
				<td>
					<s:property value="%{ productDTO.productQuantity }" />個
				</td>
			</tr>
		</table>
		<div class="text-center">
			<input type="hidden" name="productId" value="${ productId }" />
			<input class="linkButton" type="submit" value="商品を追加する" />
		</div>
	</form>
</s:if>
