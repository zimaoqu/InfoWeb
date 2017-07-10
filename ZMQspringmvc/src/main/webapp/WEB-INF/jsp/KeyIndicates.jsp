<%--
  Created by IntelliJ IDEA.
  User: Vikun
  Date: 2017/7/6
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>关键指标监控</title>


</head>
<style>
    .echart_container1 {
        height: 400px;
        /*position: absolute;*/
        left: 5%;
        width: 49%;
        margin-bottom: 20px;

    }

    .echart_container2 {
        display: block;
        height: 400px;
        /*position: absolute;*/
        width: 49%;
        margin-top: -421px;
        margin-bottom: 20px;
        float: right;
    }
    .echart_container3 {
        height: 400px;
        /*position: absolute;*/
        width: 90%;
        left: 5%;
        margin-bottom: 20px;

    }


</style>
<body>
    <div class="container-fluid">
        <br/>
        <%@include file="title.jsp" %>
        <br/>
    </div>
    <div id="graphicGDPCountry" class="echart_container1"></div>
    <div id="graphicGDPSH" class="echart_container2"></div>
    <div id="graphicPPIandCPI" class="echart_container3"  ></div>
    <div id="graphicExportImport" class="echart_container3"></div>
    <div id="graphicBDI" class="echart_container3"></div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesGDPCountry.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesGDPSH.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesPPI.js" type="text/javascript"></script>

<%--<script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesCPI.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesExportImport.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesBDI.js" type="text/javascript"></script>
</html>
