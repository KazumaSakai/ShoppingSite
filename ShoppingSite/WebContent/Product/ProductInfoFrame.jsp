<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table class="table">
	<tr>
		<th>商品価格</th>
		<td><s:property value="productDTO.productPrice" />円</td>
	</tr>
	<tr>
		<th>取り扱い残量</th>
		<td><s:property value="productDTO.productQuantity" />個</td>
	</tr>
	<tr>
		<th>商品説明</th>
		<td><s:property value="productDTO.productDescription" /></td>
	</tr>
	<tr>
		<th>販売会社</th>
		<td>
			<a href="<s:url action='CompanyInfoAction?companyId=%{ productDTO.salesCompanyId }'/>">
				<s:property value="productDTO.salesCompanyDTO.companyName" />
			</a>
		</td>
	</tr>
	<tr>
		<th>製造会社</th>
		<td>
			<a href="<s:url action='CompanyInfoAction?companyId=%{ productDTO.productionCompanyId }'/>">
				<s:property value="productDTO.productionCompanyDTO.companyName" />
			</a>
		</td>
	</tr>
	<tr>
		<th>発売日</th>
		<td><s:property value="productDTO.releasedDateFormat" /></td>
	</tr>
</table>