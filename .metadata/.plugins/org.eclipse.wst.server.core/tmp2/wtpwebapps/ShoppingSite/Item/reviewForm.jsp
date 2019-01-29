<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="PostItemReviewAction">
	<input type="hidden" name="item_id"
		value="<c:out value='${itemDTO.item_id }' />" />
	<table class="table">
		<tr>
			<th colspan="2" style="font-size: 23px">レビューを投稿する</th>
		</tr>
		<tr>
			<td>タイトル</td>
			<td><input name="title" type="text" required="required" /></td>
		</tr>
		<tr>
			<td>評価</td>
			<td><select name="point" required="required">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5" selected>5</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="2">コメント <textarea name="comment"
					required="required"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="text-center"><input type="submit"
				value="送信" /></td>
		</tr>
	</table>
</form>
