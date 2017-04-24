<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/23
  Time: 21:45
  政策新闻推送
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
    <div class="col-xs-2 span2">
        <div class="btn-group-vertical policy_right" role="group"
             aria-label="...">
            <button type="button" id="custom"
                    class="btn policy_btn"
                    onclick="getByCategory('hg')">
                海关
            </button>
            <button type="button" id="bussiness"
                    class="btn policy_btn"
                    onclick="getByCategory('sw')">
                商务
            </button>
            <button type="button" id="tax"
                    class="btn policy_btn"
                    onclick="getByCategory('shuiw')">
                税务
            </button>
            <button type="button" id="industry"
                    class="btn policy_btn"
                    onclick="getByCategory('gs')">
                工商
            </button>
            <button type="button" id="quality"
                    class="btn policy_btn"
                    onclick="getByCategory('zljd')">
                质量监督
            </button>
        </div>
    </div>
    <div class="col-xs-10 span10">
        <div class="news1">
            <div class="one">
                初始日期：
                <div class="input-group date form_date col-md-16" data-date=""
                     data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
                     data-link-format="yyyy-mm-dd">

                    <input id="startDate" class="form-control" size="16" type="text" name="startDate"
                           value="">
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
                    <input id="endDate" class="form-control" size="16" type="text" name="endDate" value="">
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
            <input id="cat" value="" style="display: none;"/>
            <br/>
            <input type="button" value="搜索" class="btn btn-default" onclick="getPolicyByCondition()"/>
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
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/pagination.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/livesearch/jquery.livesearch.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/PolicyNews.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/PolicyNewsByCat.js" type="text/javascript"></script>
<<script src="${pageContext.request.contextPath}/resources/js/zmqjs/PolicyNewsByCon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/template/template.js"
        type="text/javascript"></script>
</html>
