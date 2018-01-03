<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/19
  Time: 13:33
  Function：网站的统一标题栏
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/News.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker.min.css" rel="stylesheet">
    <%--<script src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js"> </script>--%>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/china.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/json2.js" type="text/javascript" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/echarts-wordcloud.min.js"></script>

    <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
    <title>中国自由贸易试验区大数据管理与分析平台</title>
</head>
<style type="text/css">
    #wrapper {
        width: 800px;
        margin: 0 auto;
        color: #333;
        font-family: Tahoma, Verdana, sans-serif;
        line-height: 1.5;
        font-size: 14px;
    }

    .demo {
        margin: 30px 0;
    }

    .date-picker-wrapper .month-wrapper table .day.lalala {
        background-color: orange;
    }

    .options {
        display: none;
        border-left: 6px solid #8ae;
        padding: 10px;
        font-size: 12px;
        line-height: 1.4;
        background-color: #eee;
        border-radius: 4px;
    }

    .date-picker-wrapper.date-range-picker19 .day.first-date-selected {
        background-color: red !important;
    }

    .date-picker-wrapper.date-range-picker19 .day.last-date-selected {
        background-color: orange !important;
    }
</style>
<body>

<div class="row-fluid">
    <div class="span12">
        <h1 class="text-center" >
            中国自由贸易试验区大数据管理与分析平台
            <small>V1.0</small>
        </h1>
    </div>
</div>
<br/>

<div id="menu" style="margin-left: auto; margin-right: auto; width: 1100px;">
    <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/zmq/showHome">首页</a>
        </div>
        <div>
            <ul class="nav navbar-nav">

                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                        data-toggle="dropdown"> 企业新闻推送 <b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/zmq/showTopCompanyNews">重中之重企业新闻</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showCompanyNews">重点企业新闻推送</a></li>
                    </ul></li>

                <li class="dropdown"><a href="/InfoWeb/relTendency" class="dropdown-toggle"
                                        data-toggle="dropdown"> 企业态势分析 <b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/zmq/showAbnormalWarning">企业异常预警</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showAbnormalComWarning">企业异动预警</a></li>
                        <%--<li><a href="${pageContext.request.contextPath}/zmq/showTopAbnormalComWarning">重点企业预警</a></li>--%>
                        <li><a href="${pageContext.request.contextPath}/zmq/showComKeyEvents">企业重点事件预警</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showComCreditScore">企业信用评估</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showComPublicOpinionEvaluation">企业舆情评价</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showComHealthTendency">企业健康态势</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showComReputationAnalysis">企业声誉分析</a></li>
                    </ul></li>

                <li class="dropdown"><a href="" class="dropdown-toggle"
                                        data-toggle="dropdown"> 企业事件分析 <b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/zmq/showEventRelationship">企业事件分析</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showHistoricalEvolution">企业热点事件链</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showDeduplicationNews">企业新闻链</a></li>
                    </ul>
                </li>


                <li class="dropdown"><a href="" class="dropdown-toggle"
                                        data-toggle="dropdown"> 企业关联分析 <b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/zmq/showPotentialRelationship">潜在关系</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showCompanyRelationship">企业关系网</a></li>
                        <li><a href="http://139.224.199.170:7474" target="Blank">关系图数据库</a></li>
                    </ul>
                </li>

                <li class="dropdown"><a href="" class="dropdown-toggle"
                                        data-toggle="dropdown"> 自贸区数据与分析 <b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/zmq/showZmqIndex">自贸区热度趋势</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showZmqPolicy">自贸区政策推送</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showSHZmqNews">上海自贸区新闻</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showOtherZmqNews">其他自贸区新闻</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showSHZmqPublicOpinionEvaluation">上海自贸区舆情评价</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showSHZmqHealthTendency">上海自贸区健康态势</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showZmqCompare">自贸区对比</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/showThirdPartyData">第三方数据</a></li>

                    </ul>
                </li>

                <li class="dropdown"><a href="" class="dropdown-toggle"
                                        data-toggle="dropdown"> 行业数据与分析 <b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/zmq/showIndustryNews">重点行业新闻</a></li>
                        <li><a href="#">第三方数据</a></li>
                        <li><a href="#">行业态势分析</a></li>
                    </ul>
                </li>

                <li class="dropdown"><a href="" class="dropdown-toggle"
                                        data-toggle="dropdown"> 国家级数据与分析 <b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/zmq/showPolicyNews">政策新闻推送</a></li>
                        <%--<li><a href="${pageContext.request.contextPath}/zmq/queryKeyByFlag?flag=1">关键指标监控</a></li>--%>
                        <li><a href="${pageContext.request.contextPath}/zmq/keyIndicateInit">关键指标监控</a></li>
                        <li><a href="${pageContext.request.contextPath}/zmq/IndexCorrelationAnalysis">指标关联分析</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
</div>

<%--<script type="text/javascript">--%>
    <%--window.onload = function(){--%>
        <%--var config = {--%>
            <%--vx: 4,--%>
            <%--vy:  4,--%>
            <%--height: 2,--%>
            <%--width: 2,--%>
            <%--count: 100,--%>
            <%--color: "121, 162, 185",--%>
            <%--stroke: "100,200,180",--%>
            <%--dist: 6000,--%>
            <%--e_dist: 20000,--%>
            <%--max_conn: 10--%>
        <%--}--%>
        <%--CanvasParticle(config);--%>
    <%--}--%>
<%--</script>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/canvas-particle.js"></script>--%>
</body>

</html>
