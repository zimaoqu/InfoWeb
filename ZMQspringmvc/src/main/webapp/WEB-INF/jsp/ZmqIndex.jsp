<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/22 0022
  Time: 18:57
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
<style>
    .echart_container1 {
        width: 1320px;
        height: 600px;
        float: left;
        display: inline
    }

    .divcss {
        margin-left: auto;
        margin-right: auto;
        width: 1320px;
    }

    .indexSum{
        width:1320px;
        height:300px;
    }
</style>

<body>
<br/>
<%@include file="title.jsp" %>
<br/><br/><br/>

<div class="divcss">
    <div id="indexSum" class="indexSum">
        <fieldset>
            <legend>指数概况</legend>
            <div>
                <ul id="myTab" class="nav nav-tabs">
                    <li class="active">
                        <a href="#last7days" onclick="changedate1()" data-toggle="tab">
                            近7天
                        </a>
                    </li>
                    <li><a href="#last30days" onclick="changedate2()" data-toggle="tab">近30天</a></li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="last7days">
                        <br/>
                        <from action="">
                            <div class="btn-group" style="float: left">
                                <button type="button" class="btn btn-default dropdown-toggle"data-toggle="dropdown">
                                    上海自贸区 <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">河南自贸区</a></li>
                                    <li><a href="#">福建自贸区</a></li>
                                    <li><a href="#">浙江自贸区</a></li>
                                    <li><a href="#">广东自贸区</a></li>
                                    <li><a href="#">四川自贸区</a></li>
                                    <li><a href="#">陕西自贸区</a></li>
                                    <li><a href="#">湖北自贸区</a></li>
                                    <li><a href="#">辽宁自贸区</a></li>
                                    <li><a href="#">重庆自贸区</a></li>
                                    <li><a href="#">天津自贸区</a></li>
                                    <li><a href="#">浙江自贸区</a></li>
                                </ul>
                            </div>
                            <div style="float: left;margin-left: 200px">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>整体搜索指数</th>
                                    <th>移动搜索指数</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>123</td>
                                        <td>456</td>
                                    </tr>
                                </tbody>
                            </table>
                            </div>
                            <div style="float: left;margin-left: 200px">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>整体环比</th>
                                        <th>整体同比</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>123</td>
                                        <td>456</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div style="float: left;margin-left: 200px">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>移动同比</th>
                                        <th>移动环比</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>123</td>
                                        <td>456</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </from>
                    </div>
                    <div class="tab-pane fade" id="last30days">
                        <br/>
                        <from action="">
                            <div class="btn-group" style="float: left">
                                <button type="button" class="btn btn-default dropdown-toggle"data-toggle="dropdown">
                                    上海自贸区 <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">河南自贸区</a></li>
                                    <li><a href="#">福建自贸区</a></li>
                                    <li><a href="#">浙江自贸区</a></li>
                                    <li><a href="#">广东自贸区</a></li>
                                    <li><a href="#">四川自贸区</a></li>
                                    <li><a href="#">陕西自贸区</a></li>
                                    <li><a href="#">湖北自贸区</a></li>
                                    <li><a href="#">辽宁自贸区</a></li>
                                    <li><a href="#">重庆自贸区</a></li>
                                    <li><a href="#">天津自贸区</a></li>
                                    <li><a href="#">浙江自贸区</a></li>
                                </ul>
                            </div>
                            <div style="float: left;margin-left: 200px">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>整体搜索指数</th>
                                        <th>移动搜索指数</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>123</td>
                                        <td>456</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div style="float: left;margin-left: 200px">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>整体环比</th>
                                        <th>整体同比</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>123</td>
                                        <td>456</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div style="float: left;margin-left: 200px">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>移动同比</th>
                                        <th>移动环比</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>123</td>
                                        <td>456</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </from>
                    </div>
                </div>
            </div>

        </fieldset>
    </div>

    <fieldset>
        <legend>搜索指数趋势</legend>
        <ul id="myTab2" class="nav nav-tabs">
            <li class="active"><a href='#allTrends' onclick="allTrends()" data-toggle="tab">整体趋势</a></li>
            <li><a href='#pcTrends' onclick="pcTrends()" data-toggle="tab">PC趋势</a></li>
            <li><a href='#wiseTrends' onclick="wiseTrends()" data-toggle="tab">移动趋势</a></li>
        </ul>
        <div id="myTab2Content" class="tab-content">
            <div class="tab-pane fade in active" id="allTrends" >
                <div id="main1" class="echart_container1"></div>
            </div>
            <div class="tab-pane fade" id="pcTrends" >
                <div id="main2" class="echart_container1"></div>
            </div>
            <div class="tab-pane fade" id="wiseTrends" >
                <div id="main3" class="echart_container1"></div>
            </div>
        </div>
        <!--媒体指数main4-->
        <div>
            <div id="main4" class="echart_container1"></div>
        </div>

    </fieldset>

</div>

<!--搜索指数 main1-6-->


<script src="${pageContext.request.contextPath}/resources/js/zmqjs/ZmqIndex.js"></script>

</body>

</html>
