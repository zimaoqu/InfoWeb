<%--
  Created by IntelliJ IDEA.
  User: CHZhao
  Date: 2018/1/3
  Time: 下午4:49
  指标关联分析页面.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>指标关联分析</title>



</head>
<style>
    .menu{
        height: 500px;
        /*position: absolute;*/
        width: 18%;
        margin-bottom: 20px;
        margin-left: 20px;
        margin-top: 30px;
        float: left;

    }

    .echart_container{
        display: block;
        height: 500px;
        /*position: absolute;*/
        width: 100%;
        margin-bottom: 20px;
    }
    .echart_container1{
        height: 500px;
        /*position: absolute;*/
        width: 80%;
        margin-bottom: 20px;
        margin-left: 10%;
        margin-right: 10%;
    }

    .echart_container2 {
        display: block;
        height: 500px;
        /*position: absolute;*/
        width: 80%;
        margin-bottom: 20px;
        margin-left: 10%;
        margin-right: 10%;
    }

    .echart_container3 {
        display: block;
        height: 500px;
        /*position: absolute;*/
        width: 80%;
        margin-bottom: 20px;
        margin-left: 10%;
        margin-right: 10%;
    }



</style>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
</div>
<div  class="row-fluid">
</div>
<div class="echart_container">
    <div id="l1" style="display: block">
        <div id="graphicPMI" class="echart_container1" ></div>
    </div>
    <div id="l2" style="display: block">
        <div id="graphicPPI" class="echart_container2" ></div>
    </div>
    <div id="l3" style="display: block">
        <div id="graphic" class="echart_container3" ></div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/resources/js/echarts3.8.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/IndexCorrelationAnalysis.js" type="text/javascript"></script>
</body>
</html>
