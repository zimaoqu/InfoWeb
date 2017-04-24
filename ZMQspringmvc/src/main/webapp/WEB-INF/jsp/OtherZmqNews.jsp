<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/22
  Time: 16:53
  To change this template use File | Settings | File Templates.
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

</div>
<div class="row-fluid">
    <div class="col-xs-8 span8">
        <div class="news">
            <form action="${pageContext.request.contextPath}/zmq/showMatchOtherZmqResult">
                <div class="one">
                    初始日期：
                    <div class="input-group date form_date col-md-16" data-date=""
                         data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
                         data-link-format="yyyy-mm-dd">

                        <input id="startDate" class="form-control" size="16" type="text" name="startDate" value="">
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
                <div class="one">
                    终止日期：
                    <div class="input-group date form_date col-md-16" data-date=""
                         data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
                         data-link-format="yyyy-mm-dd">
                        <input id = "endDate" class="form-control" size="16" type="text" name="endDate" value="">
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
                <script type="text/javascript">
                    $('.form_date').datetimepicker({
                        weekStart: 1,
                        todayBtn: 1,
                        autoclose: 1,
                        todayHighlight: 1,
                        startView: 2,
                        minView: 2,
                        forceParse: 0
                    });
                </script>
                <%--<div class="three">--%>
                <%--<p>--%>
                <%--<input type="submit" value="GO"/>--%>
                <%--</p>--%>
                <%--</div>--%>

                <br/>
                <div class="col-lg-4">
                    <div class="input-group">
                        <input id="key" name="key" type="text" placeholder="自贸区名称"
                               class="form-control" value="${key}"/> <span class="input-group-btn">
								<!-- <button class="btn btn-default" type="button">搜索</button> -->
							</span>
                    </div>
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

</div>
</body>
<script type="text/javascript">
    var ctx = "http://localhost:8080";
    var key = $("#key").val();
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
</script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/pagination.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/livesearch/jquery.livesearch.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/OtherZmqNews.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/template/template.js"
        type="text/javascript"></script>
</html>
