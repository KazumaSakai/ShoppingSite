<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="successMsg != null && !successMsg.isEmpty()">
	<div class="sucessBox">
		<p>メッセージ</p>
		<s:property value="successMsg" escape="false" />
	</div>
</s:if>