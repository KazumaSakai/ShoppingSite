<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="../template.jsp">
	<jsp:param value="${itemDTO.item_name }" name="title" />
	<jsp:param value="false" name="showSlider" />
	<jsp:param value="true" name="showSideMenu" />
	<jsp:param value="true" name="showMain" />
	<jsp:param name="content">
		<jsp:attribute name="value">

			<s:if test="#session.isAdmin">
				<div style="margin: 0px auto; max-width: 800px">

					<div class="tab" index="0">
						<div name="商品情報変更">
							<jsp:include page="../Admin/itemUpdateForm.jsp" />
						</div>
						<div name="商品画像">
							<jsp:include page="../Admin/itemUpdateForm.jsp" />
						</div>
						<div name="商品在庫追加">
							<jsp:include page="../Admin/itemUpdateForm.jsp" />
						</div>
						<div name="商品統計">
							<jsp:include page="../Admin/itemUpdateForm.jsp" />
						</div>
					</div>

				</div>
			</s:if>

		</jsp:attribute>
	</jsp:param>
</jsp:include>