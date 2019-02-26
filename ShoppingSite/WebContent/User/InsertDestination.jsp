<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../template.jsp">
	<jsp:param value="住所を追加" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">
			<h1>住所を追加</h1>

			<jsp:include page="../ErrorMsgFrame.jsp" />

			<form action="InsertDestinationAction" method="post">
				<input type="hidden" name="goBuy" value="<s:property value='goBuy'/>" />
				<table class="table center" cellspacing="0">
					<tr>
						<th>姓</th>
						<td><input type="text" name="familyName" required="required" min="10" max="100" /></td>
					</tr>
					<tr>
						<th>名</th>
						<td><input type="text" name="firstName" required="required" min="10" max="100" /></td>
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
						<td><input type="text" name="postalCode" required="required" min="10" max="100" /></td>
					</tr>
					<tr>
						<th>住所</th>
						<td><input type="text" name="address" required="required" min="10" max="100" /></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="text" name="email" required="required" min="10" max="100" /></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><input type="text" name="phoneNumber" required="required" min="10" max="100" /></td>
					</tr>
				</table>
				<div class="text-center">
					<input class="linkButton" value="宛先を登録" type="submit" />
				</div>
			</form>

		</jsp:attribute>
	</jsp:param>
</jsp:include>