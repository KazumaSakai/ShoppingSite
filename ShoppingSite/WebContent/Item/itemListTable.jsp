<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<ul class="itemList">
	<s:iterator value="itemList">
		<li onclick="location.href='<s:url action='ItemPageAction?id=%{ item_id }'/>'">
			<p>
				<img src="./Images/ItemImages/${ item_id }/1.jpg" />
			</p>
			<p>${ item_name }</p>
			<p>販売価格 : <s:property value="item_price" />円</p>
			<p>販売個数 : <s:property value="item_count" />個</p>

			<div class="itemButton">
				<ul class="dropMenu">
					<li><a href="<s:url action='AddItemAction?item_id=%{ item_id }'/>">カートに追加</a></li>
					<s:if test="#session.isAdmin">
						<li><a href="<s:url action='GoSalesDataAction?item_id=%{ item_id }'/>">統計</a></li>
						<li><a href="<s:url action='AdminUpdateItemInfoAction?item_id=%{ item_id }'/>">変更</a></li>
						<li><a href="<s:url action='AdminDeleteItemAction?item_id=%{ item_id }'/>" style="color: red">削除</a></li>
					</s:if>
				</ul>
			</div>
		</li>
	</s:iterator>
</ul>