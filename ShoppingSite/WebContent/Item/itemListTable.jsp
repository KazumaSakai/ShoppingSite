<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<ul class="itemList">
	<s:iterator value="itemList">
		<li>
			<div class="imageBox"  onclick="location.href = '<s:url action='ItemPageAction?id=%{ item_id }' />'">
				<img src="./Images/ItemImages/${ item_id }/1.jpg" />
			</div>
			<p>${ item_name }</p>
			<p>販売価格 : <s:property value="item_price" />円</p>
			<p>販売個数 : <s:property value="item_count" />個</p>
			
			<s:if test="#session.isAdmin">
				<p style="margin: 0; padding: 0">
					<a href="<s:url action='GoSalesDataAction?item_id=%{ item_id }'/>">統計</a>
				</p>
				
				<form class="center" action="AdminAddItemQuantityAction" method="post">
					<input type="number" name="quantity" value='1' style="width: 50px; text-align: right; padding: 2px">個
					<input type="hidden" name="id" value="${ item_id }">
					<input type="submit" value="追加" />
				</form>
			</s:if>
		</li>
	</s:iterator>
</ul>