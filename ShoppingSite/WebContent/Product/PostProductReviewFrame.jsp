<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="PostProductReviewAction" method="post">
	<input type="hidden" name="productId" value="<c:out value='${productDTO.id }' />" />
	<table class="table">
		<tr>
			<th>
				タイトル
			</th>
			<td>
				<input name="reviewTitle" type="text" required="required" />
			</td>
		</tr>
		<tr>
			<th>
				評価
			</th>
			<td>
				<select name="reviewPoint" required="required">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5" selected>5</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>
				コメント
			</th>
			<td>
				<textarea name="reviewComment" required="required"></textarea>
			</td>
		</tr>
	</table>
	<div class="text-center">
		<input class="linkButton"  type="submit" value="送信"/>
	</div>
</form>
