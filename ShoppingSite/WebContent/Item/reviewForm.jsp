<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="PostItemReviewAction" method="post">
	<input type="hidden" name="id" value="<c:out value='${itemDTO.item_id }' />" />
	<table class="table">
		<tr>
			<th>タイトル</<th>
			<td><input name="title" type="text" required="required" /></td>
		</tr>
		<tr>
			<th>評価</<th>
			<td>
				<select name="point" required="required">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5" selected>5</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>コメント</th>
			<td><textarea name="comment" required="required"></textarea></td>
		</tr>
	</table>
</form>
<div class="text-center">
	<input class="linkButton"  type="submit" value="送信"/>
</div>
