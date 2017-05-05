<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/19
  Time: 13:31
  Function: 自贸区网站的首页
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>

<style>
    .echart_container{
        height: 600px;

        position: absolute;
        left: 10%;
        width: 80%;
        margin-bottom: 20px;
    }
</style>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>

    <div id="map" class="echart_container"></div>
    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById("map"));

        function randomData() {
            return Math.round(Math.random()*1000);
        }

        option = {
            title: {
                text: '各自贸区发展情况对比',
                subtext: '',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data:['沿海','成立较早','税收较高']
            },
            visualMap: {
                min: 0,
                max: 2500,
                left: 'left',
                top: 'bottom',
                text: ['高','低'],           // 文本，默认为数值文本
                calculable: true
            },
            toolbox: {
                show: true,
                orient: 'vertical',
                left: 'right',
                top: 'center',
                feature: {
                    dataView: {readOnly: false},
                    restore: {},
                    saveAsImage: {}
                }
            },
            series: [
                {
                    name: '沿海',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    label: {
                        normal: {
                            show: true
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data:[
                        {name: '天津',value: randomData() },
                        {name: '上海',value: randomData() },
                        {name: '辽宁',value: randomData() },
                        {name: '浙江',value: randomData() },
                        {name: '广东',value: randomData() },
                        {name: '福建',value: randomData() }
                    ]
                },
                {
                    name: '成立较早',
                    type: 'map',
                    mapType: 'china',
                    label: {
                        normal: {
                            show: true
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data:[
                        {name: '天津',value: randomData() },
                        {name: '上海',value: randomData() },
                        {name: '广东',value: randomData() },
                        {name: '福建',value: randomData() }
                    ]
                },
                {
                    name: '税收较高',
                    type: 'map',
                    mapType: 'china',
                    label: {
                        normal: {
                            show: true
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data:[
                        {name: '天津',value: randomData() },
                        {name: '上海',value: randomData() },
                        {name: '重庆',value: randomData() },
                        {name: '河南',value: randomData() },
                        {name: '辽宁',value: randomData() },
                        {name: '浙江',value: randomData() },
                        {name: '湖北',value: randomData() },
                        {name: '广东',value: randomData() },
                        {name: '四川',value: randomData() },
                        {name: '陕西',value: randomData() },
                        {name: '福建',value: randomData() }
                    ]
                }
            ]
        };

        myChart.setOption(option);
    </script>
</div>
</body>
</html>
