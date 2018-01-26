<%--
  Created by IntelliJ IDEA.
  User: LeiYh
  Date: 2018/1/10 0010
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
</head>

<body>
<%@include file="title.jsp" %>
<link href="${pageContext.request.contextPath}/resources/css/ZmqEvent.css" rel="stylesheet">
<div class="wrap">
    <!-- 左边内容 -->
    <div id="left" class="left">
        <div id="logoDiv" class="logoDiv">
            <p id="logoTitle" class="logoTitle">
                <span style="font-size:18px;">中国自贸区大事记</span>
            </p>
        </div>
        <div class="menu-item" href="#shanghai" data-toggle="tab" onclick="shanghaiZmqEvents()">
            中国（上海）自贸区
        </div>
        <div class="menu-item" href="#fujian" data-toggle="tab" onclick="fujianZmqEvents()">
            中国（福建）自贸区
        </div>
        <div class="menu-item" href="#guangdong" data-toggle="tab" onclick="guangdongZmqEvents()">
            中国（广东）自贸区
        </div>
        <div class="menu-item" href="#chongqing" data-toggle="tab" onclick="chongqingZmqEvents()">
            中国（重庆）自贸区
        </div>
        <div class="menu-item" href="#henan" data-toggle="tab" onclick="henanZmqEvents()">
            中国（河南）自贸区
        </div>
        <div class="menu-item" href="#hubei" data-toggle="tab" onclick="hubeiZmqEvents()">
            中国（湖北）自贸区
        </div>
        <div class="menu-item" href="#liaoning" data-toggle="tab" onclick="liaoningZmqEvents()">
            中国（辽宁）自贸区
        </div>
        <div class="menu-item" href="#shanxi" data-toggle="tab" onclick="shanxiZmqEvents()">
            中国（陕西）自贸区
        </div>
        <div class="menu-item" href="#sichuan" data-toggle="tab" onclick="sichuanZmqEvents()">
            中国（四川）自贸区
        </div>
        <div class="menu-item" href="#tianjin" data-toggle="tab" onclick="tianjinZmqEvents()">
            中国（天津）自贸区
        </div>
        <div class="menu-item" href="#zhejiang" data-toggle="tab" onclick="henanZmqEvents()">
            中国（浙江）自贸区
        </div>
    </div>
    <!-- 右边内容 -->
    <div id="right" class="tab-content right" >
            <div class="eventBox">
                <ul class="event_year">
                    <li class="current"><label for="2017">2017</label></li>
                    <li><label for="2016">2016</label></li>
                    <li><label for="2015">2015</label></li>
                    <li><label for="2014">2014</label></li>
                    <li><label for="2013">2013</label></li>
                    <li><label for="2012">2012</label></li>
                    <li><label for="2011">2011</label></li>
                    <li><label for="2010">2010</label></li>
                    <li><label for="2009">2009</label></li>
                    <li><label for="2008">2008</label></li>
                    <li><label for="2007">2007</label></li>
                    <li><label for="2006">2006</label></li>
                    <li><label for="2005">2005</label></li>
                </ul>
                <ul class="event_list" id="result">
                </ul>
            </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/ZmqEvent.js"></script>
<script>
    $(function(){
        $('label').click(function(){
            $('.event_year>li').removeClass('current');
            $(this).parent('li').addClass('current');
            var year = $(this).attr('for');
            $('#'+year).parent().prevAll('div').slideUp(800);
            $('#'+year).parent().slideDown(800).nextAll('div').slideDown(800);
        });
        $(".menu-item").click(function() {
            $(".menu-item").removeClass("menu-item-active");
            $(this).addClass("menu-item-active");
        });
    });
</script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.min_v1.0.js" type="text/javascript"></script>
</html>