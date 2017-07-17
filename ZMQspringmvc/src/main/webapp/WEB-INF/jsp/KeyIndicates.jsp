<%--
  Created by IntelliJ IDEA.
  User: Vikun
  Date: 2017/7/6
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.scorpion.pojo.bignews" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>关键指标监控</title>


</head>
<style>
    .echart_container1{
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
        position: absolute;
        width: 90%;
        left: 5%;
        margin-bottom: 20px;

    }


</style>
<%

    //    List<String> nameList =(ArrayList<String>)request.getAttribute("nameList");
//    List<String> numList=(ArrayList<String>)request.getAttribute("numList");
//    List<String> numList1=(ArrayList<String>)request.getAttribute("numList1");
    String flag=request.getAttribute("flag")!=null?request.getAttribute("flag").toString():"4";

%>
<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
</div>
<div>
    <div  class="row-fluid">
               <span style="font-size:20px;">
                指标：
                    <select name="selectKeyIndicate" id="selectKeyIndicate" onchange="change(this)"  style="width:200px;">
                        <option value="1">国内生产总值(GDP)&&国内生产总值</option>
                        <option value="2">工业生产者出厂价格指数(PPI)&&居民消费价格指数(CPI)</option>
                        <option value="3">进出口总额</option>
                        <option value="4">波罗的海干散货指数(BDI)</option>
                    </select>
                    <button id="subcom">提交</button>
                </span>
        <div>
            <%
                if(flag.equals("1")){
            %>

            <div id="graphicGDPCountry" class="echart_container1"></div>
            <div id="graphicGDPSH" class="echart_container2"></div>
            <script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesGDPCountry.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesGDPSH.js" type="text/javascript"></script>
            <%
            }else if(flag.equals("2")){
            %>

            <div id="graphicPPIandCPI" class="echart_container3" ></div>
            <script id="s3" src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesPPI.js" type="text/javascript"></script>

            <%
            }else if(flag.equals("3")){
            %>
            <div id="graphicExportImport" class="echart_container3"></div>
            <script id="s4" src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesExportImport.js" type="text/javascript"></script>
            <%
            }else if(flag.equals("4")){
            %>
            <div id="graphicBDI" class="echart_container3" ></div>
            <script id="s5" src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesBDI.js" type="text/javascript"></script>
            <%
                }

            %>
        </div>
    </div>



</body>
<script type="text/javascript">
    $("#subcom").click(function () {
        flag = $("#selectKeyIndicate option:selected").val()

        req = "${pageContext.request.contextPath}/zmq/queryKeyByFlag?flag=" +flag
        $.post(req,
            {
                //companyname:tmp
            },
            function () {
                location.href = "${pageContext.request.contextPath}/zmq/queryKeyByFlag?flag=" + flag
            });
    });
</script>

<%--<script id="s2" src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesGDPSH.js" type="text/javascript"></script>--%>
<%--<script id="s3" src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesPPI.js" type="text/javascript"></script>--%>

<%--&lt;%&ndash;<script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesCPI.js" type="text/javascript"></script>&ndash;%&gt;--%>
<%--<script id="s4" src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesExportImport.js" type="text/javascript"></script>--%>
<%--<script id="s5" src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesBDI.js" type="text/javascript"></script>--%>
</html>
