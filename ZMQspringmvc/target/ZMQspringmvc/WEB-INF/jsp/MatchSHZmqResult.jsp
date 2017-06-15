<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/22
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="${pageContext.request.contextPath}/resources/css/pagination.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/pagination.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/livesearch/jquery.livesearch.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/zmqjs/MatchSHZmqResult.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/template/template.js"
            type="text/javascript"></script>

    <title>中国自由贸易试验区大数据管理与分析平台</title>

</head>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>

</div>
<div class="row-fluid">
    <div class="col-xs-8 span8">
        <div class="news">
            <form action="${pageContext.request.contextPath}/zmq/showMatchResult">
                <div id="wrapper">
                    <div class="demo">
                        <span id="two-inputs">
                            <div class="one">
                                <input id="date-range200" size="20" class="form-control" name="startDate" placeholder="起始时间" value="${startDate}">
                            </div>
                            <div class="one">
                                <input id="date-range201" size="20" class="form-control" name="endDate" placeholder="截止时间" value="${endDate}">
                            </div>
                        </span>

                    </div>

                </div>
                <input type="submit" value="搜索" class="btn btn-default"/>
            </form>
            <br/>
            <div class="content">
                <div id="result">
                    <!--  <div>
                         <div id="title"><h3>
                             <li><a></a></li></h3>
                         </div>
                         <div id="abstract">
                           <span></span>
                         </div>
                     </div> -->
                </div>
            </div>
            <div id="page" class="pagination">
            </div>
        </div>
        <%--<div class="news">--%>
    </div>
    <div id="right" class="col-xs-3 span3 ">
        <div class="row divfix">
            <div class="wordcloud" style="top:350px; width: 400px;height: 300px;"></div>
        </div>
    </div>

</div>
</body>
<script type="text/javascript">
    var ctx = "${pageContext.request.contextPath}";
    var startDate = $("input[name='startDate']").val();
    var endDate = $("input[name='endDate']").val();
</script>
<script id="rslt" type="text/html">

    {{each resultList as hit i}}
    <h3>
        <b><font size="4">{{hit.title}}
        </font></b>
    </h3>
    <p>
        {{hit.date}}
    </p>
    <p>
        {{hit.description}}
    </p>
    <p>
        <a class="btn btn-default" href={{hit.url}} target="_blank">原文»</a>
        &nbsp;<font color="blue">{{hit.name}}</font>
    </p>
    {{/each}}
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.16.0/moment.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.daterangepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/demo.js"></script>
</html>


