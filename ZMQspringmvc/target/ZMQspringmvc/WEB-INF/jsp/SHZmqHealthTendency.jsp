<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/23
  Time: 11:42
  上海自贸区健康态势
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>

<style>
    .echart_container1 {
        width: 660px;
        height: 600px;
        float: left;
        display: inline
    }
    .echart_container2 {
        width: 500px;
        height: 500px;
        margin-left: 50px;
        float: left;
        display: inline
    }

    .divcss {
        margin-left: auto;
        margin-right: auto;
        width: 1320px;
    }
</style>

<body>
<br/>
<%@include file="title.jsp" %>
<br/><br/><br/>

<div class="divcss">
    <div id="main" class="echart_container1"></div>
    &nbsp;
    <div id="main2" class="echart_container2"></div>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var myChart2 = echarts.init(document.getElementById('main2'));
    // 指定图表的配置项和数据


    option = {

        title: {
            text: '2016自贸区行业健康态势'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['贸易', '物流运输', '医药', '汽车', '食品'],
            left: '40%'
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
        },
        yAxis: {
            type: 'value',
            name: '健康度'
        },
        series: [
            {
                name: '贸易',
                type: 'line',
                data: [5.4, 4.3, 4.0, 4.5, 5.2, 6.3, 6.5]
            },
            {
                name: '物流运输',
                type: 'line',
                data: [6.8, 5.3, 4.9, 6.2, 6.9, 3.3, 3.1]
            },
            {
                name: '医药',
                type: 'line',
                data: [6.5, 6.3, 7.1, 7.5, 5.9, 5.3, 7.3]
            },
            {
                name: '汽车',
                type: 'line',
                data: [3.9, 3.2, 4.1, 4.0, 3.9, 4.7, 5.0]
            },
            {
                name: '食品',
                type: 'line',
                data: [6.2, 6.7, 5.1, 5.4, 5.0, 5.5, 6.7]
            }
        ]
    };

    option2 = {
        title: {
            text: '相关行业新闻量'
        },
        tooltip: {},
        legend: {
            data: ['新闻数量']
        },
        radar: {
            // shape: 'circle',
            indicator: [
                {name: '贸易', max: 600},
                {name: '物流运输', max: 600},
                {name: '医药', max: 600},
                {name: '汽车', max: 600},
                {name: '食品', max: 600},
                {name: '服务', max: 600}
            ]
        },
        series: [{
            name: '行业新闻量',
            type: 'radar',
            // areaStyle: {normal: {}},
            data: [
                {
                    value: [503, 482, 324, 350, 280, 293],

                }
            ]
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart2.setOption(option2);
</script>
</body>

</html>

