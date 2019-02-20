<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta http-equiv="Content-Ttype" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/ShoppingSite/style.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<script src="https://d3js.org/d3.v5.min.js" charset="utf-8"></script>
	<script>
		$(document).ready(function() {
			$('#top_slider').bxSlider({
				auto : true,
				speed : 700,
				pause : 5000
			});
			$('#item_slider').bxSlider({
				auto : true,
				speed : 700,
				pause : 5000
			});
		});
	</script>
	<title>${ param.title }</title>
</head>
<body>
	<header>
		<p id="site_title">ShoppingSite</p>
		<ul id="main_menu">
			<li><a href='<s:url action="GoHomeAction"/>'>ホーム</a></li>
			<li><a href='<s:url action="ItemListAction"/>'>商品リスト</a></li>
			<s:if test="#session.isLogin">
				<li>
					<ul class="dropDownMenu">
						<li><s:property value="#session.user_name" escape="false" /></li>
						<li><a href='<s:url action="GoUserPageAction"/>'>ユーザーページ</a></li>
						<li><a href='<s:url action="MyCartAction"/>'>マイカート</a></li>
						<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
					</ul>
				</li>
			</s:if>
			<s:else>
				<li>
					<ul class="dropDownMenu">
						<li>ログイン</li>
						<li><a href='/ShoppingSite/GoLoginAction.action'>ログイン</a></li>
						<li><a href='<s:url action="GoSignUpAction"/>'>新規会員登録</a></li>
					</ul>
				</li>
			</s:else>
		</ul>
	</header>

	<c:if test="${ param.showSlider }">
		<div id="top_slider">
			<div>
				<img src="http://localhost:8080/ShoppingSite/Images/jQuery_image1.jpg">
			</div>
			<div>
				<img src="http://localhost:8080/ShoppingSite/Images/jQuery_image2.jpg">
			</div>
			<div>
				<img src="http://localhost:8080/ShoppingSite/Images/jQuery_image3.jpg">
			</div>
			<div>
				<img src="http://localhost:8080/ShoppingSite/Images/jQuery_image4.jpg">
			</div>
			<div>
				<img src="http://localhost:8080/ShoppingSite/Images/jQuery_image5.jpg">
			</div>
		</div>
	</c:if>

	<c:if test="${ param.showMain }">
		<div id="main">
			<c:if test="${ param.showSideMenu }">
				<div id="left">
					<div class="boxarea">
						<div class="article">
							${ param.content }
						</div>
					</div>
				</div>
				<div id="right">
					<div class="boxarea">
						<h2>制作物</h2>
						<ul class="side_menu">
							<li><a href='<s:url action="GoSortAction"/>'>ソート可視化 JavaScript Canvas</a></li>
						</ul>
					</div>
				</div>
			</c:if>
			<c:if test="${ !param.showSideMenu }">
				<div id="left_max">
					<div class="boxarea">
						<div class="article">
							${ param.content }
						</div>
					</div>
				</div>
			</c:if>
		</div>
	</c:if>
	<footer> copyright © internous | 4each blog is the one which
		provides A to Z about programming. </footer>
</body>
</html>