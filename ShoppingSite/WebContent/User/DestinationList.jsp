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

			<ul>
				<s:iterator value="destinationDTOList">
					<li style="border: 1px solid black">
						<ul>
							<li>
								<s:property value="familyName" />
							</li>
							<li>
								<s:property value="firstName" />
							</li>
							<li>
								<s:property value="gender" />
							</li>
							<li>
								<s:property value="postalCode" />
							</li>
							<li>
								<s:property value="address" />
							</li>
							<li>
								<s:property value="email" />
							</li>
							<li>
								<s:property value="phoneNumber" />
							</li>
						</ul>
					</li>
				</s:iterator>
			</ul>

		</jsp:attribute>
	</jsp:param>
</jsp:include>