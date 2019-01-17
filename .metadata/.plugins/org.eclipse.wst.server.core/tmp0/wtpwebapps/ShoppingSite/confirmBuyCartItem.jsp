<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="購入が完了しました" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="false" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>購入が完了しました</h1>
			<table class="itemList" border="1">
				<tr>
					<th colspan="3">ご購入された商品</th>
				</tr>
				<tr>
					<th style="width: 100px">商品名</th>
					<th style="width: 100px">商品価格</th>
					<th style="width: 100px">購入数</th>
				</tr>
				<s:iterator value="buyItemList">
					<tr>
						<td><s:property value="item_name" /></td>
						<td><s:property value="item_price" />円</td>
						<td><s:property value="item_count" />個</td>
					</tr>
				</s:iterator>
			</table>
			<p class="text-center">
				ご購入ありがとう御座いました。<br />
				またのご利用をお待ちしております。
			</p>
		</jsp:attribute>
	</jsp:param>
</jsp:include>