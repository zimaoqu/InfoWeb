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

    .indexSum {
        width: 1320px;
        height: 300px;
    }
</style>

<body>
<br/>
<%@include file="title.jsp" %>
<br/><br/><br/>

<div class="divcss">
    <div id="indexSum" class="indexSum">
        <fieldset>
            <legend>热度概况</legend>
            <div>
                <ul id="myTab" class="nav nav-tabs">
                    <li class="active"><a href="#last7days" onclick="changedate1()" data-toggle="tab">近7天</a></li>
                    <li><a href="#last30days" onclick="changedate2()" data-toggle="tab">近30天</a></li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="last7days">
                        <br/>
                        <!--自贸区：上海 河南 福建 浙江 广东 四川 陕西 湖北 辽宁 重庆 天津  -->
                        <div style="float: left">
                            <select class="btn btn-default dropdown-toggle" id="zmqName" name="last7daysIndex"
                                    onchange="last7daysIndex(this)">
                                <option id="shanghai">上海自贸区</option>
                                <option id="henan">河南自贸区</option>
                                <option id="fujian">福建自贸区</option>
                                <option id="zhejiang">浙江自贸区</option>
                                <option id="guangdong">广东自贸区</option>
                                <option id="sichuan">四川自贸区</option>
                                <option id="shanxi">陕西自贸区</option>
                                <option id="hubei">湖北自贸区</option>
                                <option id="liaoning">辽宁自贸区</option>
                                <option id="chongqing">重庆自贸区</option>
                                <option id="tianjin">天津自贸区</option>
                            </select>
                        </div>
                        <div style="float: left;margin-left: 200px">
                            <table class="table" id="Search7Index">
                                <thead>
                                <tr>
                                    <th>整体网络关注热度</th>
                                    <th>移动网络关注热度</th>
                                </tr>
                                </thead>
                                <tbody>
                                <td id="c1"></td>
                                <td id="c2"></td>
                                </tbody>
                            </table>
                        </div>
                        <div style="float: left;margin-left: 200px">
                            <table class="table" id="allHuanTongbi7">
                                <thead>
                                <tr>
                                    <th>整体同比</th>
                                    <th>整体环比</th>
                                </tr>
                                </thead>
                                <tbody>
                                <td id="c5">

                                </td>
                                <td id="c6">

                                </td>
                                </tbody>
                            </table>
                        </div>
                        <div style="float: left;margin-left: 200px">
                            <table class="table" id="wiseHuanTongbi7">
                                <thead>
                                <tr>
                                    <th>移动同比</th>
                                    <th>移动环比</th>
                                </tr>
                                </thead>
                                <tbody>
                                <td id="c7">

                                </td>
                                <td id="c8">

                                </td>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="last30days">
                        <br/>
                        <!--自贸区：上海 河南 福建 浙江 广东 四川 陕西 湖北 辽宁 重庆 天津  -->
                        <div class="btn-group" style="float: left">
                            <select class="btn btn-default dropdown-toggle" id="zmqName2" name="last30daysIndex"
                                    onchange="last30daysIndex(this)">
                                <option id="shanghai2">上海自贸区</option>
                                <option id="henan2">河南自贸区</option>
                                <option id="fujian2">福建自贸区</option>
                                <option id="zhejiang2">浙江自贸区</option>
                                <option id="guangdong2">广东自贸区</option>
                                <option id="sichuan2">四川自贸区</option>
                                <option id="shanxi2">陕西自贸区</option>
                                <option id="hubei2">湖北自贸区</option>
                                <option id="liaoning2">辽宁自贸区</option>
                                <option id="chongqing2">重庆自贸区</option>
                                <option id="tianjin2">天津自贸区</option>
                            </select>
                        </div>
                        <div style="float: left;margin-left: 200px">
                            <table class="table" id="Search30Index">
                                <thead>
                                <tr>
                                    <th>整体网络关注热度</th>
                                    <th>移动网络关注热度</th>
                                </tr>
                                </thead>
                                <tbody>
                                <td id="c3"></td>
                                <td id="c4"></td>
                                </tbody>
                            </table>
                        </div>
                        <div style="float: left;margin-left: 200px">
                            <table class="table" id="allHuanTongbi30">
                                <thead>
                                <tr>
                                    <th>整体同比</th>
                                    <th>整体环比</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td id="c9">

                                    </td>
                                    <td id="c10">

                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div style="float: left;margin-left: 200px">
                            <table class="table" id="wiseHuanTongbi30">
                                <thead>
                                <tr>
                                    <th>移动同比</th>
                                    <th>移动环比</th>
                                </tr>
                                </thead>
                                <tbody>
                                <td id="c11">

                                </td>
                                <td id="c12">

                                </td>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>

    <fieldset>
        <legend>网络关注热度</legend>
        <ul id="myTab2" class="nav nav-tabs">
            <li class="active"><a href='#allTrends' onclick="allTrends()" data-toggle="tab">整体趋势</a></li>
            <li><a href='#pcTrends' onclick="pcTrends()" data-toggle="tab">PC趋势</a></li>
            <li><a href='#wiseTrends' onclick="wiseTrends()" data-toggle="tab">移动趋势</a></li>
        </ul>
        <div id="myTab2Content" class="tab-content">
            <div class="tab-pane fade in active" id="allTrends">
                <div id="main1" class="echart_container1"></div>
            </div>
            <div class="tab-pane fade" id="pcTrends">
                <div id="main2" class="echart_container1"></div>
            </div>
            <div class="tab-pane fade" id="wiseTrends">
                <div id="main3" class="echart_container1"></div>
            </div>
        </div>

    </fieldset>
    <fieldset>
        <legend>媒体热度</legend>
        <!--媒体指数main4-->
        <div>
            <div id="main4" class="echart_container1"></div>
        </div>
    </fieldset>

</div>

<script src="${pageContext.request.contextPath}/resources/js/zmqjs/ZmqIndex.js"></script>

</body>

</html>
