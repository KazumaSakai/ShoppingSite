<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="宛先一覧" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>宛先一覧</h1>

		<jsp:include page="../ErrorMsgFrame.jsp" />

		<ul class="destinationList">
			<s:iterator value="destinationDTOList">
				<li>
					<table>
						<tr>
							<th>
								名前
							</th>
							<td>
								<s:property value="familyName" /> <s:property value="firstName" />
							</td>
						</tr>

						<tr>
							<th>
								性別
							</th>
							<td>
								<s:property value="genderString" />
							</td>
						</tr>

						<tr>
							<th>
								住所
							</th>
							<td>
								<s:property value="postalCode" /><br/>
								<s:property value="address" />
							</td>
						</tr>

						<tr>
							<th>
								メールアドレス
							</th>
							<td>
								<s:property value="email" />
							</td>
						</tr>

						<tr>
							<th>
								電話番号
							</th>
							<td>
								<s:property value="phoneNumber" />
							</td>
						</tr>
					</table>
				</li>
			</s:iterator>
		</ul>
	</c:param>
</c:import>