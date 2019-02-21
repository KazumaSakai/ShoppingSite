<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table class="table">
	<tr>
		<th>商品価格</th>
		<td><s:property value="itemDTO.item_price" />円</td>
	</tr>
	<tr>
		<th>取り扱い残量</th>
		<td><s:property value="itemDTO.item_count" />個</td>
	</tr>
	<tr>
		<th>商品説明</th>
		<td><s:property value="itemDTO.description" /></td>
	</tr>
	<tr>
		<th>販売会社</th>
		<td>
			<a href="<s:url action='SellerAction?id=%{ itemDTO.seller.id }'/>">
				<s:property value="itemDTO.seller.name" />
			</a>
		</td>
	</tr>
	<tr>
		<th>発売日</th>
		<td><s:property value="itemDTO.insert_date" /></td>
	</tr>
</table>