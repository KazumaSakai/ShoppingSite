<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="errorMsg != null">
	<div class="errorBox">
		<p>エラーメッセージ</p>
		<s:property value="errorMsg" escape="false" />
	</div>
</s:if>