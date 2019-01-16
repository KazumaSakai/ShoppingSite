<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta http-equiv="Content-Ttype" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="style.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script>
      $(document).ready(function(){
        $('#top_slider').bxSlider({
          auto: true,
          speed: 700,
          pause: 5000
        });
      });
    </script>

    <title>${param.title}</title>
  </head>
  <body>
    <header>
        <p id="site_title">ShoppingSite</p>
        <ul id="main_menu">
          <li><a href='<s:url action="GoHomeAction"/>'>ホーム</a>
          <c:if test="${session.isLogin != true }">
          	<li><a href='<s:url action="GoLoginAction"/>'>ログイン</a>
          </c:if>
          <c:if test="${session.isLogin == true }">
          	<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a>
          </c:if>
        </ul>
        <c:if test="${param.showSlider == true }">
        <div id="header_under">
          <div id="top_slider">
            <div><img src="./Images/jQuery_image1.jpg"></div>
            <div><img src="./Images/jQuery_image2.jpg"></div>
            <div><img src="./Images/jQuery_image3.jpg"></div>
            <div><img src="./Images/jQuery_image4.jpg"></div>
            <div><img src="./Images/jQuery_image5.jpg"></div>
          </div>
        </div>
        </c:if>
    </header>
    <main>
      <c:if test="${param.showSideMenu == true }">
      <div id="left">
        <div class="boxarea">
          <div class="article">
			${param.content}
          </div>
        </div>
      </div>
      <div id="right">
        <div class="boxarea">
        </div>
      </div>
      </c:if>
      <c:if  test="${param.showSideMenu == false }">
      <div id="left_max">
        <div class="boxarea">
          <div class="article">
			${param.content}
          </div>
        </div>
      </div>
      </c:if>
    </main>
    <footer>
          copyright © internous | 4each blog is the one which provides A to Z about programming.
    </footer>
  </body>
</html>