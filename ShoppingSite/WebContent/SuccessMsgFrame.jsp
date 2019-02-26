<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="successMsgList != null && !successMsgList.isEmpty()">
	<div class="successBox">
		<p>メッセージ</p>
		<s:iterator value="successMsgList">
			<p><s:property escape="false" /></p>
		</s:iterator>
	</div>
</s:if>