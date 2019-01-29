<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<table class="table">
	<tr>
		<th colspan="2" style="font-size: 23px">詳細</th>
	</tr>
	<tr>
		<td style="width: 300px">商品価格</td>
		<td style="width: 500px"><s:property value="itemDTO.item_price" />円
		</td>
	</tr>
	<tr>
		<td>取り扱い残量</td>
		<td><s:property value="itemDTO.item_count" />個</td>
	</tr>
	<tr>
		<td>商品説明</td>
		<td><s:property value="itemDTO.description" /></td>
	</tr>
	<tr>
		<td>販売会社</td>
		<td><a
			href="<s:url action='SellerAction?id=%{ itemDTO.seller.id }'/>"><s:property
					value="itemDTO.seller.name" /></a></td>
	</tr>
	<tr>
		<td>発売日</td>
		<td><s:property value="itemDTO.insert_date" /></td>
	</tr>
	<s:if test="#session.isLogin">
		<tr>
			<td class="text-center" colspan="2">
				<form class="text-center" action="AddItemAction">
					<input type="hidden" name="request_Quantity"
						value='<s:property value="1" />' min="0"> <input
						type="hidden" name="item_id"
						value='<s:property value="itemDTO.item_id" />'> <input
						type="submit" value="カートに追加する" />
				</form>
			</td>
		</tr>
	</s:if>
	<s:else>
		<tr>
			<td class="text-center" colspan="2">
				<p>
					商品を購入するには、ログインが必要です。ログインは<a href='<s:url action="GoLoginAction"/>'>こちら</a>からできます。
				</p>
			</td>
		</tr>
	</s:else>
</table>