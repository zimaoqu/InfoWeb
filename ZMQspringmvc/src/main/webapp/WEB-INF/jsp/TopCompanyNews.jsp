<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/19
  Time: 13:54
  重点企业新闻的展示页面
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="${pageContext.request.contextPath}/resources/css/pagination.css" rel="stylesheet">


    <title>中国自由贸易试验区大数据管理与分析平台</title>

</head>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
    <%
        String industry = request.getAttribute("industry").toString();
    %>

</div>
<div class="row-fluid">

    <div id="left" class="col-xs-8 span8">
        <div class="news">
            <form action="${pageContext.request.contextPath}/zmq/showTopMatchResult">
                <div id="wrapper">
                    <div class="demo">
                        <span id="two-inputs">
                            <div class="one">
                                <input id="date-range200" size="20" class="form-control" name="startDate"
                                       placeholder="起始时间" value="${startDate}">
                            </div>
                            <div class="one">
                                <input id="date-range201" size="20" class="form-control" name="endDate"
                                       placeholder="截止时间" value="${endDate}">
                            </div>
                        </span>

                    </div>
                </div>
                <div class="one" style="margin-left: 50px">
                    <input id="key" name="key" type="text" placeholder="企业名称"
                           class="form-control" value="${key}"/> <span class="input-group-btn">
								<!-- <button class="btn btn-default" type="button">搜索</button> -->
							</span>
                </div>
                <div class="one" style="margin-left: 50px">
                    <select name="industry" id="industry" style="width:200px;height: 35px">
                        "<%=industry%>"
                    </select>
                </div>
                <input type="submit" value="搜索" class="btn btn-default"/>
            </form>
            <br/>
            <div class="content">
                <div id="result">
                </div>
            </div>
            <div id="page" class="pagination">
            </div>
        </div>
        <%--<div class="news">--%>
    </div>

    <div id="right" class="col-xs-3 span3 ">
        <div class="row">
            <div id="graphic1" style="width: 400px;height: 350px;"></div>
        </div>
        <div>
            <div id="graphic2" style="width: 400px;height: 350px;"></div>
        </div>
        <div class="row divfix">
            <div class="wordcloud" style="top:350px; width: 400px;height: 300px;"></div>
        </div>
    </div>

</div>
</body>
<script type="text/javascript">
    var key = $("#key").val();
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
    var industry = $("#industry option:selected").text();
</script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
<%--<script src="${pageContext.request.contextPath}/resources/js/echarts.min.js"></script>--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.16.0/moment.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.daterangepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/demo.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/pagination.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/livesearch/jquery.livesearch.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/TopCompanyNews.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/template/template.js"
        type="text/javascript"></script>
</html>