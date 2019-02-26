<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="errorMsgList != null && !errorMsgList.isEmpty()">
	<div class="errorBox">
		<p>エラーメッセージ</p>
		<s:iterator value="errorMsgList">
			<p><s:property escape="false" /></p>
		</s:iterator>
	</div>
</s:if>