<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="${item_name }" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h2 class="text-center">商品名</h2>
			<div id="item_slider">
				<div><img src="./Images/jQuery_image1.jpg"/></div>
				<div><img src="./Images/jQuery_image2.jpg"/></div>
			</div>
			<div class="text-center">
				<input type="submit" value="カートに追加する" style="padding: 15px 100px; font-size: 20px;" />
			</div>
			<div style="padding: 10px">
				<h2 class="text-center">詳細</h2>
				<table class="center table" border="1">
				  <tr>
				    <td style="width: 300px">
				      商品価格
				    </td>
				    <td style="width: 500px">
				      120円
				    </td>
				  </tr>
				  <tr>
				    <td>
				      商品説明
				    </td>
				    <td>
				      説明<br />
				      説明<br />
				      説明<br />
				      説明<br />
				      説明<br />
				      説明<br />
				    </td>
				  </tr>
				  <tr>
				    <td>販売会社</td>
				    <td>ＡＢＣ通信販売者</td>
				  </tr>
				  <tr>
				    <td>発売日</td>
				    <td>2019/01/17</td>
				  </tr>
				</table>
			</div>
			<div>
				<h2 class="text-center">レビュー</h2>
			</div>
		</jsp:attribute>
	</jsp:param>
</jsp:include>