<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:import url="../template.jsp">
	<c:param value="ユーザー一覧" name="title" />
	<c:param value="false" name="showSlider" />
	<c:param value="true" name="showSideMenu" />
	<c:param value="true" name="showMain" />
	<c:param name="content">
		<h1>ユーザー一覧</h1>
		<ul class="verticalItemList">
			<s:iterator value="userList">
				<li>
					<div class="left">
						<div>
							<a href="<s:url action='UserAction?userId=%{id}' />">
								<s:property value="userName" />
							</a>
						</div>
					</div>
					<div class="right">
						<div>
							<table>
								<tr>
									<th>
										権限
									</th>
									<td>
										<s:if test="admin">
											<span style="color: red">管理者</span>
										</s:if>
										<s:else>
											ユーザー
										</s:else>
									</td>
								</tr>
								<tr>
									<th>
										登録日
									</th>
									<td>
										<s:property value="%{ registeredDateFormat }" />
									</td>
								</tr>
							</table>
						</div>
					</div>
					<s:if test="!admin">
						<div class="button" style="top: -6px; right: -6px" onclick="location.href='<s:url action='AdminDeleteUserAction?userId=%{ id }'/>'">
							<div class="cross"></div>
						</div>
					</s:if>
				</li>
			</s:iterator>
		</ul>
		
		<ul class="pager">
			<s:iterator value="pager" var="v">
			<c:if test="${ (page + 1) == v }"> 
				<li class="disable">
					<s:property value="v" />
				</li>
			</c:if>
			<c:if test="${ (page + 1) != v }">
				<li onclick="location.href='<s:url action="AdminUserListAction"><s:param name="page" value="v" /></s:url>'">
					<s:property value="v" />
				</li>
			</c:if>
			</s:iterator>
		</ul>
		
	</c:param>
</c:import>
