<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../template.jsp">
	<jsp:param value="商品リスト" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>商品リスト</h1>
			<jsp:include page="./itemListTable.jsp" />
			<s:if test="session.isAdmin == true">
				<div class="center" style="border: solid 1px black; margin: 20px 10px">
					<h2 class="text-center">管理者用 商品追加フォーム</h2>
					<form name="AdminAddItemAction" action="/ShoppingSite/AdminAddItemAction.action" method="post" class="form">
						<table class="center">
							<tr>
								<td style="text-align: left">商品名</td>
								<td style="text-align: left"><input type="text" name="name" /></td>
							</tr>
							<tr>
								<td style="text-align: left">商品価格</td>
								<td style="text-align: left"><input type="number" name="price" /> 円</td>
							</tr>
							<tr>
								<td style="text-align: left">販売個数</td>
								<td style="text-align: left"><input type="number" name="quantity" /> 個</td>
							</tr>
							<tr>
								<td style="text-align: left">販売者ID</td>
								<td style="text-align: left"><input type="number" name="seller" /></td>
							</tr>
							<tr>
								<td style="text-align: left">画像数</td>
								<td style="text-align: left"><input type="number" name="image_num" /></td>
							</tr>
							<tr>
								<td style="text-align: left">説明</td>
								<td style="text-align: left"><textarea name="description" style="width: 300px; height: 100px"></textarea>
							</tr>
							<tr>
								<td colspan="2" class="text-center" ><input type="submit" value="商品を追加する"/></td>
							</tr>
						</table>
					</form>
				</div>
			</s:if>
		</jsp:attribute>
	</jsp:param>
</jsp:include>