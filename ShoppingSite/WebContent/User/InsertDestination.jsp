<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="宛先登録" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>宛先登録</h1>

		<jsp:include page="../ErrorMsgFrame.jsp" />

		<form action="InsertDestinationAction" method="post">
			<input type="hidden" name="goBuy" value="<s:property value='goBuy'/>" />
			<table class="table center">
				<tr>
					<th>姓</th>
					<td><input type="text" name="familyName" placeholder="姓" required="required" maxlength="100" /></td>
				</tr>
				<tr>
					<th>名</th>
					<td><input type="text" name="firstName" placeholder="名" required="required" maxlength="100" /></td>
				</tr>
				<tr>
					<th>性別</th>
					<td>
						男性 <input type="radio" name="gender" required="required" value="0" />
						女性 <input type="radio" name="gender" required="required" value="1" />
						その他 <input type="radio" name="gender" required="required" value="2" />
					</td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td><input type="text" name="postalCode" placeholder="郵便番号" required="required" maxlength="8" /></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><input type="text" name="address" placeholder="住所" required="required" maxlength="255" /></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><input type="email" name="email" placeholder="メールアドレス" required="required" maxlength="255" /></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><input type="tel" name="phoneNumber" placeholder="電話番号" required="required" maxlength="16"/></td>
				</tr>
			</table>
			<div class="text-center">
				<input class="linkButton" value="宛先を登録" type="submit" />
			</div>
		</form>
	</c:param>
</c:import>