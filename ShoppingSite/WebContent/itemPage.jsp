<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="./template.jsp">
	<jsp:param value="${itemDTO.item_name }" name="title"  />
	<jsp:param value="false" name="showSlider"/>
	<jsp:param value="true" name="showSideMenu"/>
	<jsp:param value="true" name="showMain"/>
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h2 class="text-center"><c:out value="${itemDTO.item_name }" /></h2>
			<div id="item_slider">
				<c:forEach begin="1" end="${itemDescriptionDTO.image_num }" step="1" varStatus="status">
					<div><img src="./Images/jQuery_image${status.index }.jpg"/></div>
				</c:forEach>
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
				      <c:out value="${itemDTO.item_price }" />円
				    </td>
				  </tr>
				  <tr>
				    <td>取り扱い残量</td>
				    <td><c:out value="${itemDTO.item_count }" />個</td>
				  </tr>
				  <tr>
				    <td>
				      商品説明
				    </td>
				    <td>
				      <c:out value="${itemDescriptionDTO.description}" />
				    </td>
				  </tr>
				  <tr>
				    <td>販売会社</td>
				    <td><c:out value="${itemDescriptionDTO.seller }"/></td>
				  </tr>
				  <tr>
				    <td>発売日</td>
				    <td><c:out value="${itemDTO.insert_date }" /></td>
				  </tr>
				</table>
			</div>
			<div>
				<h2 class="text-center">レビュー</h2>
				<ul class="reviewList">
					<s:iterator value="itemReviewList">
						<li>
							<h3 class="title">
								<s:property value="title" />
							</h3>
							<p class="comment"/>
								<s:property value="comment" />
							</p>
							<p class="username">
								<s:property value="username" />
							</p>
						</li>
					</s:iterator>
				</ul>
			</div>
			<h2 class="title text-center">レビューを投稿する</h2>
			<form>
			  <table class="text-center center table">
			  	<tr>
			  	  <td style="width:100px">タイトル</td>
			  	  <td style="width:500px"><input/></td>
			  	</tr>
				  <tr>
			  	  <td style="width:100px">タイトル</td>
			  	  <td style="width:500px"><input/></td>
			  	</tr>
			  </table>
			</form>
		</jsp:attribute>
	</jsp:param>
</jsp:include>