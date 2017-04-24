<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/21
  Time: 21:12
  企业事件分析
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="${pageContext.request.contextPath}/resources/css/chinaz.css" rel="stylesheet">

</head>


<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>

    <div class="wrapper">
        <div class="history">
            <div class="start-history">
                <p class="cc_history">三星爆炸发展始末</p>
                <p class="next_history">PHYLOGENY</p>
                <div class="history_left">
                    <p class="history_L year2006">
                        <span class="history_2006_span">2016</span>
                        <b class="history_2006_b">
                            <span class="history_l_month">8<br/>月</span>
                            <span class="history_l_text">充电发生爆炸<br/></span>
                        </b>
                    </p>
                    <p class="history_L yearalmost">
                        <span class="history_2006_span">2016</span>
                        <b class="history_2006_b">
                            <span class="history_l_month">9<br/>月</span>
                            <span class="history_l_text">海航禁止携带该手机</span>
                        </b>
                    </p>
                    <p class="history_L year2009">
                        <span class="history_2006_span">2016</span>
                        <b class="history_2006_b">
                            <span class="history_l_month">9<br/>月</span>
                            <span class="history_l_text">韩国启动换机计划</span>
                        </b>
                    </p>
                    <p class="history_L yearalmost">
                        <span class="history_2006_span blue">2016</span>
                        <b class="history_2006_b blue">
                            <span class="history_l_month">10<br/>月</span>
                            <span class="history_l_text">三星停售该机</span>
                        </b>
                    </p>

                </div>
                <div class="history-img">
                    <img class="history_img" src="${pageContext.request.contextPath}/resources/images/history.png" alt="">
                </div>
                <div class="history_right">
                    <p class="history_R history_r_2005">
                        <span class="history_2005_span">2016</span>
                        <b class="history_2005_b">
                            <span class="history_r_month">8<br/>月</span>
                            <span class="history_r_text">三星note7正式发布</span>
                        </b>
                    </p>
                    <p class="history_R yearalmostr">
                        <span class="history_2005_span">2016</span>
                        <b class="history_2005_b">
                            <span class="history_r_month">9<br/>月</span>
                            <span class="history_r_text">宣布召回手机<br/></span>
                        </b>
                    </p>
                    <p class="history_R yearalmostr">
                        <span class="history_2005_span">2016</span>
                        <b class="history_2005_b">
                            <span class="history_r_month">10<br/>月</span>
                            <span class="history_r_text">美国市场发生爆炸70多起<br/></span>
                        </b>
                    </p>
                    <p class="history_R yearalmostr">
                        <span class="history_2005_span">2016</span>
                        <b class="history_2005_b">
                            <span class="history_r_month">10<br/>月</span>
                            <span class="history_r_text">更换后的手机发生自燃</span>
                        </b>
                    </p>
                    <p class="history_R yearalmostr">
                        <span class="history_2005_span blue">2016</span>
                        <b class="history_2005_b blue_R">
                            <span class="history_r_month">10<br/>月</span>
                            <span class="history_r_text">三星在中国召回手机</span>
                        </b>
                    </p>

                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/jquery.slidy.js"></script>
    <script>
        $(window).scroll(function(){
            var msg = $(".history-img");
            var item = $(".history_L");
            var items = $(".history_R");
            var windowHeight = $(window).height();
            var Scroll = $(document).scrollTop();
            if((msg.offset().top - Scroll -windowHeight)<=0){
                msg.fadeIn(1500);
            }
            for(var i=0;i<item.length;i++){
                if(($(item[i]).offset().top - Scroll - windowHeight)<= -100){
                    $(item[i]).animate({marginRight:'0px'},'50','swing');
                }
            }
            for(var i=0;i<items.length;i++){
                if(($(items[i]).offset().top - Scroll - windowHeight)<= -100){
                    $(items[i]).animate({marginLeft:'0px'},'50','swing');
                }
            }});

    </script>
</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.easing.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/feedback.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pageresponse.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resourcesjs/jquery.easing.js"></script>
</html>