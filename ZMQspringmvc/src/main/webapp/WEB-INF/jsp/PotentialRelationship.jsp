<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/23
  Time: 16:19
  潜在关系
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
        border: 1px solid #000;
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

    <div id="graph" class="echart_container"></div>


    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById("graph"));

        var topwordJson = {
            "all": 9500000,
            "charts": {
                "披露": 2710781,
                "确认": 2726256,
                "持有": 2779694,
                "支付": 2828790,
                "存在": 2862980,
                "负债": 2882619,
                "购买": 3003283,
                "发生": 3220167,
                "控制": 3464976,
                "关联": 3578828,
                "经营": 3948036,
                "评估": 3986259,
                "募集": 4260294,
                "交易": 4322080,
                "进行": 4525028,
                "上市": 5604217,
                "相关": 5692122,
                "管理": 6777563,
                "发行": 7398882,
                "投资": 8714569
            },
            "ie": 9743
        };

        var classJson = {
            "关系0": 320,
            "关系1": 459,
            "关系2": 467,
            "关系3": 262,
            "关系4": 319,
            "关系5": 316,
            "关系6": 1394,
            "关系7": 334,
            "关系8": 339,
            "关系9": 428
        };

        var piedataJson = {
            "收、转、投、出、发等": 320,
            "入、增、延、积、合等": 459,
            "确认、披露、承诺等": 467,
            "合并、重组、完成等": 262,
            "管理、经营、发展等": 319,
            "投资、发行、上市等": 316,
            "简称、出具、归属等": 1394,
            "进行、控制、发生等": 334,
            "相关、关联、存在等": 339,
            "评估、使用、流动等": 428
        }

        var waterMarkText = '潜在关系';

        var canvas = document.createElement('canvas');
        var ctx = canvas.getContext('2d');
        canvas.width = canvas.height = 100;
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.globalAlpha = 0.08;
        ctx.font = '20px Microsoft Yahei';
        ctx.translate(50, 50);
        ctx.rotate(-Math.PI / 4);
        ctx.fillText(waterMarkText, 0, 0);

        option = {
            backgroundColor: {
                type: 'pattern',
                image: canvas,
                repeat: 'repeat'
            },
            tooltip: {},
            title: [
                {
                    top: '5%',
                    text: '语义关系分布',
                    //subtext: '总计 ' + Object.keys(classJson).reduce(function (all, key) {
                    //    return all + classJson[key];
                    //}, 0),
                    subtext: '总计10类，共4647个词',
                    x: '25%',
                    textAlign: 'center'
                },
                {
                    top: '5%',
                    text: '高频词',
                    subtext: 'TOP 20',
                    x: '75%',
                    textAlign: 'center'
                }
            ],
            grid: [{
                top: '20%',
                width: '48%',
                bottom: '15%',
                left: '50%',
                containLabel: true
            }],
            xAxis: [{
                type: 'value',
                max: topwordJson.all,
                splitLine: {
                    show: false
                }
            }],
            yAxis: [{
                type: 'category',
                data: Object.keys(topwordJson.charts),
                axisLabel: {
                    interval: 0,
                    rotate: 30
                },
                splitLine: {
                    show: false
                }
            }],
            series: [{
                type: 'bar',
                stack: 'chart',
                z: 3,
                label: {
                    normal: {
                        position: 'right',
                        show: true
                    }
                },
                data: Object.keys(topwordJson.charts).map(function (key) {
                    return topwordJson.charts[key];
                })
            }, {
                type: 'bar',
                stack: 'chart',
                silent: true,
                itemStyle: {
                    normal: {
                        color: '#eee'
                    }
                },
                data: Object.keys(topwordJson.charts).map(function (key) {
                    return topwordJson.all - topwordJson.charts[key];
                })
            },
                {
                    type: 'pie',
                    radius: [0, '50%'],
                    center: ['25%', '50%'],
                    data: Object.keys(piedataJson).map(function (key) {
                        return {
                            name: key.replace('.js', ''),
                            value: piedataJson[key]
                        }
                    })
                }]
        };
        myChart.setOption(option);
    </script>

</div>
</body>
</html>
